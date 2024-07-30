import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartOffice office = SmartOffice.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Configure rooms");
            System.out.println("2. Set room capacity");
            System.out.println("3. Book room");
            System.out.println("4. Cancel booking");
            System.out.println("5. Add occupants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter number of rooms to configure: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Command configureRooms = new ConfigureRoomsCommand(office, count);
                    configureRooms.execute();
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter new capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Command setRoomCapacity = new SetRoomCapacityCommand(office, roomNumber, capacity);
                    setRoomCapacity.execute();
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int bookRoomNumber = scanner.nextInt();
                    System.out.print("Enter start time (HH:mm): ");
                    String startTime = scanner.next();
                    System.out.print("Enter duration in minutes: ");
                    int durationMinutes = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Command bookRoom = new BookRoomCommand(office, bookRoomNumber, startTime, durationMinutes);
                    bookRoom.execute();
                    break;

                case 4:
                    System.out.print("Enter room number: ");
                    int cancelRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Command cancelBooking = new CancelBookingCommand(office, cancelRoomNumber);
                    cancelBooking.execute();
                    break;

                case 5:
                    System.out.print("Enter room number: ");
                    int addOccupantsRoomNumber = scanner.nextInt();
                    System.out.print("Enter number of occupants: ");
                    int occupants = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Command addOccupants = new AddOccupantsCommand(office, addOccupantsRoomNumber, occupants);
                    addOccupants.execute();
                    break;

                case 6:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
