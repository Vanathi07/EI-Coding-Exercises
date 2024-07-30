public class BookRoomCommand implements Command {
    private SmartOffice office;
    private int roomNumber;
    private String startTime;
    private int durationMinutes;

    public BookRoomCommand(SmartOffice office, int roomNumber, String startTime, int durationMinutes) {
        this.office = office;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void execute() {
        office.bookRoom(roomNumber, startTime, durationMinutes);
    }
}
