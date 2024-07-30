public class ConfigureRoomsCommand implements Command {
    private SmartOffice office;
    private int count;

    public ConfigureRoomsCommand(SmartOffice office, int count) {
        this.office = office;
        this.count = count;
    }

    public void execute() {
        office.configureRooms(count);
    }
}
