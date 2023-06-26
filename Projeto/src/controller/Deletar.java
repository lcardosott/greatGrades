package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Avaliacao;
import model.InterfaceMateria;

public class Deletar {
    public static boolean deletarAvaliacao(Avaliacao avaliacao) {
        String avaliacoesCSVPath = "Projeto\\src\\controller\\Files\\Avaliacoes.csv";
        int lineToDeleteIndex = Buscar.buscarLinhaAvaliacoes(avaliacao);
        if (lineToDeleteIndex < 0) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(\nAvaliação não encontrada no registro.", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(avaliacoesCSVPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(avaliacoesCSVPath + ".tmp"))) {

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
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Renomear o arquivo temporário e apagar o original
        File avaliacoesCSV = new File(avaliacoesCSVPath);
        File tempFile = new File(avaliacoesCSVPath + ".tmp");

        if (tempFile.renameTo(avaliacoesCSV) && avaliacoesCSV.delete()) {
            JOptionPane.showMessageDialog(null, "Avaliação deletada com sucesso!", "Deletado!", JOptionPane.PLAIN_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean deletarMateria (InterfaceMateria materia) {
        String avaliacoesCSVPath = "Projeto\\src\\controller\\Files\\Avaliacoes.csv";
        int lineToDeleteIndex = Buscar.buscarLinhaMateria(materia);
        try (BufferedReader reader = new BufferedReader(new FileReader(avaliacoesCSVPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(avaliacoesCSVPath + ".tmp"))) {

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
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Deletar todas as avaliações associadas a matéria
        for (Avaliacao currAvaliacao : materia.getListaAvaliacoes()) {
            if (! deletarAvaliacao(currAvaliacao)) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao deletar uma avaliação da matéria!", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Renomear o arquivo temporário e apagar o original
        File avaliacoesCSV = new File(avaliacoesCSVPath);
        File tempFile = new File(avaliacoesCSVPath + ".tmp");

        if (tempFile.renameTo(avaliacoesCSV) && avaliacoesCSV.delete()) {
            JOptionPane.showMessageDialog(null, "Avaliação deletada com sucesso!", "Deletado!", JOptionPane.PLAIN_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado :(", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
