# [Solución] Ejercicio: Dibujo de figuras con Graphics

## Modelo: Rectangulo

~~~java
import java.awt.Color;

public class Rectangulo{
    private Color color1;
    private Color color2;

    //constructor
    public Rectangulo(){
        this.color1 = Color.BLUE;
        this.color2 = Color.GREEN;
    }

    public void setColor1(Color color1){
        this.color1 = color1;
    }
    public Color getColor1(){
        return color1;
    }
    public void setColor2(Color color2){
        this.color2 = color2;
    }
    public Color getColor2(){
        return color2;
    }
}

~~~

## Vista: RectanguloVista

~~~java
import javax.swing.*;
import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;

public class RectanguloVista extends JFrame{
    private Rectangulo modelo;

    private JRadioButton color1Rojo;
    private JRadioButton color1Azul;
    private JRadioButton color1Verde;

    private JRadioButton color2Rojo;
    private JRadioButton color2Azul;
    private JRadioButton color2Verde;

    private ButtonGroup grupoColor1;
    private ButtonGroup grupoColor2;

    private JPanel panelDibujo;

    public RectanguloVista(Rectangulo modelo){

        this.modelo = modelo;
        setTitle("Rectángulo");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //configurar los radiobutton para seleccionar los colores
        color1Azul = new JRadioButton("Azul");
        color1Rojo = new JRadioButton("Rojo");
        color1Verde = new JRadioButton("Verde");
        color2Azul = new JRadioButton("Azul");
        color2Rojo = new JRadioButton("Rojo");
        color2Verde = new JRadioButton("Verde");

        //agrupar botones 
        grupoColor1 = new ButtonGroup();
        grupoColor1.add(color1Azul);
        grupoColor1.add(color1Rojo);
        grupoColor1.add(color1Verde);
        
        grupoColor2 = new ButtonGroup();
        grupoColor2.add(color2Azul);
        grupoColor2.add(color2Rojo);
        grupoColor2.add(color2Verde);

        //panel para los controles de color1
        JPanel panelColor1 = new JPanel();
        panelColor1.setBorder(BorderFactory.createTitledBorder("Color 1"));
        panelColor1.add(color1Azul);
        panelColor1.add(color1Rojo);
        panelColor1.add(color1Verde);
        
        JPanel panelColor2 = new JPanel();
        panelColor2.setBorder(BorderFactory.createTitledBorder("Color 2"));
        panelColor2.add(color1Azul);
        panelColor2.add(color1Rojo);
        panelColor2.add(color1Verde);

        //panel para dibujar el rectangulo con el gradiente de color
        panelDibujo = new JPanel(){
             @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D rectangulo = (Graphics2D) g;

                //centrar el elemento 
                int centroX = getWidth()/2;
                int centroY = getHeight()/2;
                //dimensiones rectangulo
                int ancho = 100;
                int alto = 50;

                //dibujar el rectangulo con gradiente
                //crear gradiente
                GradientPaint gp = new GradientPaint((centroX - ancho/2),(centroY - alto /2),  modelo.getColor1(),
                                                       (centroX - ancho/2),(centroY - alto /2),  modelo.getColor2());
                //establecer color gradiente a rectangulo
                rectangulo.setPaint(gp);
                rectangulo.fillRect((centroX - ancho/2),(centroY - alto /2), ancho, alto);
            }
        };

        //añadir panles al JFrame
        add(panelColor1, BorderLayout.NORTH);
        add(panelColor2, BorderLayout.CENTER);
        add(panelDibujo, BorderLayout.SOUTH);
    }

    //Metodos para añadir los action listener a los radio buttons
    public void setColor1ActionListener(ActionListener listener){ 
        color1Azul.addActionListener(listener);
        color1Rojo.addActionListener(listener);
        color1Verde.addActionListener(listener);
    }
    public void setColor2ActionListener(ActionListener listener){
        color2Azul.addActionListener(listener);
        color2Rojo.addActionListener(listener);
        color2Verde.addActionListener(listener);
    }

    //Método para dibujar el rectángulo
    public void redibujar(){
        panelDibujo.repaint();
    }

    //getter y setter
    public JRadioButton getColor1Azul(){
        return color1Azul;
    }
    public JRadioButton getColor1Rojo(){
        return color1Rojo;
    }
    public JRadioButton getColor1Verde(){
        return color1Verde;
    }
    public JRadioButton getColor2Azul(){
        return color2Azul;
    }
    public JRadioButton getColor2Rojo(){
        return color2Rojo;
    }
    public JRadioButton getColor2Verde(){
        return color2Verde;
    }
}
~~~

## Controlador: RectanguloControlador

~~~java
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import javax.swing.Action;

public class RectanguloControlador{

    private Rectangulo modelo;
    private RectanguloVista vista;

    public RectanguloControlador(RectanguloVista vista, Rectangulo modelo){
        this.vista = vista;
        this.modelo = modelo;

        //asignar action listener a los radio buttons
        this.vista.setColor1ActionListener(new ActionListener() {
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
               //metodo que quieres realizar cuando se presione el boton.
               cambiarColor1(e);
           } 
        });

        this.vista.setColor2ActionListener(new ActionListener() {
           @Override
           public void actionPerformed(java.awt.event.ActionEvent e) {
               //metodo que quieres realizar cuando se presione el boton.
               cambiarColor2(e);
           } 
        });
    }
    private void cambiarColor1(ActionEvent e){
        if(vista.getColor1Azul().isSelected()){
            modelo.setColor1(Color.BLUE);
        }else if(vista.getColor1Rojo().isSelected()){
            modelo.setColor1(Color.RED);
        }else{
            modelo.setColor1(Color.GREEN);
        }
        vista.redibujar();

    }

    private void cambiarColor2(ActionEvent e){
        if(vista.getColor2Azul().isSelected()){
            modelo.setColor2(Color.BLUE);
        }else if(vista.getColor2Rojo().isSelected()){
            modelo.setColor2(Color.RED);
        }else{
            modelo.setColor2(Color.GREEN);
        }
        vista.redibujar();

    }
}
~~~

## Principal: Main

~~~java
public static void main(String[] args) {
        RectanguloModelo modelo = new RectanguloModelo();
        RectanguloVista vista = new RectanguloVista();
        RectanguloControlador controlador = new RectanguloControlador(modelo, vista);
        
        vista.setVisible(true);
    }
~~~
