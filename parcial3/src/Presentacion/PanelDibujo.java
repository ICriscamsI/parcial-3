package Presentacion;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {
    private String forma = "";
    private Color color = Color.WHITE;

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);

    
        if (forma.equals("cuadrado")) {
            g.fillRect(100, 100, 100, 100); //cuadrado
        } else if (forma.equals("circulo")) {
            g.fillOval(100, 100, 100, 100); //círculo
        }
    }
}
