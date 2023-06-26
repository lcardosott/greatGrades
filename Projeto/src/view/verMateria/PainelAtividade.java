package view.verMateria;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.Avaliacao;

public class PainelAtividade extends JPanel{
    public PainelAtividade(ArrayList<Avaliacao> listaAvaliacoes) {
            this.setBackground(Color.WHITE);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            adicionaAvaliacoes(listaAvaliacoes);
            this.setOpaque(true);
    }

    public void adicionaAvaliacoes(ArrayList<Avaliacao> listaAvaliacoes){
        for(Avaliacao avaliacao: listaAvaliacoes){
            this.add(new InfoAtividade(avaliacao));
        }
    }
}
