package fileOperations;
import java.io.*;

public class simpleFile implements Runnable {
    private String FileName = "text.txt";

    private String text = "Hello world!";


    FileOutputStream out;
    BufferedOutputStream bos;

    public void SimpleFile() throws FileNotFoundException {
        out = new FileOutputStream(FileName);
        bos = new BufferedOutputStream(out);
    }

    private void writeFileByte() throws IOException {
        FileOutputStream fos = new FileOutputStream(FileName);
        byte[] buffer = text.getBytes();

        fos.write(buffer, 0, buffer.length);
        System.out.println("The file has been written");
        fos.close();
    }

    private void readFilebyte() throws IOException
    {
        FileInputStream fin = new FileInputStream(FileName);
        System.out.printf("File size: %d bytes \n", fin.available());

        int i=-1;
        while((i=fin.read())!=-1){

            System.out.print((char)i);
        }
        fin.close();
    }


    private void  firstData() throws IOException {
        String t = "First text";
        bos.write(t.getBytes());
    }

    private void  secondData() throws IOException {
        String t = "Second text";
        bos.write(t.getBytes());
    }

    @Override
    public void run() {
        try {
            //writeFileByte();
            readFilebyte();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
