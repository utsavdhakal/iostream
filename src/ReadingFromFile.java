import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingFromFile {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        int data = fis.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
