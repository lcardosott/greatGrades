package controller;
import javax.swing.JOptionPane;

import model.Usuario;

public class Login {
    private Usuario user;

    public Login (String usuario, String senha) {
        boolean found = Verificar.loginUsuarioSenha(usuario, senha);
        if (found) {
            user = Buscar.buscarUsuario(usuario, Cadastro.getListaUsers());
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Bem vindo!", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public Usuario getUsuario() {
        return user;
    }
}