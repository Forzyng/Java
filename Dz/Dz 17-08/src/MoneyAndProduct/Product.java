package MoneyAndProduct;

public class Product extends Money{
    public String name;
    private String id;
    public String type;
    public Product(String currency, int valueBeforeZero, int valueAfterZero, String name, String type, String id) {
        super(currency, valueBeforeZero, valueAfterZero);
        this.type = type;
        this.id = id;
        this.name = name;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: " + type);
        System.out.println("Id: " + id);
        System.out.println("Name: "  + name);
    }

    public void MinusNumber(float number)
    {

    }
}
