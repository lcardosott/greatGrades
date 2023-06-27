package controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class OriginFile {
    
    public static void dealWithFile(File file, String header, String conteudo) {
        try {
            if (!file.exists()) {
                //CRIAR O ARQUIVO
                file.createNewFile();
                FileWriter fw = new FileWriter(file, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(header);
                    bw.write(conteudo);
                    bw.flush();
                    bw.close();
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro na montagem de arquivo", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
            }
            else { //arquivo já existe
                FileWriter fw = new FileWriter(file, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(conteudo);
                    bw.flush();
                    bw.close();
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Cadastrado!", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro na montagem de arquivo", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro na montagem de arquivo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

