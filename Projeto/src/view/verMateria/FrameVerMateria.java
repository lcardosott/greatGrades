package view.verMateria;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Materia;
import view.baseClasses.LabelIndicacao;
import view.baseClasses.OriginFrame;
import view.baseClasses.Utilidades;

public class FrameVerMateria extends OriginFrame {
    private Color roxo = new Color(0xFDB5ED);
    private ImageIcon fundo = new ImageIcon("imagens/fundo.png");
    
    public FrameVerMateria(Materia materia) {
        JPanel painel = new JPanel();

        painel.setBackground(roxo);
        painel.setLayout(null);
        painel.setBounds(Utilidades.dimensoesProporçãoAltura(0.5), Utilidades.dimensoesProporçãoAltura(0.01), 500, 500);
        painel.setBorder(BorderFactory.createEtchedBorder());

        //Título
        LabelIndicacao labelTitulo = new LabelIndicacao(materia.getNome(), new Font("Arial",Font.BOLD,35), roxo);
        labelTitulo.setBounds(65, 30, 500, 50);

        //Turma
        LabelIndicacao labelTurma = new LabelIndicacao("Turma: " + materia.getTurma(), new Font("Arial",Font.BOLD,20), roxo);
        labelTurma.setBounds(70, 80, 500, 50);

        //Nome do professor
        LabelIndicacao labelNomeProfessor = new LabelIndicacao("Nome do professor: " + materia.getNomeProfessor(), new Font("Arial",Font.BOLD,20), roxo);
        labelNomeProfessor.setBounds(70, 120, 500, 50);

        //Média atual
        LabelIndicacao labelMediaAtual = new LabelIndicacao("Média atual: " + materia.getMediaAtual(), new Font("Arial",Font.BOLD,20), roxo);
        labelMediaAtual.setBounds(70, 160 ,500,50);

        //Nota mínima para aprovação
        LabelIndicacao labelNotaMinima = new LabelIndicacao("Nota mínima: " + materia.getNotaMinima(), new Font("Arial",Font.BOLD,20), roxo);
        labelNotaMinima.setBounds(70, 200,500 ,50);

        //Créditos
        LabelIndicacao labelCreditos = new LabelIndicacao("Créditos: " + materia.getCreditos(), new Font("Arial",Font.BOLD,20), roxo);
        labelCreditos.setBounds(70, 200,500 ,50);

        //Faltas
        LabelIndicacao labelFaltas = new LabelIndicacao("Faltas: " + materia.getFaltas(), new Font("Arial",Font.BOLD,20), roxo);
        labelFaltas.setBounds(70, 200,500 ,50);

        //Número de faltas restantes
        LabelIndicacao labelFaltasRestantes = new LabelIndicacao("Faltas restantes: " + materia.calcNumFaltasRestantes(), new Font("Arial",Font.BOLD,20), roxo);
        labelFaltasRestantes.setBounds(70, 200,500 ,50);

        //Avaliações - O que fazer? Criar uma tela para visualizar uma avaliação?
        if (materia.getListaAvaliacoes().size() > 0) {
            LabelIndicacao labelAvaliacoes = new LabelIndicacao("Avaliações: " + materia.calcNumFaltasRestantes(), new Font("Arial",Font.BOLD,20), roxo);
            labelAvaliacoes.setBounds(70, 200,500 ,50);
        }

        //Label que carrega o fundo
        JLabel labelFundo = new JLabel();
        labelFundo.setBackground(Color.WHITE);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setBounds(Utilidades.dimensoesProporçãoLargura(1)-fundo.getIconWidth(),Utilidades.dimensoesProporçãoAltura(1)-fundo.getIconHeight(), fundo.getIconWidth(), fundo.getIconHeight());

        //Adicionando no Painel
        //Título
        painel.add(labelTitulo);
        //Turma
        painel.add(labelTurma);
        //Nome do professor
        painel.add(labelNomeProfessor);
        //Média atual
        painel.add(labelMediaAtual);
        //Nota mínima para aprovação
        painel.add(labelNotaMinima);
        //Créditos
        painel.add(labelCreditos);
        //Faltas
        painel.add(labelFaltas);
        //Faltas restantes
        painel.add(labelFaltasRestantes);
        //Visibilidade
        this.setVisible(true);
        this.add(painel);
        this.add(labelFundo);
    }
}
