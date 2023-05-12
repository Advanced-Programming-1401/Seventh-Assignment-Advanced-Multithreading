package sbu.cs.PrioritySimulator;
import  java.util.concurrent.CountDownLatch;
public class BlueThread extends ColorThread {
    CountDownLatch CDL;
    public BlueThread(CountDownLatch CDL){
        super();
        this.CDL = CDL;
    }

    private static final String MESSAGE = "hi finished blacks, hi whites!";

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
