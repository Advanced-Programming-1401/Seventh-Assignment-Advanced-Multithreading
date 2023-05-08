package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;

public abstract class ColorThread extends Thread {
    private CountDownLatch cdl;

    public ColorThread(CountDownLatch cdl){
        super();
        this.cdl = cdl;
    }

    void printMessage(Message message) {
        System.out.printf("[x] %s. thread_name: %s%n", message.toString(), currentThread().getName());
        Runner.addToList(message);
        cdl.countDown();
    }

    abstract String getMessage();
}
