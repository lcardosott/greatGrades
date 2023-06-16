package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Verificar {
    //Essa classe verifica informações retornando true ou false;

    public static boolean usuarioJaExiste (String usuario) {
        //verifica se um usuário já existe para evitar que sejam criados usuários com o mesmo nome
        File usersCSV = new File("Projeto\\src\\controller\\Files\\Users.csv");
        String line = "";
        boolean existe = false;
        BufferedReader br = null;
        try {
            if (usersCSV.exists()) {
                br = new BufferedReader(new FileReader(usersCSV));
                
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(","); //vetor da linha
                    String currUsuario = data[0];
                    if (usuario.equals(currUsuario)) {
                        br.close();
                        existe = true;
                        break;
                    }
                }
            }
            else {
                existe = false;
            }
        }
        catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "O usuário já existe. Tente novamente.", "Erro", JOptionPane.PLAIN_MESSAGE);
        }
        return existe;
    }

    public static boolean loginUsuarioSenha (String usuario, String senha) {
        //Verifica se o usuario dado tem realmente a senha dada.
        //Se sim, retorna true; c.c. retorna false.
        File usersCSV = new File("Projeto\\src\\controller\\Files\\Users.csv");
        String line = "";
        BufferedReader br = null;
        try {
            if (usersCSV.exists()) {
                br = new BufferedReader(new FileReader(usersCSV));
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(","); //vetor da linha
                    String currUsuario = data[0];
                    String currSenha = data[4];
                    if (usuario.equals(currUsuario)) {
                        if (senha.equals(currSenha)) {
                            br.close();
                            return true;
                        }
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "O usuário ou senha informado está incorreto, tente novamente.", "Usuário ou senha incorretos", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Ainda não há nenhum usuário cadastrado!", "Usuário ou senha incorretos", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
