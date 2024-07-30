import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SmartOffice {
    private static SmartOffice instance;
    private List<Room> rooms = new ArrayList<>();

    private SmartOffice() {}

    public static SmartOffice getInstance() {
        if (instance == null) {
            instance = new SmartOffice();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            Room room = new Room("Room " + i, 10);
            room.addObserver(new Sensor("Sensor " + i));
            room.addObserver(new ControlSystem("AC and Lights"));
            rooms.add(room);
        }
        System.out.println("Office configured with " + count + " meeting rooms: " + getRoomNames() + ".");
    }

    public void setRoomCapacity(int roomNumber, int capacity) {
        if (roomNumber > 0 && roomNumber <= rooms.size()) {
            try {
                rooms.get(roomNumber - 1).setCapacity(capacity);
                System.out.println("Room " + roomNumber + " maximum capacity set to " + capacity + ".");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid room number. Please enter a valid room number.");
        }
    }

    public void bookRoom(int roomNumber, String startTime, int durationMinutes) {
        if (roomNumber > 0 && roomNumber <= rooms.size()) {
            Room room = rooms.get(roomNumber - 1);
            if (!room.isBooked()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date date = sdf.parse(startTime);
                    Calendar bookingTime = Calendar.getInstance();
                    bookingTime.setTime(date);

                    Calendar now = Calendar.getInstance();
                    bookingTime.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));

                    long startMillis = bookingTime.getTimeInMillis();
                    long currentMillis = System.currentTimeMillis();
                    long durationMillis = durationMinutes * 60 * 1000;

                    if (startMillis < currentMillis) {
                        System.out.println("Cannot book in the past.");
                    } else {
                        room.book(durationMillis);
                        System.out.println("Room " + roomNumber + " booked from " + startTime + " for " + durationMinutes + " minutes.");
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid time format. Use HH:mm.");
                }
            } else {
                System.out.println("Room " + roomNumber + " is already booked during this time. Cannot book.");
            }
        } else {
            System.out.println("Invalid room number. Please enter a valid room number.");
        }
    }

    public void cancelBooking(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= rooms.size()) {
            Room room = rooms.get(roomNumber - 1);
            if (room.isBooked()) {
                room.cancelBooking();
                System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
            } else {
                System.out.println("Room " + roomNumber + " is not booked. Cannot cancel booking.");
            }
        } else {
            System.out.println("Invalid room number. Please enter a valid room number.");
        }
    }

    public void addOccupants(int roomNumber, int occupants) {
        if (roomNumber > 0 && roomNumber <= rooms.size()) {
            Room room = rooms.get(roomNumber - 1);
            room.addOccupants(occupants);
        } else {
            System.out.println("Invalid room number. Please enter a valid room number.");
        }
    }

    private String getRoomNames() {
        StringBuilder roomNames = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            roomNames.append(rooms.get(i).getName());
            if (i < rooms.size() - 1) {
                roomNames.append(", ");
            }
        }
        return roomNames.toString();
    }
}
