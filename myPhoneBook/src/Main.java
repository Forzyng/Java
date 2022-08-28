import fileOperations.simpleFile;
import fileSeriazable.simpleSerialization;
import phoneBook.PhoneBookView;

public class Main {
    public static void main(String[] args) {
        /*PhoneBookView phoneBookView = new PhoneBookView();
        phoneBookView.run();*/
        /*simpleFile simp = new simpleFile();
        simp.run();*/
        simpleSerialization simpS = new simpleSerialization();
        simpS.run();
    }
}