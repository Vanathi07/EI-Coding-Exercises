
public interface DisplayFormat {
    void display(String symbol, double price);
}

class PlainTextFormat implements DisplayFormat {
    @Override
    public void display(String symbol, double price) {
        System.out.println("Stock: " + symbol + ", Price: $" + price);
    }
}

class JsonFormat implements DisplayFormat {
    @Override
    public void display(String symbol, double price) {
        System.out.println("{ \"symbol\": \"" + symbol + "\", \"price\": " + price + " }");
    }
}

