public class ControlSystem implements Observer {
    private String name;

    public ControlSystem(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " system: " + message);
    }
}
