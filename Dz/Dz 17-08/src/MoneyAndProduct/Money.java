package MoneyAndProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class Money {
    public String currency;
    public int valueBeforeZero;
    public int valueAfterZero;

    public void display()
    {
        System.out.println(valueBeforeZero + "." + valueAfterZero + " " + currency);
    }
}
