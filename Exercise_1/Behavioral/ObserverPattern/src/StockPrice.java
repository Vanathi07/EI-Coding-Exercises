import java.util.ArrayList;
import java.util.List;

public class StockPrice {
    private List<Observer> observers;
    private float price;

    public StockPrice()
    {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void setPrice(float price)
    {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(price);
        }
    }
}

