package card;

public interface Observer {
        void handleEvent(String messageBalance);
        void printLog(String log);
}
