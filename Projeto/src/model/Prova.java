package model;
import java.util.Date;

public class Prova extends Avaliacoes {
    private String extraInfo;

    public Prova(String nome, Date data, Materia materia, String extraInfo) {
        super(nome, data, materia);
        this.extraInfo = extraInfo;
    }

    //Getters e Setters
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    
}
