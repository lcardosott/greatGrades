package view.menuprincipal;

import java.awt.Color;

import javax.swing.JPanel;

import view.baseClasses.Utilidades;

public class PainelInferior extends JPanel{
        public PainelInferior(){
        this.setBackground(Color.white);
        this.setBounds(0,Utilidades.dimensoesProporçãoAltura(0.10) +1, Utilidades.dimensoesProporçãoLargura(1),Utilidades.dimensoesProporçãoAltura(0.89));
        //painelEsquerda.setBorder(border);
        this.setOpaque(true);
    }
}
