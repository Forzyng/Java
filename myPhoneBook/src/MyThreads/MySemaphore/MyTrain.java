package MyThreads.MySemaphore;

import java.util.concurrent.Semaphore;

public class MyTrain implements Runnable{
    Semaphore sem;
    public MyTrain(Semaphore sem)
    {
        this.sem = sem;
    }
    @Override
    public void run() {
        try
        {
            System.out.printf("Train in Sema %s \n", Thread.currentThread().getName());
            sem.acquire();
            System.out.printf("Train can go %s \n", Thread.currentThread().getName());
       move();
       sem.release();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void move(){
        for(int i = 1; i < 5; i++)
        {
            System.out.printf("Run train %s \n", Thread.currentThread().getName());
            try {Thread.sleep(10);}
            catch (InterruptedException e) {}
        }
    }
}
