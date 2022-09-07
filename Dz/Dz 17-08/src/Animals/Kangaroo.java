package Animals;

public class Kangaroo extends Animal{
    public boolean isOntwoLegs;
    public Kangaroo(String habitation, String classofAnimal) {
        super(habitation, classofAnimal);
        isOntwoLegs = true;
    }

    @Override
    public void sound() {
        System.out.println("Sound of jumping kangaroo");
    }

    @Override
    public void eat() {
        System.out.println("kangaroo eats fruits");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("isOntwoLegs: " + isOntwoLegs);
    }

    public void jump()
    {
        System.out.println("Kangaroo jumped");
    }
}
