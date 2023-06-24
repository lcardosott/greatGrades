package model.CalcMedias;
import java.util.ArrayList;

import model.Avaliacao;

public abstract class OriginMedia {
    private ArrayList<Avaliacao> listaAvaliacoes;

    public ArrayList<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(ArrayList<Avaliacao> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }

    public double calcValor() {
        return 0;
    }
}
