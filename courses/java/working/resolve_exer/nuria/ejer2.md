# Ejericio 2 de laboratorio

## clase estudiante

~~~java
public class Estudiante {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String curso;

    // Constructor
    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String curso) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.curso = curso;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido1 + " " + apellido2 + ", DNI: " + dni + ", Curso: " + curso;
    }
}
~~~

## clase listaEstudiantes

~~~java
****import java.util.ArrayList;

public class ListadoEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    public ListadoEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void añadirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String DNI) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(DNI)) {
                return estudiante;
            }
        }
        return null;
    }

    public void eliminarEstudiante(String DNI) {
        Estudiante estudiante = buscarEstudiante(DNI);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
        }
    }

    @Override
    public String toString() {
        return estudiantes.toString();
    }
}

~~~

## principal

~~~java
import java.util.ArrayList;

public class ListadoEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    public ListadoEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void añadirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String DNI) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDni().equals(DNI)) {
                return estudiante;
            }
        }
        return null;
    }

    public void eliminarEstudiante(String DNI) {
        Estudiante estudiante = buscarEstudiante(DNI);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
        }
    }

    @Override
    public String toString() {
        return estudiantes.toString();
    }
}
~~~
