# [Solución]  Buscador de palabras

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea un programa que solicite al usuario una lista de palabras separadas por comas. Luego, ordena las palabras alfabéticamente y muestra la lista resultante por consola.

> :black_joker: **PISTA**
> Puedes utilizar el método sort de una lista para ordenar sus elementos.

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario una lista de palabras separadas por comas
  stdout.write('Ingrese una lista de palabras separadas por comas: ');
  String input = stdin.readLineSync()!;

  // Dividir la entrada en una lista de palabras
  List<String> palabras = input.split(',');

  // Ordenar las palabras alfabéticamente
  palabras.sort();

  // Mostrar el resultado por consola
  print('La lista ordenada alfabéticamente es: $palabras');
}
~~~

> :woman_teacher: **EXPLICACIÓN**
>
> Solicitamos al usuario una lista de palabras separadas por comas utilizando stdin.readLineSync().
> Utilizamos el método split de un string para dividir la entrada en una lista de palabras, utilizando la coma como delimitador.
> Utilizamos el método sort de una lista para ordenar las palabras alfabéticamente.
> Mostramos el resultado por consola indicando la lista de palabras ordenadas alfabéticamente.