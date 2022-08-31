package MyThreads;

public class MyFirstThread extends Thread{
    MyFirstThread(String name){
        super(name);
    }

    public void run()
    {
        try {
            for(int i = 0; i < 3; i++)
            {
                System.out.println(Thread.currentThread().getName());
            }

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
