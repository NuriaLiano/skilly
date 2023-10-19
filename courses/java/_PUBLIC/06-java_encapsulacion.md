# Encapsulación en Java

La encapsulación es uno de los cuatro conceptos fundamentales de la Programación Orientada a Objetos (POO), junto con la abstracción, la herencia y el polimorfismo. La encapsulación se refiere a la práctica de ocultar los detalles internos de un objeto y proporcionar una interfaz pública para interactuar con él.

## Conceptos clave

1. **Clase**: Las clases encapsulan datos (atributos) y comportamientos (métodos) relacionados.
2. **Atributos** (Variables de Instancia): La encapsulación implica la definición de atributos como privados o protegidos, lo que significa que solo pueden accederse y modificarse a través de métodos públicos.
3. **Métodos** (Funciones de Instancia):  Los métodos públicos proporcionan una interfaz para interactuar con los atributos privados y realizar acciones en el objeto.
4. **Modificadores de acceso**: Java utiliza modificadores de acceso como public, private, protected y el modificador por defecto para controlar la visibilidad y el acceso a los atributos y métodos de una clase. Esto es esencial para la encapsulación.

## Beneficios

- **Ocultamiento de Datos**: Los detalles internos (atributos) de un objeto se ocultan y no son directamente accesibles desde fuera de la clase. Esto evita la manipulación no autorizada de datos.
- **Control de Acceso**: Los métodos públicos proporcionan un control preciso sobre cómo se accede y modifica el estado interno del objeto. Puedes implementar lógica para garantizar la integridad de los datos.
- **Flexibilidad**: Cambiar la implementación interna de una clase (por ejemplo, cambiar un atributo de una variable a una propiedad calculada) no afecta a los clientes que utilizan la clase.
- **Reutilización de Código**: Los objetos encapsulados pueden ser reutilizados en diferentes partes del programa sin preocuparse por los detalles internos.

## Ejemplo

En este ejempo podemos ver que los atributos 'nombre' y 'edad' son privados, por lo que no se puede acceder directamente desde fuera de la clase.

**¿Qué podemos hacer para acceder a esos atributos?** Crear métodos públicos que devuelvan o modifiquen el valor de esos atributos como pasa con los métodos 'obtenerNombre()' y 'establecerEdad()'

~~~java
public class Persona {
    // Atributos privados
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método público para obtener el nombre
    public String obtenerNombre() {
        return nombre;
    }

    // Método público para establecer la edad
    public void establecerEdad(int nuevaEdad) {
        if (nuevaEdad >= 0) {
            edad = nuevaEdad;
        }
    }
}
~~~
