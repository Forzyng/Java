interface OperSum {
    int sum (int x, int y);
}

public class MyFirstOperation implements Runnable{
    private void SimpleLambda()
    {
        OperSum operSum;
        operSum = (x,y) -> x + y;
    }
    @Override
    public void run() {

    }
}
