# [Solución]  Calculadora de número primo

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

 Escribe un programa que solicite al usuario un número entero positivo y determine si es primo o no. Muestra un mensaje indicando si el número es primo o no por consola.

> :black_joker: **PISTA**
> Un número primo es aquel que solo es divisible por 1 y por sí mismo.

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario un número entero positivo
  stdout.write('Ingrese un número entero positivo: ');
  int numero = int.parse(stdin.readLineSync()!);

  // Verificar si el número es primo
  bool esPrimo = true; // Suponemos que el número es primo inicialmente
  if (numero <= 1) {
    esPrimo = false; // Si el número es menor o igual a 1, no es primo
  } else if (numero != 2 && numero % 2 == 0) {
    esPrimo = false; // Si el número es par y no es 2, no es primo
  }

  // Mostrar el resultado por consola
  if (esPrimo) {
    print('$numero es un número primo.');
  } else {
    print('$numero no es un número primo.');
  }
}

~~~