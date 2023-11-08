# Solución Ejercicio: Sistema de Gestión para una Biblioteca

## Clase Pais

~~~java
public enum Pais {
    USA, MEXICO, COLOMBIA, ESPANA, ARGENTINA; // y otros países según sea necesario
}
~~~

## Clase Persona

~~~java
public abstract class Persona {
    protected String nombre;
    protected String identificacion; // Asumiendo que tanto Autores como Usuarios tienen identificación

    // Constructor con parámetros para inicializar los atributos
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Métodos getters y setters para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getters y setters para identificacion
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
~~~

## Clase Libro

~~~java
public class Libro {
    private String titulo;
    private Autor autor;
    private int anioPublicacion;
    private int numeroCopias;
    private int numeroCopiasPrestadas;

    // Constructor para inicializar los atributos
    public Libro(String titulo, Autor autor, int anioPublicacion, int numeroCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroCopias = numeroCopias;
        this.numeroCopiasPrestadas = 0; // Inicialmente, no hay copias prestadas
    }

    // Método para prestar un libro
    public boolean prestarLibro() {
        if (numeroCopiasPrestadas < numeroCopias) {
            numeroCopiasPrestadas++;
            return true;
        } else {
            return false; // No hay copias disponibles para prestar
        }
    }

    // Método para devolver un libro
    public boolean devolverLibro() {
        if (numeroCopiasPrestadas > 0) {
            numeroCopiasPrestadas--;
            return true;
        } else {
            return false; // No hay copias para devolver
        }
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public int getNumeroCopiasPrestadas() {
        return numeroCopiasPrestadas;
    }

    // No hay un setter para numeroCopiasPrestadas porque su valor se maneja a través de los métodos prestarLibro y devolverLibro
~~~

## Clase Autor

~~~java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Autor extends Persona {
    private Pais pais;
    private Date fechaNacimiento;
    private List<Libro> librosPublicados;

    // Constructor para inicializar los atributos de Autor y los de Persona
    public Autor(String nombre, String identificacion, Pais pais, Date fechaNacimiento) {
        super(nombre, identificacion); // Llamada al constructor de la superclase Persona
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.librosPublicados = new ArrayList<>();
    }

    // Método para agregar un libro a la lista de libros publicados
    public void agregarLibroPublicado(Libro libro) {
        librosPublicados.add(libro);
    }

    // Método para obtener la lista de libros publicados
    public List<Libro> getLibrosPublicados() {
        return librosPublicados;
    }

    // Getters y setters para pais
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // Getters y setters para fechaNacimiento
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método opcional para imprimir la información del autor
    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", pais=" + pais +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
~~~

## Clase Usuario

~~~java
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private List<Libro> librosPrestados;

    // Constructor para inicializar los atributos de Usuario y los de Persona
    public Usuario(String nombre, String identificacion) {
        super(nombre, identificacion); // Llamada al constructor de la superclase Persona
        this.librosPrestados = new ArrayList<>();
    }

    // Método para tomar prestado un libro
    public void tomarPrestadoLibro(Libro libro) {
        if (libro.prestarLibro()) { // Si el libro puede ser prestado
            librosPrestados.add(libro); // Se añade el libro a la lista de libros prestados
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    // Método para devolver un libro
    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) { // Si el libro está en la lista de prestados
            libro.devolverLibro(); // Se invoca el método de devolución de Libro
            librosPrestados.remove(libro); // Se elimina el libro de la lista de prestados
        } else {
            System.out.println("Este usuario no tiene este libro para devolver.");
        }
    }

    // Método para obtener la lista de libros prestados
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    // Método opcional para imprimir la información del usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}
~~~

## Clase Biblioteca

~~~java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private List<Libro> libros;
    private List<Usuario> usuarios;

    // Constructor para inicializar los atributos de la biblioteca
    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Método para agregar un libro a la biblioteca
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para agregar un usuario a la biblioteca
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para buscar un libro por título
    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getNumeroCopiasPrestadas() < libro.getNumeroCopias()) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro o no hay copias disponibles
    }

    // Método para buscar un usuario por identificación
    public Usuario buscarUsuario(String identificacion) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }

    // Método para realizar un préstamo de libro
    public boolean realizarPrestamo(String identificacionUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuario(identificacionUsuario);
        Libro libro = buscarLibro(tituloLibro);
        
        if (usuario != null && libro != null) {
            usuario.tomarPrestadoLibro(libro);
            return true;
        }
        return false;
    }

    // Método para recibir una devolución de libro
    public boolean recibirDevolucion(String identificacionUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuario(identificacionUsuario);
        Libro libro = buscarLibro(tituloLibro);
        
        if (usuario != null && libro != null) {
            usuario.devolverLibro(libro);
            return true;
        }
        return false;
    }

    // Getters y setters para nombre y dirección
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método opcional para obtener todos los libros de la biblioteca
    public List<Libro> getTodosLosLibros() {
        return libros;
    }

    // Método opcional para obtener todos los usuarios de la biblioteca
    public List<Usuario> getTodosLosUsuarios() {
        return usuarios;
    }
}
~~~

## Clase Main

~~~java
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");

        // Formato de fecha para la fecha de nacimiento de los autores
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Crear autores
        try {
            Autor autor1 = new Autor("Gabriel García Márquez", "123456789", Pais.COLOMBIA, sdf.parse("06/03/1927"));
            Autor autor2 = new Autor("J.K. Rowling", "987654321", Pais.USA, sdf.parse("31/07/1965"));

            // Crear libros y asignar autores
            Libro libro1 = new Libro("Cien años de soledad", autor1, 1967, 5);
            Libro libro2 = new Libro("Harry Potter y la piedra filosofal", autor2, 1997, 3);

            // Agregar libros a la biblioteca
            biblioteca.agregarLibro(libro1);
            biblioteca.agregarLibro(libro2);

            // Crear usuarios
            Usuario usuario1 = new Usuario("Juan Pérez", "001");
            Usuario usuario2 = new Usuario("Ana López", "002");

            // Agregar usuarios a la biblioteca
            biblioteca.agregarUsuario(usuario1);
            biblioteca.agregarUsuario(usuario2);

            // Realizar operaciones de préstamo
            boolean prestamo1 = biblioteca.realizarPrestamo("001", "Cien años de soledad");
            if (prestamo1) {
                System.out.println("Préstamo realizado con éxito.");
            } else {
                System.out.println("No se pudo realizar el préstamo.");
            }

            // Realizar operaciones de devolución
            boolean devolucion1 = biblioteca.recibirDevolucion("001", "Cien años de soledad");
            if (devolucion1) {
                System.out.println("Devolución realizada con éxito.");
            } else {
                System.out.println("No se pudo realizar la devolución.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
~~~
