package card;

import java.util.ArrayList;
import java.util.List;

public class DebitCard extends Card implements Observed {

    List<Observer> observers;

    @Override
    public long addMoney(long amount) {
        long tmpDebit = super.addMoney(amount);
        this.notifySubscribers();
        return tmpDebit;
    }

    public DebitCard(long balance){
        this.balance = balance;
        this.limit = 0;
        this.observers = new ArrayList<Observer>();
    }

    public long withdrawMoney(long amount) throws Exception {
        if (amount < balance) {
            double calculateFeeValue = calculateFee(amount);
            balance -= amount;
            balance -= calculateFeeValue;
            this.notifySubscribers();
            return balance;
        } else {
            throw new Exception("You need more money on your cart");
        }
    }

    public long calculateFee(long amount) {
        double feePercent = 0.01;
        double fee;
        if (balance > amount) {
            fee = amount * feePercent;
            return (long) fee;
        }
        return 0;
    }

    public void addSubscriber(Observer observer) {
        this.observers.add(observer);
    }

    public void removeSubscriber(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifySubscribers() {
        for (Observer observer: observers) {
            observer.handleEvent("your new balance = " + balance);
        }
    }
}
