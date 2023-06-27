package controller;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Materia;
import model.Usuario;
import view.menuprincipal.FramePrincipal;

public class AddMateria {
	
	public AddMateria(JFrame frameMateria, JFrame framePrincipal, Usuario user, String nomeMateria, String turmaMateria, String profMateria, String notaMinMateria, String creditosMateria, int tipoMediaMateria) {
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
			if (Verificar.materiaJaExiste(nomeMateria, user.getUsuario())) {
				continuar = false;
			}
		}
		
		if (continuar) {
			int creditosInt = Integer.parseInt(creditosMateria);
			double notaMinDouble = Double.parseDouble(notaMinMateria);
			Materia mat = new Materia(nomeMateria, turmaMateria, profMateria, notaMinDouble, creditosInt, 0, tipoMediaMateria + 1, user);
			user.addMateria(mat);
			//Arquivo para matéria
			File materiasCSV = new File("Projeto/src/controller/Files/Materias.csv");
            String header = "USER,NOME_MATERIA,TURMA,NOME_PROFESSOR,NOTA_MINIMA,NUMERO_CREDITOS,NUMERO_FALTAS,TIPO_MEDIA\n"; 
            String conteudo = user.getUsuario() + "," + mat.getNome() + "," + mat.getTurma() + "," + mat.getNomeProfessor() + "," + mat.getNotaMinima() + "," + mat.getCreditos()+ "," + mat.getFaltas() + "," + mat.getTipoMedia()+ "\n";
			OriginFile.dealWithFile(materiasCSV, header, conteudo);
			frameMateria.dispose();
			//framePrincipal.dispose();
			new FramePrincipal(user);
		}
	}
}