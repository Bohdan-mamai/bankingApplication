package card;

public class DebitCard extends Card {

    public DebitCard(long balance){
        this.balance = balance;
        this.limit = 0;
    }

    public long withdrawMoney(long amount) throws Exception {
        if (amount <= balance) {
            balance -= amount;
            calculateFee(amount,balance,limit);
            balance -= calculateFee(amount,balance,limit);
        } else {
            throw new Exception("You are a frog");
        }
        return balance;
    }

    public long calculateFee(long amount, long balance, long limit) {
        double feePercent = 0.01;
        double fee = 0;
        if (balance >= amount) {
            fee = balance - (amount * feePercent);
        }
        return (long)fee;
    }
}
