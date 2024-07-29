public class StockServiceAdapter implements StockService {
    private OldStockService os;

    public StockServiceAdapter(OldStockService os) {
        this.os = os;
    }

    public double getPrice(String stock) {
        String priceStr = os.getPrice(stock);
        return Double.parseDouble(priceStr);
    }
}
