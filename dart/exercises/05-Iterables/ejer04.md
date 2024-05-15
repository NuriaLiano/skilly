# [Solución] Pedidos en McDonald's

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Ejercicio

Desarrolla una función llamada totalVentas que reciba una lista de pedidos de McDonald's, cada uno con un producto y precio. La función debe retornar el total de las ventas.

> :black_joker: **PISTA**
Usa map para extraer los precios y reduce para sumarlos.

~~~dart
double totalVentas(List<Map<String, dynamic>> pedidos) {
  return pedidos.map((pedido) => pedido['precio'] as double).reduce((a, b) => a + b);
}

void main() {
  List<Map<String, dynamic>> pedidos = [
    {'producto': 'Big Mac', 'precio': 5.99},
    {'producto': 'McFlurry', 'precio': 2.99}
  ];
  print('Total de ventas: \$${totalVentas(pedidos).toStringAsFixed(2)}');
}
~~~