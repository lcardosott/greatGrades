package controller;
public class Validacao {

    public static boolean validaNome (String nome) {
        return nome.matches("^[a-zA-ZÀ-ę ]*$");
    }
}