package MyThreads;

public class MainThread implements Runnable{
    void RunOtherThread()
    {
        MyFirstThread t1 = new MyFirstThread("t1");
        MyFirstThread t2 = new MyFirstThread("t2");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    void thisThread(){
        System.out.println("Sleep");

        try
        {
            Thread.sleep(1000);
            int p = Thread.currentThread().getPriority();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void run() {
        RunOtherThread();
    }
}
