public class Main {
    public static void main(String[] args) {
        DisplayFormat plainText = new PlainTextFormat();
        DisplayFormat json = new JsonFormat();

        StockDisplay plainTextDisplay = new DetailedStockDisplay(plainText);
        StockDisplay jsonDisplay = new DetailedStockDisplay(json);

        plainTextDisplay.displayStock("Books", 150.00);
        jsonDisplay.displayStock("Furniture", 2500.00);
    }
}
