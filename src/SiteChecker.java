import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;

// not tested, allegedly returns true if website is accessible, false otherwise
public class SiteChecker {
    public static boolean isSiteUp(URL site) {
        try {
            HttpURLConnection conn = (HttpURLConnection) site.openConnection();
            conn.getContent();
            return conn.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (SocketTimeoutException tout) {
            return false;
        } catch (IOException ioex) {
            // You may decide on more specific behaviour...
            return false;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            System.out.println("Enter url here");
            String link = scanner.nextLine();
            URL url = new URL(link);
            boolean available = SiteChecker.isSiteUp(url);
            if (available) {
                System.out.println("Website is online.");
            } else {
                System.out.println("Website is Offline.");
            }
        } catch (Exception e) {
            System.err.println("Invalid Url");
        }

    }
}