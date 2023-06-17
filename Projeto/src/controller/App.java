package controller;
//import view.firstPage.FrameInicial;
//import model.Materia;
//import view.cadastroAvaliacao.FrameCadastroAvaliacao;
import model.Usuario;
import view.verUsuario.FrameUsuario;

public class App {
    public static void main(String[] args) {
        //new FrameInicial();
        //Materia materia = new Materia("materiatop", "a", "nomeProf", 5, 6, 0, 1);
        //new FrameCadastroAvaliacao(materia);
        Usuario user = new Usuario("user", "Caio", "Unicamp", "Eng. Comp.", "senha");
        new FrameUsuario(user);
    }
}