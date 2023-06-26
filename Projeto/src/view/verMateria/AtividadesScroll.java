package view.verMateria;

import java.awt.Color;

import javax.swing.JScrollPane;
import model.Materia;
import view.baseClasses.Utilidades;
import view.menuprincipal.PainelMateria;

public class AtividadesScroll extends JScrollPane {
    public AtividadesScroll(Materia materia){
    this.setViewportView(new PainelAtividade(materia.getListaAvaliacoes()));
            this.setBackground(Color.white);
            this.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 113, Utilidades.dimensoesProporçãoLargura(0.46) , Utilidades.dimensoesProporçãoAltura(0.8)-(Utilidades.dimensoesProporçãoLargura(0.02) + Utilidades.dimensoesProporçãoAltura(0.2) + 120));

            this.setOpaque(true);
    }
}
