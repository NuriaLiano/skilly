# Ejercicio Aplicación de Notas Simples

Objetivo: Crear una aplicación de escritorio usando Java Swing que permita al usuario escribir y guardar notas breves.

Descripción del Ejercicio
La aplicación tendrá una interfaz simple que consta de un área de texto para escribir la nota y dos botones: uno para guardar la nota y otro para limpiar el área de texto.

>:wink: Siéntete libre de implementar todo lo que se te ocurra

## Componentes MVC

### Modelo (NotaModelo)

Almacena la nota actual.
Tiene métodos para establecer y obtener el texto de la nota.

### Vista (NotaVista)

Contiene un JTextArea para la entrada de texto.
Tiene dos botones: "Guardar" y "Limpiar".

### Controlador (NotaControlador)

Coordina las acciones entre la Vista y el Modelo.
Maneja los eventos de los botones.
