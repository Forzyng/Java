package phoneBook;

import lombok.Data;

@Data

public class Contact implements Cloneable {
    String name;
    String number;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
