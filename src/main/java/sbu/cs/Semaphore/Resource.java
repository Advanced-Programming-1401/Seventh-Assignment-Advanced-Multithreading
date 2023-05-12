package sbu.cs.Semaphore;
import java.text.SimpleDateFormat;

public class Resource {
    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");//use this form to convert the time format from millisecond



    public static void accessResource() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        try {
            System.out.println(Thread.currentThread().getName() + " accessed to the resource at " + sdf.format(System.currentTimeMillis()));
            Thread.sleep(1000);//change it to 1000 understand that every second just two threads can access the resource
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
