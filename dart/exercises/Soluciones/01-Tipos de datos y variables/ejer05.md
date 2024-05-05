# [Solución]  Contador de caracteres

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe un programa que solicite al usuario una frase y cuente cuántos caracteres tiene (incluyendo espacios). Muestra el resultado por consola.

> :black_joker: **PISTA**
> Puedes utilizar el método length de un string para contar sus caracteres.

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario una frase
  stdout.write('Ingrese una frase: ');
  String frase = stdin.readLineSync()!;

  // Calcular la cantidad de caracteres de la frase
  int cantidadCaracteres = frase.length;

  // Mostrar el resultado por consola
  print('La frase tiene $cantidadCaracteres caracteres (incluyendo espacios).');
}
~~~