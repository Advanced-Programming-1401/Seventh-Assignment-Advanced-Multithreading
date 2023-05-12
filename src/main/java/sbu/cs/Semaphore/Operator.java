package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Operator extends Thread {

   private Semaphore s;
    public Operator(Semaphore s ,String name) {

        super(name);
        this.s=s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            for (int i = 0; i < 10; i++) {
                Resource.accessResource(getName());// critical section - a Maximum of 2 operators can access the resource concurrently
                sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.release();
    }
}
