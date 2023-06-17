package view.firstPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;

import view.LabelIndicacao;
import view.Utilidades;
import view.originFrame;

public class FrameInicial extends originFrame {
    public FrameInicial() {
        //Colors

        //Fonte
        Font fonte = new Font("Arial", Font.PLAIN, 20);
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT,new File("Fontes/Sacramento-Regular.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (FontFormatException|IOException e) {
            System.err.println("Erro ao carregar fonte");
            e.printStackTrace();
        }

        //Imagens
        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");
        ImageIcon fundo = new ImageIcon("imagens/fundo.png");
        
        //Border
        Border border = BorderFactory.createLineBorder(Color.white,20);

        //Dimensao das minhas entry

        //Painel
        JLayeredPane painelEsquerda = new JLayeredPane();
        painelEsquerda.setBackground(Color.white);
        painelEsquerda.setBounds(0,0, Utilidades.dimensoesProporçãoLargura(0.4),Utilidades.dimensoesProporçãoAltura(1));
        //painelEsquerda.setBorder(border);
        painelEsquerda.setOpaque(true);

        PainelLogin painelLogin = new PainelLogin();

        LabelIndicacao greatGrades = new LabelIndicacao("GreatGrades", fonte, Color.white);
        greatGrades.setVerticalAlignment(JLabel.TOP);
        greatGrades.setIconTextGap(20);
        greatGrades.setIcon(logo);
        greatGrades.setHorizontalTextPosition(JLabel.CENTER);
        greatGrades.setVerticalTextPosition(JLabel.TOP);
        greatGrades.setBorder(border);
        greatGrades.setBounds((Utilidades.dimensoesProporçãoLargura(0.4)-300)/2, 30, 278, 400);
        greatGrades.setOpaque(true);

        painelEsquerda.add(painelLogin);
        painelEsquerda.add(greatGrades);
        


        JLayeredPane painelDireita = new JLayeredPane();
        painelDireita.setBackground(Color.white);
        painelDireita.setBounds(Utilidades.dimensoesProporçãoLargura(0.4)+1,0, Utilidades.dimensoesProporçãoLargura(0.6),Utilidades.dimensoesProporçãoAltura(1));
        painelDireita.setOpaque(true);

        PainelCadastro painelCadastro = new PainelCadastro(this);

        //Label que carrega o fundo
        JLabel labelFundo = new JLabel();
        labelFundo.setBackground(Color.WHITE);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setBounds(Utilidades.dimensoesProporçãoLargura(0.6)-fundo.getIconWidth(),Utilidades.dimensoesProporçãoAltura(1)-fundo.getIconHeight()-50,fundo.getIconWidth(),fundo.getIconHeight());
        
        painelDireita.add(painelCadastro);
        painelDireita.add(labelFundo);
        
        //Default settings
        this.getContentPane().setBackground(Color.GRAY);

        //Adicionando Paineis
        this.add(painelEsquerda);
        this.add(painelDireita);

        this.setVisible(true);
    }
}
