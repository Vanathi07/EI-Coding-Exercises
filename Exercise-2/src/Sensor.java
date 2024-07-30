public class Sensor implements Observer {
    private String name;

    public Sensor(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " detected: " + message);
    }
}
