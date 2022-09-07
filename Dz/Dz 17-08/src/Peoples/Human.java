package Peoples;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {
    public String name;
    public int years;
    public int height;
    public int weight;
    public String profession;

    public void display()
    {
        System.out.println("\nInfo");
        System.out.println("Name: " + name);
        System.out.println("Years: " + years);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Profession: " + profession);
    }
}
