package view.menuprincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Materia;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;

public class InfoMateria extends JPanel{
    public InfoMateria(Materia materia){

        //Border
        Border border = BorderFactory.createLineBorder(Color.white,10);
        //Cor
        Color roxo = new Color(0xFDB5ED);

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
        BotaoMateria botao = new BotaoMateria();
        botao.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1),
        Utilidades.dimensoesProporçãoAltura(0.35)-Utilidades.dimensoesProporçãoAltura(0.05)-50,
        Utilidades.dimensoesProporçãoLargura(0.1), 
        Utilidades.dimensoesProporçãoAltura(0.05));

        //########################################################
        //Label
        LabelIndicacao falta = new LabelIndicacao("Faltas:",new Font("Arial",Font.BOLD,20), roxo);
        falta.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)-100, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,95,23);

        //Faltasssss
        LabelIndicacao numeroFaltas = new LabelIndicacao(Integer.toString(materia.getFaltas()), new Font("Arial",Font.BOLD,20), Color.white);
        numeroFaltas.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)+5, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,60,23);
        numeroFaltas.setBorder(BorderFactory.createLineBorder(Color.black,1));
        numeroFaltas.setHorizontalAlignment(JLabel.CENTER);

        JButton mais = new JButton();
        mais.setText("+");
        mais.setFont(new Font("Arial",Font.BOLD,20));
        mais.setBackground(new Color(0XFFD954));
        mais.setForeground(Color.WHITE);
        mais.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        mais.setFocusPainted(false);
        mais.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1) + 68, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,23,23);

        JButton menos = new JButton();
        menos.setText("-");
        menos.setFont(new Font("Arial",Font.BOLD,20));
        menos.setBackground(new Color(0XFFD954));
        menos.setForeground(Color.WHITE);
        menos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        menos.setFocusPainted(false);
        menos.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1) + 95, Utilidades.dimensoesProporçãoAltura(0.07)+ 22,23,23);


        //Warninggg
        LabelIndicacao warning = new LabelIndicacao("Você pode faltar mais " + materia.calcNumFaltasRestantes()+ " vezes.", new Font("Arial",Font.BOLD,12), roxo);
        warning.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)-100, Utilidades.dimensoesProporçãoAltura(0.07)+ 50,230,15);
        this.add(warning);

        //Delete
        JButton x = new JButton("x");
        x.setFont(new Font("Arial",Font.BOLD,20));
        x.setForeground(Color.white);
        x.setBackground(Color.red);
        x.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        x.setFocusPainted(false);
        x.setBounds(Utilidades.dimensoesProporçãoLargura(0.65),10,Utilidades.dimensoesProporçãoAltura(0.03), Utilidades.dimensoesProporçãoAltura(0.03));
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


}
