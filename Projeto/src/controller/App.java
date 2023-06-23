package controller;
//import view.firstPage.FrameInicial;
import model.Materia;
import model.Usuario;
import view.addMateria.FrameAddMateria;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;
//import model.Usuario;
import view.verMateria.FrameVerMateria;
//import view.verUsuario.FrameUsuario;
import view.firstPage.FrameInicial;

public class App {
    public static void main(String[] args) {
        //new FrameInicial();
        Usuario user = new Usuario("user", "Caio", "Unicamp", "Eng. Comp.", "senha");
        Materia materia = new Materia("materiatop", "a", "nomeProf", 5, 6, 0, 1, user);
        new FrameCadastroAvaliacao(materia);
        //new FrameUsuario(user);
        //new FrameVerMateria(materia);
        //new FrameAddMateria(user);
    }
}