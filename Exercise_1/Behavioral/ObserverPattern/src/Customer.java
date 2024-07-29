public class Customer implements Observer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(float stockPrice) {
        System.out.println("Notifying " + name + " at " + email + ": Stock price updated to " + stockPrice);
    }
}
