package view.addMateria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import view.baseClasses.*;
import controller.*;
import model.*;

	public class PainelAddMateria extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JButton buttonAdd = new JButton();
		JTextField fieldNome = new JTextField();
		JTextField fieldTurma = new JTextField();
		JTextField fieldNomeProfessor = new JTextField();
		JComboBox<String> fieldTipoMedia;
		JTextField fieldCreditos = new JTextField();
		JTextField fieldNotaMinima = new JTextField();
		Usuario user;
		PainelAddMateria(Usuario user){
			this.user = user;
			//////// Fonte acima dos TextFields ///////////

			// Acima de cada campo
			Font fonteAcimaFields = new Font("Century Gothic", Font.BOLD, 20);
			// Fonte do campo
			Font fonteFields = new Font("Arial", Font.PLAIN, 16);
			
			//////// Setup dos TextFields, ComboBox e Button ////////////
			
			// LabelIndicacao e TextFields //
			
			LabelIndicacao labelNome = new LabelIndicacao("Nome da matéria", fonteAcimaFields, Color.pink);
			fieldNome.setPreferredSize(new Dimension(430,35));
			fieldNome.setFont(fonteFields);
			
			LabelIndicacao labelTurma = new LabelIndicacao("Turma", fonteAcimaFields, Color.pink);
			fieldTurma.setPreferredSize(new Dimension(430,35));
			fieldTurma.setFont(fonteFields);
			
			LabelIndicacao labelNomeProfessor = new LabelIndicacao("Nome do professor", fonteAcimaFields, Color.pink);
			fieldNomeProfessor.setPreferredSize(new Dimension(430,35));
			fieldNomeProfessor.setFont(fonteFields);
			
			LabelIndicacao labelCreditos = new LabelIndicacao("Quantidade de créditos", fonteAcimaFields, Color.pink);
			fieldCreditos.setPreferredSize(new Dimension(430,35));
			fieldCreditos.setFont(fonteFields);
			
			LabelIndicacao labelNotaMinima = new LabelIndicacao("Nota mínima", fonteAcimaFields, Color.pink);
			fieldNotaMinima.setPreferredSize(new Dimension(430,35));
			fieldNotaMinima.setFont(fonteFields);
			
			// ComboBox //
			LabelIndicacao labelTipoMedia = new LabelIndicacao("Tipo de média ", fonteAcimaFields, Color.pink);
			String[] opcoesMedia = {"Aritmética","Ponderada","Harmônica","Geométrica","Quadrática"};
			fieldTipoMedia = new JComboBox<>(opcoesMedia);
			fieldTipoMedia.setFont(fonteFields);
			fieldTipoMedia.setFocusable(false);
			
			// Button //
			buttonAdd.setPreferredSize(new Dimension(200,50));
			buttonAdd.setFont(fonteAcimaFields);
			buttonAdd.setText("Adicionar");
			buttonAdd.setFocusable(false);
			buttonAdd.addActionListener(this);
			
			///////// Setup do Panel e Adds de Componentes //////////
			Border borda = BorderFactory.createEtchedBorder(Color.white, Color.black);
			this.setBorder(borda);
			this.setOpaque(true);
			this.setBackground(Color.pink);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.setBounds((Utilidades.dimensoesProporçãoLargura(0.6)-500)/2, (Utilidades.dimensoesProporçãoAltura(1)-500)/2, 500, 460);
			
			// Adds
			this.add(labelNome);
			this.add(fieldNome);
			
			this.add(labelTurma);
			this.add(fieldTurma);
			
			this.add(labelNomeProfessor);
			this.add(fieldNomeProfessor);
			
			this.add(labelTipoMedia);
			this.add(fieldTipoMedia);
			
			this.add(labelCreditos);
			this.add(fieldCreditos);
			
			this.add(labelNotaMinima);
			this.add(fieldNotaMinima);
			
			this.add(buttonAdd);
			
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonAdd) {
				String nomeMateria = fieldNome.getText();
				String turmaMateria = fieldTurma.getText();
				String profMateria = fieldNomeProfessor.getText();
				int tipoMediaMateria = fieldTipoMedia.getSelectedIndex();
				String creditosMateria = fieldCreditos.getText();
				String notaMinMateria = fieldNotaMinima.getText();
				
				new AddMateria(user, nomeMateria, turmaMateria, profMateria, notaMinMateria, creditosMateria, tipoMediaMateria);
			}
		}
		
	}

