package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;

import javax.swing.JOptionPane;

import model.Avaliacao;
import model.InterfaceMateria;

public class Deletar {
    public static boolean deletarAvaliacao(InterfaceMateria materia, Avaliacao avaliacao) {
        String avaliacoesCSVPath = "Projeto\\src\\controller\\Files\\Avaliacoes.csv";
        File avaliacoesCSV = new File(avaliacoesCSVPath);
        File tempFile = new File(avaliacoesCSVPath + ".tmp");
        int lineToDeleteIndex = Buscar.buscarLinhaAvaliacoes(avaliacao);
        if (lineToDeleteIndex < 0) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(\nAvaliação não encontrada no registro.", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(avaliacoesCSV));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            int currLineIndex = 1;

            // Copiar as linhas do arquivo original para o arquivo temporário, menos a linha a ser removida
            while ((line = reader.readLine()) != null) {
                if (currLineIndex != lineToDeleteIndex) {
                    writer.write(line);
                    writer.newLine();
                }
                currLineIndex++;
            }
            reader.close();
            writer.close();
            // Renomear o arquivo temporário para o nome do arquivo original
            //Files.delete(Paths.get(avaliacoesCSVPath));
            
            if (!avaliacoesCSV.delete()) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o arquivo original.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            if (!tempFile.renameTo(avaliacoesCSV)) {
                JOptionPane.showMessageDialog(null, "Falha ao renomear o arquivo temporário.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (!materia.getListaAvaliacoes().remove(avaliacao)) {
                JOptionPane.showMessageDialog(null, "Falha ao remover a avaliação da lista da matéria.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            JOptionPane.showMessageDialog(null, "Avaliação deletada com sucesso!", "Deletado!", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletarMateria (InterfaceMateria materia) {
        String materiasCSVPath = "Projeto\\src\\controller\\Files\\Materias.csv";
        File materiasCSV = new File(materiasCSVPath);
        File tempFile = new File(materiasCSVPath + ".tmp");
        int lineToDeleteIndex = Buscar.buscarLinhaMateria(materia);
        try (BufferedReader reader = new BufferedReader(new FileReader(materiasCSVPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(materiasCSVPath + ".tmp"))) {

            String line;
            int currLineIndex = 1;

            // Copiar as linhas do arquivo original para o arquivo temporário, menos a linha a ser removida
            while ((line = reader.readLine()) != null) {
                if (currLineIndex != lineToDeleteIndex) {
                    writer.write(line);
                    writer.newLine();
                }
                currLineIndex++;
            }
            reader.close();
            writer.close();
            //Deletar todas as avaliações associadas a matéria
            for (Avaliacao currAvaliacao : materia.getListaAvaliacoes()) {
                if (! deletarAvaliacao(materia, currAvaliacao)) {
                    JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao deletar uma avaliação da matéria!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            // Renomear o arquivo temporário para o nome do arquivo original
            //Files.delete(Paths.get(materiasCSVPath));
            
            if (!materiasCSV.delete()) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o arquivo original.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            if (!tempFile.renameTo(materiasCSV)) {
                JOptionPane.showMessageDialog(null, "Falha ao renomear o arquivo temporário.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (!materia.getUser().getListaMaterias().remove(materia)) {
                JOptionPane.showMessageDialog(null, "Falha ao remover a matéria da lista do usuário.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            JOptionPane.showMessageDialog(null, "Matéria deletada com sucesso!", "Deletado!", JOptionPane.PLAIN_MESSAGE);
            return true;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return false;
        }
    }
}
