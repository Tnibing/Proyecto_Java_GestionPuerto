package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

/**
 *
 * @author Fran <6W>
 * 
 */

// Esta clase es para crear un borde redondo

public class BordeRedondo implements Border {

    private int radioBorde;

    public BordeRedondo(int radio) {
        this.radioBorde = radio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int ancho, int alto) {
        g.setColor(c.getBackground());
        g.fillRoundRect(x, y, ancho, alto, radioBorde, radioBorde);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radioBorde, radioBorde, radioBorde, radioBorde);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}