import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int capacity;
    private boolean isBooked;
    private long bookingEndTime;
    private int currentOccupants;
    private List<Observer> observers = new ArrayList<>();

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.isBooked = false;
        this.currentOccupants = 0;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Invalid capacity. Please enter a valid positive number.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBooked() {
        if (isBooked && System.currentTimeMillis() > bookingEndTime) {
            isBooked = false;
            currentOccupants = 0;
            notifyObservers(name + " is now unoccupied. Booking released. AC and lights off.");
        }
        return isBooked;
    }

    public void book(long durationMillis) {
        isBooked = true;
        bookingEndTime = System.currentTimeMillis() + durationMillis;
        notifyObservers(name + " booked.");
    }

    public void cancelBooking() {
        isBooked = false;
        currentOccupants = 0;
        notifyObservers(name + " booking cancelled.");
    }

    public void addOccupants(int occupants) {
        if (occupants > 0 && occupants <= capacity) {
            currentOccupants = occupants;
            if (occupants >= 2) {
                notifyObservers(name + " is now occupied by " + occupants + " persons. AC and lights turned on.");
            } else {
                notifyObservers(name + " occupancy insufficient to mark as occupied.");
            }
        } else if (occupants == 0) {
            currentOccupants = 0;
            notifyObservers(name + " is now unoccupied. AC and lights turned off.");
        } else {
            System.out.println("Invalid number of occupants.");
        }
    }

    public boolean isOccupancySufficient() {
        return currentOccupants >= 2;
    }

    public String getStatus() {
        if (isBooked) {
            return name + " is booked until " + new java.util.Date(bookingEndTime).toString();
        } else {
            return name + " is available.";
        }
    }
}
