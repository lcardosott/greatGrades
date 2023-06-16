package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Usuario {
    private String usuario;
    private String nome;
    private String faculdade;
    private Date  dataNascimento;
    private int idade;
    private ArrayList<Materia> listaMaterias;
    private String senha;

    public Usuario(String usuario, String nome, String faculdade, Date dataNascimento, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.faculdade = faculdade;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        listaMaterias = new ArrayList<Materia>();
        idade = calcIdade(dataNascimento);
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
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getIdade() {
        return idade;
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

    //Funções
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

    private int calcIdade (Date dataNascimento) {
        Date now = new Date();
        long diffInMillies = Math.abs(now.getTime() - dataNascimento.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff/365;
    }
}
