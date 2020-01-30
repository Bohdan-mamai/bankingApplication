package card;

import java.util.ArrayList;
import java.util.List;

public class CreditCard extends Card implements Observed {

    @Override
    public long addMoney(long amount) {
        long tmpCredit = super.addMoney(amount);
        this.notifySubscribers();
        return tmpCredit;
    }

    List<Observer> observers;

    public CreditCard(long balance, long limit) {
        this.balance = balance;
        this.limit = limit;
        this.observers = new ArrayList<Observer>();
    }


    public long withdrawMoney(long amount) {

        double totalFee = 0;
        double negativeAmount;
        double totalBalance = balance + limit;

        if (amount > balance) {
            totalFee = calculateFee(amount);
            negativeAmount = amount - balance;
            limit -= negativeAmount;
            totalBalance -= (totalFee + amount);
            balance = (long) totalBalance;
            this.notifySubscribers();
            return balance;
        } else if (amount < balance) {
            double calculateFeeValue = calculateFee(amount);
            balance -= amount;
            balance -= calculateFeeValue;
            this.notifySubscribers();
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

    public void removeSubscriber(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifySubscribers() {
        for (Observer observer: observers) {
            observer.handleEvent("your new balance = " + balance);
        }
    }
}
