interface Stock {
    void display();
}

class TechStock implements Stock {

    public void display() {
        System.out.println("Tech Stock");
    }
}

class FinanceStock implements Stock {

    public void display() {
        System.out.println("Finance Stock");
    }
}

class StockFactory {
    public Stock createStock(String type) {
        if (type.equalsIgnoreCase("tech")) {
            return new TechStock();
        } else if (type.equalsIgnoreCase("finance")) {
            return new FinanceStock();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        StockFactory factory = new StockFactory();

        Stock techStock = factory.createStock("tech");
        if (techStock != null) {
            techStock.display();
        }

        Stock financeStock = factory.createStock("finance");
        if (financeStock != null) {
            financeStock.display();
        }
    }
}