package model.CalcMedias;
import model.Avaliacao;

public class MediaAritimetica extends OriginMedia {
    @Override
    public double calcValor () {
        double soma = 0;
        for (Avaliacao avalicao : super.getListaAvaliacoes()) {
            soma += avalicao.getNota();
        }
        return (double) soma/super.getListaAvaliacoes().size();
    }
}