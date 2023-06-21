package view.addMateria;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Usuario;
import view.baseClasses.Utilidades;
import view.baseClasses.originFrame;

public class FrameAddMateria extends originFrame {
	JPanel painelAddMateria;
	JLabel labelLogo;
	Usuario user;
	public FrameAddMateria(Usuario user) {
	///////////// Label logo e fundo ////////////////	
		this.user = user;
		// Fundo:
        JLabel labelFundo;
        ImageIcon fundo = new ImageIcon("imagens/fundo.png");
		labelFundo = new JLabel();
        labelFundo.setBackground(Color.white);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setHorizontalAlignment(JLabel.RIGHT);
        labelFundo.setVerticalAlignment(JLabel.BOTTOM);
        labelFundo.setVisible(true);

        ///////////// Painel add materia ////////////////
		painelAddMateria = new PainelAddMateria(user);
		
		/////////// Adds e frame ///////////////////////
		
		this.setPreferredSize(Utilidades.redimensionarFrameTotal());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(painelAddMateria);
		this.pack();
		//this.getContentPane().add(super.originLabelFundo);
		this.setVisible(true);
	}

}