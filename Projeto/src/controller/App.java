package controller;
//import view.firstPage.FrameInicial;

import model.Materia;
import view.cadastroAvaliacao.FrameCadastroAvaliacao;

public class App {
    public static void main(String[] args) {
        //new FrameInicial();
        Materia materia = new Materia("materiatop", "a", "nomeProf", 5, 6, 0, 1);
        new FrameCadastroAvaliacao(materia);
    }
}