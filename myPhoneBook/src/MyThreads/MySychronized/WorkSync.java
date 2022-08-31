package MyThreads.MySychronized;

public class WorkSync implements Runnable{


    @Override
    public void run() {
        CommonResource commonResource = new CommonResource();
        for(int i = 1; i < 5; i++)
        {

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            t.start();

           /* try{
                t.join();
            }catch (Exception ex)
            {
                System.out.println();
            }*/
        }
    }
}
