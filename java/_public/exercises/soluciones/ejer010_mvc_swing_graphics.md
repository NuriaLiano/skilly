# [Solución] Ejercicio: Dibujo de figuras con Graphics

## Modelo: Circulo

~~~java
import java.awt.Color;

public class Circulo{
    
    private Color color;
    private int radio, x, y;

    public Circulo(int x, int y, int radio){

        this.color = Color.BLACK;
        this.radio = radio;
        this.x = x;
        this.y = y;
    }
    public Color getColor(){
        return this.color;
    }

    public int getRadio(){
        return this.radio;
    }

    public void setColor(Color c){
        this.color = c;
    }

    public void setRadio(int r){
        this.radio = r;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

}
~~~

## Vista: Vista

~~~java
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

public class Vista extends JFrame {
    private Circulo modelo;
    private JComboBox<String> comboColor;
    private JSlider sliderRadio;
    private JPanel panelDibujo;
    private ArrayList <Circulo> listaCirculos;

    public Vista (Circulo modelo){
        this.modelo = modelo;
        this.listaCirculos = new ArrayList<Circulo>();

        //Al extender de JFrame no es necesario crear un JFrame frame = new JFrame(); 

        setTitle("Dibujar de circulos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //crear y configurar JComboBox y JSlider

        //para añadir los colores a un JComboBox se puede hacer de dos formas
        //1. usando el método addItem
        //ej:comboColor.addItem("Rojo");
        //2. pasando un array de String en el constructor
        //ej: comboColor = new JComboBox<String>(new String[]{"Rojo", "Verde", "Azul"});

        comboColor = new JComboBox<String>(new String[]{"Rojo", "Verde", "Azul"});

        //Puedes establecer la posición del slider en el constructor (ej: new JSlider(JSlider.HORIZONTAL, 1, 100, 10);) o, si lo dejas por defecto, será HORIZONTAL
        sliderRadio = new JSlider( 1, 100, 10);

        //Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(comboColor);
        panelSuperior.add(sliderRadio);
        panelSuperior.setLayout(new GridLayout(2,1));
        add(panelSuperior, BorderLayout.NORTH);
        //panel de dibujo
        panelDibujo = new JPanel(){
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                  for (int i = 0; i < listaCirculos.size(); i++){
                      //establecer color
                    g.setColor(listaCirculos.get(i).getColor());                

                     //establecer forma de figura
                    g.fillOval( listaCirculos.get(i).getX(), listaCirculos.get(i).getY(), listaCirculos.get(i).getRadio()*2, listaCirculos.get(i).getRadio()*2);
                    
                //     //Otra forma hacerlo
                //     //Circulo circulo = listaCirculos.get(i);
                //     //g.setColor(circulo.getColor());
                //     //g.fillOval(circulo.getX(), circulo.getY(), circulo.getRadio()*2, circulo.getRadio()*2);
                    

                 }

            }
        };

        //establecer color de fondo
        panelDibujo.setBackground(Color.WHITE);

        //añadir un evento de escucha de ratón

        //se utiliza MouseAdapter para poder utilizar sólo el método de mouseClicked. En caso de utilizar MouseListener, tendriamos que llamar a todos los metodos.
        panelDibujo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println("hola");
                // //establecer funcionalidad cuando se hace click
                // listaCirculos.add(new Circulo(e.getX(), e.getY(), sliderRadio.getValue()));
                // //cambiar el color al que quiera el usuario
                // modelo.setColor(conversionColor(comboColor.getSelectedItem().toString()));

                // //volver a pintar la figura
                // repaint();


                Color color = conversionColor(comboColor.getSelectedItem().toString());
                int radio = sliderRadio.getValue();
                Circulo circulo = new Circulo(e.getX(), e.getY(), radio);
                circulo.setColor(color);
                listaCirculos.add(circulo);
                
                repaint();

            }
        });

        add(panelDibujo, BorderLayout.CENTER);
    }

    public JComboBox<String> getComboColor(){
        return comboColor;
    }

    public JSlider getSliderRadio(){
        return sliderRadio;
    }

    private Color conversionColor(String color){
        Color colorObjeto = Color.BLACK;
        switch (color) {
            case "Rojo":
                colorObjeto = Color.RED;
                break;
            case "Verde":
                colorObjeto = Color.GREEN;
                break;
            case "Azul":
                colorObjeto = Color.BLUE;
                break;
        }
        return colorObjeto;
    }

}
~~~

## Controlador: Controlador

~~~java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.*;

public class Controlador{
    private Circulo modelo;
    private Vista vista;



    public Controlador(Circulo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;

        //añadir los listener a los componentes
        this.vista.getComboColor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                //System.out.println("El color seleccionado es: " + vista.getComboColor().getSelectedItem());
                modelo.setColor(conversionColor(vista.getComboColor().getSelectedItem().toString()));
            }
        });
        
        this.vista.getSliderRadio().addChangeListener(new ChangeListener (){
            @Override
            public void stateChanged(ChangeEvent e){
                modelo.setRadio(vista.getSliderRadio().getValue());
            }
        });

    }

    //metodo necesario para convertir el string del combocolor en objeto Color

    private Color conversionColor(String color){
        Color colorObjeto = Color.BLACK;
        switch (color) {
            case "Rojo":
                colorObjeto = Color.RED;
                break;
            case "Verde":
                colorObjeto = Color.GREEN;
                break;
            case "Azul":
                colorObjeto = Color.BLUE;
                break;
        }
        return colorObjeto;
    }
}
~~~

## Principal: Main

~~~java
public class Main{
    public static void main(String[] args){
        int x = 10;
        int y = 10;
        int radio = 5;
        Circulo modelo = new Circulo (x, y, radio);
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador (modelo, vista);

        vista.setVisible(true);
    }
}
~~~