import MyThreads.MyExchanger.WorkExchanger;
import MyThreads.MyNotifyWait.Consumer;
import MyThreads.MyNotifyWait.Producer;
import MyThreads.MyNotifyWait.Store;
import MyThreads.MySemaphore.MySemaphore;
import MyThreads.MySychronized.WorkSync;

public class Main {
    public static void main(String[] args) {
        /*PhoneBookView phoneBookView = new PhoneBookView();
        phoneBookView.run();*/
        /*simpleFile simp = new simpleFile();
        simp.run();*/
        /*simpleSerialization simpS = new simpleSerialization();
        simpS.run();*/
       /* MainThread mt = new MainThread();
        mt.run();*/
        /*WorkSync work = new WorkSync();
        work.run();*/
        /*Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();*/
        /*MySemaphore sem = new MySemaphore();
        sem.run();*/
        WorkExchanger workExchanger = new WorkExchanger();
        workExchanger.run();

        System.out.println("===Main Finished===");
    }
}