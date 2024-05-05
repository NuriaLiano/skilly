# [Solución] Adivina el Número

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

¿Te sientes con suerte hoy? ¡Vamos a jugar a un juego! Introduce un número del 1 al 10 y veremos si puedes adivinar mi número secreto. Pero, ¡cuidado!, si te equivocas, tendrás que seguir intentándolo hasta que lo adivines correctamente. ¡Que comience el juego!"

> :black_joker: **PISTA**
>  Utiliza una variable booleana para controlar si el usuario ha adivinado correctamente.

~~~dart
import 'dart:io';
import 'dart:math';

void main() {
  Random random = Random();
  int numeroSecreto = random.nextInt(10) + 1;
  bool adivinado = false;

  print('¿Te sientes con suerte hoy? ¡Vamos a jugar a un juego!');
  print('Introduce un número del 1 al 10 y veremos si puedes adivinar mi número secreto.');

  do {
    stdout.write('Ingresa tu número: ');
    int numero = int.parse(stdin.readLineSync()!);

    if (numero == numeroSecreto) {
      print('¡Felicidades! ¡Has adivinado mi número secreto!');
      adivinado = true;
    } else {
      print('¡Oops! Ese no es mi número secreto. ¡Inténtalo de nuevo!');
    }
  } while (!adivinado);
}
~~~
