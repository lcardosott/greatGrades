package model.CalcMedias;
import model.Avaliacao;

public class MediaPonderada extends OriginMedia {
    @Override
    public double calcValor() {
        double soma = 0;
        for (Avaliacao avalicao : super.getListaAvaliacoes()) {
            soma += avalicao.getNota() * avalicao.getPesoNaMedia();
        }
        return (double) soma/super.getListaAvaliacoes().size();
    }
}
