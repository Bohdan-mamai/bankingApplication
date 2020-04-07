package card;

import java.util.ArrayList;
import java.util.List;

public class CreditCard extends Card implements Observed {

    private List<Observer> observers;

    @Override
    public long addMoney(long amount) {
        long tmpCredit = super.addMoney(amount);
        this.notifySubscribers();
        return tmpCredit;
    }


    CreditCard(long balance, long limit) {
        this.balance = balance;
        this.limit = limit;
        this.observers = new ArrayList<Observer>();
    }


    public long withdrawMoney(long amount) {
        double totalFee;
        double negativeAmount;

        if (amount > balance) {
            totalFee = calculateFee(amount);
            negativeAmount = amount - balance;
            limit -= negativeAmount;
            limit -= totalFee;
            return balance = 0;
        } else if (amount < balance) {
            double calculateFeeValue = calculateFee(amount);
            balance -= amount;
            balance -= calculateFeeValue;
            return balance;
        } else {
            System.out.println("You want to withdraw too much money");
        }
        return balance;
    }


    public long calculateFee(long amount) {
        double feeDebitPercent = 0.01;
        double feeCreditPercent = 0.05;
        double totalFee;
        double positiveFee;
        double negativeFee;

        if((amount > balance) && ((amount - balance) < limit)) {
            positiveFee = balance*feeDebitPercent;
            negativeFee = (amount-balance)*feeCreditPercent;
            totalFee = positiveFee + negativeFee;
            return (long) totalFee;
        }else if (balance > amount){
            totalFee = amount*feeDebitPercent;
            return (long)totalFee;
        }else{
            return 0;
        }
    }

    public void addSubscriber(Observer observer) {
        this.observers.add(observer);
    }

    public void notifySubscribers() {
        for (Observer observer: observers) {
            observer.handleEvent("balance on your card = " + balance + " Your credit limit = " + limit + "\n");
        }
    }

    void printLog(String log){
        for (Observer observer: observers) {
            observer.printLog(log);
        }
    }

    public void removeSubscriber(Observer observer) {
        this.observers.remove(observer);
    }


}
