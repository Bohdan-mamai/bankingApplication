package card;

import java.util.Scanner;

import static card.ConfigData.*;

public class OpenATM {

    public void startATM() throws Exception {

    DebitCard debitCard = new DebitCard(5000);
    CreditCard creditCard = new CreditCard(4000,20000);

    Subscriber firstSubscriber = new Subscriber("Mike");
    Subscriber secondSubscriber = new Subscriber("John");
    Subscriber thirdSubscriber = new Subscriber("Michael");

    creditCard.addSubscriber(firstSubscriber);
    creditCard.addSubscriber(secondSubscriber);

    debitCard.addSubscriber(firstSubscriber);
    debitCard.addSubscriber(thirdSubscriber);

        System.out.println(CHOOSE_CARD_TEXT);
        System.out.println(CHOOSE_DEBIT_TEXT);
        System.out.println(CHOOSE_CREDIT_TEXT);

        Scanner cardType = new Scanner(System.in);
        System.out.println(TYPE_CARD_TEXT);
        int typeOfCard = cardType.nextInt();

        if (typeOfCard == 1){
            debitCard.notifySubscribers();
            debitCard.printLog(SELECT_DEBIT_CARD);
        } else {
            creditCard.notifySubscribers();
            creditCard.printLog(SELECT_CREDIT_CARD);
        }

        System.out.println(CHOOSE_OPTION);
        System.out.println(ADD_TO_CART);
        System.out.println(WITHDRAW_FROM_CARD);

        Scanner selectOption = new Scanner(System.in);
        System.out.println(OPTION);
        int select = selectOption.nextInt();

        if ( typeOfCard == 1 && select == 1 ) {
            debitCard.printLog(SELECT_ADD_TO_CART_OPTION);
        } else if ( typeOfCard == 1 && select == 2 ){
            debitCard.printLog(SELECT_WITHDRAW_FROM_CART_OPTION);
        }

        if( typeOfCard == 2 && select == 1 ){
            creditCard.printLog(SELECT_ADD_TO_CART_OPTION);
        } else if ( typeOfCard == 2 && select == 2 ){
            creditCard.printLog(SELECT_WITHDRAW_FROM_CART_OPTION);
        }

    Scanner amountValue = new Scanner(System.in);
        System.out.println("Amount: ");
    int amount = inputDataAndValidation(amountValue);

            if (typeOfCard == 1){
        switch(select){
            case (1):
                debitCard.addMoney(amount);
                debitCard.notifySubscribers();
                break;
            case (2):
                debitCard.withdrawMoney(amount);
                debitCard.notifySubscribers();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + select);
        }
    }   else if (typeOfCard == 2)  {
        switch(select){
            case (1):
                creditCard.addMoney(amount);
                creditCard.notifySubscribers();
                break;
            case (2):
                creditCard.withdrawMoney(amount);
                creditCard.notifySubscribers();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + select);
        }
    }
}

    private static int inputDataAndValidation(Scanner inputScanner){
        String regex = "-?[0-9]";
        String readData = inputScanner.nextLine();
        boolean ISNUMBERS = readData.matches(regex);
        while (!ISNUMBERS) {
            try{
                int i = Integer.parseInt(readData);
                if (i <= 0) {
                    throw new RuntimeException (RUN_TIME_EXCEPTION_TEXT);
                } else if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
                System.out.println(NUM_FORM_EXCEPTION_TEXT);
            }
            readData = inputScanner.nextLine();
            ISNUMBERS = readData.matches(regex);
        }
        return Integer.parseInt(readData);
    }
}
