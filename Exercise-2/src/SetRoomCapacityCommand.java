public class SetRoomCapacityCommand implements Command {
    private SmartOffice office;
    private int roomNumber;
    private int capacity;

    public SetRoomCapacityCommand(SmartOffice office, int roomNumber, int capacity) {
        this.office = office;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @Override
    public void execute() {
        office.setRoomCapacity(roomNumber, capacity);
    }
}
