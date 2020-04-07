package card;

import java.util.ArrayList;
import java.util.List;

public class DebitCard extends Card implements Observed {

    private List<Observer> observers;

    @Override
    public long addMoney(long amount) {
        return super.addMoney(amount);
    }

    DebitCard(long balance) {
        this.balance = balance;
        limit = 0;
        this.observers = new ArrayList<Observer>();
    }

    public long withdrawMoney(long amount) throws Exception {
        if (amount < balance) {
            double calculateFeeValue = calculateFee(amount);
            balance -= amount;
            balance -= calculateFeeValue;
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
        for (Observer observer : observers) {
            observer.handleEvent("balance on your cart = " + balance + "\n");
        }
    }

    void printLog(String log) {
        for (Observer observer : observers) {
            observer.printLog(log);
        }
    }
}
