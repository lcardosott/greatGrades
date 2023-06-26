package model.CalcMedias;
import model.Avaliacao;

public class MediaQuadratica extends OriginMedia {
    @Override
    public double calcValor() {
        double soma = 0;
        for (Avaliacao avalicao : super.getListaAvaliacoes()) {
            soma += (double) Math.pow(avalicao.getNota(), 2);
        }
        return (double) Math.sqrt((double) soma/super.getListaAvaliacoes().size());
    }
}
