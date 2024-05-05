# [Solución]  Día de la Semana

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe un programa que solicite al usuario ingresar su edad y determine si es mayor de edad o no para permitir la entrada al local. Si es mayor de edad, muestra el mensaje "¡Pasa colega, disfruta de la fiesta!", de lo contrario, muestra el mensaje "Aún no puedes entrar colega, prueba de nuevo en unos años".

> :black_joker: **PISTA**
> Recuerda que en Dart, los días de la semana se representan comúnmente del 1 al 7.

~~~dart
import 'dart:io';

void main() {
  stdout.write('Ingrese su edad: ');
  int edad = int.parse(stdin.readLineSync()!);

  if (edad >= 18) {
    print('¡Pasa colega, disfruta de la fiesta!');
  } else {
    print('Aún no puedes entrar colega, prueba de nuevo en unos años.');
  }
}
~~~
