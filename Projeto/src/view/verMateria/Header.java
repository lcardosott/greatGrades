package view.verMateria;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.InterfaceMateria;
import model.Materia;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.Utilidades;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;

public class Header extends JPanel implements ActionListener {
    private JButton adiciona;
    private InterfaceMateria materia;
    private JFrame frameMateria;

    public Header(JFrame frameMateria, InterfaceMateria materia){
        this.frameMateria = frameMateria;
        this.materia = materia;
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoLargura(0.46) , Utilidades.dimensoesProporçãoAltura(0.2));
        


        //Info
        LabelIndicacao nome = new LabelIndicacao(materia.getNome(), new Font("Arial",Font.BOLD,40), Color.white);
        nome.setBounds(Utilidades.dimensoesProporçãoLargura(0.02),Utilidades.dimensoesProporçãoAltura(0.03),300,43);

        LabelIndicacao professor = new LabelIndicacao(materia.getNomeProfessor(), new Font("Arial",Font.PLAIN,25), Color.white);
        professor.setBounds(Utilidades.dimensoesProporçãoLargura(0.02), Utilidades.dimensoesProporçãoAltura(0.03) + 47,300,30);

        LabelIndicacao turma = new LabelIndicacao("Turma " + materia.getTurma(), new Font("Arial",Font.PLAIN,20), Color.white);
        turma.setBounds(Utilidades.dimensoesProporçãoLargura(0.02), Utilidades.dimensoesProporçãoAltura(0.03) + 82,300,25);
    

        adiciona = new JButton();
        adiciona.setText("+ Atividade");
        adiciona.setFont(new Font("Arial",Font.BOLD,18));
        adiciona.setBackground(new Color(0XFFD954));
        adiciona.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        adiciona.setFocusPainted(false);
        adiciona.setBounds(Utilidades.dimensoesProporçãoLargura(0.46) -173, Utilidades.dimensoesProporçãoAltura(0.2)-43,150, 23);

        //Adicionando
        this.add(adiciona);
        this.add(nome);
        this.add(professor);
        this.add(turma);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adiciona) {
            frameMateria.dispose();
            new FrameCadastroAvaliacao(materia);
        }
    }
}
