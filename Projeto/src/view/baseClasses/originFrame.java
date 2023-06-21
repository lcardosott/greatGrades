package view.baseClasses;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class originFrame extends JFrame {
    public originFrame() {
        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");
        this.setSize(Utilidades.redimensionarFrameTotal());
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(null); //positions defined explicitly by the programmer
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setIconImage(logo.getImage());
    }
}