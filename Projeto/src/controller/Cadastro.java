package controller;
import java.io.File;
import java.util.ArrayList;
import model.Usuario;

public class Cadastro {
    private Usuario user; //usuário que está sendo cadastrado
    private static ArrayList<Usuario> listaUsers; //lista que contém todos os usuários do aplicativo

    public Cadastro (String usuario, String nome, String faculdade, String curso, String senha) {

        if (! Verificar.usuarioJaExiste(usuario)) { //verifica se o usuário já existe
            if (listaUsers == null) {
                listaUsers = new ArrayList<Usuario>();
            }
            user = new Usuario(usuario, nome, faculdade,curso, senha);
            listaUsers.add(user);
            File usersCSV = new File("Projeto/src/controller/Files/Users.csv");
            String header = "USER, NOME, INSTITUICAO, CURSO, SENHA\n"; 
            String conteudo = user.getUsuario() + "," + user.getNome() + "," + user.getFaculdade() + "," + user.getCurso() + "," + user.getSenha() + "\n";
            originFile.dealWithFile(usersCSV, header, conteudo);
        }
    }

    public static ArrayList<Usuario> getListaUsers() {
        return listaUsers;
    }

    public Usuario getUser () {
        return user;
    }
}