package view.menuprincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Deletar;
import model.Materia;
import model.Usuario;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;
import view.verMateria.FrameMateria;

public class InfoMateria extends JPanel implements ActionListener{
    private Materia materiaClasse;
    private BotaoMateria botao;
    private JButton x;
    private JButton mais;
    private JButton menos;
    private LabelIndicacao numeroFaltas;
    private JFrame framePrincipal;

    public InfoMateria(Materia materia, JFrame framePrincipal){
        this.framePrincipal = framePrincipal;
        //Border
        Border border = BorderFactory.createLineBorder(Color.white,10);
        //Cor
        Color roxo = new Color(0xFDB5ED);
        //this.painelClasse = painel;
        this.materiaClasse= materia;
        //Seta parametros basicos
        this.setLayout(null);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(Utilidades.dimensoesProporçãoLargura(0.65), Utilidades.dimensoesProporçãoAltura(0.35)));
        this.setBackground(roxo);


        //Imagem
        ImageIcon imagem = new ImageIcon("imagens/materia.png");
        ImageIcon resizedImagem = Utilidades.resizeImage(imagem, Utilidades.dimensoesProporçãoAltura(0.2), Utilidades.dimensoesProporçãoAltura(0.2));

        //ICONE PERFIL
        JLabel icone = new JLabel();
        icone.setBackground(roxo);
        icone.setIcon(resizedImagem);
        icone.setOpaque(true);
        icone.setBounds(50,Utilidades.dimensoesProporçãoAltura(0.07), Utilidades.dimensoesProporçãoAltura(0.2), Utilidades.dimensoesProporçãoAltura(0.2));
        

        //Botao ver materia
        this.botao = new BotaoMateria();
        this.botao.addActionListener(this);
        this.botao.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1),
        Utilidades.dimensoesProporçãoAltura(0.35)-Utilidades.dimensoesProporçãoAltura(0.05)-50,
        Utilidades.dimensoesProporçãoLargura(0.1), 
        Utilidades.dimensoesProporçãoAltura(0.05));

        //########################################################
        //Label
        LabelIndicacao falta = new LabelIndicacao("Faltas:",new Font("Arial",Font.BOLD,20), roxo);
        falta.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)-100, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,95,23);

        //Faltasssss
        this.numeroFaltas = new LabelIndicacao(Integer.toString(materia.getFaltas()), new Font("Arial",Font.BOLD,20), Color.white);
        numeroFaltas.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)+5, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,60,23);
        numeroFaltas.setBorder(BorderFactory.createLineBorder(Color.black,1));
        numeroFaltas.setHorizontalAlignment(JLabel.CENTER);

        this.mais = new JButton();
        this.mais.setText("+");
        this.mais.setFont(new Font("Arial",Font.BOLD,20));
        this.mais.setBackground(new Color(0XFFD954));
        this.mais.setForeground(Color.WHITE);
        this.mais.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.mais.setFocusPainted(false);
        this.mais.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1) + 68, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,23,23);
        mais.addActionListener(this);

        this.menos = new JButton();
        this.menos.setText("-");
        this.menos.setFont(new Font("Arial",Font.BOLD,20));
        this.menos.setBackground(new Color(0XFFD954));
        this.menos.setForeground(Color.WHITE);
        this.menos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.menos.setFocusPainted(false);
        this.menos.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1) + 95, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,23,23);
        menos.addActionListener(this);


        //Warninggg
        LabelIndicacao warning = new LabelIndicacao("Você pode faltar mais " + materia.calcNumFaltasRestantes()+ " vezes.", new Font("Arial",Font.BOLD,12), roxo);
        warning.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)-100, Utilidades.dimensoesProporçãoAltura(0.07)+ 50,230,15);
        this.add(warning);

        //Delete
        this.x = new JButton("x");
        this.x.setFont(new Font("Arial",Font.BOLD,20));
        this.x.setForeground(Color.white);
        this.x.setBackground(Color.red);
        this.x.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        this.x.setFocusPainted(false);
        this.x.setBounds(Utilidades.dimensoesProporçãoLargura(0.65),10,Utilidades.dimensoesProporçãoAltura(0.03), Utilidades.dimensoesProporçãoAltura(0.03));
        this.x.addActionListener(this);
        this.add(x);


        //########################################################
        //Informacoes materia
        LabelIndicacao labelNome = new LabelIndicacao(materia.getNome(), new Font("Arial",Font.BOLD,30), roxo);
        labelNome.setBounds(60+Utilidades.dimensoesProporçãoAltura(0.2),Utilidades.dimensoesProporçãoAltura(0.11), 400, 30);
        
        //turma
        LabelIndicacao labelTurma = new LabelIndicacao("Turma: "+ materia.getTurma(), new Font("Arial",Font.PLAIN,15), roxo);
        labelTurma.setBounds(60+Utilidades.dimensoesProporçãoAltura(0.2),Utilidades.dimensoesProporçãoAltura(0.11)+57, 400, 15);

        //professor
        LabelIndicacao labelProf = new LabelIndicacao(materia.getNomeProfessor(), new Font("Arial",Font.PLAIN,20), roxo);
        labelProf .setBounds(60+Utilidades.dimensoesProporçãoAltura(0.2),Utilidades.dimensoesProporçãoAltura(0.11) +35, 400, 20);

        this.add(falta);
        this.add(labelNome);
        this.add(labelProf);
        this.add(labelTurma);
        this.add(numeroFaltas);
        this.add(mais);
        this.add(menos);
        this.add(botao);
        this.add(icone);
    }

    public void operaFalta(Materia materia, int numero){
        materia.setFaltas(materia.getFaltas() + numero);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botao) {
            //abrir o frame da matéria
            new FrameMateria(materiaClasse);
        }

        if (e.getSource() == x) {
            Deletar.deletarMateria(materiaClasse);
            //this.painelClasse.repaint();
            Usuario user = ((FramePrincipal) framePrincipal).getUser();
            framePrincipal.dispose();
            new FramePrincipal(user);
        }

        if (e.getSource() == mais) {
            materiaClasse.setFaltas(materiaClasse.getFaltas() + 1);
            this.numeroFaltas.validate();
            Usuario user = ((FramePrincipal) framePrincipal).getUser();
            framePrincipal.dispose();
            new FramePrincipal(user);
        }

        if (e.getSource() == menos) {
            materiaClasse.setFaltas(materiaClasse.getFaltas() - 1);
            this.numeroFaltas.validate();
            Usuario user = ((FramePrincipal) framePrincipal).getUser();
            framePrincipal.dispose();
            new FramePrincipal(user);
        }
    }
}
