package controller;
import java.util.ArrayList;


import model.Usuario;

public class Buscar {
    //Essa classe contém métodos que buscam um determinado objeto e o retornam.
    
    public static Usuario buscarUsuario(String usuario, ArrayList<Usuario> listaUsers) {
        for (Usuario u : listaUsers) {
            if (u.getUsuario().equals(usuario)) {
                return u;
            }
        }
        return null;
    }
}
