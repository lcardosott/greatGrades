package view.verMateria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
        info.setBounds(Utilidades.dimensoesProporçãoAltura(0.01),Utilidades.dimensoesProporçãoAltura(0.01)+ 45, 300, 65);
        this.add(info);

        //Notas
        LabelIndicacao notaIndicacao = new LabelIndicacao("Nota: ", new Font("Arial",Font.BOLD,20),Color.white);
        notaIndicacao.setBounds(Utilidades.dimensoesProporçãoLargura(0.34)-80, Utilidades.dimensoesProporçãoAltura(0.10)-28,70 ,22 );
        this.add(notaIndicacao);


        JTextPane nota = new JTextPane();
        nota.setText(Double.toString(avaliacao.getNota()));
        nota.setFont(new Font("Arial",Font.PLAIN,15));
        nota.setBorder(BorderFactory.createLineBorder(Color.black,1));
        nota.setBounds(Utilidades.dimensoesProporçãoLargura(0.34), Utilidades.dimensoesProporçãoAltura(0.10)-28, 100, 25);
        //nota.setLineWrap(true); 
        this.add(nota);

        JButton ok = new JButton("OK");
        ok.setFont(new Font("Arial",Font.BOLD,20));
        ok.setBackground(new Color(0xD643CE));
        ok.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        ok.setFocusPainted(false);
        ok.setBounds(Utilidades.dimensoesProporçãoLargura(0.34), Utilidades.dimensoesProporçãoAltura(0.10), 100, 25);
        this.add(ok);


        //Delete
        JButton x = new JButton("x");
        x.setFont(new Font("Arial",Font.BOLD,20));
        x.setForeground(Color.white);
        x.setBackground(Color.red);
        x.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        x.setFocusPainted(false);
        x.setBounds( Utilidades.dimensoesProporçãoLargura(0.43),0,Utilidades.dimensoesProporçãoAltura(0.03), Utilidades.dimensoesProporçãoAltura(0.03));
        this.add(x);

    }
}
