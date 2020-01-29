package card;

public abstract class Card {

    long balance;
    long limit;

    public long addMoney(long amount){
        balance += amount;
        return balance;
    }

    public abstract long withdrawMoney(long amount) throws Exception;
    public abstract long calculateFee(long amount);

}
