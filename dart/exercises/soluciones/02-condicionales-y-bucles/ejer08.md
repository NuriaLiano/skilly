# [Solución]  El Gran Escape

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

 Te encuentras en la prisión de Dartmoor y estás planeando tu gran escape. Escribe un programa que simule tus intentos de escapar de la prisión. Utiliza la estructura de control do-while para intentar abrir las puertas hasta que finalmente logres escapar o te atrapen las autoridades. ¡Recuerda mantener la calma y no rendirte!

> :black_joker: **PISTA**
> Utiliza un bucle do-while para simular los intentos de apertura de la puerta y una condición de salida para determinar cuándo has logrado escapar o te han atrapado.

~~~dart
import 'dart:math';

void main() {
  Random random = Random();
  bool puertaAbierta = false;

  do {
    print('¡Intentando abrir la puerta...');
    // Simulación de intento de abrir la puerta
    if (random.nextDouble() < 0.5) {
      puertaAbierta = true;
    }
  } while (!puertaAbierta);

  print('¡Hemos escapado! ¡Corre, corre, corre!');
}
~~~
