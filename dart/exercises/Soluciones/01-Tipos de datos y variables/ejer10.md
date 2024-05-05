# [Solución]  Generador de facturas

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña un programa que simule la generación de una factura para una tienda. El programa deberá solicitar al usuario información sobre los productos comprados, sus precios y las cantidades. Luego, calcular el total de la factura y mostrar la factura completa por consola, incluyendo los detalles de los productos, precios unitarios, cantidades y el total a pagar.

> :black_joker: **PISTA**
> Utiliza listas para almacenar los nombres de los productos, sus precios y cantidades. Luego, puedes iterar sobre estas listas para calcular el total de la factura y construir el formato de la factura.

## Ejemplo de resultado:

~~~sh
Ingrese el nombre del primer producto: Camiseta
Ingrese el precio de la camiseta: 15
Ingrese la cantidad de camisetas: 2

Ingrese el nombre del segundo producto: Pantalón
Ingrese el precio del pantalón: 25
Ingrese la cantidad de pantalones: 1

Ingrese el nombre del tercer producto: Zapatos
Ingrese el precio de los zapatos: 40
Ingrese la cantidad de pares de zapatos: 1

======= Factura =======
Producto        Precio Unitario     Cantidad        Total
----------------------------------------------------------
Camiseta             $15.00               2             $30.00
Pantalón             $25.00               1             $25.00
Zapatos              $40.00               1             $40.00
----------------------------------------------------------
Total a pagar: $95.00
~~~

~~~dart
import 'dart:io';

void main() {
  List<String> productos = [];
  List<double> precios = [];
  List<int> cantidades = [];

  // Solicitar al usuario información sobre los productos comprados
  stdout.write('Ingrese el nombre del primer producto: ');
  String producto1 = stdin.readLineSync()!;
  productos.add(producto1);

  stdout.write('Ingrese el precio del primer producto: ');
  double precio1 = double.parse(stdin.readLineSync()!);
  precios.add(precio1);

  stdout.write('Ingrese la cantidad del primer producto: ');
  int cantidad1 = int.parse(stdin.readLineSync()!);
  cantidades.add(cantidad1);

  stdout.write('Ingrese el nombre del segundo producto: ');
  String producto2 = stdin.readLineSync()!;
  productos.add(producto2);

  stdout.write('Ingrese el precio del segundo producto: ');
  double precio2 = double.parse(stdin.readLineSync()!);
  precios.add(precio2);

  stdout.write('Ingrese la cantidad del segundo producto: ');
  int cantidad2 = int.parse(stdin.readLineSync()!);
  cantidades.add(cantidad2);

  stdout.write('Ingrese el nombre del tercer producto: ');
  String producto3 = stdin.readLineSync()!;
  productos.add(producto3);

  stdout.write('Ingrese el precio del tercer producto: ');
  double precio3 = double.parse(stdin.readLineSync()!);
  precios.add(precio3);

  stdout.write('Ingrese la cantidad del tercer producto: ');
  int cantidad3 = int.parse(stdin.readLineSync()!);
  cantidades.add(cantidad3);

  // Calcular el total de la factura
  double total = precios[0] * cantidades[0] + precios[1] * cantidades[1] + precios[2] * cantidades[2];

  // Mostrar la factura completa por consola
  print('======= Factura =======');
  print('Producto        Precio Unitario     Cantidad        Total');
  print('----------------------------------------------------------');
  print('${productos[0]}'.padRight(20) + '\$${precios[0].toStringAsFixed(2)}'.padRight(20) + '${cantidades[0]}'.padRight(15) + '\$${(precios[0] * cantidades[0]).toStringAsFixed(2)}');
  print('${productos[1]}'.padRight(20) + '\$${precios[1].toStringAsFixed(2)}'.padRight(20) + '${cantidades[1]}'.padRight(15) + '\$${(precios[1] * cantidades[1]).toStringAsFixed(2)}');
  print('${productos[2]}'.padRight(20) + '\$${precios[2].toStringAsFixed(2)}'.padRight(20) + '${cantidades[2]}'.padRight(15) + '\$${(precios[2] * cantidades[2]).toStringAsFixed(2)}');
  print('----------------------------------------------------------');
  print('Total a pagar: \$${total.toStringAsFixed(2)}');
}
~~~