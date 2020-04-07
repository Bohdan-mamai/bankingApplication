package card;

public class Subscriber implements Observer {

    private String name;

    Subscriber(String name){
        this.name = name;
    }

    public void handleEvent(String messageBalance) {
        System.out.print("Dear " + name + " " + messageBalance);
    }

    public void printLog(String log) {
        System.out.println("Dear " + name + log);
    }


}
