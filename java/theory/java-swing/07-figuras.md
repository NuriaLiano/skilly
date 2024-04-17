# Creación de figuras

## ¡¿En java swing se pueden crear figuras?!

Sí, como lo estás leyendo, en Java Swing, se pueden crear figuras y gráficos personalizados mediante la representación gráfica en un componente, como un JPanel. Aunque Swing está diseñado principalmente para crear interfaces de usuario, proporciona la capacidad de dibujar y personalizar figuras utilizando el objeto Graphics y sobrescribiendo el método paintComponent(Graphics g) del componente.

Veamos como hacerlo para poder entrar en más detalles:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploDibujoEnSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Dibujo en Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la aplicación se cerrará por completo cuando se cierre la ventana principal.
        
        // Crear un JPanel personalizado para dibujar
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Dibujar una línea roja
                g.setColor(Color.RED);
                g.drawLine(50, 50, 200, 200);
            }
        };
        
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
```

## Componentes Swing para Dibujar

Como vemos en el ejemplo de arriba, para crear figuras en Swing, generalmente se utiliza un componente JPanel. Este JPanel servirá como el lienzo en el que dibujarás las figuras. Además de JPanel también puedes añadir otros componentes como JLabel, JScrollPane, JComponent, JLayeredPane.

La elección del componente adecuado depende de tus necesidades y del tipo de gráficos que desees crear. En muchos casos, el JPanel es la opción más utilizada debido a su versatilidad y facilidad de uso. Sin embargo, los otros componentes pueden ser útiles en situaciones específicas, como la superposición de gráficos o la creación de gráficos interactivos.

```java
JFrame frame = new JFrame("Ejemplo de Dibujo en Swing");
```

## El método paintComponent()

Cuando ya tengas tu JPanel definido es necesario crear una subclase de JPanel y sobreescribir el método `paintComponent(Graphics g)`. Este método se llama automáticamente cuando el componente necesita ser repintado, y es donde dibujarás tus figuras.

```java
JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
```

## Objeto Graphics

Antes de avanzar más vamos a hacer incapié en el parámetro Graphics que se pasa a la función paintComponent(). El objeto Graphics en Java es una parte fundamental de la API de dibujo de AWT y Swing que se utiliza para realizar operaciones de dibujo en componentes gráficos, como ventanas (JFrame), paneles (JPanel), imágenes y otros elementos de la interfaz de usuario. El objeto Graphics proporciona métodos para dibujar líneas, figuras geométricas, texto y otros gráficos en el lienzo de un componente.

Cada componente gráfico, como un JPanel, tiene su propio objeto Graphics asociado que se crea automáticamente cuando el componente necesita ser repintado.

### Métodos de dibujo

Métodos de Dibujo: El objeto Graphics proporciona varios métodos que te permiten dibujar en el lienzo del componente. Algunos de los métodos de dibujo más comunes incluyen: - drawLine(int x1, int y1, int x2, int y2): Dibuja una línea desde el punto (x1, y1) hasta el punto (x2, y2) - drawRect(int x, int y, int width, int height): Dibuja un rectángulo con la esquina superior izquierda en (x, y) y el ancho y alto especificados. - drawOval(int x, int y, int width, int height): Dibuja un óvalo dentro de un rectángulo delimitador con la esquina superior izquierda en (x, y) y el ancho y alto especificados. - drawString(String str, int x, int y): Dibuja un texto en la posición (x, y). - Y muchos otros métodos para dibujar figuras geométricas, imágenes y texto.

### Personalización gráfica

Puedes personalizar el objeto Graphics utilizando métodos como setColor(Color c) para establecer el color de dibujo, setStroke(Stroke s) para definir el grosor de línea y setFont(Font font) para especificar la fuente para el texto.

```java
// Dibujar una línea roja
                g.setColor(Color.RED);
                g.drawLine(50, 50, 200, 200);
```

## Dibujar una figura básica

En este ejemplo vamos a dibujar una estrella con un degradado de color

![resultado estrella java swing](https://gitlab.com/Nuria\_Liano/skilly/-/raw/899f93f020116a8ea182c5a9bea613fa8638a3da/img/estrella\_swing.png)

```java
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class DibujarEstrellaConDegradado extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Crear un degradado de color
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), getHeight(), Color.YELLOW);
        g2d.setPaint(gradient);

        // Dibujar una estrella
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int radioExterno = 50;
        int radioInterno = 20;
        int numPuntas = 5;

        double angle = 2 * Math.PI / numPuntas;
        double rotation = Math.PI / 2;

        Path2D star = new Path2D.Double();
        star.moveTo(x + Math.cos(rotation) * radioExterno, y + Math.sin(rotation) * radioExterno);

        for (int i = 0; i < numPuntas; i++) {
            rotation += angle;
            star.lineTo(x + Math.cos(rotation) * radioInterno, y + Math.sin(rotation) * radioInterno);
            rotation += angle;
            star.lineTo(x + Math.cos(rotation) * radioExterno, y + Math.sin(rotation) * radioExterno);
        }

        star.closePath();

        g2d.fill(star);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dibujar Estrella con Degradado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DibujarEstrellaConDegradado panel = new DibujarEstrellaConDegradado();
        frame.add(panel);

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
```
