# Primeros pasos en Java

## Hola Skilly

```java
public class HolaMundo {
    public static void main(String[] args) {
        // Esto es un comentario. El programa comienza ejecutando el método 'main'.
        
        // La siguiente línea imprime "Hola Skilly" en la consola.
        System.out.println("Hola Skilly");
    }
}
```

![java sintaxis](../img/java-sintaxis.png)

* `public class HolaMundo`: Esta línea define una clase llamada "HolaMundo". En Java, cada programa comienza con al menos una clase. El nombre de la clase debe coincidir con el nombre del archivo Java que contiene el código fuente.
* `{`: Esto marca el comienzo del cuerpo de la clase.
* `public static void main(String[] args) {`: Aquí definimos un método llamado "main". El método "main" es el punto de entrada de un programa Java. Debe tener exactamente esta firma y estructura para que Java lo reconozca como punto de entrada. Los detalles de los argumentos `(String[] args)` se explicarán más adelante en programas más complejos.
* `// Esto es un comentario.`: Los comentarios comienzan con // y se ignoran durante la ejecución.
* `System.out.println("Hola Skilly");`: Esta línea imprime el mensaje "Hola Skilly" en la consola. System.out se refiere a la consola y println es un método que imprime una línea de texto en la consola. "Hola Skilly" es el mensaje que se imprimirá.
* `}`: Esto marca el final del cuerpo del método "main"
* `}`: Esto marca el final del cuerpo de la clase.

> :warning: **ADVERTENCIA** Todas las líneas de Java tienen que terminar en `;` para indicar que acaba la instrucción

## Tipos de datos

En Java, los tipos de datos se utilizan para definir el tipo de valor que una variable puede contener. Los tipos de datos se dividen en dos categorías principales: tipos de datos primitivos y tipos de datos de objeto.

| Tipo de Dato | Descripción                                   | Ejemplo                                                  |
| ------------ | --------------------------------------------- | -------------------------------------------------------- |
| `int`        | Número entero                                 | `int edad = 30;`                                         |
| `double`     | Número de punto flotante                      | `double salario = 1500.50;`                              |
| `boolean`    | Valor verdadero o falso                       | `boolean esMayor = true;`                                |
| `char`       | Carácter individual                           | `char letra = 'A';`                                      |
| `String`     | Cadena de caracteres                          | `String nombre = "Juan";`                                |
| `long`       | Número entero largo                           | `long poblacion = 7000000000L;`                          |
| `float`      | Número de punto flotante (precisión reducida) | `float altura = 1.75f;`                                  |
| `byte`       | Entero de 8 bits                              | `byte codigo = 65;`                                      |
| `short`      | Entero corto de 16 bits                       | `short cantidad = 1000;`                                 |
| `BigDecimal` | Número decimal de alta precisión              | `BigDecimal precio = new BigDecimal("19.99");`           |
| `BigInteger` | Entero de alta precisión                      | `BigInteger cantidad = new BigInteger("1000000000000");` |
| `Date`       | Fecha y hora                                  | `Date fecha = new Date();`                               |

## Variables

Las variables se utilizan para almacenar valores en la memoria durante la ejecución de un programa. Deben declararse con un tipo de dato y un nombre.

```java
int edad = 25;
double salario = 1500.50;
String nombre = "Ana";
```

### Scope de las variables

El alcance de una variable se refiere a la parte del programa en la que la variable es visible y puede utilizarse. En Java, las variables pueden tener alcance local o alcance de clase.

```java
public class EjemploScope {
    // Variable de clase
    static int variableClase = 10;
    
    public static void main(String[] args) {
        // Variable local
        int variableLocal = 5;
        
        System.out.println(variableClase); // Acceso a la variable de clase
        System.out.println(variableLocal); // Acceso a la variable local
        
        // ...
    }
}
```

## Funciones

Las funciones, también conocidas como métodos en Java, son bloques de código reutilizables que realizan tareas específicas. Pueden aceptar argumentos y devolver valores.

```java
public class EjemploFunciones {
    public static void main(String[] args) {
        int resultado = suma(5, 3);
        System.out.println("El resultado de la suma es: " + resultado);
    }
    
    // Función que suma dos números
    static int suma(int a, int b) {
        return a + b;
    }
}

```

## Clases y Objetos

Las clases son plantillas para crear objetos. Los objetos son instancias de clases que tienen atributos y métodos.

```java
public class Persona {
    String nombre;
    int edad;
    
    void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
    
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Juan";
        persona1.edad = 30;
        persona1.saludar();
    }
}
```

## Herencia

La herencia en Java permite que una clase herede los atributos y métodos de otra clase. La clase que hereda se llama subclase o clase derivada, y la clase de la que hereda se llama superclase o clase base.

```java
public class Animal {
    void comer() {
        System.out.println("El animal come.");
    }
}

public class Perro extends Animal {
    void ladrar() {
        System.out.println("El perro ladra.");
    }
    
    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.comer(); // Hereda el método de la clase Animal
        miPerro.ladrar(); // Propio método de la clase Perro
    }
}
```

## Polimorfismo

El polimorfismo permite que objetos de diferentes clases se comporten de manera similar cuando se accede a través de una superclase común. Esto se logra mediante la sobrescritura de métodos en las subclases.

```java
public class Figura {
    void dibujar() {
        System.out.println("Dibujando una figura genérica.");
    }
}

public class Circulo extends Figura {
    @Override
    void dibujar() {
        System.out.println("Dibujando un círculo.");
    }
}

public class Cuadrado extends Figura {
    @Override
    void dibujar() {
        System.out.println("Dibujando un cuadrado.");
    }
    
    public static void main(String[] args) {
        Figura figura1 = new Circulo();
        Figura figura2 = new Cuadrado();
        
        figura1.dibujar(); // Llama al método de Circulo
        figura2.dibujar(); // Llama al método de Cuadrado
    }
}
```

## Gestion de la memoria | Garbage Colletion

Java utiliza un proceso llamado "Garbage Collection" para gestionar automáticamente la memoria utilizada por objetos que ya no son referenciados y, por lo tanto, son inaccesibles. Esto evita las fugas de memoria y libera recursos.
