import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoCadastro extends JButton implements ActionListener{
    public BotaoCadastro(){
        this.setText("Cadastrar");
        this.setBounds(75, 412, 350,50);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this);
    }
}
