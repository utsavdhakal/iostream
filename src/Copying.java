import java.io.*;
import java.util.Scanner;

public class Copying {

    private static void copy() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file: ");
        String source = sc.nextLine();

        System.out.print("Enter destination file: ");
        String destination = sc.nextLine();

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File Copied!");
    }

    private static void copy(String sourceFile, String destinationFile) {
        long startTime = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(destinationFile)) {
            int readByte;
            while ((readByte = in.read()) != -1) {
                out.write(readByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s copied in %d milliseconds", sourceFile, endTime - startTime);
    }

    private static void copyWithBuffer(String sourceFile, String destinationFile) {
        System.out.printf("%s consists of %d bytes\n", sourceFile, new File(sourceFile).length());

        long startTime = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            int numBytesRead;
            byte[] byteBuffer = new byte[10000];
            while ((numBytesRead = in.read(byteBuffer)) != -1) {
                out.write(byteBuffer, 0, numBytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s copied in %d milliseconds", sourceFile, endTime - startTime);
    }

    public static void main(String[] args) {
        String sourceFile = "mis/greenery.jpg";
        String destinationFile = "mis/greenery-copied.jpg";
        copy();
        copy(sourceFile, destinationFile);
        copyWithBuffer(sourceFile, destinationFile);
    }
}
