package MyThreads.MySemaphore;

import java.util.concurrent.Semaphore;

public class MySemaphore implements Runnable{
    @Override
    public void run() {
        Semaphore sema = new Semaphore(250);
        for(int i = 1; i < 500; i++)
        {
            new Thread(new MyTrain(sema)).start();
        }
    }
}
