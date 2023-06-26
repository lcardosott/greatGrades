package controller;
import model.Usuario;

public class Buscar {
    //Essa classe contém métodos que buscam um determinado objeto e o retornam.
    
    public static Usuario buscarUsuario(String usuario) {
    	Cadastro.lerUsuarios();
        for (Usuario u : Cadastro.getListaUsers()) {
            if (u.getUsuario().equals(usuario)) {
                return u;
            }
        }
        return null;
    }
}
