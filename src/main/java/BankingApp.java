import card.CreditCard;
import card.DebitCard;
import card.Subscriber;

import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) throws Exception {

        DebitCard debitCard = new DebitCard(3000);
        CreditCard creditCard = new CreditCard(3000,20000);

        Subscriber subscriber = new Subscriber("Mike");
        creditCard.addSubscriber(subscriber);
        debitCard.addSubscriber(subscriber);

        System.out.println("Choose your card");
        System.out.println("1. Debit card");
        System.out.println("2. Credit card");

        Scanner cardType = new Scanner(System.in);
        System.out.println("Type of Card: ");
        int typeOfCard = cardType.nextInt();

        System.out.println("Choose your option");
        System.out.println("1. Add to card");
        System.out.println("2. Withdraw from card");
        Scanner selectOption = new Scanner(System.in);
        System.out.println("Option: ");
        int select = selectOption.nextInt();

        Scanner amountValue = new Scanner(System.in);
        System.out.println("Amount: ");
        long amount = amountValue.nextLong();

            if (typeOfCard == 1){
                switch(select){
                    case (1):
                        debitCard.addMoney(amount);
                        break;
                    case (2):
                        debitCard.withdrawMoney(amount);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + select);
                }
        }   else if (typeOfCard == 2)  {
            switch(select){
                case (1):
                    creditCard.addMoney(amount);
                    break;
                case (2):
                    creditCard.withdrawMoney(amount);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }

    }

}
