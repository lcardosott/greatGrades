import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setSize(420, 420);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setVisible(true);

        ImageIcon image = new ImageIcon("Logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(231, 134, 255));
    }
}
