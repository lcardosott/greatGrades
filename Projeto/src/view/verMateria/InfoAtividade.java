package view.verMateria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import model.Avaliacao;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;

public class InfoAtividade  extends JPanel {
    public InfoAtividade(Avaliacao avaliacao){
         //Border
        Border border = BorderFactory.createLineBorder(Color.black,1);
        //Cor
        Color roxo = new Color(0xD643CE);

        //Seta parametros basicos
        this.setLayout(null);
        this.setBorder(border);
        this.setPreferredSize(new Dimension(Utilidades.dimensoesProporçãoLargura(0.38), Utilidades.dimensoesProporçãoAltura(0.2)));
        this.setBackground(Color.white);

        //Nome
        LabelIndicacao nomeAvaliacao = new LabelIndicacao(avaliacao.getNome()+" - " + avaliacao.getData(), new Font("Arial",Font.BOLD,25),Color.white);
        nomeAvaliacao.setBounds(Utilidades.dimensoesProporçãoAltura(0.01),Utilidades.dimensoesProporçãoAltura(0.01), 300,28);
        this.add(nomeAvaliacao);
        //Peso 
        LabelIndicacao peso = new LabelIndicacao("Peso: " + avaliacao.getPesoNaMedia(), new Font("Arial",Font.PLAIN,12),Color.white);
        peso.setBounds(Utilidades.dimensoesProporçãoAltura(0.01),Utilidades.dimensoesProporçãoAltura(0.01)+ 28, 300,15);
        this.add(peso);

        //Info
        JTextPane info = new JTextPane();
        info.setText("Info: " + avaliacao.getExtraInfo());
        info.setEditable(false);
        info.setFont(new Font("Arial",Font.PLAIN,15));
            //    LabelIndicacao info = new LabelIndicacao("Info: " + avaliacao.getExtraInfo(), new Font("Arial",Font.PLAIN,15),Color.white);;
        info.setBounds(Utilidades.dimensoesProporçãoAltura(0.01),Utilidades.dimensoesProporçãoAltura(0.01)+ 45, 300, 65);
        this.add(info);

    }
}
