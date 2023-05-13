package sbu.cs.Semaphore;

import static java.lang.Thread.currentThread;
import java.util.Date;
public class Resource {
    public static void accessResource() {
        System.out.println("Thread: " + currentThread().getName() + " Time: " + new Date());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
