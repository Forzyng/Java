package entities;


import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    public String Name;
    @Getter
    @Setter
    public String Email;

    @Override
    public String toString() {
        return "User {" +
                " Name - " + Name + " | "
                + "Email - " + Email + " }";
    }
}
