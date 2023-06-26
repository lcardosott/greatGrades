package view.menuprincipal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import model.Materia;
import view.baseClasses.Utilidades;

public class PainelInferiorEsquerdo extends JScrollPane{
        public PainelInferiorEsquerdo(ArrayList<Materia> listaMaterias){
            //Teste materia

            this.setViewportView(new PainelMateria(listaMaterias));
            this.setBackground(Color.white);
            this.setBounds(0,Utilidades.dimensoesProporçãoAltura(0.10) +1, Utilidades.dimensoesProporçãoLargura(0.7),Utilidades.dimensoesProporçãoAltura(0.9)-1);

            this.setOpaque(true);
    }
}
