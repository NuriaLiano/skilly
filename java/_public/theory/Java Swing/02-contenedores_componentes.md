# Contenedores y Componentes

## Contenedores de nivel superior

Son aquellos que actuan como la base fundamental o raíz para una interfaz de usuario. A diferencia de otros componentes estos contenedores pueden existir independientemente en la pantalla y no necesitan ser anidades dentro de otro componente Swing.

En esta sección encontrás una explicación resumida sobre los contenedores y algunos componentes pero,si quieres saber más, puedes ir a la sección específica de cada uno haciendo click en cada enlace

### JApplet

Los applets son programas de Java que pueden ejecutarse en un navegador web compatible con Java.
JApplet ha caído en desuso debido a las limitaciones de seguridad y la disminución del soporte para applets en navegadores modernos.

Para ejecutar un JApplet, necesitas un entorno que soporte applets de Java, que la mayoría de los navegadores modernos ya no ofrecen.

~~~java
import javax.swing.JApplet;
import javax.swing.JLabel;

public class EjemploJApplet extends JApplet {
    public void init() {
        add(new JLabel("Hola, JApplet!"));
    }
}
~~~

> :books: **PARA SABER MÁS**
> [Ir a la sección JApplet]()

### JDialog

Funciona como una ventana de diálogo. Puede ser modal (bloquea la entrada a otras ventanas de la aplicación hasta que se cierre).
Se utiliza conmunmente para ventanas emergentes que requieren respuesta del usuario, como confirmaciones o formularios de entrada de datos.

~~~java
import javax.swing.JDialog;
import javax.swing.JLabel;

public class EjemploJDialog {
    public static void main(String[] args) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Ejemplo JDialog");
        dialog.setSize(300, 200);
        dialog.add(new JLabel("Hola, JDialog!"));
        dialog.setVisible(true);
    }
}
~~~

![imagen jdialog](https://gitlab.com/Nuria_Liano/skilly/-/raw/master/img/jdialog.png)

> :books: **PARA SABER MÁS**
> [Ir a la sección JDialog]()

### JFrame

Probablemente es el contenedor de nivel superior más utilizado en aplicaciones de escritorio Swing. Representa una ventana con border decorativos y controles para minimizar, maximizar y cerrar.
Es el punto de partida para la mayoría de las aplicaciones de escritorio Swing, donde otros componentes Swing son agregados.

~~~java
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new JLabel("Hola, JFrame!"));
        frame.setVisible(true);
    }
}
~~~

![imagen jframe](https://gitlab.com/Nuria_Liano/skilly/-/raw/master/img/jframe.png)

> :books: **PARA SABER MÁS**
> [Ir a la sección JFrame]()

### JWindow

Es similar a JFrame pero sin bordes decorativos ni controles de ventana.
Útil para ventanas emergentes y flotantes donde los controles de ventana estándar no son necesarios.

~~~java
import javax.swing.JWindow;
import javax.swing.JLabel;

public class EjemploJWindow {
    public static void main(String[] args) {
        JWindow window = new JWindow();
        window.setSize(300, 200);
        window.add(new JLabel("Hola, JWindow!"));
        window.setVisible(true);
    }
}
~~~

![imagen jwindow](https://gitlab.com/Nuria_Liano/skilly/-/raw/master/img/jwindow.png)

> :books: **PARA SABER MÁS**
> [Ir a la sección JWindow]()

## Componentes intermedios

Estos componentes actúan como contenedores secundarios dentro de un contenedor de nivel superior. Se utilizan para agrupar, organizar y administrar componentes más pequeños.

### JPanel

Contenedor genérico utilizado para agrupar otros componentes.

~~~java
import javax.swing.*;

public class EjemploJPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.add(new JButton("Un botón en un panel"));
        frame.add(panel);

        frame.setVisible(true);
    }
}
~~~

### JScrollPane

Proporciona barras de desplazamiento a componentes como listas o tablas

~~~java
import javax.swing.*;

public class EjemploJScrollPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JScrollPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
~~~

### JSplitPane

Divide dos componentes.

~~~java
import javax.swing.*;

public class EjemploJSplitPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JSplitPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                              new JButton("Botón Izquierdo"), 
                                              new JButton("Botón Derecho"));
        frame.add(splitPane);

        frame.setVisible(true);
    }
}
~~~

### JTabbedPane

Organiza los componentes en pestañas separadas.

~~~java
import javax.swing.*;

public class EjemploJTabbedPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JTabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Pestaña 1", new JLabel("Contenido de la Pestaña 1"));
        tabbedPane.addTab("Pestaña 2", new JLabel("Contenido de la Pestaña 2"));
        frame.add(tabbedPane);

        frame.setVisible(true);
    }
}
~~~

### JToolBar

Utilizado para crear barras de herramientas.

~~~java
import javax.swing.*;

public class EjemploJToolBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JToolBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JToolBar toolBar = new JToolBar("Barra de Herramientas");
        toolBar.add(new JButton("Botón 1"));
        toolBar.add(new JButton("Botón 2"));
        frame.add(toolBar, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
~~~

## Componentes atómicos

Son los elementos básicos de la interfaz de usuario y no están destinados a contener otros componentes. Estos componentes interactúan directamente con el usuario.

### JButton

Un botón que el usuario puede clickear.

~~~java
import javax.swing.*;

public class EjemploJButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Pulsa Aquí");
        frame.add(button);

        frame.setVisible(true);
    }
}
~~~

### JLabel

Muestra texto o imágenes.

~~~java
import javax.swing.*;

public class EjemploJLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label = new JLabel("Hola, soy una etiqueta");
        frame.add(label);

        frame.setVisible(true);
    }
}
~~~

### JTextField y JTextArea

Permiten la entrada de texto.

~~~java
import javax.swing.*;

public class EjemploJTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextField textField = new JTextField(20);
        frame.add(textField);

        frame.setVisible(true);
    }
}
~~~

### JCheckBox y JRadioButton

Para selecciones y opciones.

~~~java
import javax.swing.*;

public class EjemploJCheckBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JCheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JCheckBox checkBox = new JCheckBox("Acepto los términos y condiciones");
        frame.add(checkBox);

        frame.setVisible(true);
    }
}
~~~

### JComboBox y JList

Despliegan listas de elementos para seleccionar.

~~~java
import javax.swing.*;

public class EjemploJComboBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        frame.add(comboBox);

        frame.setVisible(true);
    }
}
~~~

### JTable

Muestra datos en formato de tabla.

~~~java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EjemploJTable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Columna 1", "Columna 2"}, 0);
        model.addRow(new Object[]{"Valor 1", "Valor 2"});
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table));

        frame.setVisible(true);
    }
}
~~~

### JSlider

Permite seleccionar un valor deslizando un control.

~~~java
import javax.swing.*;

public class EjemploJSlider {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo JSlider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        frame.add(slider);

        frame.setVisible(true);
    }
}
~~~