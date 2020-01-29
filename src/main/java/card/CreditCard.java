package card;

public class CreditCard extends Card {

    public CreditCard(long balance, long limit) {
        this.balance = balance;
        this.limit = limit;
    }

    public long withdrawMoney(long amount) {

        double totalFee = 0;
        double negativeAmount;
        double totalBalance = balance + limit;

        if (amount > balance) {
            calculateFee(amount, balance, limit);
            negativeAmount = amount - balance;
            limit -= negativeAmount;
            totalBalance -= (totalFee + amount);
            return (long) totalBalance;
        } else if (amount < balance) {
            double calculateFeeValue = calculateFee(amount, balance, limit);
            balance -= amount;
            balance -= calculateFeeValue;
            return balance;
        } else {
            System.out.println("You want to withdraw too much money");
        }
        return balance;
    }


    public long calculateFee(long amount, long balance, long limit) {

        double feeDebitPercent = 0.01;
        double feeCreditPercent = 0.05;
        double totalFee;
        double positiveFee;
        double negativeFee;

        if((amount > balance) && ((amount - balance) < limit)) {
            positiveFee = balance*feeDebitPercent;
            negativeFee = (limit-(amount-balance))*feeCreditPercent;
            totalFee = positiveFee + negativeFee;
            return (long) totalFee;
        }else if (balance > amount){
            totalFee = amount*feeDebitPercent;
            return (long)totalFee;
        }else{
            return 0;
        }
    }

}
