package model;
import java.util.ArrayList;

public class Usuario {
    private String usuario;
    private String nome;
    private String faculdade;
    private ArrayList<Materia> listaMaterias;
    private String senha;
    private String curso;

    public Usuario(String usuario, String nome, String faculdade, String curso, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.faculdade = faculdade;
        this.senha = senha;
        this.curso = curso;
        listaMaterias = new ArrayList<Materia>();
    }

    //Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFaculdade() {
        return faculdade;
    }
    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso () {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean addMateria(Materia materia) {
        try{
            listaMaterias.add(materia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeMateria(Materia materia) {
        try {
            listaMaterias.remove(materia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
