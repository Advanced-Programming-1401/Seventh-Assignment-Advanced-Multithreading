package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;

public abstract class ColorThread extends Thread {

    void printMessage(Message message) {
        System.out.printf("[x] %s. thread_name: %s%n", message.toString(), currentThread().getName());
        Runner.addToList(message);
    }

    abstract String getMessage();
}
