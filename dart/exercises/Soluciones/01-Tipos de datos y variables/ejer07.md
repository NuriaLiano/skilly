# [Solución]  Buscador de palabras

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe un programa que solicite al usuario una frase y una palabra. Luego, determina si la palabra ingresada está presente en la frase y muestra un mensaje indicando el resultado.

> :black_joker: **PISTA**
>  Puedes utilizar el método contains de un string para verificar si contiene una palabra específica.

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario una frase
  stdout.write('Ingrese una frase: ');
  String frase = stdin.readLineSync()!;

  // Solicitar al usuario una palabra a buscar
  stdout.write('Ingrese una palabra a buscar: ');
  String palabra = stdin.readLineSync()!;

  // Verificar si la palabra está presente en la frase
  bool estaPresente = frase.contains(palabra);

  // Mostrar el resultado por consola
  if (estaPresente) {
    print('La palabra "$palabra" está presente en la frase.');
  } else {
    print('La palabra "$palabra" no está presente en la frase.');
  }
}
~~~