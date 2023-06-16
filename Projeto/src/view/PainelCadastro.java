package view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastro extends JPanel{
    //Cores
    Color roxo = new Color(0xFDB5ED);
    BotaoCadastro botaoCadastro;
    public PainelCadastro(){
        this.setBackground(roxo);
        this.setLayout(null);
        this.setBounds((Utilidades.dimensoesProporçãoLargura(0.6)-500)/2, (Utilidades.dimensoesProporçãoAltura(1)-500)/2 -30, 500, 500);
        this.setBorder(BorderFactory.createEtchedBorder());


        JTextField nomeCadastro = new JTextField();
        nomeCadastro.setBounds(35, 101, 430, 35);

        JTextField usuarioCadastro = new JTextField();
        usuarioCadastro.setBounds(35, 166, 430, 35);

        JTextField instituicaoCadastro = new JTextField();
        instituicaoCadastro.setBounds(35, 226, 430, 35);

        JTextField cursoCadastro = new JTextField();
        cursoCadastro.setBounds(35, 286, 430, 35);

        JTextField senhaCadastro = new JTextField();
        senhaCadastro.setBounds(35, 346, 430, 35);

        botaoCadastro= new BotaoCadastro();

        //Label que carrega o cadastro
        LabelIndicacao labelNovo = new LabelIndicacao("Novo por aqui?", new Font("Arial",Font.BOLD,30), roxo);
        labelNovo.setBounds(35,35,400,30);

        LabelIndicacao labelNome = new LabelIndicacao("Nome:", new Font("Arial",Font.BOLD,20), roxo);
        labelNome.setBounds(35, 80 ,300 ,20);

        LabelIndicacao labelUsuario = new LabelIndicacao("Usuario:", new Font("Arial",Font.BOLD,20), roxo);
        labelUsuario.setBounds(35, 145 ,300 ,20);

        LabelIndicacao labelInstituicao = new LabelIndicacao("Instituição:", new Font("Arial",Font.BOLD,20), roxo);
        labelInstituicao.setBounds(35, 205 ,300 ,20);
        
        LabelIndicacao labelCurso = new LabelIndicacao("Curso:", new Font("Arial",Font.BOLD,20), roxo);
        labelCurso.setBounds(35, 265,300 ,20);

        LabelIndicacao labelSenha = new LabelIndicacao("Senha:", new Font("Arial",Font.BOLD,20), roxo);
        labelSenha.setBounds(35, 325 ,300 ,20);

        this.add(labelNovo);
        this.add(labelNome);
        this.add(labelUsuario);
        this.add(labelInstituicao);
        this.add(labelCurso);
        this.add(labelSenha);
        this.add(nomeCadastro);
        this.add(usuarioCadastro);
        this.add(instituicaoCadastro);
        this.add(cursoCadastro);
        this.add(senhaCadastro);
        this.add(botaoCadastro);
    }
    
}
