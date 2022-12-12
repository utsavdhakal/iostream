import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file: ");
        String source = sc.nextLine();

        System.out.print("Enter destination file: ");
        String destination = sc.nextLine();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();
        System.out.println("File Copied!");
    }
}
