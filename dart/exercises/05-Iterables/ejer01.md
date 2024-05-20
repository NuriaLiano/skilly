# [Solución] Inventario de IKEA

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una función llamada totalProductos que tome una lista de productos de IKEA donde cada producto es un mapa con nombre, cantidad y sección. La función debe retornar el total de productos en la sección de "Muebles".

> :black_joker: **PISTA**
Utiliza métodos de Iterable como where para filtrar y fold para sumar.

~~~dart
int totalProductos(List<Map<String, dynamic>> productos) {
  return productos
    .where((producto) => producto['sección'] == 'Muebles')
    .fold(0, (total, current) => total + current['cantidad']);
}

void main() {
  List<Map<String, dynamic>> productos = [
    {'nombre': 'Mesa', 'cantidad': 10, 'sección': 'Muebles'},
    {'nombre': 'Lámpara', 'cantidad': 15, 'sección': 'Iluminación'},
    {'nombre': 'Silla', 'cantidad': 25, 'sección': 'Muebles'}
  ];
  print('Total de productos en Muebles: ${totalProductos(productos)}');
}
~~~