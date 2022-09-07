package MyStream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BaseStream {
    int[] num ;

    public void fillArr()
    {
        int max = 100;
        int min = -101;
        int range = max - min + 1;

        int size = max;
        num = new int[size];

        for (int i = 0; i < size; i++) {
            int rand = (int) (Math.random() * range) + min;
            num[i] = rand;
        }
        /*for(int i )
        {
            num[i] =
        }*/
    }

    public void run()
    {
        fillArr();
        long time;
        time = System.nanoTime();



        apiStyle();
        System.out.println(System.nanoTime() - time + " - time api");

        time = System.nanoTime();
        cStyle();

        System.out.println(System.nanoTime() - time + " - time cS");
    }

    private void methods()
    {
        var min = Arrays.stream(num).min();
        var max = Arrays.stream(num).max();
        var average = Arrays.stream(num).average();
        var first = Arrays.stream(num).findFirst();

        var skip = Arrays.stream(num).skip(10).toArray();
        var take = Arrays.stream(num).takeWhile(el -> el > 10).toArray();
        var sort = Arrays.stream(num).sorted().toArray();

    }

    private void apiStyle()
    {
        int countM = (int) Arrays.stream(num).filter(el -> el < 0).count();
        int countP = (int) IntStream.of(num).filter(el -> el > 0).count();

        System.out.println("Plus: " + countP);
        System.out.println("Minus: " + countM);
    }

    private void cStyle()
    {
        int countM = 0;
        int countP = 0;
        for(int i = 0; i < num.length; i++)
        {
            if(num[i] < 0) countM++;
            if(num[i] > 0) countP++;
        }

        System.out.println("Plus: " + countP);
        System.out.println("Minus: " + countM);
    }
}
