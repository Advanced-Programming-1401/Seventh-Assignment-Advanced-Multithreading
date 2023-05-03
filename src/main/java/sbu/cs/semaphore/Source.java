package sbu.cs.semaphore;

public class Source {

    public static void getSource() {
        // A maximum of 2 chefs can access the source concurrently
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
