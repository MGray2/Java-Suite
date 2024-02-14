import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

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
