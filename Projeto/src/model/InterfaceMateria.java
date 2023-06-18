package model;

import java.util.ArrayList;

public interface InterfaceMateria {

    String getNome();

    String getTurma();

    String getNomeProfessor();

    double getNotaMinima();

    int getCreditos();

    int getFaltas();

    int getTipoMedia();

    double getMediaAtual();

    ArrayList<Avaliacao> getListaAvaliacoes();

    void setNome(String nome);

    void setTurma(String turma);

    void setNomeProfessor(String nomeProfessor);

    void setNotaMinima(double notaMinima);

    void setCreditos(int creditos);

    void setFaltas(int faltas);

    void setTipoMedia(int tipoMedia);

    double calcMediaAtual();

    boolean jaPassou();

    int calcNumFaltasMax();

    int calcNumFaltasRestantes();

    boolean addAvaliacao(Avaliacao avalicao);

    boolean removerAvaliacao(Avaliacao avalicao);

}