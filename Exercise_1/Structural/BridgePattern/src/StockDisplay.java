abstract class StockDisplay {
    protected DisplayFormat format;

    public StockDisplay(DisplayFormat format) {
        this.format = format;
    }

    public abstract void displayStock(String symbol, double price);
}
