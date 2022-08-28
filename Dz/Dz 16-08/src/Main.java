import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            // 1
            System.out.println("\"Your time is limited,");
            System.out.println("\tso dont waste it");
            System.out.println("\t\tliving someone elses life\"");
            System.out.println("\t\t\tSteve Jobs");

            // 2


            System.out.println("\nEnter number: ");
            String Number = reader.readLine();
            System.out.println("\nEnter percent: ");
            String Percent = reader.readLine();

            int n = Integer.parseInt(Number);
            int p = Integer.parseInt(Percent);

            float result = (n*p)/100;
            System.out.println("\nResult: " + result);

            // 3

            System.out.println("\nEnter first number: ");
            String Number1 = reader.readLine();
            System.out.println("\nEnter second number: ");
            String Number2 = reader.readLine();
            System.out.println("\nEnter third number: ");
            String Number3 = reader.readLine();

            if(Number1.length() == 1 && Number2.length() == 1 && Number3.length() == 1) {

                if (isNumber(Number1) && isNumber(Number2) && isNumber(Number3)) {
                    System.out.println("\nResult: " + Number1 + Number2 + Number3);
                }
            }
            else {
                System.out.println("Must be 1 symbol");
            }

            // 4
            System.out.println("\nNumber (6 symbols): ");
            String NumberToChange = reader.readLine();
            if(isNumber(NumberToChange) && NumberToChange.length() == 6)
            {
                int res = Integer.parseInt(replace(NumberToChange, 0, NumberToChange.length() - 1, 1, NumberToChange.length() - 2));
                System.out.println("Result: " + res);
            }else {
                System.out.println("Bad value");
            }

            // 5
            System.out.println("\nNumber of month: ");
            String NumberOfMonth = reader.readLine();
            if(isNumber(NumberOfMonth))
            {
                int valueM = Integer.parseInt(NumberOfMonth);
                if(valueM < 1 || valueM > 12)
                {
                    System.out.println("Bad value");
                }
                else {
                    if(valueM == 1 || valueM == 2 || valueM == 12)
                    {
                        System.out.println("Result: Winter");
                    }
                    else {
                        if(valueM >= 3 && valueM <= 5)
                        {
                            System.out.println("Result: Spring");
                        }
                        else
                        {
                            if(valueM >= 6 && valueM <= 8)
                            {
                                System.out.println("Result: Summer");
                            }
                            else
                            {
                                if(valueM >= 9 && valueM <= 11)
                                {
                                    System.out.println("Result: Autumn");
                                }
                            }
                        }
                    }

                }
            }else {
                System.out.println("Bad value");
            }

            // 6
            System.out.println("\nNumber of m: ");
            String NumberOfMetr = reader.readLine();
            if(isNumber(NumberOfMetr))
            {
                System.out.println("\n1 - Yardy ");
                System.out.println("2 - Dyumy ");
                System.out.println("3 - Mili ");
                System.out.println("Choice: ");
                String NChoice = reader.readLine();
                if(isNumber(NChoice))
                {
                    double yards = 1.09361;
                    double dyums = 39.3701;
                    double mili = 0.000621371;

                    switch (Integer.parseInt(NChoice)) {
                        case 1:
                            System.out.println("\nResult: " + Double.parseDouble(NumberOfMetr) *  yards);
                            break;
                        case 2:
                            System.out.println("\nResult: " + Double.parseDouble(NumberOfMetr) *  dyums);
                            break;
                        case 3:
                            System.out.println("\nResult: " + Double.parseDouble(NumberOfMetr) *  mili);
                            break;
                        default:
                            System.out.println("Bad data ");
                    }



                }else {
                    System.out.println("Bad value");
                }

            }else {
                System.out.println("Bad value");
            }



            // 7

            System.out.println("\nFirst Number: ");
            String FirstNumbIn = reader.readLine();
            System.out.println("\nSecond Number: ");
            String SecondNumbIn = reader.readLine();

            if(isNumber(FirstNumbIn) && isNumber(SecondNumbIn))
            {
                int val1 = Integer.parseInt(FirstNumbIn);
                int val2 = Integer.parseInt(SecondNumbIn);

                if(val2 < val1)
                {
                    int temp = val2;
                    val2 = val1;
                    val1 = temp;
                }
                    System.out.println("\nNot odd in this diapason: ");
                    for(int i = val1; i < val2; i++)
                    {
                        if(i % 2 != 0)
                        {
                            System.out.println(i);
                        }
                    }

            }
            else {
                System.out.println("Bad value");
            }

            // 8

            System.out.println("\nUmn Number: ");
            String NumberUmn = reader.readLine();
            System.out.println("\nTo Number: ");
            String ToNumber = reader.readLine();

            if(isNumber(NumberUmn) && isNumber(ToNumber))
            {
                int Umnval1 = Integer.parseInt(NumberUmn);
                int Toval2 = Integer.parseInt(ToNumber);

                System.out.println("\nDiapason: ");
                for (int a = 1; a <= Toval2; a++)
                {
                    System.out.println(Umnval1 * a);
                }
            } else {
                System.out.println("Bad value");
            }





            // 10


            int maxR = 10;
            int minR = -10;
            int rangeR = maxR - minR + 1;

            int MniejZeroR = 0;
            int WiecejZeroR = 0;
            int odd = 0;
            int notodd = 0;

            int randarr[];
            randarr = new int[maxR];

            System.out.println("\nRAND Result: ");
            // generate random numbers within 1 to 10
            for (int i = 0; i < maxR; i++) {
                int rand = (int)(Math.random() * rangeR) + minR;
                randarr[i] = rand;
                if(rand < 0)
                {
                    MniejZeroR++;
                }
                else {
                    if (rand > 0) {
                        WiecejZeroR++;
                    }
                }

                if(i % 2 == 0)
                {
                    odd++;
                }
                else
                {
                    notodd++;
                }
                System.out.println(randarr[i]);
            }

            int oddarr[];
            oddarr = new int[odd];
            for (int i = 0; i < maxR; i++) {
                if(randarr[i] % 2 == 0)
                {
                    for(int j = 0; j < oddarr.length; j++)
                    {
                        if(oddarr[j] == 0)
                        {
                            oddarr[j] = randarr[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("Odd array: ");
            for(int i = 0; i < oddarr.length; i++)
            {
                System.out.println(oddarr[i]);
            }

            int notoddarr[];
            notoddarr = new int[notodd];
            for (int i = 0; i < maxR; i++) {
                if(randarr[i] % 2 != 0)
                {
                    for(int j = 0; j < notoddarr.length; j++)
                    {
                        if(notoddarr[j] == 0)
                        {
                            notoddarr[j] = randarr[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("Not Odd array: ");
            for(int i = 0; i < notoddarr.length; i++)
            {
                System.out.println(notoddarr[i]);
            }

            int mniejarr[];
            mniejarr = new int[MniejZeroR];
            for (int i = 0; i < maxR; i++) {
                if(randarr[i] < 0)
                {
                    for(int j = 0; j < mniejarr.length; j++)
                    {
                        if(mniejarr[j] == 0)
                        {
                            mniejarr[j] = randarr[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("< 0 array: ");
            for(int i = 0; i < mniejarr.length; i++)
            {
                System.out.println(mniejarr[i]);
            }

            int wiecejarr[];
            wiecejarr = new int[WiecejZeroR];
            for (int i = 0; i < maxR; i++) {
                if(randarr[i] > 0)
                {
                    for(int j = 0; j < wiecejarr.length; j++)
                    {
                        if(wiecejarr[j] == 0)
                        {
                            wiecejarr[j] = randarr[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("> 0 array: ");
            for(int i = 0; i < wiecejarr.length; i++)
            {
                System.out.println(wiecejarr[i]);
            }



            // 11

            System.out.print("\nSymbol: ");
            String Symbol = reader.readLine();
            System.out.print("\nIs vertical (Y/N): ");
            String Vertical = reader.readLine();
            System.out.print("\nLength: ");
            String Length = reader.readLine();

            if(Symbol.length() == 1 && isNumber(Length))
            {
                if(Vertical.equalsIgnoreCase("y") || Vertical.equalsIgnoreCase("n"))
                {
                    boolean bl = false;
                    if(Vertical.equalsIgnoreCase("y"))
                    {
                        bl = true;
                    }
                    printLine(Symbol, bl, Integer.parseInt(Length));
                }
                else {
                    System.out.println("Bad value");
                }
            }else {
                System.out.println("Bad value");
            }



            // 9


            int max = 10;
            int min = -10;
            int range = max - min + 1;

            int MniejZero = 0;
            int WiecejZero = 0;
            int Zero = 0;

            int nums[];
            nums = new int[max];

            System.out.println("\nRAND Result: ");
            // generate random numbers within 1 to 10
            for (int i = 0; i < max; i++) {
                int rand = (int)(Math.random() * range) + min;
                nums[i] = rand;
                if(rand < 0)
                {
                    MniejZero++;
                }
                else {
                    if (rand > 0) {
                        WiecejZero++;
                    } else {
                            Zero++;
                    }
                }
                // Output is different everytime this code is executed
                System.out.println(nums[i]);
            }

            System.out.println("\n< 0: " + MniejZero);
            System.out.println("> 0: " + WiecejZero);
            System.out.println("= 0: " + Zero);

            System.out.print("\nEnter your sort(1+|2-):");
            String Sort = reader.readLine();
            int newArr[];
            if(isNumber(Sort))
            {
                int spVal = Integer.parseInt(Sort);
                if(spVal == 1)
                {
                    newArr = bubbleSort1(nums);
                    System.out.println("\nSorted Arr:");
                    for (int i = 0; i < newArr.length; i++) {
                        System.out.println(newArr[i]);
                    }
                }
                else
                {
                    if(spVal == 2)
                    {
                        newArr = bubbleSort2(nums);
                        System.out.println("\nSorted Arr:");
                        for (int i = 0; i < newArr.length; i++) {
                            System.out.println(newArr[i]);
                        }
                    }
                    else
                    {
                        System.out.println("Bad value");
                    }
                }
            }
            else
            {
                System.out.println("Bad value");
            }

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static int[] bubbleSort1(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }

        return arr;
}

    public static int[] bubbleSort2(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] < arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static boolean isNumber(String str)
    {
        try {
            int iVal = Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e) {
            System.out.println("Cannot parse the string to integer");
        }
        return false;
    }

    public static void printLine(String symbol, boolean isVertical, int length)
    {
        if(length>0) {
            if (isVertical) {
                for (int i = 0; i < length; i++) {
                    System.out.println(symbol);
                }
            } else {
                for (int i = 0; i < length; i++) {
                    System.out.print(symbol);
                }
            }
        }
    }

    public static String replace(String number, int first, int last, int second, int prelast) throws Exception {

        char firstChar = number.charAt(first);
        char lastChar = number.charAt(last);
        char secondChar = number.charAt(second);
        char prelastChar = number.charAt(prelast);

        char[] strChars = number.toCharArray();
        strChars[first] = lastChar;
        strChars[last] = firstChar;
        strChars[second] = prelastChar;
        strChars[prelast] = secondChar;

        return new String(strChars);
    }

}
