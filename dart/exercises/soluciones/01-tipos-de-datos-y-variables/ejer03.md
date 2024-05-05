# [Solución]  Calculadora de interés compuesto

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña un programa que calcule el valor final de una inversión después de un cierto número de años, utilizando la fórmula del interés compuesto. Solicita al usuario el monto inicial, la tasa de interés anual y el número de años. Muestra el resultado por consola.

> :black_joker: **PISTA**
> La fórmula del interés compuesto es: ValorFinal = MontoInicial * (1 + TasaInteres/100)^Años.

~~~dart
import 'dart:io'; // Importamos la librería 'dart:io' para poder interactuar con la entrada y salida estándar.

void main() {
  // Solicitamos al usuario el monto inicial de la inversión.
  stdout.write('Ingrese el monto inicial de la inversión: ');
  double montoInicial = double.parse(stdin.readLineSync()!);

  // Solicitamos al usuario la tasa de interés anual.
  stdout.write('Ingrese la tasa de interés anual (%): ');
  double tasaInteres = double.parse(stdin.readLineSync()!);

  // Solicitamos al usuario el número de años de la inversión.
  stdout.write('Ingrese el número de años de la inversión: ');
  int años = int.parse(stdin.readLineSync()!);

  // Calculamos el valor final de la inversión utilizando la fórmula del interés compuesto.
  double valorFinal = montoInicial * pow(1 + tasaInteres / 100, años); // Utilizamos la función 'pow' para calcular la potencia.

  // Mostramos el resultado por consola.
  print('El valor final de la inversión después de $años años es: $valorFinal');
}
~~~

> :woman_teacher: EXPLICACIÓN
>
> - `import 'dart:io';`: Importamos la librería dart:io para poder interactuar con la entrada y salida estándar.
> - `stdout.write('Ingrese el monto inicial de la inversión: ');`: Utilizamos stdout.write() para mostrar un mensaje al usuario y solicitar su entrada sin pasar a una nueva línea.
> - `double montoInicial = double.parse(stdin.readLineSync()!);`: Leemos la entrada del usuario utilizando stdin.readLineSync() y convertimos el resultado a double para obtener el monto inicial de la inversión.
> - `pow(1 + tasaInteres / 100, años);`: Utilizamos la función pow para calcular la potencia. Esta función necesita ser importada con dart:math para ser utilizada.
> - `print('El valor final de la inversión después de $años años es: $valorFinal');`: Mostramos el valor final de la inversión calculado por consola. Utilizamos interpolación de cadenas para incluir variables dentro de la cadena de salida.