# [Solución] Aventuras en el Laberinto Encantado

## Objetivo

El objetivo de la aplicación "Aventuras en el Laberinto Encantado" es proporcionar una experiencia interactiva y divertida al usuario, donde este debe navegar a través de un laberinto lleno de misterios, puzzles y criaturas fantásticas. El jugador utilizará una serie de comandos para explorar habitaciones, interactuar con objetos y personajes, y resolver acertijos para avanzar en el juego.

## Clases y métodos

### PalabrasComando

~~~java
public class PalabrasComando {
    // Constantes para los comandos disponibles en el juego.
    private static final String[] comandosValidos = {"ir", "fin", "ayuda", "mirar"};

    // Verifica si una cadena es un comando válido.
    public boolean esComando(String unaCadena) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(unaCadena)) {
                return true;
            }
        }
        // Si la cadena no coincide con ningún comando, retorna falso.
        return false;
    }

    // Muestra todos los comandos disponibles.
    public void mostrarTodos() {
        for (String comando : comandosValidos) {
            System.out.print(comando + " ");
        }
        System.out.println(); // Salto de línea después de listar comandos.
    }
}
~~~

### Comando

~~~java
public class Comando {
    private String comando = null;
    private String segundaPalabra = null;

    // Constructor que establece el comando y la segunda palabra.
    public Comando(String primerPalabra, String segundaPalabra) {
        this.comando = primerPalabra;
        this.segundaPalabra = segundaPalabra;
    }

    // Retorna la palabra del comando.
    public String getComando() {
        return comando;
    }

    // Retorna la segunda palabra del comando.
    public String getSegundaPalabra() {
        return segundaPalabra;
    }

    // Verifica si hay un comando.
    public boolean hayComando() {
        return comando != null;
    }

    // Verifica si hay una segunda palabra.
    public boolean haySegundaPalabra() {
        return segundaPalabra != null;
    }
}
~~~

### Transformar

~~~java
public class Transformar {
    private PalabrasComando palabrasComando;

    // Constructor por defecto.
    public Transformar() {
        palabrasComando = new PalabrasComando(); // Inicializa la lista de comandos.
    }

    // Toma un string de entrada y lo convierte en un objeto Comando.
    public Comando getCommand(String entradaUsuario) {
        String[] palabras = entradaUsuario.split(" "); // Divide la entrada en palabras.
        
        String palabra = null;
        String segundaPalabra = null;

        if (palabras.length > 0) {
            palabra = palabras[0]; // Primera palabra.

            if (palabras.length > 1) {
                segundaPalabra = palabras[1]; // Segunda palabra si existe.
            }
        }

        // Verifica si la palabra es un comando válido y crea un Comando.
        if (palabrasComando.esComando(palabra)) {
            return new Comando(palabra, segundaPalabra);
        } else {
            return new Comando(null, segundaPalabra); // Comando no válido.
        }
    }
}
~~~

### Habitación

~~~java
public class Habitacion {
    private String descripcion;
    // Las salidas de esta habitación.
    private Habitacion norte, sur, este, oeste;

    // Constructor que establece la descripción de la habitación.
    public Habitacion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Establece las salidas de esta habitación.
    public void setSalida(String direccion, Habitacion vecina) {
        switch (direccion) {
            case "norte": this.norte = vecina; break;
            case "sur": this.sur = vecina; break;
            case "este": this.este = vecina; break;
            case "oeste": this.oeste = vecina; break;
        }
    }

    // Devuelve una descripción larga de esta habitación.
    public String getDescripcionLarga() {
        return "Estás en " + descripcion + ".\n" + getStringDeSalidas();
    }

    // Devuelve una cadena con las salidas disponibles.
    private String getStringDeSalidas() {
        String salidas = "Salidas:";
        if(norte != null) salidas += " norte";
        if(este != null) salidas += " este";
        if(sur != null) salidas += " sur";
        if(oeste != null) salidas += " oeste";
        return salidas;
    }

    // Devuelve la habitación que se encuentra en la dirección dada.
    public Habitacion getSalida(String direccion) {
        switch (direccion) {
            case "norte": return norte;
            case "sur": return sur;
            case "este": return este;
            case "oeste": return oeste;
            default: return null;
        }
    }
}
~~~

### Subclases de Habitación

#### Subclase HabitacionOscura

~~~java
public class HabitacionOscura extends Habitacion {
    // Constructor que recibe la descripción.
    public HabitacionOscura(String descripcion) {
        super(descripcion);
    }

    // Sobreescribe el método getDescripcionLarga para reflejar la oscuridad.
    @Override
    public String getDescripcionLarga() {
        return "Estás en una habitación oscura y no puedes ver nada.";
    }

    // Sobreescribe getStringDeSalidas para no mostrar salidas en la oscuridad.
    @Override
    public String getStringDeSalidas() {
        return "No puedes ver las salidas desde la oscuridad.";
    }
}
~~~

#### Subclase HabitacionIluminable

~~~java
public class HabitacionIluminable extends Habitacion {
    private boolean iluminada;

    // Constructor que recibe la descripción y el estado inicial de la luz.
    public HabitacionIluminable(String descripcion, boolean iluminada) {
        super(descripcion);
        this.iluminada = iluminada;
    }

    // Método para cambiar el estado de la iluminación.
    public void cambiarLuz() {
        iluminada = !iluminada;
    }

    // Sobreescribe getDescripcionLarga según el estado de la iluminación.
    @Override
    public String getDescripcionLarga() {
        if (iluminada) {
            return super.getDescripcionLarga(); // Devuelve la descripción estándar si está iluminada.
        } else {
            return "Estás en una habitación oscura. Usa el comando 'luz' para encender la luz.";
        }
    }
}
~~~

### Juego

~~~java
public class Juego {
    private Transformar transformar;
    private Habitacion habitacionActual;

    public Juego() {
        crearHabitaciones();
        transformar = new Transformar();
    }

    // Crea todas las habitaciones y les asigna salidas.
    private void crearHabitaciones() {
        // Crear las habitaciones.
        Habitacion exterior = new Habitacion("en el exterior del laberinto");
        // Más habitaciones aquí.
        // Definir las salidas de cada habitación.
        exterior.setSalida("norte", /* otra habitación */);

        // Habitación inicial del juego.
        habitacionActual = exterior;
    }

    // Inicia y ejecuta el bucle principal del juego.
    public void jugar() {
        bienvenido();
        // Entrar al bucle del juego.
        boolean terminado = false;
        while (!terminado) {
            Comando comando = transformar.getCommand(/* leer entrada del usuario */);
            terminado = procesarComando(comando);
        }
        System.out.println("Gracias por jugar. ¡Adiós!");
    }

    // Muestra un mensaje de bienvenida al jugador.
    private void bienvenido() {
        System.out.println("Bienvenido al Laberinto Encantado!");
        System.out.println("Escribe 'ayuda' si necesitas ayuda.");
        System.out.println();
        System.out.println(habitacionActual.getDescripcionLarga());
    }

    // Procesa el comando introducido por el jugador.
    private boolean procesarComando(Comando comando) {
        // Lógica para procesar diferentes comandos.
        return false; // Retorna true para terminar el juego.
    }
}
~~~

### Run

~~~java
public class Run {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar(); // Comienza el juego.
    }
}
~~~
