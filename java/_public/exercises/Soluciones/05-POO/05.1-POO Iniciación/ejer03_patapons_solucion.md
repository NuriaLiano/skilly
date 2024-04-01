# [Solución] Ejercicio de arrays. Aventura de los Patapons

Espero que hayas conseguido resolver el ejercicio por tí mism@ pero si no, no te preocupes, vamos a repasar el resultado para que puedas entender que elementos eran necesarios y por qué.

Para resolver este ejercicio, crearé un programa en Java que simula un nivel básico del videojuego Patapon. Este programa utilizará arrays para gestionar tanto el ejército de Patapons como los enemigos, y todo el código estará contenido en una única clase Main. La simulación incluirá interacciones básicas como organizar el ejército de Patapons, avanzar por el campo de batalla, y enfrentarse a enemigos.

~~~java
import java.util.Scanner;

public class AventuraPatapon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir arreglos para representar el ejército de Patapons y los enemigos
        String[] ejercitoPatapon = {"Atacante", "Defensor", "Soporte", "Atacante"};
        String[] enemigos = {"Ogro", "Troll", "Ogro", "Troll"};

        int indicePatapon = 0; // Índice para controlar la posición actual del ejército de Patapons
        int indiceEnemigo = 0; // Índice para controlar la posición actual de los enemigos

        System.out.println("Inicio de la Aventura de los Patapons");

        // Mientras haya enemigos y Patapons, el juego continúa
        while (indiceEnemigo < enemigos.length && indicePatapon < ejercitoPatapon.length) {
            System.out.println("Encuentras un " + enemigos[indiceEnemigo] + " en el camino.");

            // Decisión del jugador
            System.out.println("¿Deseas atacar (1) o defender (2)?");
            int eleccion = scanner.nextInt();

            // Simulación de combate
            if (eleccion == 1) { // Atacar
                System.out.println("Tu " + ejercitoPatapon[indicePatapon] + " atacó al " + enemigos[indiceEnemigo]);
                indiceEnemigo++; // El enemigo es derrotado
            } else if (eleccion == 2) { // Defender
                System.out.println("Tu " + ejercitoPatapon[indicePatapon] + " defendió el ataque.");
            }

            indicePatapon++; // Avanzar al siguiente Patapon en el ejército

            // Verificar si quedan Patapons o enemigos
            if (indicePatapon >= ejercitoPatapon.length) {
                System.out.println("Todos tus Patapons han sido utilizados.");
            }

            if (indiceEnemigo >= enemigos.length) {
                System.out.println("Todos los enemigos han sido derrotados. ¡Has ganado!");
                break;
            }
        }

        // Resultado final
        if (indicePatapon < ejercitoPatapon.length) {
            System.out.println("Aún tienes Patapons, pero todos los enemigos han sido derrotados. ¡Victoria!");
        } else if (indiceEnemigo < enemigos.length) {
            System.out.println("Te has quedado sin Patapons. Juego terminado.");
        }

        scanner.close();
    }
}
~~~
