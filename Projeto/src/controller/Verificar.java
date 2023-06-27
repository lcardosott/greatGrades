package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Usuario;

public class Verificar {
    //Essa classe verifica informações retornando true ou false;

    public static boolean usuarioJaExiste (String usuario) {
        //verifica se um usuário já existe para evitar que sejam criados usuários com o mesmo nome
        boolean existe = false;
    	for (Usuario userAtual : Cadastro.getListaUsers()) {
        	if (userAtual.getUsuario().equals(usuario)) {
        		existe = true;
        	}
        }
    	return existe;
    }

    public static boolean loginUsuarioSenha (String usuario, String senha) {
        //Verifica se o usuario dado tem realmente a senha dada.
        //Se sim, retorna true; c.c. retorna false.
    	
    	for (Usuario userAtual : Cadastro.getListaUsers()) {
    		if (userAtual.getUsuario().equals(usuario) &&
    			userAtual.getSenha().equals(senha)) {
    			return true;
    		}
    	}
    	
    	return false;
    	
    }

    public static boolean validaNome (String nome) {
        return nome.matches("^[a-zA-ZÀ-ę ]*$");
    }
    
    public static boolean isInteger(String str) {
    	try {
    		Integer.parseInt(str);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    
    public static boolean isDouble(String str) {
    	try {
    		Double.parseDouble(str);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }

    public static boolean materiaJaExiste (String nomeMateria, String usuario) {
        //verifica se o nome de uma matéria já existe para um usuário 
        //evitar que sejam criados matéria com o mesmo nome para um mesmo usuário
        File materiasCSV = new File("Projeto\\src\\controller\\Files\\Materias.csv");
        String line = "";
        boolean existe = false;
        BufferedReader br = null;
        try {
            if (materiasCSV.exists()) {
                br = new BufferedReader(new FileReader(materiasCSV));
                
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(","); //vetor da linha
                    String currUsuario = data[0];
                    if (usuario.equals(currUsuario)) {
                        String currMateria = data[1];
                        if (currMateria.equals(nomeMateria)) {
                            br.close();
                            existe = true;
                            break;
                        }
                    }
                }
            }
            else {
                existe = false;
            }
        }
        catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "Você já cadastrou uma matéria com este nome. Tente novamente.", "Matéria já existente!", JOptionPane.PLAIN_MESSAGE);
        }
        return existe;
    }

public static boolean avaliacaoJaExiste (String nomeAvaliacao, String nomeMateria, String usuario) {
        //verifica se o nome de uma avaliacao já existe para uma materia 
        //evitar que sejam criados avaliacoes com o mesmo nome para uma mesma materia
        File avaliacoesCSV = new File("Projeto\\src\\controller\\Files\\Avaliacoes.csv");
        String line = "";
        boolean existe = false;
        BufferedReader br = null;
        try {
            if (avaliacoesCSV.exists()) {
                br = new BufferedReader(new FileReader(avaliacoesCSV));
                
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(","); //vetor da linha
                    String currUsuario = data[0];
                    //compara usuário
                    if (usuario.equals(currUsuario)) {
                        String currMateria = data[1];
                        //compara matéria
                        if (currMateria.equals(nomeMateria)) {
                            String currNomeAvaliacao = data[2];
                            //compara nome da avaliação
                            if (currNomeAvaliacao.equals(nomeAvaliacao)) {
                                br.close();
                                existe = true;
                                break;
                            }
                        }
                    }
                }
            }
            else {
                existe = false;
            }
        }
        catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "Você já cadastrou uma matéria com este nome. Tente novamente.", "Matéria já existente!", JOptionPane.PLAIN_MESSAGE);
        }
        return existe;
    }
}