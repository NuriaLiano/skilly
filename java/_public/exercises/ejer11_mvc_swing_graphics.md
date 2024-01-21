# Ejercicio: Aplicación de Control de Color de un Rectángulo

## Objetivo

Desarrollar una aplicación de escritorio en Java utilizando Swing que permita a los usuarios ajustar el color de fondo de un rectángulo dibujado en un panel. El color se controlará mediante tres JSliders, correspondientes a las componentes roja, verde y azul (RGB) del color.

## Descripción de la Aplicación

### 1. Control del Color del Rectángulo

- Utilizar tres JSliders que permitan seleccionar las componentes roja, verde y azul (RGB) del color del rectángulo. Cada JSlider tendrá un rango de 0 a 255.
- Mostrar el valor actual de cada componente RGB en JTextFields adyacentes a los JSliders.
- El rectángulo se dibujará en un JPanel, y su color de fondo cambiará en tiempo real según los valores seleccionados en los JSliders.

### 2. Modelo de Datos (RectangleColorModel)

- Crear una clase modelo RectangleColorModel que almacene el color actual del rectángulo en términos de sus componentes RGB
- El modelo debe tener métodos para obtener y establecer las componentes de color.

## Tareas

1. Implementar la Vista (RectangleColorView)
   1. Diseñar e implementar la clase RectangleColorView.
   2. La vista debe incluir tres JSliders para ajustar las componentes RGB y tres JTextFields para mostrar los valores numéricos de estas componentes.
   3. La vista también debe incluir un JPanel donde se dibuja el rectángulo con el color de fondo actual.
   4. Incluir métodos necesarios para que la clase sea funcional, como getters, setters y un método para redibujar el rectángulo.

2. Implementar el Controlador (RectangleColorController)
   1. Diseñar e implementar la clase RectangleColorController.
   2. El controlador debe manejar los eventos de los JSliders y actualizar el modelo y los JTextFields correspondientes cuando se ajusta un JSlider.
   3. El controlador también debe actualizar el JPanel para redibujar el rectángulo con el nuevo color.

## Clase Modelo: RectanguloColorModelo

~~~java
import java.awt.Color;

public class RectanguloColorModelo {
    private int rojo, verde, azul;

    public RectanguloColorModelo() {
        rojo = verde = azul = 0; // Valores iniciales
    }

    // Getters y setters para rojo, verde, azul
    public void setColor(int rojo, int verde, int azul) {
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }
}
~~~

## Clase Principal: RectanguloColorApp

~~~java
public class RectangleColorApp {
    public static void main(String[] args) {
        RectanguloColorModelo modelo = new RectanguloColorModelo();
        RectanguloColorVista vista = new RectanguloColorVista(modelo);
        RectanguloColorControlador controlador = new RectanguloColorControlador(modelo, vista);
    }
}
~~~

## Resultado final

![imagen final del ejercicio](https://gitlab.com/Nuria_Liano/skilly/-/raw/899f93f020116a8ea182c5a9bea613fa8638a3da/img/imagenfinal.png)
