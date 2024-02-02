# [Solución] Ejercicio Aplicación de Notas Simples

## Modelo: NotaModelo

~~~java
public class NotaModelo {
    private String nota;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
~~~

## Vista: NotaVista

~~~java
import javax.swing.*;

public class NotaVista {
    private JFrame frame;
    private JTextArea textArea;
    private JButton saveButton, clearButton;

    public NotaVista() {
        frame = new JFrame("Aplicación de Notas");
        textArea = new JTextArea(10, 30); // 10 filas y 30 columnas
        saveButton = new JButton("Guardar");
        clearButton = new JButton("Limpiar");

        JPanel panel = new JPanel();
        panel.add(textArea);
        panel.add(saveButton);
        panel.add(clearButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public String getTextoNota() {
        return textArea.getText();
    }

    public void setTextoNota(String texto) {
        textArea.setText(texto);
    }

    public void limpiarTextoNota() {
        textArea.setText("");
    }

    public void addGuardarListener(ActionListener listenForSaveButton) {
        saveButton.addActionListener(listenForSaveButton);
    }

    public void addLimpiarListener(ActionListener listenForClearButton) {
        clearButton.addActionListener(listenForClearButton);
    }
}
~~~

## Controlador: NotaControlador

~~~java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotaControlador {
    private NotaModelo modelo;
    private NotaVista vista;

    public NotaControlador(NotaModelo modelo, NotaVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.addGuardarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setNota(vista.getTextoNota());
            }
        });

        this.vista.addLimpiarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.limpiarTextoNota();
            }
        });
    }
}
~~~

## Clase Principal: Aplicación

~~~java
public class Aplicacion {
    public static void main(String[] args) {
        NotaModelo modelo = new NotaModelo();
        NotaVista vista = new NotaVista();
        NotaControlador controlador = new NotaControlador(modelo, vista);
    }
}
~~~
