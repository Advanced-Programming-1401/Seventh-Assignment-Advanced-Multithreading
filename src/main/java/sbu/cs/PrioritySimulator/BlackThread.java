package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;
public class BlackThread extends ColorThread {

    public BlackThread(CountDownLatch countdown) {
        super(countdown);
    }

    private static final String MESSAGE = "hi blues, hi whites!";

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        // TODO call printMessage
    }
}