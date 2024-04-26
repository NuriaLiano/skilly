# Java Swing

Java Swing es un marco de trabajo (framework) para el desarrollo de interfaces gráficas de usuario (GUI) en Java. Forma parte del Java Foundation Classes (JFC), que es un conjunto de APIs para proporcionar una interfaz gráfica para programas Java.

## Características clave

* **Rico Conjunto de Componentes**: Swing ofrece una amplia gama de componentes GUI, como botones, etiquetas, cuadros de texto, tablas, listas desplegables, menús y varios tipos de paneles.
* **Plataforma Independiente**: Al igual que Java, Swing es independiente de la plataforma, lo que significa que las interfaces creadas en Swing pueden ejecutarse en cualquier sistema operativo que soporte Java sin necesidad de modificar el código.
* **Personalizable y Extensible**: Los componentes de Swing pueden ser personalizados y extendidos según las necesidades específicas de una aplicación. Esto incluye cambiar el aspecto y comportamiento de los componentes GUI.
* **Modelo de Eventos Robusto**: Swing utiliza un modelo de eventos sofisticado para manejar la interacción del usuario con los componentes GUI, permitiendo a los desarrolladores controlar la lógica de la aplicación en respuesta a diversas acciones del usuario.
* **Look and Feel**: Swing permite a los desarrolladores cambiar el "look and feel" de las aplicaciones GUI, pudiendo incluso emular la apariencia de diferentes plataformas o usar un estilo personalizado.
* **Arquitectura MVC**: Muchos componentes de Swing siguen el patrón Modelo-Vista-Controlador (MVC), separando los datos (Modelo) de la representación visual (Vista) y la lógica de control (Controlador).

## Componente vs Contenedor

Empezaremos por definir que es cada uno

* **Contenedor**: componente de Swing que puede contener otros componentes, incluyendo otros contenedores. Su principal función es organizar, contener y gestionar un grupo de componentes. Los contenedores son la base para construir la interfaz de usuario en una aplicación Swing, ya que definen cómo se agrupan y se muestran los componentes en la GUI. Ejemplos de contenedores: - JFrame: Es el contenedor de nivel superior que representa la ventana de una aplicación. - JPanel: Un contenedor genérico que se usa para agrupar otros componentes. - JScrollPane: Un contenedor que agrega barras de desplazamiento a otro componente.
* **Componente**: objeto en Swing que tiene una representación visual, es decir, algo que se puede ver y con lo que se puede interactuar en la GUI. Los componentes son elementos como botones, etiquetas, campos de texto, etc., y son los elementos con los que el usuario interactúa directamente. Ejemplos de componentes: - JButton: Un botón que el usuario puede presionar. - JLabel: Una etiqueta para mostrar texto o imágenes. - JTextField: Un campo para la entrada de texto por parte del usuario.

Entonces... **¿Qué relación tienen?** Todos los contenedores son componentes, pero no todos los componentes son contenedores. Esto significa que, en Swing, un contenedor es un tipo especializado de componente que puede contener otros componentes, incluyendo otros contenedores.

## Componentes comunes

* JFrame: El contenedor principal utilizado para la ventana de una aplicación.
* JPanel: Un contenedor genérico usado para agrupar otros componentes.
* JButton, JLabel, JTextField, JTextArea: Componentes básicos para entradas de usuario, etiquetas y botones.
* JComboBox, JList: Para presentar una lista de opciones a los usuarios.
* JTable: Para mostrar datos en formato de tabla.
* JMenu, JMenuBar, JMenuItem: Para crear menús en la aplicación.

## ¿Cómo uso los componentes?

Usar componentes implica varios pasos: crear el componente, configurarlo a lo que necesites y agregarlos a contenedores. Vamos a ver paso a paso detalladamente

### Crear componente

Lo priimero que tenemos que hacer es crear instancias de los componentes que necesites. Ten en cuenta que los componentes son objetos, como cualquiera de los que has visto antes, asi que la forma de crearlos es igual que cualquier otro objeto.

```java
JButton boton = new JButton("Click Me");
JLabel etiqueta = new JLabel("Introduce tu nombre:");
JTextField campoTexto = new JTextField(20); // 20 es el ancho del campo de texto
JCheckBox checkBox = new JCheckBox("Acepto los términos y condiciones.");
```

### Configurar componente

Una vez ya está creado puedes empezar a configurarlo. Por ejemplo, puedes editar las dimensiones, colores, tipografías, escuchas de eventos, etc.

```java
boton.addActionListener(e -> System.out.println("Botón presionado!"));
campoTexto.setToolTipText("Escribe tu nombre aquí.");
checkBox.setSelected(true);
```

En este ejemplo puedes ver la forma de añadir a un botón la acción de reaccionar a los clics.

### Agregar componetes a contenedores

Ahora que ya tienes el componente a punto para ser utilizado debes agregarlo a un contenedor. El contenedor más común es JPanel, que luego puedes agregar a un JFrame, el contenedor de nivel superior para una aplicación de escritorio

```java
JPanel panel = new JPanel();
panel.add(etiqueta);
panel.add(campoTexto);
panel.add(boton);
panel.add(checkBox);

JFrame ventana = new JFrame("Mi Aplicación Swing");
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ventana.getContentPane().add(panel);
```

### Mostar la ventana

Para terminar, debes configurar el tamaño de tu JFrame y hacerlo visible.

```java
ventana.pack(); // Ajusta el tamaño de la ventana según sus componentes
ventana.setVisible(true);
```

## Ejemplo completo

En esta sección sumo todos los trozos de código vistos previamente para que lo puedas apreciar todo junto en un único fichero.

```java
import javax.swing.*;

public class MiAplicacionSwing {

    public static void main(String[] args) {
        // Crear componentes
        JButton boton = new JButton("Click Me");
        JLabel etiqueta = new JLabel("Introduce tu nombre:");
        JTextField campoTexto = new JTextField(20); // 20 es el ancho del campo de texto
        JCheckBox checkBox = new JCheckBox("Acepto los términos y condiciones.");

        // Configurar componentes
        boton.addActionListener(e -> System.out.println("Botón presionado!"));
        campoTexto.setToolTipText("Escribe tu nombre aquí.");

        // Agregar componentes a un panel
        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.add(campoTexto);
        panel.add(boton);
        panel.add(checkBox);

        // Configurar el marco principal (JFrame)
        JFrame ventana = new JFrame("Mi Aplicación Swing");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(panel);
        ventana.pack(); // Ajusta el tamaño de la ventana según sus componentes
        ventana.setVisible(true);
    }
}
```

## Estructurar y organizar un proyecto en Java Swing

Antes de terminar esta sección vamos a ver como organizar tu proyecto en Swing.

> :back: **PARA ENTRAR EN CONTEXTO** Recomendamos echar un vistazo a MVC en la [sección previa](../08-MVC.md).

Estructurar un proyecto en Java Swing de manera eficiente es crucial para mantener el código organizado, facilitar la mantenibilidad y mejorar la colaboración en equipos. A continuación, te describo una estructura de proyecto recomendada:

```sh
MiAplicacionSwing/
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── miempresa/
    │   │           └── miaplicacion/
    │   │               ├── model/
    │   │               ├── view/
    │   │               ├── controller/
    │   │               ├── util/
    │   │               └── main/
    │   └── resources/
    └── test/
        └── java/
```

> :white\_check\_mark: **RECOMENDADO** Es importante organizar las clases de acuerdo a su función siguiendo el patrón [MVC](../08-MVC.md) y otros roles.

Ahora ya puedes empezar a practicar swing con el [primer ejercicio](../../exercises/ejer6\_mvc\_swing.md)
