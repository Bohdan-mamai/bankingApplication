package card;

import java.util.List;

public interface Observed {
    public void addSubscriber(Observer observer);
    public void removeSubscriber(Observer observer);
    public void notifySubscribers();
}
