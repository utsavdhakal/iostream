import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);

        int data = fis.read();
        while (data != -1) {
            fos.write(data);
            data = fis.read();
        }
        fis.close();
        fos.close();
        System.out.println("File Copied!");
    }
}
