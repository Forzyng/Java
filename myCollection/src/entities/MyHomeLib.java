package entities;

public class MyHomeLib implements Runnable{

    @Override
    public void run() {
        try{
            work();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void work() throws Exception
    {
        Person bul = new Person("bul");

        Book[] books = new Book[2];
        books[0] = new Book("mim", bul);
        books[1] = new Book("sob s", bul);

        for (int i = 0; i < 2; i++)
        {
            System.out.println(books[i]);
        }

    }
}
