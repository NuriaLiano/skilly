# [Solución] Ejercicio de Pasapalabra

## Clase Pregunta

~~~java
public class Pregunta {
    // Atributos de la clase
    private char identificador; // Letra inicial de la palabra
    private String enunciado; // Definición de la palabra
    private String respuesta; // Palabra buscada
    private String respuesta_correcta; // Estado de la pregunta: Azul, Verde, Rojo

    // Constructor de la clase
    public Pregunta(char identificador, String enunciado, String respuesta) {
        this.identificador = identificador;
        this.enunciado = enunciado;
        this.respuesta = respuesta;
        this.respuesta_correcta = "Azul"; // Por defecto, la pregunta está sin responder
    }

    // Métodos para cambiar el estado de la respuesta
    public void cambiaRespuestaCorrecta() {
        this.respuesta_correcta = "Verde";
    }

    public void cambiaRespuestaIncorrecta() {
        this.respuesta_correcta = "Rojo";
    }

    public void cambiaPasapalabra() {
        this.respuesta_correcta = "Azul"; // Reestablece a no respondida
    }

    // Getters para acceder a los atributos de la clase
    public char getIdentificador() {
        return identificador;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getRespuesta_correcta() {
        return respuesta_correcta;
    }
}
~~~

## Clase GeneraListaPreguntas

~~~java
import java.util.ArrayList;

public class GeneraListaPreguntas {
    // Atributo que almacena la lista de preguntas
    private ArrayList<Pregunta> lista;

    // Constructor de la clase
    public GeneraListaPreguntas() {
        lista = new ArrayList<Pregunta>();
        // Aquí se pueden añadir las preguntas manualmente o mediante otra lógica
        // Ejemplo:
        lista.add(new Pregunta('A', "Definición de la palabra que empieza por A", "respuestaA"));
        // Añadir más preguntas según se necesite
    }

    // Método para obtener la lista de preguntas
    public ArrayList<Pregunta> getLista() {
        return lista;
    }
}
~~~

## Clase ProtoPasapalabra

~~~java
import java.util.Scanner;

public class ProtoPasapalabra {
    public static void main(String[] args) {
        GeneraListaPreguntas glp = new GeneraListaPreguntas();
        Scanner scanner = new Scanner(System.in);

        for (Pregunta pregunta : glp.getLista()) {
            System.out.println(pregunta.getEnunciado());
            String respuestaUsuario = scanner.nextLine();

            if (respuestaUsuario.equalsIgnoreCase("pasapalabra")) {
                pregunta.cambiaPasapalabra();
            } else if (respuestaUsuario.equalsIgnoreCase(pregunta.getRespuesta())) {
                pregunta.cambiaRespuestaCorrecta();
            } else {
                pregunta.cambiaRespuestaIncorrecta();
            }
        }

        // Al final del juego, muestra el estado de cada pregunta
        for (Pregunta pregunta : glp.getLista()) {
            System.out.println("Pregunta: " + pregunta.getEnunciado() +
                               " - Estado: " + pregunta.getRespuesta_correcta());
        }

        scanner.close();
    }
}
~~~
