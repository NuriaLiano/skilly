# Modificadores en Java

Los modificadores son palabras clave que se utilizan para controlar el acceso y la visibilidad de clases, métodos, atributos y otros elementos dentro de un programa. Los modificadores permiten establecer reglas y restricciones sobre cómo se pueden acceder y utilizar estos elementos. Hay varios tipos de modificadores en Java, que se pueden aplicar a diferentes elementos del código.

| Modificador                   | Descripción y Uso                                                   |
| ----------------------------- | ------------------------------------------------------------------- |
| `public`                      | Accesible desde cualquier parte del programa.                      |
| `protected`                   | Accesible en su clase, en clases del mismo paquete y subclases.     |
| (sin modificador) `default`   | Accesible solo en su clase y clases del mismo paquete.             |
| `private`                     | Accesible solo en su propia clase.                                  |
| `final`                       | Clase no extensible, método no anulable, atributo constante.        |
| `abstract`                    | Clase abstracta, método sin implementación (debe ser implementado por subclases). |
| `static`                      | Método o atributo pertenece a la clase en lugar de instancias.     |
| `synchronized`                | Controla la concurrencia de acceso a un método.                   |
| `native`                      | Método implementado en código nativo (fuera de Java).            |
| `transient`                   | Atributo no se serializa al guardar el estado del objeto.         |
| `volatile`                    | Atributo accesible de manera segura por múltiples hilos.           |
| `strictfp`                    | Cálculos de punto flotante consistentes en todas las plataformas.  |
| `interface`                   | Define un conjunto de métodos abstractos que deben ser implementados por las clases que la implementen. |
| `enum`                        | Define un tipo de dato enumerado con un conjunto fijo de constantes. |
| `package-private`             | Accesible solo dentro de su propio paquete.                         |

## Modificadores de acceso

- **public**: El elemento es accesible desde cualquier parte del programa. No hay restricciones de visibilidad.
- **protected**: El elemento es accesible dentro de su propia clase, en clases del mismo paquete y en subclases fuera del paquete.
- **default** (sin modificador): El elemento es accesible solo dentro de su propia clase y en clases del mismo paquete.
- **private**: El elemento es accesible solo dentro de su propia clase.

## Modificador `final`

- **final**: Cuando se aplica a una clase, la clase no puede ser extendida (subclases). Cuando se aplica a un método, el método no puede ser anulado en subclases. Cuando se aplica a una variable, la variable es constante y no se puede cambiar una vez que se le asigna un valor.

## Modificadores de clase

- **abstract**: Indica que una clase es abstracta y no se puede instanciar. Las clases abstractas pueden tener métodos abstractos que deben ser implementados por las subclases.
- **final**: Evita que una clase sea heredada (no puede tener subclases).

## Modificadores de Método

- **abstract**: Indica que un método no tiene implementación en la clase actual y debe ser implementado por subclases abstractas.
- **static**: El método pertenece a la clase en lugar de a las instancias de la clase. Puede ser invocado a través del nombre de la clase.
- **synchronized**: Controla la concurrencia de acceso a un método. Solo un hilo puede ejecutar el método sincronizado a la vez.
- **native**: Indica que el método está implementado en código nativo (generalmente en otro lenguaje como C/C++) y no en Java.

## Modificadores de Atributo

- **static**: El atributo pertenece a la clase en lugar de a las instancias de la clase. Es compartido por todas las instancias de la clase.
- **transient**: Indica que un atributo no debe ser serializado cuando se guarda el estado del objeto.
- **volatile**: Indica que un atributo puede ser accedido por múltiples hilos de manera segura. Evita que las optimizaciones del compilador afecten la lectura/escritura de este atributo.

## Modificador `interface`

- **interface**: Indica que una interfaz define un conjunto de métodos abstractos que deben ser implementados por las clases que la implementen.

## Modificar `enum`

- **enum**: Define un tipo de dato enumerado que consiste en un conjunto fijo de constantes predefinidas.

## Modificador `package`

- **package-private** (sin modificador): Cuando no se especifica ningún modificador de acceso, el elemento es accesible solo dentro de su propio paquete.

## Ejemplo

En este sencillo ejemplo podemos ver el uso de los modificadores

- El atributo nombre es público y, por lo tanto, se puede acceder y modificar desde la clase Principal.
- El atributo edad es privado y solo se puede acceder desde dentro de la propia clase Persona.
- El método saludar es público y se puede llamar desde la clase Principal.
- El método despedirse es privado y no se puede llamar desde la clase Principal.

~~~java
// Clase principal
public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de la clase Persona
        Persona persona = new Persona();

        // Acceso a los atributos y métodos de la clase Persona
        persona.nombre = "Alice"; // Acceso a un atributo público
        // persona.edad = 30; // Esto generaría un error ya que edad es privado

        // Llamada a métodos públicos
        persona.saludar(); // Método público

        // persona.despedirse(); // Esto generaría un error ya que despedirse es privado
    }
}

// Clase Persona
class Persona {
    // Atributo público
    public String nombre;

    // Atributo privado
    private int edad;

    // Constructor
    public Persona() {
        this.edad = 0;
    }

    // Método público
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    // Método privado
    private void despedirse() {
        System.out.println("Adiós.");
    }
}
~~~
