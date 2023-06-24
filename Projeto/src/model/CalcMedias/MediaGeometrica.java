package model.CalcMedias;
import model.Avaliacao;

public class MediaGeometrica extends OriginMedia {
    @Override
    public double calcValor() {
        double multiplicacao = 0;
        for (Avaliacao avalicao : super.getListaAvaliacoes()) {
            multiplicacao *= avalicao.getNota();
        }
        return Math.pow(multiplicacao, (double) 1/super.getListaAvaliacoes().size());
    }
}
