package model;

public class Avaliacao {
    private Materia materia;
    private String nome;
    private String data;
    private double nota;
    private double pesoNaMedia;
    private String extraInfo;

    public Avaliacao(String nome, String data, double nota, double pesoNaMedia, String extraInfo, Materia materia) {
        this.nome = nome;
        this.data = data;
        this.nota = nota;
        this.pesoNaMedia = pesoNaMedia;
        this.extraInfo = extraInfo;
        this.materia = materia;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        //altera a nota da avaliação; a média da matéria é recalculada
        this.nota = nota;
        materia.calcMediaAtual();
    }

    public double getPesoNaMedia() {
        return pesoNaMedia;
    }

    public void setPesoNaMedia(double pesoNaMedia) {
        this.pesoNaMedia = pesoNaMedia;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
