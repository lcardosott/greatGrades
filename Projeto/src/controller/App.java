package controller;
import model.Avaliacao;
import model.Materia;
import model.Usuario;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;
import view.firstPage.FrameInicial;
import view.menuprincipal.FramePrincipal;
import view.verMateria.FrameMateria;
import view.verMateria.FrameVerMateria;
import view.firstPage.FrameInicial;

public class App {
    public static void main(String[] args) {
    	Inicializar.lerTudo();
    	// Depois do login, deve-se ler as matérias que pertencem a um user,
    	// bem como as avaliações.
    	
    	//new FrameInicial();
        Usuario user = new Usuario("user", "Caio", "Unicamp", "Eng. Comp.", "senha");
        Materia materia = new Materia("materiatop", "a", "nomeProf", 5, 6, 0, 1, user);
	
        user.getListaMaterias().add(materia);
        user.getListaMaterias().add(materia);
        user.getListaMaterias().add(materia);        
        //new FrameCadastroAvaliacao(materia);
        Avaliacao avaliacao = new Avaliacao("P3","27/06" , 0,3, "Experimento 3 e 4, que se trata de circuitos eletricos e osciloscopio", materia);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        new FramePrincipal(user);
        new FrameMateria(materia);
        //new FrameAddMateria(user);
    }
}