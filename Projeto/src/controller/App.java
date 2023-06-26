package controller;
import model.Avaliacao;
import model.Materia;
import model.Usuario;
import view.addMateria.FrameAddMateria;
import view.baseClasses.OriginFrame;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;
import view.firstPage.FrameInicial;
import view.verMateria.FrameMateria;
import view.verMateria.FrameVerMateria;
import view.verUsuario.FrameUsuario;
import view.menuprincipal.FramePrincipal;

public class App {  
    public static void main(String[] args) {
        //new FrameInicial();
        
        Materia materia = new Materia("F329", "A", "Thiago Alegre", 5, 6, 0, 1);
        //new FrameCadastroAvaliacao(materia);
        //Usuario user = new Usuario("user", "Caio", "Unicamp", "Eng. Comp.", "senha");
        //new FramePrincipal(user);
        //new OriginFrame();
        //new FrameUsuario(user);
        Avaliacao avaliacao = new Avaliacao("P3","27/06" , 0,3, "Experimento 3 e 4, que se trata de circuitos eletricos e osciloscopio", materia);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        materia.addAvaliacao(avaliacao);
        new FrameMateria(materia);
        //new FrameAddMateria(user);
    }
}