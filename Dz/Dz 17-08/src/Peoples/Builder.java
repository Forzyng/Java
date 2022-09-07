package Peoples;

public class Builder extends Human{
    private String inTeam;
    private String instruments;
    public Builder(String name, int years, int height, int weight, String profession, String instruments, String inTeam) {
        super(name, years, height, weight, profession);
        this.instruments = instruments;
        this.inTeam = inTeam;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Peoples in team: : " + inTeam);
        System.out.println("Instruments: " + instruments);
    }

    public void build()
    {
        System.out.println("Builder is building ");
    }
}
