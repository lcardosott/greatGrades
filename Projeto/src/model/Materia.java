package model;
import java.util.ArrayList;
import model.CalcMedias.*;

public class Materia implements InterfaceMateria {
    private Usuario user;
    private String nome;
    private String turma;
    private String nomeProfessor;
    private ArrayList<Avaliacao> listaAvaliacoes;
    private double notaMinima; //nota minima para aprovação
    private int creditos;
    private int faltas; //quantas vezes o aluno já faltou nas aulas da disciplina
    private int tipoMedia;
    private OriginMedia media;

    public Materia (String nome, String turma, String nomeProfessor, double notaMinima, int creditos, int faltas, int tipoMedia, Usuario user) {
        this.nome = nome;
        this.turma = turma;
        this.nomeProfessor = nomeProfessor;
        this.notaMinima = notaMinima;
        this.faltas = faltas;
        this.creditos = creditos;
        this.tipoMedia = tipoMedia;
        listaAvaliacoes = new ArrayList<Avaliacao>();
        this.user = user;
        //Setting media
        if (tipoMedia == Medias.MEDIA_ARITMETICA_SIMPLES.getValue()) {
            this.media = new MediaAritimetica();
        }
        else if (tipoMedia == Medias.MEDIA_PONDERADA.getValue()) {
            this.media = new MediaPonderada();
        }
        else if (tipoMedia == Medias.MEDIA_HARMONICA.getValue()) {
            this.media = new MediaHarmonica();
        }
        else if (tipoMedia == Medias.MEDIA_GEOMETRICA.getValue()) {
            media = new MediaGeometrica();
        }
        else {
            media = new MediaQuadratica();
        }
        media.setListaAvaliacoes(listaAvaliacoes);
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

    public Usuario getUser() {
        return user;
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
        return media.calcValor();
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
    @Override
    public boolean jaPassou() {
        //verifica se, com a média atual, o aluno já foi aprovado na matéria.
        if (media.calcValor() >= notaMinima) {
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