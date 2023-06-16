package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import model.Usuario;

public class Cadastro {
    private Usuario user;
    private PrintWriter out;

    public Cadastro (String usuario, String nome, String faculdade, String curso, String senha) {
        user = new Usuario(usuario, nome, faculdade,curso, senha);
        File usersCSV = new File("controller/File/Users.csv");
        try {
            out = new PrintWriter(usersCSV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        out.printf("%s, %s, %s, %s, %s", user.getUsuario(), user.getNome(), user.getFaculdade(), user.getCurso(), user.getSenha());
        out.close();
    }
}