package view.baseClasses;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelIndicacao extends JLabel{
    public LabelIndicacao(String texto, Font fonte, Color cor) {
        this.setText(texto);
        this.setFont(fonte);
        this.setOpaque(true);
        this.setBackground(cor);
    }
}