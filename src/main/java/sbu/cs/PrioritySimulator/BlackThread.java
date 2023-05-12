package sbu.cs.PrioritySimulator;
import java.util.concurrent.CountDownLatch;


public class BlackThread extends ColorThread {

    private static final String MESSAGE = "hi finished blacks, hi whites!";

    private final CountDownLatch blackLatch;
    public BlackThread(CountDownLatch blackLatch) {
        this.blackLatch = blackLatch;
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
        blackLatch.countDown();
    }
}
