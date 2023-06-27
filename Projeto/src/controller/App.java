package controller;
//import model.Avaliacao;
//import model.Materia;
//import model.Usuario;
//import view.addMateria.FrameAddMateria;
//import view.cadastroAvaliacao.FrameCadastroAvaliacao;
import view.firstPage.FrameInicial;
//import view.menuprincipal.FramePrincipal;
//import view.verMateria.FrameMateria;
//import view.verUsuario.FrameUsuario;
//import view.firstPage.FrameInicial;

public class App {
    public static void main(String[] args) {
    	Inicializar.lerInicio();
    	// Depois do login, deve-se ler as matérias que pertencem a um user,
    	// bem como as avaliações.
    	
    	new FrameInicial();

        //new FrameCadastroAvaliacao(materia);
        //Materia materia = new Materia("a","a","a",1,1,1,1,new Usuario("a","a","a","a","a"));
        //new FramePrincipal(user);
        //new FrameMateria(materia);
        //new FrameAddMateria(user);
    }
}