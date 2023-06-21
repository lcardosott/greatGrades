package view.baseClasses;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

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

    public static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        return new ImageIcon(resizedImage);
    }
}
