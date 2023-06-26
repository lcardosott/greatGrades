package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Usuario;

public class Cadastro {
    private Usuario user; //usuário que está sendo cadastrado
    private static ArrayList<Usuario> listaUsers; //lista que contém todos os usuários do aplicativo

    public Cadastro (String usuario, String nome, String faculdade, String curso, String senha) {
    	boolean continuar = true;
    	
    	if (usuario.isBlank() || nome.isBlank() || faculdade.isBlank() ||
    	curso.isBlank() || senha.isBlank()) {
    		continuar = false;
    		JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir!", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    	
    	if (continuar) {	
    		if (!Verificar.usuarioJaExiste(usuario)) { //verifica se o usuário já existe
    			if (listaUsers == null) {
    				listaUsers = new ArrayList<Usuario>();
    			}
    			user = new Usuario(usuario, nome, faculdade,curso, senha);
    			listaUsers.add(user);
    			File usersCSV = new File("Projeto/src/controller/Files/Users.csv");
    			String header = "USER,NOME,INSTITUICAO,CURSO,SENHA\n"; 
    			String conteudo = user.getUsuario() + "," + user.getNome() + "," + user.getFaculdade() + "," + user.getCurso() + "," + user.getSenha() + "\n";
    			OriginFile.dealWithFile(usersCSV, header, conteudo);
    		}
        }
    }

    public static void lerUsuarios() {
    	if (listaUsers == null) {
    		listaUsers = new ArrayList<Usuario>();
    	}
    	
    	String caminho = "Projeto/src/controller/Files/Users.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String linha = br.readLine();
	    	linha = br.readLine();
	    	
	    	while (linha != null) {
	    		String[] campos = linha.split(",");
	    		Usuario userAtual = new Usuario(campos[0], campos[1], campos[2], campos[3], campos[4]);
	    		listaUsers.add(userAtual);
	    		linha = br.readLine();
	    	}
	    	br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static void setListaUsers(ArrayList<Usuario> listaUsers) {
    	Cadastro.listaUsers = listaUsers;
    }
    
    public static ArrayList<Usuario> getListaUsers() {
        return listaUsers;
    }

    public Usuario getUser () {
        return user;
    }
}