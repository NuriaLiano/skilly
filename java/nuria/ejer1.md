# Ejercicio 1. Práctica de Programación II: Vectores en 2D

En esta práctica se abordará la creación de una clase para representar vectores bidimensionales en el plano.
Para ello, tendréis que implementar la clase Vector2D, una clase para representar vectores en dos
dimensiones.

## Especificación

**Vector2D**: Representará un vector en dos dimensiones con componentes x e y.

## Operaciones

1. Constructor: Un constructor en la clase Vector2D que tome dos números (componentes x e y) como
parámetros y cree un objeto vector con esos valores.
2. Suma y Resta: Métodos en la clase Vector2D que permitan sumar y restar vectores. Estos dos métodos
deben sumar el propio vector con otro vector (parámetro) y devolver un nuevo objeto vector como resultado
de la operación.
3. Producto Escalar: Un método en la clase Vector2D que permita calcular el producto escalar entre dos
vectores.
4. Módulo: Un método en la clase Vector2D que calcule el módulo (magnitud) del vector.
5. Ángulo: Un método en la clase Vector2D que calcule el ángulo entre dos vectores.
6. Representación como String: Un método en la clase Vector2D que represente el vector como una cadena
de caracteres en la forma "(x, y)".

## Requisitos adicionales

- Se ha de elaborar una especificación de la clase Vector2D con el diagrama de clases visto en las clases de la
asignatura.
- Se ha de elaborar la especificación del TAD (necesita-modifica-produce) como se ha visto en clase.
- Implementar manejo de excepciones para casos como la división por cero en el cálculo del ángulo o el
producto escalar entre vectores de diferentes dimensiones (try-catch).
- Proporcionar un programa de prueba (clase Main) que demuestre el funcionamiento correcto de la clase
Vector2D, incluyendo casos de suma, resta, producto escalar, cálculo de módulo y ángulo.

## Solución

~~~java
import java.util.Objects;

public class Vector2D {
    private double x;
    private double y;

    // Constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos para obtener las componentes x e y
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Método para sumar dos vectores y devolver un nuevo vector
    public Vector2D suma(Vector2D otroVector) {
        double sumaX = this.x + otroVector.getX();
        double sumaY = this.y + otroVector.getY();
        return new Vector2D(sumaX, sumaY);
    }

    // Método para restar dos vectores y devolver un nuevo vector
    public Vector2D resta(Vector2D otroVector) {
        double restaX = this.x - otroVector.getX();
        double restaY = this.y - otroVector.getY();
        return new Vector2D(restaX, restaY);
    }

    // Método para calcular el producto escalar entre dos vectores
    //Producto escalar = 
    public double productoEscalar(Vector2D otroVector) {
        return this.x * otroVector.getX() + this.y * otroVector.getY();
    }

    // Método para calcular el módulo (magnitud) del vector
    public double modulo() {
        return Math.sqrt(x * x + y * y);
    }

    // Método para calcular el ángulo entre dos vectores en radianes
    public double angulo(Vector2D otroVector) {
        double productoEscalar = productoEscalar(otroVector);
        double moduloProducto = modulo() * otroVector.modulo();

        // Manejo de excepciones para evitar la división por cero
        if (moduloProducto == 0) {
            throw new ArithmeticException("No se puede calcular el ángulo entre vectores de magnitud cero.");
        }

        // Cálculo del ángulo en radianes
        double cosTheta = productoEscalar / moduloProducto;
        return Math.acos(cosTheta);
    }

    // Representación como cadena de caracteres
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Método equals para comparar dos vectores por igualdad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2D vector2D = (Vector2D) obj;
        return Double.compare(vector2D.x, x) == 0 && Double.compare(vector2D.y, y) == 0;
    }

    // Método hashCode para generar un código hash para el vector
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        // Ejemplo de uso y prueba de la clase Vector2D
        Vector2D vector1 = new Vector2D(3.0, 4.0);
        Vector2D vector2 = new Vector2D(1.0, 2.0);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Vector 2: " + vector2);

        Vector2D suma = vector1.suma(vector2);
        System.out.println("Suma: " + suma);

        Vector2D resta = vector1.resta(vector2);
        System.out.println("Resta: " + resta);

        double productoEscalar = vector1.productoEscalar(vector2);
        System.out.println("Producto Escalar: " + productoEscalar);

        double modulo = vector1.modulo();
        System.out.println("Módulo de Vector 1: " + modulo);

        try {
            double angulo = vector1.angulo(vector2);
            System.out.println("Ángulo entre Vector 1 y Vector 2 (en radianes): " + angulo);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

~~~
