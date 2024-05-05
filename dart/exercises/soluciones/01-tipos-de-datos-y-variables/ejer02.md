# [Solución]  Calculadora de IMC

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe un programa que solicite al usuario su peso (en kilogramos) y su altura (en metros), y calcule su IMC. Luego, muestra el IMC por consola.

> :black_joker: **PISTA**
> La fórmula del IMC es peso / (altura * altura).

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario su peso en kilogramos
  stdout.write('Ingrese su peso en kilogramos: ');
  double peso = double.parse(stdin.readLineSync()!);

  // Solicitar al usuario su altura en metros
  stdout.write('Ingrese su altura en metros: ');
  double altura = double.parse(stdin.readLineSync()!);

  // Calcular el IMC
  double imc = peso / (altura * altura);

  // Mostrar el IMC por consola
  print('Tu Índice de Masa Corporal (IMC) es: $imc');
}
~~~

> :woman_teacher: EXPLICACIÓN
> 
>-  `import 'dart:io';`: Importamos la librería dart:io para utilizar la funcionalidad de entrada y salida estándar (E/S) de Dart y así poder interactuar con el usuario a través de la consola.
>-  `stdout.write()`: Utilizamos stdout.write() para mostrar un mensaje al usuario y solicitar su entrada sin pasar a una nueva línea.
>-  `stdin.readLineSync()`: Leemos la entrada del usuario utilizando stdin.readLineSync() y convertimos el resultado a double para obtener el peso y la altura en kilogramos y metros, respectivamente.