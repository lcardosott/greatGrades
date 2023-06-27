package controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.InterfaceMateria;
import model.Usuario;

public class Buscar {
    //Essa classe contém métodos que buscam um determinado objeto e o retornam.
    
    public static Usuario buscarUsuario(String usuario) {
        for (Usuario u : Cadastro.getListaUsers()) {
            if (u.getUsuario().equals(usuario)) {
                return u;
            }
        }
        return null;
    }

    public static int buscarLinhaAvaliacoes(Avaliacao avaliacao) {
        //dado uma avaliação, retorna a linha que a contem
        //se não achar, retorna -1
        String caminho = "Projeto\\src\\controller\\Files\\Avaliacoes.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String linha = br.readLine();
	    	linha = br.readLine();
	    	int currIndex = 2;

	    	while (linha != null) {
	    		String[] campos = linha.split(",");
	    	    String currMateria = campos[1];
                String currNomeAvaliacao = campos[2];
                if (currMateria.equals(avaliacao.getMateria().getNome()) && currNomeAvaliacao.equals(avaliacao.getNome())) {
                    return currIndex;
                }
	    		linha = br.readLine();
                currIndex++;
	    	}
	    	br.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return -1;
		}
        return -1;
    }

    public static int buscarLinhaMateria (InterfaceMateria materia) {
        //dado uma avaliação, retorna a linha que a contem
        //se não achar, retorna -1
        String caminho = "Projeto\\src\\controller\\Files\\Materias.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String linha = br.readLine();
	    	linha = br.readLine();
	    	int currIndex = 2;

	        while (linha != null) {
	    		String[] campos = linha.split(",");
	    	    String currUsuario = campos[0];
                String currNomeMateria = campos[2];
                if (currUsuario.equals(materia.getUser().getUsuario()) && currNomeMateria.equals(materia.getNome())) {
                    return currIndex;
                }
	    		linha = br.readLine();
                currIndex++;
	    	}
	    	br.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return -1;
		}
        return -1;
    }
}
