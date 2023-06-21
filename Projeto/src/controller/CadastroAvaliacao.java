package controller;
import java.io.File;
import javax.swing.JOptionPane;
import model.Avaliacao;
import model.Materia;

public class CadastroAvaliacao {
    private Avaliacao avaliacao;
    
    public CadastroAvaliacao(String nome, String data, String nota, String pesoNaMedia, String extraInfo, Materia materia) {
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
            //Arquvio
            File avaliacoesCSV = new File("Projeto/src/controller/Files/Avaliacoes.csv");
            String header = "USER, NOME_MATERIA, NOME_AVALIACAO, DATA_AVALIACAO, NOTA, PESO_NA_MEDIA, EXTRA_INFO\n"; 
            String conteudo = materia.getUser().getUsuario() + "," + materia.getNome() + "," + avaliacao.getNome() + "," + avaliacao.getData() + "," + avaliacao.getNota() + "," + avaliacao.getPesoNaMedia()+ "," + avaliacao.getExtraInfo() +"\n";
			OriginFile.dealWithFile(avaliacoesCSV, header, conteudo);
        }
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
}
