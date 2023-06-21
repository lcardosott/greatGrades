package model;

public class Trabalho extends Avaliacao {
    String tituloTrabalho;
    String statusDoTrabalho;
    public Trabalho(String nome, String data, double nota, double pesoNaMedia, String extraInfo, Materia materia, String tituloTrabalho, String statusTrabalho) {
        super(nome, data, nota, pesoNaMedia, extraInfo, materia);
        this.statusDoTrabalho = statusTrabalho;
        this.tituloTrabalho = tituloTrabalho;
    }
}
