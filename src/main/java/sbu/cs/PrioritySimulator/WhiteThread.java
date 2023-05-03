package sbu.cs.PrioritySimulator;

public class WhiteThread extends ColorThread {

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
        // TODO call printMessage
    }
}
