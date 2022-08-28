package entities;

import java.util.ArrayList;

public class MyArrayList implements Runnable{
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
        ArrayList<Contact> myPhoneBook = new ArrayList<>();

        Contact art = new Contact("Art", "+44223412");
        Contact pen = new Contact("Pen", "000023232");

        myPhoneBook.add(art);
        myPhoneBook.add(pen);

        print(myPhoneBook);
    }

    private void print(ArrayList<Contact> myPhoneBook) throws Exception {
        for(Contact p: myPhoneBook)
        {
            System.out.println(p);
        }
    }
}
