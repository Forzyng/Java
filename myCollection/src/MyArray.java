import entities.Contact;

public class MyArray implements Runnable{

    @Override
    public void run() {
       try
       {
           SimpleArray();
       }catch (Exception ex)
       {
           System.out.println(ex.getMessage());
       }
    }

    public void SimpleArray() throws Exception
    {
        Contact art = new Contact("Art", "+44223412");
        Contact pen = new Contact("Pen", "000023232");

        Contact[] MyFriends = new Contact[2];
        MyFriends[0] = art;
        MyFriends[1] = pen;

        System.out.println("My Friends");

        for (int i = 0; i < 2; i++)
        {
            System.out.println(MyFriends[i]);
        }
    }
}
