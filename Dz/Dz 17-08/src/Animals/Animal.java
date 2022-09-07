package Animals;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {
    public String habitation;
    public String classofAnimal;
    public void sound()
    {
        System.out.println("???");
    }
    public void eat()
    {
        System.out.println("???");
    }
    public void display()
    {
        System.out.println("\nhabitation: " + habitation);
        System.out.println("classofAnimal: " + classofAnimal);
    }
}
