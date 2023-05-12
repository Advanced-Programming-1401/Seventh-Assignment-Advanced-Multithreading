package sbu.cs.PrioritySimulator;
import  java.util.concurrent.CountDownLatch;
public class WhiteThread extends ColorThread {
    CountDownLatch CDL;
    public WhiteThread(CountDownLatch CDL){
        super();
        this.CDL = CDL;
    }

    private static final String MESSAGE = "hi finished blacks, hi finished blues!";

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        printMessage();
        CDL.countDown();
    }
}
