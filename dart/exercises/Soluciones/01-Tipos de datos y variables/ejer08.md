# [Solución]  Suma de números en una lista

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña un programa que solicite al usuario una lista de números separados por comas. Luego, suma todos los números de la lista y muestra el resultado por consola.

> :black_joker: **PISTA**
> Puedes utilizar el método split de un string para dividirlo en una lista de strings y luego convertir esos strings a números para sumarlos.

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario una lista de números separados por comas
  stdout.write('Ingrese una lista de números separados por comas: ');
  String input = stdin.readLineSync()!;

  // Dividir la entrada en una lista de strings
  List<String> numerosString = input.split(',');

  // Convertir los strings a números y sumarlos
  int suma = 0;
  for (String numeroString in numerosString) {
    int numero = int.parse(numeroString.trim());
    suma += numero;
  }

  // Mostrar el resultado por consola
  print('La suma de los números es: $suma');
}

~~~

> :woman_teacher: **EXPLICACIÓN**
>
> Solicitamos al usuario una lista de números separados por comas utilizando stdin.readLineSync().
> Utilizamos el método split de un string para dividir la entrada en una lista de strings, utilizando la coma como delimitador.
> Recorremos la lista de strings convertiendo cada elemento a número con int.parse() y los sumamos.
> Mostramos el resultado por consola indicando la suma de los números ingresados.