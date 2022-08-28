package phoneBook;

import java.util.Scanner;

public class PhoneBookView implements Runnable{

    PhoneBookModel model = new PhoneBookModel();
    Scanner in = new Scanner(System.in);

    public void add()
    {
        try
        {


        System.out.println("Creating contact... ");

        Contact c = new Contact("","");
        System.out.println("\nName: ");
        c.setName(in.nextLine());
        System.out.println("\nPhone: ");
        c.setPhone(in.nextLine());
if(model.searchByPhone(c.getPhone()) != null)
{
    throw new Exception("Phone is Using");
}
            model.add(c);

            System.out.println("\nNew Contact: ");
            System.out.println(c);
        } catch (Exception ex)
        {
            MyException(ex);
        }
    }

    private void PrintAll()
    {
        for (Contact c:model) {
            System.out.println(c);
        }
        System.out.println("\n==========");
        model.printAll();
    }
    
    private void MyException(Exception ex)
    {
        System.out.println("\n\n!!! ----- Error ----- !!!");
        System.out.println(ex.getMessage());
        System.out.println("!!! ----- ----- ----- !!!\n\n");
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            char input = ' ';
            do {
                System.out.println("\n\tSelect one: ");
                System.out.println("1 - Add Contact");
                System.out.println("2 - Print All");
                System.out.println("x - Exit");

                System.out.println("\nEnter: ");
                input = in.nextLine().charAt(0);

                switch (input) {
                    case '1':
                        System.out.println("\n\n!!! ----- Create ----- !!!");
                        add();
                        break;
                    case '2':
                        System.out.println("\n\n!!! ----- All ----- !!!");
                        PrintAll();
                        break;
                    case 'x':
                        System.out.println("\nBye");
                        break;
                }
            } while (input != 'x');


        }
        catch (Exception ex)
        {
            MyException(ex);
        }
    }
}
