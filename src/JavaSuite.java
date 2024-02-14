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
        LocalTime evening = LocalTime.parse("20:00:00");
        LocalTime morning = LocalTime.parse("08:00:00");

        JLabel title = new JLabel("Java Suite"); // the title
        title.setFont(title.getFont().deriveFont(30f));

        if (currentTime.isAfter(evening) || currentTime.isBefore(morning)) {
            frame.getContentPane().setBackground(new Color(28, 28, 28));
            title.setForeground(Color.white);
        } else {
            frame.getContentPane().setBackground(Color.white);
            title.setForeground(Color.black);
        }
        frame.add(title);



    }
}
