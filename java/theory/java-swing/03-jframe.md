# JFrame explicado

## ¿Qué es el JFrame ?

Es una clase fundamental en Java Swing, utilizada para crear la ventana principal de una aplicación de interfaz gráfica de usuario (GUI). Es un contenedor de nivel superior que proporciona un marco para la ventana, con características estándar que esperarías en cualquier ventana de aplicación, como la barra de título, los botones de minimizar/maximizar/cerrar, y la capacidad de cambiar de tamaño.

## Características clave

* **Contenedor de Nivel Superior**: Al ser un contenedor de nivel superior, un JFrame actúa como la base sobre la cual agregas otros componentes de Swing, como paneles (JPanel), etiquetas (JLabel), botones (JButton), etc.
* **Barra de Título y Botones de Control de Ventana**: Por defecto, un JFrame incluye una barra de título que muestra el título de la ventana y los botones estándar para cerrar, minimizar y maximizar la ventana.
* **Manejo de Eventos de Ventana**: Puedes manejar eventos de ventana, como abrir, cerrar, minimizar, o maximizar, mediante el uso de WindowListener.
* **Definir Tamaño y Posición**: Puedes especificar el tamaño y la posición de un JFrame usando métodos como setSize(int width, int height) y setLocation(int x, int y). Además, pack() ajusta el tamaño de la ventana para acomodar los tamaños de sus componentes internos.
* **Operación de Cierre**: Por defecto, un JFrame no hace nada cuando el usuario intenta cerrarlo. Debes definir el comportamiento de cierre utilizando setDefaultCloseOperation(int operation), donde las operaciones comunes incluyen EXIT\_ON\_CLOSE (cerrar la aplicación), HIDE\_ON\_CLOSE (ocultar la ventana), y DISPOSE\_ON\_CLOSE (deshacerse de la ventana pero mantener la aplicación en ejecución).
* **Personalización**: Puedes personalizar un JFrame con diferentes características, como cambiar el ícono de la ventana, establecer un menú de barra (usando JMenuBar), y modificar el estilo o el "look and feel" de la ventana.

## Métodos más utilizados y algunas curiosidades

Si quieres ver todos los métodos disponibles y que parámetros puedes utilizar te recomendamos revisar la [documentación oficial de JFrame](https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html).

Si no aquí tienes una tabla con los métodos más comunes y algunos un poco curiosos

| Método                             | Descripción                                                                                   |
| ---------------------------------- | --------------------------------------------------------------------------------------------- |
| `setVisible(boolean)`              | Muestra u oculta la ventana dependiendo del valor booleano.                                   |
| `setSize(int width, int height)`   | Establece el tamaño de la ventana.                                                            |
| `setDefaultCloseOperation(int)`    | Define la operación que se realizará cuando se cierre la ventana.                             |
| `setTitle(String)`                 | Establece el título de la ventana.                                                            |
| `getContentPane()`                 | Obtiene el contenedor de contenido principal de la ventana, donde se añaden los componentes.  |
| `pack()`                           | Ajusta el tamaño de la ventana para acomodar el tamaño preferido de todos sus subcomponentes. |
| `setLayout(LayoutManager)`         | Establece el gestor de diseño para el contenedor de contenido de la ventana.                  |
| `add(Component)`                   | Añade un componente al contenedor de contenido de la ventana.                                 |
| `setLocationRelativeTo(Component)` | Coloca la ventana relativa a otro componente (centra en pantalla si es `null`).               |
| `setResizable(boolean)`            | Establece si la ventana puede cambiar de tamaño o no.                                         |
| `setJMenuBar(JMenuBar)`            | Añade una barra de menú a la ventana.                                                         |

| Métodos Curiosos                              | Descripción                                                                                         |
| --------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `dispose()`                                   | Libera los recursos de la ventana.                                                                  |
| `setUndecorated(boolean)`                     | Elimina o añade la barra de título y los bordes de la ventana (debe hacerse antes de `setVisible`). |
| `getRootPane().setWindowDecorationStyle(int)` | Permite personalizar el estilo de los bordes y la barra de título.                                  |
| `setOpacity(float)`                           | Establece la opacidad de la ventana (valor entre 0.0 y 1.0).                                        |
| `setExtendedState(int)`                       | Permite maximizar la ventana o establecerla en estado normal.                                       |
| `getGraphicsConfiguration()`                  | Obtiene la configuración gráfica asociada con esta ventana.                                         |

## Ejemplo básico de uso

En este ejemplo vamos a crear un JFrame con un título, definimos el tamaño y lo hacemos visible. Puede servir como punto de partida para cualquier aplicación.

> :sparkles: **IMPORTANTE** Acuérdate de hacer visible el JFrame antes de ejecutar tu aplicación

```java
import javax.swing.JFrame;

public class MiVentana {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Titulo de la Ventana");

        // Configurar operación por defecto al cerrar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer tamaño de la ventana
        frame.setSize(400, 300);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
```

## Buenas prácticas

* Evitar Tamaño Fijo: En lugar de usar setSize con dimensiones fijas, considera usar pack() junto con layouts adecuados para que tu GUI sea flexible y pueda manejar diferentes tamaños de contenido y resoluciones de pantalla.
* Uso de JPanel: Generalmente, en lugar de agregar componentes directamente a un JFrame, agrega un JPanel y luego agrega otros componentes a este panel para una mejor organización y manejo del layout.
