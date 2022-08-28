package phoneBook;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PhoneBook {
    ArrayList<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<Contact>();
    }

    public void add(Contact c)
    {
        contacts.add(c);
    }

    public void print()
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            System.out.println(contacts.get(i));
        }
    }

    public void doMe(@NotNull Contact s)
    {
        s.setName("InPhone book");
        System.out.println(s);
    }
}
