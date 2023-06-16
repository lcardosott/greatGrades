import java.awt.Dimension;
import java.awt.Toolkit;

public class Utilidades {
    public static Dimension redimensionarFrameTotal (){
    return (
        new Dimension (
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ()));
    }

    public static int dimensoesProporçãoLargura(double propLargura){
        return (
                (int)  Math.round(
                Toolkit.getDefaultToolkit ().getScreenSize ().getWidth () * propLargura));
        }
    
    public static int dimensoesProporçãoAltura(double propAltura){
        return (
                (int)  Math.round(
                Toolkit.getDefaultToolkit ().getScreenSize ().getHeight() * propAltura));
        }

}
