import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelLogin extends JPanel{
    //Cores
    Color roxo = new Color(0xFDB5ED);
    BotaoLogin botaoLogin;
    public PainelLogin(){

        this.setBackground(roxo);
        this.setLayout(null);
        this.setBounds((Utilidades.dimensoesProporçãoLargura(0.4)-350)/2, (Utilidades.dimensoesProporçãoAltura(1)-300) -30, 350, 200);
        this.setBorder(BorderFactory.createEtchedBorder());

        LabelIndicacao labelUsuario = new LabelIndicacao("Usuario:", new Font("Arial",Font.BOLD,20), roxo);
        labelUsuario.setBounds(15, 15, 100, 20);

        JTextField usuario = new JTextField();
        usuario.setBounds(15, 36, 320, 35);

        LabelIndicacao labelSenha = new LabelIndicacao("Senha:", new Font("Arial",Font.BOLD,20), roxo);
        labelSenha.setBounds(15, 76 ,100 ,20);
        JTextField senha = new JTextField();
        senha.setBounds(15, 97, 320, 35);

        botaoLogin = new BotaoLogin();

        this.add(labelUsuario);
        this.add(usuario);
        this.add(labelSenha);
        this.add(senha);
        this.add(botaoLogin);
    }
}
