# [Solución]  Carrera de Caracoles

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Estás organizando una emocionante carrera de caracoles y necesitas un programa para controlar la carrera. Escribe un programa que simule la carrera de caracoles hasta que uno de ellos alcance la línea de meta. Cada vez que se ejecuta el programa, los caracoles avanzan una pequeña distancia aleatoria. ¡Que gane el más veloz (o el menos lento)!

> :black_joker: **PISTA**
> Utiliza un bucle while para simular la carrera y una condición de salida para determinar cuándo un caracol llega a la meta.

~~~dart
import 'dart:math';

void main() {
  print('¡Comienza la carrera de caracoles!');
  int meta = 10;
  Random random = Random();

  int caracol1 = 0, caracol2 = 0, caracol3 = 0;
  while (caracol1 < meta && caracol2 < meta && caracol3 < meta) {
    caracol1 += random.nextInt(3);
    caracol2 += random.nextInt(3);
    caracol3 += random.nextInt(3);
    print('Caracol 1 avanza... ${caracol1}');
    print('Caracol 2 avanza... ${caracol2}');
    print('Caracol 3 avanza... ${caracol3}');
  }
  if (caracol1 >= meta) {
    print('¡Caracol 1 ha llegado a la meta! ¡Felicidades!');
  } else if (caracol2 >= meta) {
    print('¡Caracol 2 ha llegado a la meta! ¡Felicidades!');
  } else {
    print('¡Caracol 3 ha llegado a la meta! ¡Felicidades!');
  }
}
~~~
