package work;

public class MyFirstWork {
    public void DoCalc()
    {
        try
        {
            int a = 10;
            System.out.println(a / 0);
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void DoMyCalc() throws Exception
    {
        int a = 10;
        int b = 0;
        if(b == 0) throw new Exception("The number is 0");
        System.out.println(a / b);
    }
}
