import javax.swing.*;
import java.awt.*;
import java.time.*;

public class JavaSuite {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Java Suite™");
        frame.setSize(690, 420); // window size
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // needed to see window
        ImageIcon logo = new ImageIcon("images/java.svg");
        frame.setIconImage(logo.getImage());

        // Get the current time
        LocalTime currentTime = LocalTime.now();
        LocalTime evening = LocalTime.parse("18:00:00");
        LocalTime morning = LocalTime.parse("06:00:00");
        if (currentTime.isAfter(evening) || currentTime.isBefore(morning)) {
            frame.getContentPane().setBackground(Color.black);
        } else {
            frame.getContentPane().setBackground(Color.white);
        }

    }
}
