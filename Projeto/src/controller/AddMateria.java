package controller;

import javax.swing.JOptionPane;

import model.Materia;
import model.Usuario;

public class AddMateria {
	
	public AddMateria(Usuario user, String nomeMateria, String turmaMateria, String profMateria, String notaMinMateria, String creditosMateria, int tipoMediaMateria) {
		boolean continuar = true;
		
		if (nomeMateria.isBlank() || turmaMateria.isBlank() 
	     || profMateria.isBlank()  || creditosMateria.isBlank() 
	     || notaMinMateria.isBlank()) {
			continuar = false;
			JOptionPane.showMessageDialog(null, "Preencha todos os campos para continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if (!Verificar.isInteger(creditosMateria)) {
				continuar = false;
				JOptionPane.showMessageDialog(null, "\"Quantidade de créditos\" deve ser um número inteiro", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			if (!Verificar.isDouble(notaMinMateria)) {
				continuar = false;
				JOptionPane.showMessageDialog(null, "\"Nota mínima\" deve ser um número", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (continuar) {
			int creditosInt = Integer.parseInt(creditosMateria);
			double notaMinDouble = Double.parseDouble(notaMinMateria);
			Materia mat = new Materia(nomeMateria, turmaMateria, profMateria, notaMinDouble, creditosInt, 0, tipoMediaMateria + 1);
			user.addMateria(mat);
			JOptionPane.showMessageDialog(null, "Matéria adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
