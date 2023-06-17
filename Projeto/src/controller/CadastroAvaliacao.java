package controller;
import javax.swing.JOptionPane;

import model.Avaliacao;
import model.InterfaceMateria;

public class CadastroAvaliacao {
    private Avaliacao avaliacao;
    
    public CadastroAvaliacao(String nome, String data, String nota, String pesoNaMedia, String extraInfo, InterfaceMateria materia) {
        double notaDouble = 0;
        double pesoNaMediaDouble = 0;
        boolean checkNota = false;
        boolean checkPesoNaMedia = false;
        if (!nota.equals("")) {
            try {
                notaDouble = Double.parseDouble(nota);
                checkNota = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "O campo 'Nota' deve necessariamente ser um número.\nUse '.' para separar as casas decimais.", "Campo inadequado!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            checkNota = true;
        }
        try {
            pesoNaMediaDouble = Double.parseDouble(pesoNaMedia);
            checkPesoNaMedia = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo 'Peso na média' deve necessariamente ser um número.\nUse '.' para separar as casas decimais.", "Campo inadequado!", JOptionPane.ERROR_MESSAGE);
        }
        if (checkNota && checkPesoNaMedia) {
            avaliacao = new Avaliacao(nome, data, notaDouble, pesoNaMediaDouble, extraInfo, materia);
            materia.addAvaliacao(avaliacao);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Avaliação cadastrada!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
}
