package sbu.cs.Semaphore;
import java.text.SimpleDateFormat;

public class Resource {
    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");



    public static void accessResource() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
