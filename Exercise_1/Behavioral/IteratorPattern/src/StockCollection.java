import java.util.ArrayList;
import java.util.List;

public class StockCollection {
    private List<Stock> stocks;

    public StockCollection() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public StockIterator iterator() {
        return new StockIteratorImpl();
    }

    private class StockIteratorImpl implements StockIterator {
        private int index = 0;

        public boolean hasNext() {
            return index < stocks.size();
        }

        public Stock next() {
            if (hasNext()) {
                return stocks.get(index++);
            }
            return null;
        }
    }
}
