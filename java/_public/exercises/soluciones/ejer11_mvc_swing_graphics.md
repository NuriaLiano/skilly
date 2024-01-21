# [Solución] Ejercicio: Aplicación de Control de Color de un Rectángulo

## Clase vista: RectanguloColorVista

~~~java
import javax.swing.*;
import java.awt.*;

public class RectanguloColorVista extends JFrame {
    private RectanguloColorModelo modelo;
    private JSlider sliderRojo, sliderVerde, sliderAzul;
    private JTextField textoRojo, textoVerde, textoAzul;
    private JPanel rectanguloPanel;

    public RectanguloColorVista(RectanguloColorModelo modelo) {
        this.modelo = modelo;
        setTitle("Control de Color de Rectángulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlesPanel = new JPanel(new GridLayout(3, 3));
        sliderRojo = new JSlider(0, 255, 0);
        sliderVerde = new JSlider(0, 255, 0);
        sliderAzul = new JSlider(0, 255, 0);
        textoRojo = new JTextField(3);
        textoVerde = new JTextField(3);
        textoAzul = new JTextField(3);

        controlesPanel.add(new JLabel("Rojo:"));
        controlesPanel.add(sliderRojo);
        controlesPanel.add(textoRojo);
        controlesPanel.add(new JLabel("Verde:"));
        controlesPanel.add(sliderVerde);
        controlesPanel.add(textoVerde);
        controlesPanel.add(new JLabel("Azul:"));
        controlesPanel.add(sliderAzul);
        controlesPanel.add(textoAzul);

        rectanguloPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(model.getColor());
                g.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
            }
        };

        add(controlesPanel, BorderLayout.NORTH);
        add(rectanguloPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters para sliders y text fields
    public JSlider getsliderRojo() { return sliderRojo; }
    public JSlider getsliderVerde() { return sliderVerde; }
    public JSlider getsliderAzul() { return sliderAzul; }
    public JTextField gettextoRojo() { return textoRojo; }
    public JTextField gettextoVerde() { return textoVerde; }
    public JTextField gettextoAzul() { return textoAzul; }
    public JPanel getrectanguloPanel() { return rectanguloPanel; }
}
~~~

## Clase controlador: RectanguloColorControlador

~~~java
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanguloColorControlador {
    private RectanguloColorModelo model;
    private RectanguloColorVista vista;

    public RectanguloColorControlador(RectanguloColorModelo model, RectanguloColorVista vista) {
        this.model = model;
        this.vista = vista;

        // Controladores para los sliders
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                model.setRojo(vista.getSliderRed().getValue());
                model.setVerde(vista.getSliderGreen().getValue());
                model.setAzul(vista.getSliderBlue().getValue());
                vista.gettextoRojo().setText(String.valueOf(model.getRojo()));
                vista.getTextoVerde().setText(String.valueOf(model.getVerde()));
                vista.getTextoAzul().setText(String.valueOf(model.getAzul()));
                vista.getrectanguloPanel().repaint();
            }
        };

        vista.getsliderRojo().addChangeListener(changeListener);
        vista.getsliderVerde().addChangeListener(changeListener);
        vista.getsliderAzul().addChangeListener(changeListener);
    }
}
~~~