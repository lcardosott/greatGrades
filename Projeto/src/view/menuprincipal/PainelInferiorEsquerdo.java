package view.menuprincipal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import model.Materia;
import view.baseClasses.Utilidades;

public class PainelInferiorEsquerdo extends JScrollPane{
    
    ArrayList<Materia> listaMaterias = new ArrayList<Materia>();

        public PainelInferiorEsquerdo(){
            //Teste materia
            this.listaMaterias.add(new Materia("MC322", "A", "Esther estherlc@unicamp.br", 5, 6, 0, 1));
            this.listaMaterias.add(new Materia("EA513", "B", "Christian Lira Filho", 5, 6, 0, 1));
            this.listaMaterias.add(new Materia("F328", "A", "Flavia Coveira", 5, 6, 0, 1));
            this.listaMaterias.add(new Materia("MC329", "A", "Thiago Alegre", 5, 6, 0, 1));


            this.setViewportView(new PainelMateria(listaMaterias));
            this.setBackground(Color.white);
            this.setBounds(0,Utilidades.dimensoesProporçãoAltura(0.10) +1, Utilidades.dimensoesProporçãoLargura(0.7),Utilidades.dimensoesProporçãoAltura(0.9)-1);

            this.setOpaque(true);
    }
}
