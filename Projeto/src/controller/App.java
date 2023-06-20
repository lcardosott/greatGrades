package controller;
import model.Materia;
import model.Usuario;
import view.addMateria.FrameAddMateria;
import view.baseClasses.OriginFrame;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;
import view.firstPage.FrameInicial;
import view.verMateria.FrameVerMateria;
import view.verUsuario.FrameUsuario;
import view.menuprincipal.FramePrincipal;

public class App {  
    public static void main(String[] args) {
        new FrameInicial();
        //new FramePrincipal();
        //Materia materia = new Materia("materiatop", "a", "nomeProf", 5, 6, 0, 1);
        //new FrameCadastroAvaliacao(materia);
        //Usuario user = new Usuario("user", "Caio", "Unicamp", "Eng. Comp.", "senha");
        //new OriginFrame();
        //new FrameUsuario(user);
        //new FrameVerMateria(materia);
        //new FrameAddMateria(user);
    }
}