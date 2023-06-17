package controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
            try {
                if (!usersCSV.exists()) {
                    usersCSV.createNewFile();
                    FileWriter fw = new FileWriter(usersCSV, true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write(header);
                        bw.write(conteudo);
                    }
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Bem vindo!", JOptionPane.PLAIN_MESSAGE);
                }
                
                else { //arquivo já existe
                    FileWriter fw = new FileWriter(usersCSV, true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write(conteudo);
                    }
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Bem vindo!", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro na montagem de arquivo", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }

    public static ArrayList<Usuario> getListaUsers() {
        return listaUsers;
    }

    public Usuario getUser () {
        return user;
    }
}