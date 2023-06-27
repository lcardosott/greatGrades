package controller;
import java.awt.Frame;

import javax.swing.JOptionPane;

import model.Materia;
import model.Usuario;
import view.menuprincipal.FramePrincipal;

public class Login {
    private Usuario user;

    public Login (Frame frameInicial, String usuario, String senha) {
    	boolean continuar = true;
    	if (usuario.isBlank() || senha.isBlank()) {
    		continuar = false;
			JOptionPane.showMessageDialog(null, "Preencha os dois campos para continuar!", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    	
    	if (continuar) {
    		boolean found = Verificar.loginUsuarioSenha(usuario, senha);
        	if (found) {
        		user = Buscar.buscarUsuario(usuario);
        		Inicializar.lerMaterias(user);
        		for (Materia mat : user.getListaMaterias()) {
        			Inicializar.lerAvaliacoes(user, mat);
        		}
            	JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Bem vindo!", JOptionPane.PLAIN_MESSAGE);
				frameInicial.dispose();
            	new FramePrincipal(user);
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "O usuário ou senha informado está incorreto, tente novamente.", "Usuário ou senha incorretos", JOptionPane.PLAIN_MESSAGE);
        	}
    	}
    }

    public Usuario getUser() {
        return user;
    }
}