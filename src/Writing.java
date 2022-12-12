import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Writing {

    private static void downloadWebsite(String link, String file) {
        long startTime = System.currentTimeMillis();
        try {
            URL url = new URI(link).toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));

            String readLine;
            while ((readLine = in.readLine()) != null) {
                out.write(readLine + "\n");
            }

            in.close();
            out.close();
            con.disconnect();

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("%s\ndownloaded in %d milliseconds.", link, elapsedTime);
    }

    public static void main(String[] args) {
        String link = "https://docs.oracle.com/javase/8/docs/technotes/guides/net/overview/overview.html";
        String file = "networking-overview";
        downloadWebsite(link, file);
    }
}
