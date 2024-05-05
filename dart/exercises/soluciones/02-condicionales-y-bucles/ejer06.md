# [Solución]  Decisión en el Restaurante

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Estás en un restaurante y estás debatiendo qué pedir de postre: ¿tarta de chocolate o helado de vainilla? Escribe un programa que te ayude a decidir qué pedir. Si te sientes aventurero, ve por la tarta de chocolate. Si prefieres algo refrescante, opta por el helado de vainilla. ¡Pero cuidado! Si te quedas indeciso, el camarero podría sugerirte la opción sorpresa: un batido de brócoli.

> :black_joker: **PISTA**
> Utiliza una estructura de control if-else para tomar decisiones basadas en las preferencias del usuario.

~~~dart
import 'dart:io';

void main() {
  print('¿Qué te gustaría de postre?');
  print('1. Tarta de chocolate');
  print('2. Helado de vainilla');
  stdout.write('Por favor, selecciona una opción: ');
  int opcion = int.parse(stdin.readLineSync()!);

  if (opcion == 1) {
    print('¡Genial elección! Disfruta de tu deliciosa tarta de chocolate.');
  } else if (opcion == 2) {
    print('¡Una excelente opción! Disfruta de tu refrescante helado de vainilla.');
  } else {
    print('Opción inválida. Por favor, selecciona 1 o 2.');
  }
}
~~~
