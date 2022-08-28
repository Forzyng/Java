package fileSeriazable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class simpleSerialization implements Runnable{
    void simpleSeriaz()
    {
        StandartPerson standartPerson = new StandartPerson("Name", 12, 127, false);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            oos.writeObject(standartPerson);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            StandartPerson p=(StandartPerson)ois.readObject();
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void run() {
        simpleSeriaz();
    }
}
