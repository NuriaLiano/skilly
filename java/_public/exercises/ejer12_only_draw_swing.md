# Ejercicio: Dibujo de una clase vista

Se te proporciona el código de una interfaz de usuario creada con Java Swing. Tu tarea es dibujar, en papel, cómo crees que se verá la interfaz gráfica basándote en el código proporcionado. Considera la disposición de los componentes, sus tamaños relativos y cómo crees que se organizarán en la ventana.

~~~java
import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    public UserInterface() {
        setTitle("Dibuja la Interfaz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel superior con etiquetas
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(new JTextField(10));
        topPanel.add(new JLabel("Apellido:"));
        topPanel.add(new JTextField(10));

        // Panel central con un JTextArea
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Panel inferior con botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton("Guardar"));
        bottomPanel.add(new JButton("Cancelar"));

        // Añadir paneles al panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al JFrame
        add(mainPanel);

        setVisible(true);
    }
}
~~~
