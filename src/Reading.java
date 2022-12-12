import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class Reading {
    private static void ReadWithInputStream(String file) {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(file)) {
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("%s reading completed in %d milliseconds.", file, elapsedTime);
    }

    private static void ReadWithInputStreamReader(String file) {
        long startTime = System.currentTimeMillis();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String lineText;
            while ((lineText = in.readLine()) != null) {
                System.out.println(lineText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("%s reading completed in %d milliseconds.", file, elapsedTime);
    }

    private static void ReadFromConsole() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            String lineRead;
            while ((lineRead = in.readLine()) != null && !lineRead.equals("quit")) {
                System.out.println(lineRead + " " + new Date());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadFromConsoleUsingScanner() {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println("Integer : " + input);
    }

    private static void ReadStringUsingScanner() {
        Scanner in = new Scanner("hello, i am a java developer\ni am using intellij idea and java 17");
        System.out.println(in.nextLine());
        System.out.println(in.nextLine());
    }

    public static void main(String[] args) {
         String file = "mis/.zshrc";
         ReadWithInputStream(file);
         ReadWithInputStreamReader(file);
         ReadFromConsole();
         ReadFromConsoleUsingScanner();
         ReadStringUsingScanner();
    }
}
