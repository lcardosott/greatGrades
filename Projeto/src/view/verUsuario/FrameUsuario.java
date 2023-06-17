package view.verUsuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Usuario;
import view.LabelIndicacao;
import view.Utilidades;
import view.originFrame;

public class FrameUsuario extends originFrame {
    private Color roxo = new Color(0xFDB5ED);
    private ImageIcon fundo = new ImageIcon("imagens/fundo.png");
    
    public FrameUsuario(Usuario user) {
        JPanel painel = new JPanel();

        painel.setBackground(roxo);
        painel.setLayout(null);
        painel.setBounds(Utilidades.dimensoesProporçãoAltura(0.5), Utilidades.dimensoesProporçãoAltura(0.01), 500, 500);
        painel.setBorder(BorderFactory.createEtchedBorder());

        //Título
        LabelIndicacao labelTitulo = new LabelIndicacao("Informações do Usuário", new Font("Arial",Font.BOLD,35), roxo);
        labelTitulo.setBounds(65, 30, 500, 50);

        //Usuário
        LabelIndicacao labelUsuario = new LabelIndicacao("Usuário: " + user.getUsuario(), new Font("Arial",Font.BOLD,20), roxo);
        labelUsuario.setBounds(70, 80, 500, 50);

        //Nome
        LabelIndicacao labelNome = new LabelIndicacao("Nome: " + user.getNome(), new Font("Arial",Font.BOLD,20), roxo);
        labelNome.setBounds(70, 120, 500, 50);

        //Instituição
        LabelIndicacao labelInstituicao = new LabelIndicacao("Instituição: " + user.getFaculdade(), new Font("Arial",Font.BOLD,20), roxo);
        labelInstituicao.setBounds(70, 160 ,500,50);

        //Curso
        LabelIndicacao labelCurso = new LabelIndicacao("Curso: " + user.getCurso(), new Font("Arial",Font.BOLD,20), roxo);
        labelCurso.setBounds(70, 200,500 ,50);

        //Label que carrega o fundo
        JLabel labelFundo = new JLabel();
        labelFundo.setBackground(Color.WHITE);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setBounds(Utilidades.dimensoesProporçãoLargura(1)-fundo.getIconWidth(),Utilidades.dimensoesProporçãoAltura(1)-fundo.getIconHeight(), fundo.getIconWidth(), fundo.getIconHeight());

        //Adicionando no Painel
        //Título
        painel.add(labelTitulo);
        //Usuário
        painel.add(labelUsuario);
        //Nome
        painel.add(labelNome);
        //Instituição
        painel.add(labelInstituicao);
        //Nota
        painel.add(labelCurso);
        //Visibilidade
        this.setVisible(true);
        this.add(painel);
        this.add(labelFundo);
    }
}
