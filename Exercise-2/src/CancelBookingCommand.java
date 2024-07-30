public class CancelBookingCommand implements Command {
    private SmartOffice office;
    private int roomNumber;

    public CancelBookingCommand(SmartOffice office, int roomNumber) {
        this.office = office;
        this.roomNumber = roomNumber;
    }

    @Override
    public void execute() {
        office.cancelBooking(roomNumber);
    }
}
