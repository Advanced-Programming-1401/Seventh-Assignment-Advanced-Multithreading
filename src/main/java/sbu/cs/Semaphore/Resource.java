package sbu.cs.Semaphore;

public class Resource {

    public static void accessResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
