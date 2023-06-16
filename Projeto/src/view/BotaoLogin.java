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
    }
}
