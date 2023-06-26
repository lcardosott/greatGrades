package controller;
import javax.swing.JOptionPane;

import model.Usuario;

public class Login {
    private Usuario user;

    public Login (String usuario, String senha) {
    	boolean continuar = true;
    	if (usuario.isBlank() || senha.isBlank()) {
    		continuar = false;
			JOptionPane.showMessageDialog(null, "Preencha os dois campos para continuar!", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    	
    	if (continuar) {
    		boolean found = Verificar.loginUsuarioSenha(usuario, senha);
        	if (found) {
        		user = Buscar.buscarUsuario(usuario);
            	JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Bem vindo!", JOptionPane.PLAIN_MESSAGE);
        	}
    	}
    }

    public Usuario getUser() {
        return user;
    }
}