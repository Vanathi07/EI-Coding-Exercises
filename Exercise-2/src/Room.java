public class Room {
    private String name;
    private int capacity;
    private boolean isBooked;
    private long bookingEndTime;
    private int currentOccupants;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.isBooked = false;
        this.currentOccupants = 0;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity must be a positive number.");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBooked() {
        if (isBooked && System.currentTimeMillis() > bookingEndTime) {
            isBooked = false;
            currentOccupants = 0;
        }
        return isBooked;
    }

    public void book(long durationMillis) {
        isBooked = true;
        bookingEndTime = System.currentTimeMillis() + durationMillis;
    }

    public void cancelBooking() {
        isBooked = false;
        currentOccupants = 0;
    }

    public void addOccupants(int occupants) {
        if (occupants > 0 && occupants <= capacity) {
            currentOccupants = occupants;
            if (occupants >= 2) {
                System.out.println(name + " is now occupied by " + occupants + " persons.");
            } else {
                System.out.println("Occupancy insufficient to mark as occupied.");
            }
        } else {
            System.out.println("Invalid number of occupants.");
        }
    }

    public void removeOccupants() {
        currentOccupants = 0;
        System.out.println(name + " is now unoccupied. AC and lights turned off.");
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
