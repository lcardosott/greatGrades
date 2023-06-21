package view.cadastroAvaliacao;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoCadastroAvaliacao extends JButton {
    public BotaoCadastroAvaliacao() {
        this.setText("Cadastrar avaliação");
        this.setBounds(75, 620, 350,50);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setVisible(true);
    }
}
