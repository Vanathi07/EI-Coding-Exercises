public class AddOccupantsCommand implements Command {
    private SmartOffice office;
    private int roomNumber;
    private int occupants;

    public AddOccupantsCommand(SmartOffice office, int roomNumber, int occupants) {
        this.office = office;
        this.roomNumber = roomNumber;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        office.addOccupants(roomNumber, occupants);
    }
}
