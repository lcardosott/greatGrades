package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotaoLogin extends JButton implements ActionListener {
    public BotaoLogin(){
        this.setText("Log-in");
        this.setBounds(40, 145, 265,30);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this);
        /*
        Verificar se o usuário bate com a senha
        se sim, abrir a página principal
            frame.dispose();
            MainFrame mainFrame = new MainFrame();

        se não, avisar que o usuário ou senha está incorreto
            JOptionPane.showMessageDialog(null, "A senha ou usuário está incorreta. Tente novamente.", "Senha ou usuário inválido", JOptionPane.INFORMATION_MESSAGE);
        */
    }
}
