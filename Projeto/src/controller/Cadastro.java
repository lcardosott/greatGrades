package controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.Usuario;

public class Cadastro {
    private Usuario user;

    public Cadastro (String usuario, String nome, String faculdade, String curso, String senha) {
        user = new Usuario(usuario, nome, faculdade,curso, senha);
        File usersCSV = new File("Projeto\\src\\controller\\Files\\Users.csv");
        String header = "USER, NOME, INSTITUICAO, CURSO, SENHA\n"; 
        String conteudo = user.getUsuario() + ", " + user.getNome() + ", " + user.getFaculdade() + ", " + user.getCurso() + ", " + user.getSenha() + "\n";
        try {
            if (!usersCSV.exists()) {
                usersCSV.createNewFile();
                FileWriter fw = new FileWriter(usersCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(header);
                    bw.write(conteudo);
                }
            }
            else {
                FileWriter fw = new FileWriter(usersCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(conteudo);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}