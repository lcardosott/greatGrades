package view.firstPage;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoLogin extends JButton{
    public BotaoLogin(){
        this.setText("Log-in");
        this.setBounds(40, 145, 265,30);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}
