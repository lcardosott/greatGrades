package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Avaliacao;
import model.Materia;
import model.Usuario;


public class Inicializar {
	public static void lerInicio() {
		File usersCSV = new File("Projeto/src/controller/Files/Users.csv");
		File materiasCSV = new File("Projeto/src/controller/Files/Materias.csv");
		File avaliacoesCSV = new File("Projeto/src/controller/Files/Avaliacoes.csv");
		
		try {
			ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();
			Cadastro.setListaUsers(listaUsers);
			
			if (!usersCSV.exists()) {
				usersCSV.createNewFile();
                FileWriter fw = new FileWriter(usersCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("USER,NOME,INSTITUICAO,CURSO,SENHA\n");
                    bw.flush();
                    bw.close();
					fw.close();
                } 
                catch (IOException e) {
                    // Erro - joptionpane
                }
			}
			else {
				try (BufferedReader br = new BufferedReader(new FileReader(usersCSV))) {
					String linha;
					linha = br.readLine();
					linha = br.readLine();
					while (linha != null) {
						String[] campos = linha.split(",");
						campos[0] = campos[0].replaceAll("\"", "");
						campos[4] = campos[4].replaceAll("\"", "");
						Usuario user = new Usuario(campos[0], campos[1], campos[2], campos[3], campos[4]);
						listaUsers.add(user);
						linha = br.readLine();
					}
					br.close();
				}
			}
		
			if (!materiasCSV.exists()) {
				materiasCSV.createNewFile();
                FileWriter fw = new FileWriter(materiasCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("USER,NOME_MATERIA,TURMA,NOME_PROFESSOR,NOTA_MINIMA,NUMERO_CREDITOS,NUMERO_FALTAS,TIPO_MEDIA\n");
                    bw.flush();
                    bw.close();
					fw.close();
                } 
                catch (IOException e) {
                	// Erro - joptionpane
                }
			}
		
			if (!avaliacoesCSV.exists()) {
				avaliacoesCSV.createNewFile();
                FileWriter fw = new FileWriter(avaliacoesCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("USER,NOME_MATERIA,NOME_AVALIACAO,DATA_AVALIACAO,NOTA,PESO_NA_MEDIA,EXTRA_INFO\n");
                    bw.flush();
                    bw.close();
					fw.close();
                } 
                catch (IOException e) {
                	// Erro - joptionpane
                }
			}
		}
		
		catch (IOException e) {
			// Erro - joptionpane
		}		
	}
	
	public static void lerMaterias(Usuario user) {
		File materiasCSV = new File("Projeto/src/controller/Files/Materias.csv");
		FileReader fw = null;
		try {
			fw = new FileReader(materiasCSV);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(fw)) {
			String linha;
			linha = br.readLine();
			linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				campos[0] = campos[0].replaceAll("\"", "");
				campos[7] = campos[7].replaceAll("\"", "");
				if (campos[0].equals(user.getUsuario())) {
					Materia mat = new Materia(campos[1], campos[2], campos[3], Double.parseDouble(campos[4]), 
							    Integer.parseInt(campos[5]), Integer.parseInt(campos[6]), 
								Integer.parseInt(campos[7]), user);
					user.addMateria(mat);
				}
				linha = br.readLine();
			}
			br.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// JOptionPane
		} catch (IOException e) {
			// JOptionPane
		}
	}
	
	public static void lerAvaliacoes(Usuario user, Materia mat) {
		File avaliacoesCSV = new File("Projeto/src/controller/Files/Avaliacoes.csv");
		FileReader fr = null;
		try {
			fr = new FileReader(avaliacoesCSV);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(fr)) {
			String linha;
			linha = br.readLine();
			linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				campos[0] = campos[0].replaceAll("\"", "");
				campos[6] = campos[6].replaceAll("\"", "");
				if (campos[0].equals(user.getUsuario()) && campos[1].equals(mat.getNome())) {
					Avaliacao av = new Avaliacao(campos[2], campos[3], Double.parseDouble(campos[4]), 
												Double.parseDouble(campos[5]), campos[6], mat);
					mat.addAvaliacao(av);
				}
				linha = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}