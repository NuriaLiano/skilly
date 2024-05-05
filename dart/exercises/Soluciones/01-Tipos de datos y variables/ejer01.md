# [Solución]  Suma y resta de números enteros

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crear un programa que te haga sentir un poco más joven al calcular la edad de tu vecin@ a partir de su año de nacimiento. Solicítale al usuario su año de nacimiento y calcula su edad actual. Luego, muestra la edad por consola.

> :black_joker: **PISTA**
>  Utiliza el año actual y el año de nacimiento para calcular la edad

~~~dart
import 'dart:io';

void main() {
  // Solicitar al usuario su año de nacimiento
  stdout.write('Ingrese su año de nacimiento: ');
  int añoNacimiento = int.parse(stdin.readLineSync()!);

  // Obtener el año actual
  int añoActual = DateTime.now().year;

  // Calcular la edad
  int edad = añoActual - añoNacimiento;

  // Mostrar la edad por consola
  print('Tu edad actual es: $edad años.');
}
~~~

> :woman_teacher: **EXPLICACIÓN**
> `import 'dart:io';`: es necesario importar la librería o paquete para poder utilizar la funcionalidad de entrada y salida estándar (E/S) de Dart para interactuar con el usuario a través de la consola. La librería dart:io proporciona clases y funciones que permiten leer datos desde la entrada estándar (teclado) y escribir datos en la salida estándar (consola).

