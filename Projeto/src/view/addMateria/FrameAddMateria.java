package view.addMateria;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Usuario;
import view.baseClasses.OriginFrame;
import view.baseClasses.Utilidades;

public class FrameAddMateria extends OriginFrame {
	JPanel painelAddMateria;
	JLabel labelFundo;
	Usuario user;
	
	public FrameAddMateria(Usuario user) {
	///////////// Label logo e fundo ////////////////	
		this.user = user;
		// Fundo:
		ImageIcon fundo = new ImageIcon("imagens/fundo.png");
		labelFundo = new JLabel();
        labelFundo.setBackground(Color.white);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setHorizontalAlignment(JLabel.RIGHT);
        labelFundo.setVerticalAlignment(JLabel.BOTTOM);
 
    ///////////// Painel add materia ////////////////
        painelAddMateria = new PainelAddMateria(user);
		
	/////////// Adds e frame ///////////////////////
		this.setLayout(new BorderLayout());
		this.add(painelAddMateria);
		this.add(labelFundo);
		this.setVisible(true);
	}

}