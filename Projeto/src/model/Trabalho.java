package model;
import java.util.ArrayList;
import java.util.Date;

public class Trabalho extends Avaliacoes {
    private ArrayList<String> grupoTrabalho;
    private String metodoEnvio;

    public Trabalho(String nome, Date data, Materia materia) {
        super(nome, data, materia);
        grupoTrabalho = new ArrayList<String>();
    }

    //Getters e Setters
    public ArrayList<String> getGrupoTrabalho() {
        return grupoTrabalho;
    }

    public String getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(String metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }
    
    //Funções
    public boolean addPessoaGrupo (String nome) {
        if (Validacao.validaNome(nome)) {
            grupoTrabalho.add(nome);
            return true;
        }
        return false;
    }

    public boolean removerPessoaGrupo (String nome) {
        for (String currNome : grupoTrabalho) {
            if (currNome.equals(nome)) {
                grupoTrabalho.remove(nome);
                return true;
            }
        }
        return false; //nome não encontrado
    }
}
