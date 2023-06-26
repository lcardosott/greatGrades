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
        
        //Label
        LabelIndicacao falta = new LabelIndicacao("Faltas:",new Font("Arial",Font.BOLD,20), roxo);
        falta.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1),Utilidades.dimensoesProporçãoAltura(0.07), 100,20);

        //Botao ver materia
        BotaoMateria botao = new BotaoMateria();
        botao.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1),
        Utilidades.dimensoesProporçãoAltura(0.35)-Utilidades.dimensoesProporçãoAltura(0.05)-50,
        Utilidades.dimensoesProporçãoLargura(0.1), 
        Utilidades.dimensoesProporçãoAltura(0.05));

        //########################################################333
        //Faltasssss
        LabelIndicacao numeroFaltas = new LabelIndicacao("0", new Font("Arial",Font.BOLD,70), Color.white);
        numeroFaltas.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1), Utilidades.dimensoesProporçãoAltura(0.07)+ 22,100,71);
        numeroFaltas.setBorder(BorderFactory.createEtchedBorder());
        numeroFaltas.setHorizontalAlignment(JLabel.CENTER);

        JButton mais = new JButton();
        mais.setText("+");
        mais.setFont(new Font("Arial",Font.BOLD,30));
        mais.setBackground(Color.red);
        mais.setBorder(BorderFactory.createEtchedBorder());
        mais.setFocusPainted(false);
        mais.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)+ 102,
        Utilidades.dimensoesProporçãoAltura(0.07)+ 22,
        Utilidades.dimensoesProporçãoAltura(0.04),
        Utilidades.dimensoesProporçãoAltura(0.04));

        JButton menos = new JButton();
        menos.setText("-");
        menos.setFont(new Font("Arial",Font.BOLD,30));
        menos.setBackground(Color.blue);
        menos.setBorder(BorderFactory.createEtchedBorder());
        menos.setFocusPainted(false);
        menos.setBounds(Utilidades.dimensoesProporçãoLargura(0.65)-Utilidades.dimensoesProporçãoLargura(0.1)+ 102,
        Utilidades.dimensoesProporçãoAltura(0.07)+ 22 + Utilidades.dimensoesProporçãoAltura(0.04) + 5,
        Utilidades.dimensoesProporçãoAltura(0.04),
        Utilidades.dimensoesProporçãoAltura(0.04));


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
}
