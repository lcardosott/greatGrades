package view.menuprincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.baseClasses.Utilidades;


public class PainelSuperior extends JPanel{
    public PainelSuperior(){
        
        Font fonte = new Font("Arial", Font.PLAIN, Utilidades.dimensoesProporçãoAltura(0.08));
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT,new File("Fontes/Sacramento-Regular.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (FontFormatException|IOException e) {
            System.err.println("Erro ao carregar fonte");
            e.printStackTrace();  
        }
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBounds(0,0, Utilidades.dimensoesProporçãoLargura(1),Utilidades.dimensoesProporçãoAltura(0.10));
        //painelEsquerda.setBorder(border);
        this.setOpaque(true);

        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");
        ImageIcon resizedLogo = Utilidades.resizeImage(logo, Utilidades.dimensoesProporçãoAltura(0.08) , Utilidades.dimensoesProporçãoAltura(0.08));
        
        JLabel labelLogo = new JLabel("GreatGrades");
        labelLogo.setFont(fonte);
        labelLogo.setBackground(Color.WHITE);
        labelLogo.setIcon(resizedLogo);
        labelLogo.setHorizontalTextPosition(JLabel.LEFT);
        labelLogo.setIconTextGap(8);
        labelLogo.setOpaque(true);
        labelLogo.setHorizontalAlignment(JLabel.RIGHT);

        
        //labelLogo.setBounds(1, Utilidades.dimensoesProporçãoAltura(0.01), labelLogo.getWidth(), labelLogo.getHeight());

        labelLogo.setOpaque(true);
        //this.setLayout(null);
        this.add(labelLogo);
    }
}
