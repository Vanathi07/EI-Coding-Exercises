class DetailedStockDisplay extends StockDisplay {

    public DetailedStockDisplay(DisplayFormat format) {
        super(format);
    }

    public void displayStock(String symbol, double price) {
        format.display(symbol, price);
    }
}
