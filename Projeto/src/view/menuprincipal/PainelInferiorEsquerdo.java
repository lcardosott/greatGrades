package view.menuprincipal;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import model.Materia;
import view.baseClasses.Utilidades;

public class PainelInferiorEsquerdo extends JScrollPane{

        public PainelInferiorEsquerdo(ArrayList<Materia> listaMaterias){
            //Teste materia
            verificaMateria(listaMaterias);
            this.setBackground(Color.white);
            this.setBounds(0,Utilidades.dimensoesProporçãoAltura(0.10) +1, Utilidades.dimensoesProporçãoLargura(0.7),Utilidades.dimensoesProporçãoAltura(0.9)-1);

            this.setOpaque(true);
    }
    public void verificaMateria(ArrayList<Materia> listaMaterias){
        if (listaMaterias.isEmpty()){
            JTextPane info = new JTextPane();
            info.setText("\n\n     :(     Parece que você ainda não\n             possui nenhuma matéria \n             cadastradada. \n\n             Cadastre sua primeira \n             matéria no botão 'Cadastrar Matéria'");
            info.setEditable(false);
            info.setFont(new Font("Arial",Font.PLAIN,20));
            info.setBackground(new Color(0xFDB5ED));
            info.setBounds(Utilidades.dimensoesProporçãoAltura(0.1),Utilidades.dimensoesProporçãoAltura(0.1)+ 45, 100, 100);
            this.setViewportView(info);
        }else{
            this.setViewportView(new PainelMateria(listaMaterias));
        }
    }
}
