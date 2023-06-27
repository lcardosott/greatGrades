package view.verMateria;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JScrollPane;
import model.InterfaceMateria;
//import model.Materia;
import view.baseClasses.Utilidades;


public class AtividadesScroll extends JScrollPane {
    public AtividadesScroll(Frame frameMateria, InterfaceMateria materia){
        this.setViewportView(new PainelAtividade(frameMateria, materia.getListaAvaliacoes()));
        this.setBackground(Color.white);
        this.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 113, Utilidades.dimensoesProporçãoLargura(0.46) , Utilidades.dimensoesProporçãoAltura(0.8)-(Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 140));

        this.setOpaque(true);
    }
}
