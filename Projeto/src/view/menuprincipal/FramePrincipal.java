package view.menuprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.baseClasses.Utilidades;

public class FramePrincipal extends JFrame {
    public FramePrincipal(){
        //Imagens
        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");

        //Fonte

        PainelSuperior painelSuperior = new PainelSuperior();
        PainelInferior painelInferior = new PainelInferior();


        this.setSize(Utilidades.redimensionarFrameTotal());
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setVisible(true);
        this.setLayout(null); //positions defined explicitly by the programmer
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.GRAY);
        
        this.add(painelSuperior);
        this.add(painelInferior);
    }
}
