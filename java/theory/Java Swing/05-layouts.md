# Layouts explicado

Los gestores de diseño (layout managers) en Java Swing son fundamentales para organizar los componentes de la interfaz de usuario (UI) en contenedores como JPanel. En Swing, un layout manager controla el tamaño y la posición de los componentes dentro de un contenedor. Cada contenedor tiene su propio layout manager, y puedes elegir entre varios tipos según tus necesidades.

## ¿Cómo utilizo los Layouts Managers?

Para establecer un layout manager en Swing, utilizas el método setLayout en un contenedor. Por ejemplo:

~~~java
JPanel panel = new JPanel();
panel.setLayout(new FlowLayout());
~~~

## Tipos principales de Layout Managers

### FlowLayout

- Es el gestor de diseño predeterminado para JPanel.
- Coloca los componentes en una fila, ajustándolos de izquierda a derecha y luego de arriba a abajo.
- Útil para pequeños conjuntos de componentes, como una barra de herramientas.

~~~java
import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Botón 2"));
        panel.add(new JButton("Botón 3"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de flowlayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/flowlayout.png?ref_type=heads)

### BorderLayout

- Divide el área en cinco regiones: NORTH, SOUTH, EAST, WEST y CENTER.
- Cada región puede contener solo un componente, y su tamaño se ajusta según el tamaño del contenedor.
- Comúnmente utilizado en JFrame para organizar componentes de alto nivel.

~~~java
import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.setLayout(new BorderLayout());
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de borderlayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/border.png?ref_type=heads)

### GridLayout

- Divide el contenedor en una cuadrícula rectangular, donde cada celda puede contener un componente.
- Todos los componentes tienen el mismo tamaño.
- Útil para crear diseños regulares, como calculadoras.

~~~java
import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns
        frame.add(new JButton("Botón 1"));
        frame.add(new JButton("Botón 2"));
        frame.add(new JButton("Botón 3"));
        frame.add(new JButton("Botón 4"));
        frame.add(new JButton("Botón 5"));

        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de gridlayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/grid.png?ref_type=heads)

### BoxLayout

- Coloca los componentes ya sea en una línea vertical (Y_AXIS) o una línea horizontal (X_AXIS).
- Permite que los componentes mantengan sus tamaños preferidos.
- Bueno para listas de componentes, como menús o barras de herramientas.

~~~java
import javax.swing.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Botón 2"));
        panel.add(new JButton("Botón 3"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de boxlayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/boxlayout.png?ref_type=heads)

### CardLayout

- Permite que varios componentes ocupen el mismo espacio, pero solo uno se muestra a la vez.
- Útil para implementar asistentes o diálogos con múltiples pasos.

~~~java
import javax.swing.*;
import java.awt.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new CardLayout());

        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        card1.add(new JButton("Ir a Card 2"));

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
        card2.add(new JButton("Volver a Card 1"));

        panel.add(card1, "Card1");
        panel.add(card2, "Card2");

        frame.add(panel);
        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de cardlayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/cardlayout.png?ref_type=heads)

### GridBagLayout

- Es el más flexible y complejo de los gestores de diseño estándar.
- Permite especificar el tamaño y la posición de los componentes con restricciones (GridBagConstraints).
- Ideal para crear interfaces de usuario muy personalizadas y adaptativas.

~~~java
import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JButton("Botón 1"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(new JButton("Botón 2"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JButton("Botón 3"), constraints);

        frame.add(panel);
        frame.setVisible(true);
    }
}
~~~

![ejemplo grafico de gridbaglayout](https://gitlab.com/Nuria_Liano/skilly/-/blob/master/img/gridbag.png?ref_type=heads)

### Consejos para usar Layouts Managers

1. Planificación: Antes de agregar componentes, piensa en cómo deberían organizarse y elegir el gestor de diseño adecuado.
2. Nesting: Puedes anidar paneles con diferentes gestores de diseño para crear interfaces más complejas.
3. Tamaño y Posición: En lugar de establecer tamaños y posiciones fijas para los componentes, utiliza el layout manager para gestionar el diseño de forma que se adapte a diferentes tamaños de ventana y resoluciones de pantalla.
4. Experimentación: A veces, el mejor enfoque es experimentar con diferentes layout managers para ver cuál se adapta mejor a tus necesidades.
