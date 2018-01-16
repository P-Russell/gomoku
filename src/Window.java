import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{

    public Window(int width, int height, String title, TestPlay p){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(p);
        frame.setVisible(true);
    }
}
