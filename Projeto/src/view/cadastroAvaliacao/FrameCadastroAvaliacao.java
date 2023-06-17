package view.cadastroAvaliacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CadastroAvaliacao;
import model.Materia;
import view.LabelIndicacao;
import view.Utilidades;
import view.originFrame;

public class FrameCadastroAvaliacao extends originFrame implements ActionListener{
    private Color roxo = new Color(0xFDB5ED);
    private ImageIcon fundo = new ImageIcon("imagens/fundo.png");
    private BotaoCadastroAvaliacao BotaoCadastroAvaliacao;
    private JTextField nome;
    private JTextField dataEntrega;
    private JTextField nota;
    private JTextField pesoNaMedia;
    private JTextField extraInfo;
    private Materia materia;
    
    public FrameCadastroAvaliacao(Materia materia) {
        JPanel painel = new JPanel();
        this.materia = materia;

        painel.setBackground(roxo);
        painel.setLayout(null);
        painel.setBounds(Utilidades.dimensoesProporçãoAltura(0.5), Utilidades.dimensoesProporçãoAltura(0.01), 500, 500);
        painel.setBorder(BorderFactory.createEtchedBorder());

        //Título
        LabelIndicacao labelTitulo = new LabelIndicacao("Cadastro de Avaliação", new Font("Arial",Font.BOLD,35), roxo);
        labelTitulo.setBounds(70, 30, 500, 50);

        //Nome
        LabelIndicacao labelNome = new LabelIndicacao("Nome:", new Font("Arial",Font.BOLD,20), roxo);
        labelNome.setBounds(70, 80, 100, 20);
        nome = new JTextField();
        nome.setBounds(70, 100, 320, 35);

        //Data de entrega
        LabelIndicacao labelDataEntrega = new LabelIndicacao("Data:", new Font("Arial",Font.BOLD,20), roxo);
        labelDataEntrega.setBounds(70, 140 ,300,20);
        dataEntrega = new JTextField();
        dataEntrega.setBounds(70, 160, 320, 35);

        //Nota
        LabelIndicacao labelNota = new LabelIndicacao("Nota:", new Font("Arial",Font.BOLD,20), roxo);
        labelNota.setBounds(70, 200,300 ,20);
        nota = new JTextField();
        nota.setBounds(70, 220, 320, 35);

        //Peso na média
        LabelIndicacao labelPesoNaMedia = new LabelIndicacao("Peso na média:", new Font("Arial",Font.BOLD,20), roxo);
        labelPesoNaMedia.setBounds(70, 260 ,300,20);
        pesoNaMedia = new JTextField();
        pesoNaMedia.setBounds(70, 280, 320, 35);
        
        //Extra info
        LabelIndicacao labelExtraInfo = new LabelIndicacao("Informação extra:", new Font("Arial",Font.BOLD,20), roxo);
        labelExtraInfo.setBounds(70, 320 ,300,20);
        extraInfo = new JTextField();
        extraInfo.setBounds(70, 340, 320, 35);

        //Botão de cadastro
        BotaoCadastroAvaliacao = new BotaoCadastroAvaliacao();
        BotaoCadastroAvaliacao.addActionListener(this);

        //Label que carrega o fundo
        JLabel labelFundo = new JLabel();
        labelFundo.setBackground(Color.WHITE);
        labelFundo.setIcon(fundo);
        labelFundo.setOpaque(true);
        labelFundo.setBounds(Utilidades.dimensoesProporçãoLargura(1)-fundo.getIconWidth(),Utilidades.dimensoesProporçãoAltura(1)-fundo.getIconHeight(), fundo.getIconWidth(), fundo.getIconHeight());

        //Adicionando no Painel
        //Título
        painel.add(labelTitulo);
        //Nome
        painel.add(labelNome);
        painel.add(nome);
        //Data de entrega
        painel.add(labelDataEntrega);
        painel.add(dataEntrega);
        //Nota
        painel.add(labelNota);
        painel.add(nota);
        //Peso na média
        painel.add(labelPesoNaMedia);
        painel.add(pesoNaMedia);
        //Extra info
        painel.add(labelExtraInfo);
        painel.add(extraInfo);
        //Botão
        painel.add(BotaoCadastroAvaliacao);
        //Visibilidade
        this.setVisible(true);
        BotaoCadastroAvaliacao.setVisible(true);
        this.add(painel);
        this.add(labelFundo);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BotaoCadastroAvaliacao) {
            String nomeStr = nome.getText();
            String dataStr = dataEntrega.getText();
            String notaStr = nota.getText();
            String pesoNaMediaStr = pesoNaMedia.getText();
            String extraInfoStr = extraInfo.getText();
            new CadastroAvaliacao(nomeStr, dataStr, notaStr, pesoNaMediaStr, extraInfoStr, materia);
        }
    }
}
