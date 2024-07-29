import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockMarket sm1 = StockMarket.getInstance();
        System.out.println("Enter stock price:");
        double p1 = sc.nextDouble();
        sm1.setPrice(p1);
        System.out.println("Current Stock Price: Rs " + sm1.getPrice());

        StockMarket sm2 = StockMarket.getInstance();
        System.out.println("Stock Price from another reference: Rs " + sm2.getPrice());
        System.out.println("Enter new stock price:");
        double p2 = sc.nextDouble();
        sm2.setPrice(p2);
        System.out.println("Updated Stock Price: Rs " + sm1.getPrice());
    }
}
