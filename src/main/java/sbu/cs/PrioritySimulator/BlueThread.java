package sbu.cs.PrioritySimulator;
import java.util.concurrent.CountDownLatch;


public class BlueThread extends ColorThread {

    private static final String MESSAGE = "hi finished blacks, hi whites!";

    private final CountDownLatch blueLatch;
    public BlueThread(CountDownLatch blueLatch) {
        this.blueLatch = blueLatch;
    }

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
        blueLatch.countDown();
    }
}
