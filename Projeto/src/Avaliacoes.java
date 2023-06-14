import java.util.Date;

public abstract class Avaliacoes {
    private Materia materia;
    private String nome;
    private Date data;
    private double nota;
    private double pesoNaMedia;

    public Avaliacoes(String nome, Date data, Materia materia) {
        this.nome = nome;
        this.data = data;
        this.materia = materia;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    
}
