package view.firstPage;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoCadastro extends JButton{
    public BotaoCadastro(){
        this.setText("Cadastrar");
        this.setBounds(75, 412, 350,50);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}