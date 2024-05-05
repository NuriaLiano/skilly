# [Solución]  Tabla de Multiplicar

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Imagina que estás desarrollando una aplicacion para un colegio de infantiil. Los niños están aprendiendo las tablas de multiplicar y, de vez en cuando, necesitan revisar las tablas completas. Crea un programa que solicite al usuario ingresar un número entero positivo y luego muestre la tabla de multiplicar de ese número del 1 al 10.

> :black_joker: **PISTA**
> Utiliza un bucle for para iterar del 1 al 10 y muestra el resultado de la multiplicación en cada iteración.

~~~dart
import 'dart:io';

void main() {
  stdout.write('Ingresa un número entero positivo: ');
  int numero = int.parse(stdin.readLineSync()!);

  print('Tabla de multiplicar del $numero:');
  for (int i = 1; i <= 10; i++) {
    int resultado = numero * i;
    print('$numero x $i = $resultado');
  }
}
~~~
