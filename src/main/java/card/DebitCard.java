package card;

public class DebitCard extends Card {

    public DebitCard(long balance){
        this.balance = balance;
        this.limit = 0;
    }

    public long withdrawMoney(long amount) throws Exception {
        if (amount < balance) {
            double calculateFeeValue = calculateFee(amount);
            balance -= amount;
            balance -= calculateFeeValue;
            return balance;
        } else {
            throw new Exception("You are a frog");
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
}
