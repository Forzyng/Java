import Animals.Crocodile;
import Peoples.Sailor;

public class Main {
    public static void main(String[] args) {
        // 1
        Sailor sailor = new Sailor("Andrew", 21, 179, 89, "Sailor", "Sail Company", "Big ship");
        sailor.display();
        sailor.sail();

        // 2

        Crocodile crocodile = new Crocodile("Zoo", "Amphibian");
        crocodile.eat();
        crocodile.sound();
        crocodile.display();

        // 3


    }
}