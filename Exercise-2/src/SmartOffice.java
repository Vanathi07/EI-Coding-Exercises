import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartOffice {
    private List<Room> rooms = new ArrayList<>();

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.add(new Room("Room " + i, 10));
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
                    long startMillis = sdf.parse(startTime).getTime();
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
            if (room.isBooked()) {
                room.addOccupants(occupants);
            } else {
                System.out.println("Room " + roomNumber + " is not booked. Cannot add occupants.");
            }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartOffice smartOffice = new SmartOffice();
        boolean running = true;

        while (running) {
            System.out.println("1. Configure Room Count");
            System.out.println("2. Configure Room Capacity");
            System.out.println("3. Block Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Add Occupants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number of rooms: ");
                    int roomCount = scanner.nextInt();
                    smartOffice.configureRooms(roomCount);
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumberForCapacity = scanner.nextInt();
                    System.out.print("Enter maximum capacity: ");
                    int capacity = scanner.nextInt();
                    smartOffice.setRoomCapacity(roomNumberForCapacity, capacity);
                    break;
                case 3:
                    System.out.print("Enter room number: ");
                    int roomNumberForBooking = scanner.nextInt();
                    System.out.print("Enter start time (HH:mm): ");
                    String startTime = scanner.next();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    smartOffice.bookRoom(roomNumberForBooking, startTime, duration);
                    break;
                case 4:
                    System.out.print("Enter room number: ");
                    int roomNumberForCancellation = scanner.nextInt();
                    smartOffice.cancelBooking(roomNumberForCancellation);
                    break;
                case 5:
                    System.out.print("Enter room number: ");
                    int roomNumberForOccupants = scanner.nextInt();
                    System.out.print("Enter number of occupants: ");
                    int occupants = scanner.nextInt();
                    smartOffice.addOccupants(roomNumberForOccupants, occupants);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }

        scanner.close();
    }
}
