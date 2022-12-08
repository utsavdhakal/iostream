import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingToFile {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        fos.write(5);
        System.out.println("Saved!");
        fos.close();
    }
}
