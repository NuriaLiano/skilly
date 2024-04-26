# [Solución] Ejercicios básicos sobre POO

Espero que hayas conseguido resolver los ejercicios por ti mismo, pero si no, no te preocupes. Vamos a repasar el resultado para que puedas entender qué elementos eran necesarios y por qué. 

## Ejercicio 1: Crear una Clase Libro

~~~java
public class Libro {
    // Propiedades
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Método para mostrar detalles
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Año de Publicación: " + anioPublicacion);
    }

    // Métodos getters y setters podrían añadirse aquí
}

class Main {
    public static void main(String[] args) {
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        libro.mostrarDetalles();
    }
}
~~~

## Sistema Básico de Gestión de Estudiantes

### Estudiante

~~~java
class Estudiante {
    // Propiedades
    private String nombre;
    private int edad;
    private String grado;

    // Constructor
    public Estudiante(String nombre, int edad, String grado) {
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }

    // Método para mostrar detalles
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Grado: " + grado);
    }
}
~~~

### Curso

~~~java
class Curso {
    // Propiedad
    private String nombreCurso;
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = new ArrayList<>();
    }

    // Método para agregar estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Método para mostrar detalles de estudiantes
    public void mostrarEstudiantes() {
        System.out.println("Estudiantes del curso " + nombreCurso + ":");
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarDetalles();
        }
    }
}
~~~

### Main

~~~java
class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Juan", 20, "2º de Bachillerato");
        Estudiante estudiante2 = new Estudiante("Ana", 19, "2º de Bachillerato");

        Curso curso = new Curso("Matemáticas Avanzadas");
        curso.agregarEstudiante(estudiante1);
        curso.agregarEstudiante(estudiante2);

        curso.mostrarEstudiantes();
    }
}
~~~
