import java.util.ArrayList;

public class Materia {
    private String nome;
    private String turma;
    private String nomeProfessor;
    private ArrayList<Prova> listaProvas;
    private ArrayList<Trabalho> listaTrabalhos;
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
        listaProvas = new ArrayList<Prova>();
        listaTrabalhos = new ArrayList<Trabalho>();
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

    //Funções

    private double calcMediaAritmeticaSimples (int N) {
        double soma = 0;
        for (Prova prova : listaProvas) {
            soma += prova.getNota();
        }
        for (Trabalho trabalho : listaTrabalhos) {
            soma += trabalho.getNota();
        }
        return soma/N;
    }

    private double calcMediaPonderada (int N) {
        double soma = 0;
        for (Prova prova : listaProvas) {
            soma += prova.getNota() * prova.getPesoNaMedia();
        }

        for (Trabalho trabalho : listaTrabalhos) {
            soma += trabalho.getNota() * trabalho.getPesoNaMedia();
        }
        
        return soma/N;
    }

    private double calcMediaHarmonica (int N) {
        double soma = 0;
        for (Trabalho trabalho : listaTrabalhos) {
            soma += (double) 1/trabalho.getNota();
        }
        for (Prova prova : listaProvas) {
            soma += (double) 1/prova.getNota();
        }
        return N/soma;
    }

    private double calcMediaGeometrica (int N) {
        double multiplicacao = 0;
        for (Trabalho trabalho : listaTrabalhos) {
            multiplicacao *= trabalho.getNota();
        }
        for (Prova prova : listaProvas) {
            multiplicacao *= prova.getNota();
        }
        return Math.pow(multiplicacao, (double) 1/N);
    }

    private double calcMediaQuadratica (int N) {
        double soma = 0;
        for (Trabalho trabalho : listaTrabalhos) {
            soma += (double) Math.pow(trabalho.getNota(), 2);
        }
        for (Prova prova : listaProvas) {
            soma += (double) Math.pow(prova.getNota(), 2);
        }
        return (double) Math.sqrt((double) soma/N);
    }

    public double calcMediaAtual () {
        //calcula a média atual do aluno na matéria em questão
        int N = listaProvas.size() + listaTrabalhos.size();
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

    public boolean addProva(Prova prova) {
        try{
            listaProvas.add(prova);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean removerProva(Prova prova) {
        try {
            listaProvas.remove(prova);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean addTrabalho(Trabalho trabalho) {
        try{
            listaTrabalhos.add(trabalho);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean removerTrabalho (Trabalho trabalho) {
        try {
            listaTrabalhos.remove(trabalho);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}