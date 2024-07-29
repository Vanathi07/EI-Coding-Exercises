public class StockMarket {
    private static StockMarket instance;
    private double price;

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void setPrice(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }
}
