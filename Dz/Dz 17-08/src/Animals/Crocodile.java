package Animals;

public class Crocodile extends Animal{
    public boolean isCanSwim;
    public Crocodile(String habitation, String classofAnimal) {
        super(habitation, classofAnimal);
        isCanSwim = true;
    }

    @Override
    public void sound() {
        System.out.println("\nRRRRRRRRR (but as Croco)");
    }

    @Override
    public void eat() {
        System.out.println("\nCroco eats meat");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("isCanSwim: " + isCanSwim);
    }

    public void swim()
    {
        System.out.println("\nCroco swim");
    }
}
