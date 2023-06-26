package view.menuprincipal;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoMateria extends JButton {
    public BotaoMateria(){
        this.setText("Visualizar");
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setFocusPainted(false);
    }
}
