import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient implements Runnable{
    @Override
    public void run() {
        try
        {
            InetAddress address = InetAddress.getByName(null);
            Socket socket = new Socket(address, 8080);

            BufferedReader in = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            for(int i = 0; i < 5; i++)
            {
                out.println("Hi " + i);
                String str = in.readLine();

                if(str.equals("END"))
                {
                    break;
                }
                out.println(str);
                System.out.println(str);
            }

            out.println("END");

            socket.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
