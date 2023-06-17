package model;
import java.util.ArrayList;

public class Materia {
    private String nome;
    private String turma;
    private String nomeProfessor;
    private ArrayList<Avaliacao> listaAvaliacoes;
    private double notaMinima; //nota minima para aprovação
    private int creditos;
    private int faltas; //quantas vezes o aluno já faltou nas aulas da disciplina
    private int tipoMedia;
    private double mediaAtual;

    public Materia (String nome, String turma, String nomeProfessor, double notaMinima, int creditos, int faltas, int tipoMedia) {
        this.nome = nome;
        this.turma = turma;
        this.nomeProfessor = nomeProfessor;
        this.notaMinima = notaMinima;
        this.faltas = faltas;
        this.creditos = creditos;
        this.tipoMedia = tipoMedia;
        this.mediaAtual = calcMediaAtual();
        listaAvaliacoes = new ArrayList<Avaliacao>();
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

    public ArrayList<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
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

    //Funções

    private double calcMediaAritmeticaSimples (int N) {
        double soma = 0;
        for (Avaliacao avalicao : listaAvaliacoes) {
            soma += avalicao.getNota();
        }
        return soma/N;
    }

    private double calcMediaPonderada (int N) {
        double soma = 0;
        for (Avaliacao avalicao : listaAvaliacoes) {
            soma += avalicao.getNota() * avalicao.getPesoNaMedia();
        }
        return soma/N;
    }

    private double calcMediaHarmonica (int N) {
        double soma = 0;
        for (Avaliacao avalicao : listaAvaliacoes) {
            soma += (double) 1/avalicao.getNota();
        }
        return N/soma;
    }

    private double calcMediaGeometrica (int N) {
        double multiplicacao = 0;
        for (Avaliacao avalicao : listaAvaliacoes) {
            multiplicacao *= avalicao.getNota();
        }
        return Math.pow(multiplicacao, (double) 1/N);
    }

    private double calcMediaQuadratica (int N) {
        double soma = 0;
        for (Avaliacao avalicao : listaAvaliacoes) {
            soma += (double) Math.pow(avalicao.getNota(), 2);
        }
        return (double) Math.sqrt((double) soma/N);
    }

    public double calcMediaAtual () {
        //calcula a média atual do aluno na matéria em questão
        int N = listaAvaliacoes.size();
        if (tipoMedia == Medias.MEDIA_ARITMETICA_SIMPLES.getValue()) {
            mediaAtual = calcMediaAritmeticaSimples(N);
            return mediaAtual;
        }
        else if (tipoMedia == Medias.MEDIA_PONDERADA.getValue()) {
            mediaAtual = calcMediaPonderada(N);
            return mediaAtual;
        }
        else if (tipoMedia == Medias.MEDIA_HARMONICA.getValue()) {
            mediaAtual = calcMediaHarmonica(N);
            return mediaAtual;
        }
        else if (tipoMedia == Medias.MEDIA_GEOMETRICA.getValue()) {
            mediaAtual = calcMediaGeometrica(N);
            return mediaAtual;
        }
        else { 
            mediaAtual = calcMediaQuadratica(N);
            return mediaAtual;
        }
        
    }
    public boolean jaPassou() {
        //verifica se, com a média atual, o aluno já foi aprovado na matéria.
        if (mediaAtual >= notaMinima) {
            return true;
        }
        return false;
    }

    public int calcNumFaltasMax () {
        //calcula o número máximo de vezes que o estudante pode faltar na matéria
        return 2*creditos - 1;
    }

    public int calcNumFaltasRestantes () {
        //calcula quantas vezes o estudantes ainda pode faltar na matéria
        return calcNumFaltasMax() - faltas;
    }

    public boolean addAvaliacao(Avaliacao avalicao) {
        try{
            listaAvaliacoes.add(avalicao);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean removerAvaliacao(Avaliacao avalicao) {
        try {
            listaAvaliacoes.remove(avalicao);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}