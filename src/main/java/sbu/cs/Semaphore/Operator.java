package sbu.cs.Semaphore;
import java.util.concurrent.Semaphore;
public class Operator extends Thread {

    private Semaphore semaphore;
    public Operator(String name , Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
        {
            try {
                semaphore.acquire();
                Resource.accessResource();
                System.out.println("Thread: " + currentThread().getName() + " Time: " + java.time.LocalTime.now());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
