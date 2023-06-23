package view.menuprincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.baseClasses.Utilidades;


public class PainelSuperior extends JPanel{
    public PainelSuperior(){
        //Get fonte
        Font fonte = new Font("Arial", Font.PLAIN, Utilidades.dimensoesProporçãoAltura(0.08));
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT,new File("Fontes/Sacramento-Regular.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (FontFormatException|IOException e) {
            System.err.println("Erro ao carregar fonte");
            e.printStackTrace();  
        }

        //Sets Basicos
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBounds(0,0, Utilidades.dimensoesProporçãoLargura(1),Utilidades.dimensoesProporçãoAltura(0.10));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));

        //Referente a logo
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

        //Referente ao botao
        ImageIcon exit = new ImageIcon("imagens/exit.png");
        JButton sair = new JButton(exit);
        sair.setBackground(Color.gray);
        sair.setBorder(BorderFactory.createEtchedBorder());
        sair.setFocusPainted(false);
        sair.setOpaque(true);
//
        //this.add(sair);
        this.add(labelLogo);
    }
}
