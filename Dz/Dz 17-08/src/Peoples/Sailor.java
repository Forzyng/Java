package Peoples;

public class Sailor extends Human{
    String company;
    String typeOfShip;
    public Sailor(String name, int years, int height, int weight, String profession, String company, String typeOfShip) {
        super(name, years, height, weight, profession);
        this.typeOfShip = typeOfShip;
        this.company = company;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Company: " + company);
        System.out.println("Type of Ship: " + typeOfShip);
    }

    public void sail()
    {
        System.out.println("Sailor is sailing ");
    }
}
