public class Main {
    public static void main(String[] args) {
        StockCollection stockCollection = new StockCollection();

        stockCollection.addStock(new Stock("Books", 150.00));
        stockCollection.addStock(new Stock("Furniture", 2500.00));
        stockCollection.addStock(new Stock("Gadgets", 280.00));

        StockIterator iterator = stockCollection.iterator();
        while (iterator.hasNext()) {
            Stock stock = iterator.next();
            System.out.println(stock.getSymbol() + ": Rs." + stock.getPrice());
        }
    }
}
