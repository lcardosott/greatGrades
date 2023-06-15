package view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyFrame extends JFrame {
    public MyFrame() {
        //Colors
        Color bgMenuColor = new Color(231, 134, 255);

        //Logo image
        ImageIcon image = new ImageIcon("Logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(bgMenuColor);

        //Labels
        JLabel label = new JLabel();
        label.setText("Bem vindo ao GreatGrades!");
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setBackground(bgMenuColor);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP);
        //label.setIcon(image);
        this.add(label);

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setBounds(0, 0, 480, 50);

        //Default settings
        this.setSize(500, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setVisible(true);
        this.setLayout(null);
    }
}