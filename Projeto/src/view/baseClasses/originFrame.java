package view.baseClasses;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class originFrame extends JFrame {
    public originFrame() {
        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");
        this.setSize(Utilidades.redimensionarFrameTotal());
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setLayout(null); //positions defined explicitly by the programmer
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.WHITE);
    }
}