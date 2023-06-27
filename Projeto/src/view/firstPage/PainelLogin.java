package view.firstPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Login;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;

public class PainelLogin extends JPanel implements ActionListener{
    //Cores
    private Color roxo = new Color(0xFDB5ED);
    private BotaoLogin botaoLogin;
    private JTextField usuario;
    private JTextField senha;
    private Frame frame;

    public PainelLogin(Frame frame) {
        this.frame = frame;
        this.setBackground(roxo);
        this.setLayout(null);
        this.setBounds((Utilidades.dimensoesProporçãoLargura(0.4)-350)/2, (Utilidades.dimensoesProporçãoAltura(1)-300) -30, 350, 200);
        this.setBorder(BorderFactory.createEtchedBorder());

        LabelIndicacao labelUsuario = new LabelIndicacao("Usuario:", new Font("Arial",Font.BOLD,20), roxo);
        labelUsuario.setBounds(15, 15, 100, 20);

        usuario = new JTextField();
        usuario.setBounds(15, 36, 320, 35);

        LabelIndicacao labelSenha = new LabelIndicacao("Senha:", new Font("Arial",Font.BOLD,20), roxo);
        labelSenha.setBounds(15, 76 ,100 ,20);
        senha = new JTextField();
        senha.setBounds(15, 97, 320, 35);

        botaoLogin = new BotaoLogin();
        botaoLogin.addActionListener(this);

        this.add(labelUsuario);
        this.add(usuario);
        this.add(labelSenha);
        this.add(senha);
        this.add(botaoLogin);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoLogin) {
            String usuarioStr = usuario.getText();
            String senhaStr = senha.getText();
            new Login(frame, usuarioStr, senhaStr);
        }
    }
}
