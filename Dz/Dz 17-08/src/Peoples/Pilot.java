package Peoples;

public class Pilot extends Human{
    private String company;
    private String transport;
    public Pilot(String name, int years, int height, int weight, String profession, String company, String transport) {
        super(name, years, height, weight, profession);
        this.company = company;
        this.transport = transport;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Company: " + company);
        System.out.println("Transport: " + transport);
    }

    public void piloting()
    {
        System.out.println("Pilot is piloting ");
    }
}
