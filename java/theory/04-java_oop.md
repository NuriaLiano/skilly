# Programación orientada a objetos (OOP)

Es un paradigma de programación que se centra en la creación de clases y objetos para modelar y resolver problemas

## Conceptos clave

1. **Objeto**: Un objeto es una instancia concreta de una clase. Representa un ente que puede tener atributos (datos) y comportamientos (métodos). Por ejemplo, un objeto podría ser una instancia de la clase "Coche" con atributos como color y modelo, y métodos como acelerar y frenar.
2. **Clase**: Una clase es una plantilla o plano que define la estructura y el comportamiento de los objetos. Las clases son como moldes para crear objetos. Por ejemplo, una clase "Coche" podría definir cómo se crean y se comportan los objetos tipo coche.
3. **Atributos**: Los atributos son variables que almacenan datos en un objeto. Cada objeto tiene su propio conjunto de valores de atributos. En el ejemplo del coche, los atributos podrían ser "color" y "modelo".
4. **Métodos**: Los métodos son funciones que definen el comportamiento de un objeto. Los objetos pueden invocar métodos para realizar acciones o calcular valores. En el ejemplo del coche, los métodos podrían ser "acelerar" y "frenar".
5. **Encapsulación**: La encapsulación es el principio de ocultar los detalles internos de una clase y proporcionar una interfaz pública para interactuar con los objetos. Esto promueve la seguridad y el mantenimiento del código.

## Beneficios

1. **Reutilización de Código**: La POO permite reutilizar código a través de la creación de clases y la creación de objetos a partir de esas clases. Esto reduce la duplicación de código y facilita el mantenimiento.
2. **Abstracción**: Permite modelar conceptos del mundo real en un software de manera más natural y abstracta. Los objetos y clases reflejan objetos y conceptos reales.
3. **Modularidad**: El código se divide en objetos y clases, lo que facilita la organización y comprensión del software. Los cambios en una clase tienen un impacto limitado en el resto del programa.
4. **Herencia**: La POO permite crear nuevas clases basadas en clases existentes, heredando sus atributos y métodos. Esto promueve la reutilización y la extensión del código.
5. **Polimorfismo**: Permite que los objetos de diferentes clases se comporten de manera similar al definir métodos con el mismo nombre en clases diferentes. Facilita la gestión de objetos de manera genérica.

## Clases y ficheros

En esta sección vamos a responder a la típica pregunta: **Las clases ¿van en el mismo fichero que el main o en un fichero a parte?**

Bien, antes de dar una respuesta vamos a ponernos en contexto

### Fichero main

Generalmente se refiere al punto de entrada de un programa en Java, es decir el fichero que contiene `public static void main(String[] args)` que indica el comienzo de un programa en Java.

Desgranemos el contenido del método main:

1. `public`: El método main debe ser público para que pueda ser accesible desde fuera de la clase.
2. `static`: El método main se declara como estático para que pueda ser invocado sin crear una instancia de la clase que lo contiene.
3. `void`: El método main no devuelve un valor.
4. `String[] args`: El método main acepta un parámetro de matriz de cadenas (args), que permite pasar argumentos desde la línea de comandos al programa.

> :pencil: **NOTA** Normalmente, el nombre de la clase que contiene el método main puede ser diferente del nombre del archivo fuente. Sin embargo, es importante que el archivo que contiene la clase tenga el mismo nombre que la clase que contiene el método main.

Ahora que tenemos los conceptos de qué es el método main y las clases ya podemos responder y es que depende de tu programa. Si nos basamos en buenas prácticas lo normal es que las clases estén en ficheros separados y los llames desde el fichero main. Pero, sólo en caso de prácticas, podemos definir la clase encima del método main y mantenerlo todo dentro del mismo fichero

> :heavy\_exclamation\_mark: **NO RECOMENDADO** desaconsejamos esta practica y optamos por código limpio y ordenado.

### Llamar a la clase desde el main

1.  Si el archivo que contiene la clase que deseas utilizar se encuentra en el mismo paquete que el archivo donde planeas utilizarla, simplemente debes crear una instancia de la clase y un objeto de esa instancia.

    ```java
     public class Main {
         public static void main(String[] args) {
             // Crear una instancia de la clase MiClase
             MiClase miObjeto = new MiClase();

             // Llamar a métodos o acceder a atributos de miObjeto
             miObjeto.algunMetodo();
             int valor = miObjeto.algunAtributo;
         }
     }
    ```
2.  En cambio, si la clase procede de otro paquete, es necesario importar ese paquete.

    ```java
    // Sintaxis básica de import
     import paquete.NombreDeClase;

     public class Main {
         public static void main(String[] args) {
             // Uso de la clase importada
             NombreDeClase objeto = new NombreDeClase();
             objeto.metodo();
         }
     }
    ```

## Ejemplo

Este es el típico ejemplo que se enseña en Java pero muestra los conceptos esenciales de la creación de clases, objetos, métodos y atributos en la Programación Orientada a Objetos en Java.

* Crear clase: Creamos la clase Persona usando la palabra clave class.
* Crear objetos: Creamos dos objetos de la clase Persona llamados persona1 y persona2 utilizando el constructor de la clase.
* Usar clase: Usamos la clase Persona como una plantilla para crear objetos con atributos y métodos.
* Usar objeto: Usamos objetos de la clase Persona (persona1 y persona2) para acceder a sus atributos y métodos.
* Crear métodos: Definimos métodos en la clase Persona como obtenerNombre(), obtenerEdad(), y mostrarInformacion().
* Usar métodos de un objeto: Invocamos los métodos de los objetos persona1 y persona2 para obtener información sobre ellos y mostrarla en la consola.
* Atributos: La clase Persona tiene dos atributos: nombre y edad.
* Constructor: La clase Persona tiene un constructor que se utiliza para inicializar los atributos cuando se crea un objeto de la clase.

```java

// Crear una clase llamada Persona
public class Persona {
    // Atributos de la clase
    private String nombre;
    private int edad;

    // Constructor de la clase Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para obtener el nombre de la persona
    public String obtenerNombre() {
        return nombre;
    }

    // Método para obtener la edad de la persona
    public int obtenerEdad() {
        return edad;
    }

    // Método para mostrar información de la persona
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear objetos de la clase Persona
        Persona persona1 = new Persona("Alice", 30);
        Persona persona2 = new Persona("Bob", 25);

        // Usar la clase para crear objetos
        System.out.println("Creación de objetos de la clase Persona:");

        // Usar objetos de la clase Persona
        System.out.println("\nUsando objetos de la clase Persona:");

        System.out.println("Nombre de persona1: " + persona1.obtenerNombre());
        System.out.println("Edad de persona1: " + persona1.obtenerEdad());

        System.out.println("Nombre de persona2: " + persona2.obtenerNombre());
        System.out.println("Edad de persona2: " + persona2.obtenerEdad());

        // Usar métodos de un objeto
        System.out.println("\nUsar métodos de un objeto:");

        persona1.mostrarInformacion();
        persona2.mostrarInformacion();
    }
}

```
