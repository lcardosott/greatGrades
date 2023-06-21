package model;

public class Prova extends Avaliacao {
    int numero_questoes;
    String tempoDeProva;
    public Prova(String nome, String data, double nota, double pesoNaMedia, String extraInfo, Materia materia, int numero_questoes, String tempoDeProva) {
        super(nome, data, nota, pesoNaMedia, extraInfo, materia);
        this.numero_questoes = numero_questoes;
        this.tempoDeProva = tempoDeProva;
    }
    public int getNumero_questoes() {
        return numero_questoes;
    }
    public void setNumero_questoes(int numero_questoes) {
        this.numero_questoes = numero_questoes;
    }
    public String getTempoDeProva() {
        return tempoDeProva;
    }
    public void setTempoDeProva(String tempoDeProva) {
        this.tempoDeProva = tempoDeProva;
    }
}
