package view.verMateria;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import model.InterfaceMateria;
import model.Materia;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.OriginFrame;
import view.baseClasses.Utilidades;

public class FrameMateria extends OriginFrame{
    
    public FrameMateria(InterfaceMateria materia) {
        Color roxo = new Color(0xFDB5ED);
        ImageIcon fundo = new ImageIcon("imagens/fundo.png");
        JPanel painel = new JPanel();
        painel.setBackground(roxo);
        painel.setLayout(null);
        painel.setBounds(Utilidades.dimensoesProporçãoAltura(0.1), Utilidades.dimensoesProporçãoAltura(0.1),Utilidades.dimensoesProporçãoLargura(0.5) , Utilidades.dimensoesProporçãoAltura(0.8));
        painel.setBorder(BorderFactory.createEtchedBorder());

        //CarregaFundo
        JLabel labelFundo = new JLabel();
        labelFundo.setBackground(Color.WHITE);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setBounds(Utilidades.dimensoesProporçãoLargura(1)-fundo.getIconWidth(),Utilidades.dimensoesProporçãoAltura(1)-fundo.getIconHeight(), fundo.getIconWidth(), fundo.getIconHeight());

        //Faltas
        LabelIndicacao faltas = new LabelIndicacao("Faltas: ", new Font("Arial",Font.BOLD,20),roxo);
        faltas.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 20, 90,23);

        LabelIndicacao faltaResultado = new LabelIndicacao(Integer.toString(materia.getFaltas()), new Font("Arial",Font.BOLD,20),new Color(0xD643CE));
        faltaResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        faltaResultado.setBounds(Utilidades.dimensoesProporçãoLargura(0.02) + 100,Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 20,40 ,22 );
        faltaResultado.setHorizontalAlignment(JLabel.CENTER);


        //Media Atual
        LabelIndicacao media = new LabelIndicacao("Media Atual: ", new Font("Arial",Font.BOLD,20),roxo);
        media.setBounds(Utilidades.dimensoesProporçãoLargura(0.02) + 220,Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 20, 180,23);

        LabelIndicacao mediaAtual = new LabelIndicacao(Double.toString(materia.getMediaAtual()), new Font("Arial",Font.BOLD,20),new Color(0xD643CE));
        mediaAtual.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mediaAtual.setBounds(Utilidades.dimensoesProporçãoLargura(0.02) + 400,Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 20,70 ,22 );
        mediaAtual.setHorizontalAlignment(JLabel.CENTER);


        //Atividades
        LabelIndicacao atividades = new LabelIndicacao("Atividades: ", new Font("Arial",Font.BOLD,30),roxo);
        atividades.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 80, 300,33);

        //Header
        Header header = new Header(this, materia);

        //Scroll
        AtividadesScroll scroll = new AtividadesScroll(this, materia);
        painel.add(scroll);
        painel.add(faltas);
        painel.add(faltaResultado);
        painel.add(media);
        painel.add(mediaAtual);
        painel.add(atividades);
        painel.add(header);




        //Visibilidade
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.add(painel);
        this.add(labelFundo);
}
}
