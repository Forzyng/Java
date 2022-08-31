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
        WorkSync work = new WorkSync();
        work.run();

        System.out.println("===Main Finished===");
    }
}