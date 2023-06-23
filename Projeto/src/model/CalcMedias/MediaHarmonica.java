package model.CalcMedias;
import model.Avaliacao;

public class MediaHarmonica extends OriginMedia {
    @Override
    public double calcValor() {
        double soma = 0;
        for (Avaliacao avalicao : super.getListaAvaliacoes()) {
            soma += (double) 1/avalicao.getNota();
        }
        return (double) super.getListaAvaliacoes().size()/soma;
    }
}
