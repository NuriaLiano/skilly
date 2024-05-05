#  [Solución] Sistema de Puntuación de Juegos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada calcularPuntuacion que simule el cálculo de la puntuación en un juego de video. La función debería generar un número aleatorio entre 0 y 100 para representar la puntuación del jugador en una partida.

> :black_joker: **PISTA**
> Utiliza la clase Random para generar números aleatorios.

~~~dart
import 'dart:math';

int calcularPuntuacion() {
  Random random = Random();
  return random.nextInt(101); // Genera un número aleatorio entre 0 y 100
}

void main() {
  int puntuacion = calcularPuntuacion();
  print('La puntuación obtenida en el juego es: $puntuacion');
}
~~~

