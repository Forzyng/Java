package Animals;

public class Tiger extends Animal{
    public boolean isFast;
    public Tiger(String habitation, String classofAnimal) {
        super(habitation, classofAnimal);
        isFast = true;
    }

    @Override
    public void sound() {
        System.out.println("RRRRRRRRR");
    }

    @Override
    public void eat() {
        System.out.println("Tiger eats meat");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("isFast: " + isFast);
    }

    public void run()
    {
        System.out.println("Tiger run for the meat");
    }
}
