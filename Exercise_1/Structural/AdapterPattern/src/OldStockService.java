public class OldStockService {
    public String getPrice(String stock) {
        if (stock.equalsIgnoreCase("Furniture")) {
            return "1500";
        } else if (stock.equalsIgnoreCase("Books")) {
            return "250";
        } else if (stock.equalsIgnoreCase("Gadgets")) {
            return "800";
        }
        return "0.00";
    }
}
