import java.util.ArrayList;

public class Materia {
    private String nome;
    private String turma;
    private String nomeProfessor;
    private ArrayList<Prova> listaProvas;
    private ArrayList<Trabalho> listaTrabalhos;
    private double notaMinima;
    private int creditos;
    private int faltas;
    private int tipoMedia;

    public Materia (String nome, String turma, String nomeProfessor, double notaMinima, int creditos, int faltas, int tipoMedia) {
        this.nome = nome;
        this.turma = turma;
        this.nomeProfessor = nomeProfessor;
        this.notaMinima = notaMinima;
        this.faltas = faltas;
        this.creditos = creditos;
        this.tipoMedia = tipoMedia;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public int getCreditos() {
        return creditos;
    }

        public int getFaltas() {
        return faltas;
    }

    public int getTipoMedia() {
        return tipoMedia;
    }

    
    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setTipoMedia(int tipoMedia) {
        this.tipoMedia = tipoMedia;
    }
}