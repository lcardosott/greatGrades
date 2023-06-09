package view.menuprincipal;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Usuario;
import view.baseClasses.Utilidades;

public class FramePrincipal extends JFrame {
    private Usuario user;
    public FramePrincipal(Usuario usuario){
        this.user = usuario;
        //Imagens
        ImageIcon logo = new ImageIcon("imagens/Logo.jpg");

        //Fonte

        PainelSuperior painelSuperior = new PainelSuperior();
        PainelInferiorEsquerdo painelInferiorEsquerdo = new PainelInferiorEsquerdo(this, usuario.getListaMaterias());
        PainelInferiorDireito painelInferiorDireito = new PainelInferiorDireito(this, usuario);

        this.setSize(Utilidades.redimensionarFrameTotal());
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Great Grades");
        this.setVisible(true);
        this.setLayout(null); //positions defined explicitly by the programmer
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(Color.GRAY);
        
        this.add(painelSuperior);
        this.add(painelInferiorEsquerdo);
        this.add(painelInferiorDireito);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Usuario getUser() {
        return this.user;
    }
}
