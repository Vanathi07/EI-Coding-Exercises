import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockPrice sp = new StockPrice();
        Observer cus1 = new Customer("Sam", "sam@gmail.com");
        Observer cus2 = new Customer("Preethi", "preethi@gmail.com");
        Observer cus3 = new Customer("Akshay", "akshay@gmail.com");

        sp.addObserver(cus1);
        sp.addObserver(cus2);
        sp.addObserver(cus3);

        System.out.print("Enter stock price update for publisher : ");
        float p1 = sc.nextFloat();
        System.out.println("\nAll subscribers are notified of stock price change !!!\n");
        sp.setPrice(p1);
        System.out.print("\nEnter new stock price update for publisher : ");
        float p2 = sc.nextFloat();
        System.out.println("\nAll subscribers are notified of stock price change !!!\n");
        sp.setPrice(p2);
    }
}
