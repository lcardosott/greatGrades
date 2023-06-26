package model;
import java.util.ArrayList;

public class Materia implements InterfaceMateria {
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
        this.listaAvaliacoes = new ArrayList<Avaliacao>();
        this.mediaAtual = 0;
    }

    //Getters
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTurma() {
        return turma;
    }

    @Override
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    @Override
    public double getNotaMinima() {
        return notaMinima;
    }

    @Override
    public int getCreditos() {
        return creditos;
    }

        @Override
        public int getFaltas() {
        return faltas;
    }

    @Override
    public int getTipoMedia() {
        return tipoMedia;
    }

    @Override
    public ArrayList<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public double getMediaAtual() {
        return mediaAtual;
    }

    
    //Setters
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    @Override
    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    @Override
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
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

    @Override
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
    @Override
    public boolean jaPassou() {
        //verifica se, com a média atual, o aluno já foi aprovado na matéria.
        if (mediaAtual >= notaMinima) {
            return true;
        }
        return false;
    }

    @Override
    public int calcNumFaltasMax () {
        //calcula o número máximo de vezes que o estudante pode faltar na matéria
        return 2*creditos - 1;
    }

    @Override
    public int calcNumFaltasRestantes () {
        //calcula quantas vezes o estudantes ainda pode faltar na matéria
        return calcNumFaltasMax() - faltas;
    }

    @Override
    public boolean addAvaliacao(Avaliacao avalicao) {
        try{
            listaAvaliacoes.add(avalicao);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean removerAvaliacao(Avaliacao avalicao) {
        try {
            listaAvaliacoes.remove(avalicao);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}