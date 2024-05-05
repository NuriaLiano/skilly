#  [Solución] Gestión de Inventarios

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña una función llamada actualizarInventario que reciba como parámetro una lista de productos y sus cantidades y actualice el inventario de una tienda. La función debe tomar en cuenta las existencias actuales y sumar las nuevas cantidades de productos.

> :black_joker: **PISTA**
> Utiliza un mapa para representar el inventario, donde las claves son los nombres de los productos y los valores son las cantidades disponibles. Luego, actualiza este mapa según las nuevas cantidades proporcionadas.

~~~dart
Map<String, int> actualizarInventario(Map<String, int> inventario, Map<String, int> nuevasExistencias) {
  nuevasExistencias.forEach((producto, cantidad) {
    if (inventario.containsKey(producto)) {
      inventario[producto] += cantidad;
    } else {
      inventario[producto] = cantidad;
    }
  });
  return inventario;
}

void main() {
  Map<String, int> inventarioActual = {
    'Manzanas': 20,
    'Plátanos': 15,
    'Naranjas': 10,
  };

  Map<String, int> nuevasExistencias = {
    'Manzanas': 5,
    'Peras': 8,
  };

  Map<String, int> inventarioActualizado = actualizarInventario(inventarioActual, nuevasExistencias);

  print('Inventario actualizado:');
  inventarioActualizado.forEach((producto, cantidad) {
    print('$producto: $cantidad');
  });
}
~~~
