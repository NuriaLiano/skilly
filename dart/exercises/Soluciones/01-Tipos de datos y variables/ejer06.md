# [Solución]  Concatenación de listas

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

 Crea dos listas de números ingresadas por el usuario. Luego, concatena las dos listas y muestra la lista resultante por consola.

> :black_joker: **PISTA**
> Puedes utilizar el operador + para concatenar listas en Dart.

~~~dart
void main() {
  // Solicitar al usuario la primera lista de números
  stdout.write('Ingrese la primera lista de números separados por coma: ');
  String input1 = stdin.readLineSync()!;
  List<int> lista1 = input1.split(',').map((e) => int.parse(e.trim())).toList();

  // Solicitar al usuario la segunda lista de números
  stdout.write('Ingrese la segunda lista de números separados por coma: ');
  String input2 = stdin.readLineSync()!;
  List<int> lista2 = input2.split(',').map((e) => int.parse(e.trim())).toList();

  // Concatenar las dos listas
  List<int> listaConcatenada = [...lista1, ...lista2];

  // Mostrar la lista resultante por consola
  print('La lista resultante es: $listaConcatenada');
}
~~~

>:woman_teacher: **EXPLICACIÓN**
>
> Solicitamos al usuario la primera lista de números y la segunda lista de números utilizando stdin.readLineSync() y split(',') para separar los números ingresados por coma y convertirlos en una lista de enteros.
>Concatenamos las dos listas utilizando el operador + y mostramos la lista resultante por consola.