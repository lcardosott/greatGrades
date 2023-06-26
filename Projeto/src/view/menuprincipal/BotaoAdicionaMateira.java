package view.menuprincipal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoAdicionaMateira extends JButton {
        public BotaoAdicionaMateira(){
        //COR
        Color rosa = new Color(0xD541CD);
        this.setText("+ Cadastrar Materia");
        this.setFont(new Font("Arial",Font.BOLD,20));
        this.setBackground(rosa);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setFocusPainted(false);
        }
}
