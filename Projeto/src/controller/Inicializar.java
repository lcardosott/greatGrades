package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Usuario;


public class Inicializar {
	public static void lerTudo() {
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
                    bw.write("USER,NOME,INSTITUICAO,CURSO,SENHA");
                    bw.flush();
                    bw.close();
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
						Usuario user = new Usuario(campos[0], campos[1], campos[2], campos[3], campos[4]);
						Cadastro.getListaUsers().add(user);
					}
				}
			}
		
			if (!materiasCSV.exists()) {
				materiasCSV.createNewFile();
                FileWriter fw = new FileWriter(materiasCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("USER,NOME,MATERIA,TURMA,NOME_PROFESSOR,NOTA_MINIMA,NUMERO_CREDITOS,NUMERO_FALTAS,TIPO_MEDIA");
                    bw.flush();
                    bw.close();
                } 
                catch (IOException e) {
                	// Erro - joptionpane
                }
			}
		
			if (!avaliacoesCSV.exists()) {
				avaliacoesCSV.createNewFile();
                FileWriter fw = new FileWriter(avaliacoesCSV, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write("USER,NOME,MATERIA,NOME_AVALIACAO,DATA_AVALIACAO,NOTA,PESO_NA_MEDIA,EXTRA_INFO");
                    bw.flush();
                    bw.close();
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
}