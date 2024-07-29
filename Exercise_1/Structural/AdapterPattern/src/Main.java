public class Main {
    public static void main(String[] args) {
        OldStockService os = new OldStockService();
        StockService ns = new StockServiceAdapter(os);

        System.out.println("Furniture: Rs " + ns.getPrice("Furniture"));
        System.out.println("Books: Rs " + ns.getPrice("Books"));
        System.out.println("Gadgets: Rs " + ns.getPrice("gadgets"));
    }
}
