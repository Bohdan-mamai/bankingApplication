import card.Card;
import card.CreditCard;
import card.DebitCard;

import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) throws Exception {

        DebitCard debitCard = new DebitCard(3000);
        CreditCard creditCard = new CreditCard(0,20000);

        Scanner amountValue = new Scanner(System.in);
        System.out.println("Amount: ");
        long amount = amountValue.nextLong();

        Scanner cardType = new Scanner(System.in);
        System.out.println("Type of Card: ");
        String typeOfCard = cardType.nextLine();

            System.out.println("Choose your option");
            System.out.println("1. Add to card");
            System.out.println("2. Withdraw from card");
            Scanner selectOption = new Scanner(System.in);
            System.out.println("Option: ");
            int select = selectOption.nextInt();
            if (typeOfCard.equals("debit")){
                switch(select){
                    case (1):
                        System.out.println(debitCard.addMoney(amount));
                        break;
                    case (2):
                        System.out.println(debitCard.withdrawMoney(amount));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + select);
                }
        }   else if (typeOfCard.equals("credit"))  {
            switch(select){
                case (1):
                    System.out.println(creditCard.addMoney(amount));
                    break;
                case (2):
                    System.out.println(creditCard.withdrawMoney(amount));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }

    }

}
