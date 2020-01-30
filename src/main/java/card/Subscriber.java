package card;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    public void handleEvent(String messageBalance) {
        System.out.print("Dear " + name + " " + messageBalance);
    }
}
