# Manejo de Eventos

## ¿Qué son los eventos?

Los eventos en programación son acciones o sucesos que ocurren en un programa de software en respuesta a diversas interacciones o condiciones. Estos eventos pueden ser desencadenados por la interacción del usuario con la interfaz de usuario, como hacer clic en un botón, mover el ratón, presionar una tecla, o por cambios en el estado del programa, como recibir datos de una red, recibir una señal de tiempo, etc.

En Java Swing, los eventos se manejan utilizando "oyentes" (listeners) que están asociados a los componentes de la interfaz de usuario. Estos oyentes están diseñados para escuchar eventos específicos y responder a ellos ejecutando cierto código o acción. Por ejemplo, un "ActionListener" puede estar asociado a un botón y se activará cuando se haga clic en ese botón, permitiendo que se realice una acción específica en respuesta al clic.

## ¿Cómo generan eventos los componentes?

A través de un proceso que involucra la interacción por parte del usuario o cambios en su estado interno.

* **Interacciones del usuario**: clic en un botón, movimiento del ratón, presión de teclas, selección en listas o casillas
* **Escucha de eventos**: Para capturar estos eventos, los componentes Swing utilizan oyentes (listeners) específicos. Cada tipo de evento tiene su propio conjunto de oyentes asociados.
* **Registro de listeners**: Al desarrollar tu aplicación debes registrar listeners en los componentes para que estén atentos a eventos específicos. Esto se hace utilizando métodos como addActionListener(), addMouseListener(), o addKeyListener(), dependiendo del tipo de evento que se quiera capturar.
* **Ejecución del código de respuesta**: Cuando ocurre un evento, el oyente asociado a ese evento se activa automáticamente. Este código puede realizar acciones específicas, como abrir una nueva ventana, realizar un cálculo o actualizar la interfaz de usuario.
* **Propagación de Eventos**: En una aplicación Swing con varios componentes, los eventos pueden propagarse a través de la jerarquía de componentes. Esto significa que si un componente genera un evento, ese evento puede ser capturado y manejado por componentes superiores en la jerarquía. Por ejemplo, un evento de clic en un botón puede ser manejado por un oyente en el panel que contiene ese botón.

## Principales componentes y sus eventos

En esta tabla puedes ver los componentes más comunes y los eventos típicamente asociados a ellos.

| Componente   | Eventos Principales                                       |
| ------------ | --------------------------------------------------------- |
| JButton      | - ActionEvent (clic en el botón)                          |
| JCheckBox    | - ItemEvent (cambio de selección)                         |
| JRadioButton | - ItemEvent (cambio de selección)                         |
| JTextField   | - ActionEvent (tecla "Enter" presionada)                  |
| JTextArea    | - KeyEvent (entrada de texto)                             |
| JList        | - ListSelectionEvent (cambio de selección)                |
| JComboBox    | - ActionEvent (selección de elemento)                     |
| JSlider      | - ChangeEvent (cambio de valor)                           |
| JProgressBar | - ChangeEvent (cambio de valor)                           |
| JTable       | - MouseEvent (clic en una celda)                          |
| JTree        | - TreeSelectionEvent (cambio de selección de nodo)        |
| JPopupMenu   | - ActionEvent (selección de elemento en el menú)          |
| JMenuItem    | - ActionEvent (selección de elemento en el menú)          |
| JMenuBar     | - ActionEvent (selección de elemento en la barra de menú) |
| JFrame       | - WindowEvent (apertura, cierre, etc., de la ventana)     |
| JPanel       | - MouseEvent (movimiento de ratón, clic, etc.)            |

## Manejo de eventos

Es un proceso fundamental que permite a los desarrolladores responder a las interacciones del usuario con la interfaz de usuario de manera dinámica. Vamos a ver como se manejan los eventos paso a paso

1. **Registro de Oyentes (Listeners)**: se utilizan oyentes (listeners) específicos que están diseñados para escuchar eventos particulares. Esto se hace utilizando métodos como addActionListener(), addMouseListener(), addKeyListener(), etc.,

```java
JButton miBoton = new JButton("Clic Me");

// Registrar un ActionListener para el botón
miBoton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código a ejecutar cuando se haga clic en el botón
        System.out.println("¡Botón clicado!");
    }
});
```

2. **Implementación de Interfaces de Oyentes**: Los oyentes son interfaces en Java. Para manejar eventos, debes implementar la interfaz correspondiente al tipo de evento que deseas capturar. Este método contiene el código que se ejecutará en respuesta al evento.

```java
// Implementar la interfaz ActionListener
public class MiListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código a ejecutar cuando se active el evento
        System.out.println("Evento ActionListener activado");
    }
}

// Registrar un ActionListener con una instancia de MiListener
JButton miBoton = new JButton("Clic Me");
miBoton.addActionListener(new MiListener());
```

3. **Captura de Eventos**: Cuando ocurre un evento en un componente Swing, el oyente registrado para ese evento se activa automáticamente.

```java
JButton miBoton = new JButton("Clic Me");

miBoton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código a ejecutar en respuesta al evento
        System.out.println("¡Botón clicado!");
    }
});
```

4. **Identificación del Origen del Evento**: En el método que maneja el evento, puedes identificar el componente que generó el evento utilizando la palabra clave getSource(). Esto te permite tomar decisiones basadas en el origen del evento.

```java
JButton boton1 = new JButton("Botón 1");
JButton boton2 = new JButton("Botón 2");

ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Identificar el botón que generó el evento
        JButton botonOrigen = (JButton) e.getSource();
        System.out.println("Clic en " + botonOrigen.getText());
    }
};

boton1.addActionListener(listener);
boton2.addActionListener(listener);
```

5. **Manejo de Eventos Múltiples**: Puedes registrar varios oyentes en un componente para manejar diferentes tipos de eventos. Esto te permite realizar múltiples acciones en respuesta a diferentes eventos en el mismo componente.

```java
JButton miBoton = new JButton("Clic Me");

// Registrar múltiples oyentes para diferentes eventos
miBoton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código para clic en el botón
    }
});

miBoton.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Código para evento de clic de ratón
    }
});
```

6. **Detención de la Propagación de Eventos**: En algunos casos, puedes detener la propagación de un evento para evitar que se propague a otros componentes. Esto se hace utilizando métodos como consume() o stopPropagation(). Esto es útil cuando deseas manejar un evento en un componente sin que otros oyentes lo intercepten.

```java
JButton miBoton = new JButton("Clic Me");

miBoton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Detener la propagación del evento
        e.consume();
    }
});
```

## Clases de eventos

En esta tabla puedes ver los eventos más comunes con una descripción y sus métodos asociados más utilizados.

| Clase de Evento  | Descripción                                               | Métodos Principales                             |
| ---------------- | --------------------------------------------------------- | ----------------------------------------------- |
| `ActionEvent`    | Evento de acción generado por componentes Swing.          | `getActionCommand()`, `getModifiers()`          |
| `ActionListener` | Interfaz para manejar eventos de acción.                  | `actionPerformed(ActionEvent e)`                |
| `MouseEvent`     | Evento de ratón generado por componentes Swing.           | `getX()`, `getY()`, `getButton()`               |
| `MouseListener`  | Interfaz para manejar eventos de ratón.                   | `mouseClicked`, `mousePressed`, `mouseReleased` |
| `KeyEvent`       | Evento de teclado generado por componentes Swing.         | `getKeyChar()`, `getKeyCode()`                  |
| `KeyListener`    | Interfaz para manejar eventos de teclado.                 | `keyPressed`, `keyReleased`, `keyTyped`         |
| `WindowEvent`    | Evento de ventana, como abrir o cerrar una ventana Swing. | `getWindow()`, `getEventType()`                 |
| `WindowListener` | Interfaz para manejar eventos de ventana.                 | `windowOpened`, `windowClosing`, `windowClosed` |

## Flujo de eventos ¿Cómo se propaga un evento a través de la jerarquía de componentes?

El flujo de eventos en Java Swing se refiere a cómo un evento generado por un componente se propaga a través de la jerarquía de componentes en una aplicación Swing. Entender el flujo de eventos es muy importante para el manejo adecuado de eventos en una interfaz de usuario. Vamos a verlo paso a paso:

1. **Generación del Evento:** Todo comienza cuando un usuario realiza una acción que genera un evento en un componente Swing, como hacer clic en un botón, mover el ratón o presionar una tecla. El componente que genera el evento crea una instancia del objeto de evento correspondiente (por ejemplo, ActionEvent, MouseEvent o KeyEvent) para representar ese evento específico.
2. **Búsqueda del Listener Apropiado:** Una vez que se genera el evento, el componente verifica si tiene oyentes (listeners) registrados para ese tipo de evento en particular. Si tiene oyentes registrados, se pasa al siguiente paso. Si el componente no tiene oyentes registrados para ese evento, el evento se descarta y no se propaga más.
3. **Ejecución del Listener en el Componente Actual:** El componente actual, que generó el evento, ejecuta el método del oyente (listener) asociado al tipo de evento. Por ejemplo, un botón que generó un ActionEvent ejecutará el método actionPerformed() de su ActionListener.
4. **Propagación del Evento a Componentes Padres:** Después de ejecutar el listener en el componente actual, el evento se propaga hacia arriba en la jerarquía de componentes. El evento se envía al componente padre inmediato del componente actual, y este proceso continúa hasta llegar al componente superior en la jerarquía, que generalmente es la ventana principal (por ejemplo, JFrame). En cada nivel de la jerarquía, se verifica si hay oyentes registrados para el evento en ese componente. Si se encuentran oyentes, se ejecuta el método del oyente en ese componente.
5. **Detención de la Propagación (Opcional):** En algunos casos, un oyente puede detener la propagación del evento para evitar que se siga propagando hacia arriba en la jerarquía. Esto se puede hacer utilizando métodos como consume() o stopPropagation(). Si un oyente detiene la propagación del evento, los componentes superiores no recibirán ni responderán a ese evento.
6. Finalización de la Propagación:\*\* Un\*\*a vez que el evento ha sido propagado a través de la jerarquía de componentes y todos los oyentes han tenido la oportunidad de manejarlo, se considera que la propagación del evento ha terminado.

## Ejemplo

Con todo lo que has aprendido hasta aquí ya eres capaz de hacer tus aplicaciones con eventos pero antes de lanzarnos a hacer ejercicios vamos a ver un ejemplo completo.

En este ejemplo, se creará una ventana con un botón y un cuadro de texto. Cuando se haga clic en el botón, se mostrará un mensaje en el cuadro de texto.

1. Creamos una ventana JFrame.
2. Agregamos un botón JButton y un cuadro de texto JTextField a la ventana.
3. Registramos un ActionListener en el botón para manejar eventos de clic.
4. Cuando se hace clic en el botón, el ActionListener cambia el texto del cuadro de texto para indicar que se hizo clic en el botón.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploFlujoEventos {
    public static void main(String[] args) {
        // Crear una ventana JFrame
        JFrame frame = new JFrame("Ejemplo de Flujo de Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Crear un botón
        JButton button = new JButton("Clic Me");

        // Crear un cuadro de texto
        JTextField textField = new JTextField(20);

        // Agregar el botón y el cuadro de texto a la ventana
        frame.add(button);
        frame.add(textField);

        // Registrar un ActionListener para el botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código a ejecutar cuando se haga clic en el botón
                textField.setText("¡Botón clicado!");
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
```
