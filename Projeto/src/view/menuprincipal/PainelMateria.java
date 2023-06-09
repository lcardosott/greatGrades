package view.menuprincipal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Materia;


public class PainelMateria extends JPanel{
    private JFrame framePrincipal;

    public PainelMateria(JFrame framePrincipal, ArrayList<Materia> listaMaterias){
        this.framePrincipal = framePrincipal;
            this.setBackground(Color.WHITE);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            adicionaMaterias(listaMaterias);
            this.setOpaque(true);
    }
    public void adicionaMaterias(ArrayList<Materia> listaMaterias){
        for(Materia materia: listaMaterias){
            this.add(new InfoMateria(materia, framePrincipal));
        }
    }
}
