package view.menuprincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.addMateria.FrameAddMateria;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;
import model.Usuario;

public class PainelInferiorDireito extends JPanel implements ActionListener {
    private Usuario user;
    private BotaoAdicionaMateira botaoAdicionaMateria;
    private JFrame framePrincipal;

    public PainelInferiorDireito(JFrame framePrincipal, Usuario usuario){
        this.framePrincipal = framePrincipal;
        this.user = usuario;
        //fonte
        Font fonteBasica = new Font("Arial",Font.PLAIN,20);

        //Informaçoes basicas
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setBounds(Utilidades.dimensoesProporçãoLargura(0.7)+1,Utilidades.dimensoesProporçãoAltura(0.10) +1, Utilidades.dimensoesProporçãoLargura(0.3)-1,Utilidades.dimensoesProporçãoAltura(0.9)-1);

        //Imagem
        ImageIcon perfil = new ImageIcon("imagens/user.png");
        ImageIcon resizedPerfil = Utilidades.resizeImage(perfil, 100, 100);

        //ICONE PERFIL
        JLabel icone = new JLabel();
        icone.setBackground(Color.white);
        icone.setIcon(resizedPerfil);
        icone.setOpaque(true);
        icone.setBounds(23, 75,100, 100);
        
        //Meu perfil:
        LabelIndicacao labelPerfil= new LabelIndicacao("Meu Perfil:", new Font("Arial",Font.BOLD,25), Color.WHITE);
        labelPerfil.setBounds(20,20, 250,25);

        //Nome
        LabelIndicacao labelNome = new LabelIndicacao("Nome: " + usuario.getNome(), fonteBasica, Color.WHITE);
        labelNome.setBounds(146,78, 250,20);

        //Instituição
        LabelIndicacao labelInstituicao = new LabelIndicacao("Instituição: " + usuario.getFaculdade(), fonteBasica, Color.WHITE);
        labelInstituicao.setBounds(146,108, 250,20);

         //Curso
        LabelIndicacao labelCurso = new LabelIndicacao("Curso: " + usuario.getCurso(), fonteBasica, Color.WHITE);
        labelCurso.setBounds(146,138, 250,20);

        botaoAdicionaMateria = new BotaoAdicionaMateira();
        botaoAdicionaMateria.addActionListener(this);
        botaoAdicionaMateria.setBounds(Utilidades.dimensoesProporçãoLargura(0.025),Utilidades.dimensoesProporçãoAltura(0.9)-150,Utilidades.dimensoesProporçãoLargura(0.25),Utilidades.dimensoesProporçãoAltura(0.08));

        this.add(labelPerfil);
        this.add(botaoAdicionaMateria);
        this.add(icone) ;
        this.add(labelNome) ;
        this.add(labelInstituicao) ;
        this.add(labelCurso) ;
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAdicionaMateria) {
            framePrincipal.dispose();
            new FrameAddMateria(framePrincipal, user);
        }
    }
}