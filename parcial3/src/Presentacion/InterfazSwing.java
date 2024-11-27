package Presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Parcial de Hector Florez");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(4, 2, 10, 10));
        panelIzquierdo.setPreferredSize(new Dimension(150, 0));
        JLabel labelR = new JLabel("R:");
        JTextField textR = new JTextField("0.0");
        JLabel labelG = new JLabel("G:");
        JTextField textG = new JTextField("1.0");
        JLabel labelB = new JLabel("B:");
        JTextField textB = new JTextField("1.0");

        panelIzquierdo.add(labelR);
        panelIzquierdo.add(textR);
        panelIzquierdo.add(labelG);
        panelIzquierdo.add(textG);
        panelIzquierdo.add(labelB);
        panelIzquierdo.add(textB);

        // Boton
        JButton btnCuadrado = new JButton("Cuadrado");
        JButton btnCirculo = new JButton("Circulo");
        panelIzquierdo.add(btnCuadrado);
        panelIzquierdo.add(btnCirculo);

        // Panel 
        PanelDibujo panelDibujo = new PanelDibujo();
        panelDibujo.setBackground(Color.WHITE);

        btnCuadrado.addActionListener((ActionEvent e) -> {
            try {
                float r = Float.parseFloat(textR.getText());
                float g = Float.parseFloat(textG.getText());
                float b = Float.parseFloat(textB.getText());

                if (r < 0 || r > 1 || g < 0 || g > 1 || b < 0 || b > 1) {
                    JOptionPane.showMessageDialog(frame, "valores entre 0.0 y 1.0");
                    return;
                }
                //color
                panelDibujo.setColor(new Color(r, g, b));
                panelDibujo.setForma("cuadrado");
                panelDibujo.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "ingrese valores válidos para RGB");
            }
        });

        btnCirculo.addActionListener((ActionEvent e) -> {
            try {
                float r = Float.parseFloat(textR.getText());
                float g = Float.parseFloat(textG.getText());
                float b = Float.parseFloat(textB.getText());

                if (r < 0 || r > 1 || g < 0 || g > 1 || b < 0 || b > 1) {
                    JOptionPane.showMessageDialog(frame, "Los valores RGB deben estar entre 0.0 y 1.0");
                    return;
                }

                panelDibujo.setColor(new Color(r, g, b));
                panelDibujo.setForma("circulo");
                panelDibujo.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "ingrese valores válidos para RGB");
            }
        });

        frame.add(panelIzquierdo, BorderLayout.WEST);
        frame.add(panelDibujo, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
