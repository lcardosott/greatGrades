package view.verMateria;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.Avaliacao;

public class PainelAtividade extends JPanel{

    private Frame frameMateria;
    public PainelAtividade(Frame frameMateria, ArrayList<Avaliacao> listaAvaliacoes) {
        this.frameMateria = frameMateria;
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        adicionaAvaliacoes(listaAvaliacoes);
        this.setOpaque(true);
    }

    public void adicionaAvaliacoes(ArrayList<Avaliacao> listaAvaliacoes){
        for(Avaliacao avaliacao: listaAvaliacoes){
            this.add(new InfoAtividade(frameMateria, avaliacao));
        }
    }
}
