package MyThreads.MyNotifyWait;

public class Store {
    private int product=0;


    /**
     * Продажа товара
     */
    public synchronized void get() {
//        while (product<1) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {
//            }
//        }

        if(product < 1 )
            try {wait(100);}
            catch (InterruptedException e) {}
        else
            notify();

        product--;
        System.out.println("Customer Bought 1 product");
        System.out.println("Left: " + product);
        // notify();
    }


    /**
     * Принятие товара на склад
     */
    public synchronized void put() {
//        while (product>=3) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {
//            }
//        }

        if(product >= 3 )
            try {wait(100);}
            catch (InterruptedException e) {}
        else
            notify();

        product++;
        System.out.println("Producer gave 1 product");
        System.out.println("Left: " + product);
        // notify();
    }
}
