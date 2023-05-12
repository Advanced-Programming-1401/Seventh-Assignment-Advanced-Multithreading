package sbu.cs.Semaphore;

public class Resource {

    public static void accessResource(String s) {
        String name = s;
        try {
            Thread.sleep(100);
            System.out.println(name);
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
