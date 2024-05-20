# [Solución] Diferencia de Listas

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada diferenciaDeListas que reciba dos listas y retorne una lista que contenga solo los elementos que están en la primera lista pero no en la segunda.

> :black_joker: **PISTA**
Utiliza las operaciones de conjuntos para calcular la diferencia, y luego convierte el resultado de vuelta a una lista para el retorno.

~~~dart
List<T> diferenciaDeListas<T>(List<T> listaA, List<T> listaB) {
  var conjuntoB = listaB.toSet();
  return listaA.where((item) => !conjuntoB.contains(item)).toList();
}

void main() {
  print(diferenciaDeListas([1, 2, 3, 4, 5], [4, 5, 6, 7, 8]));  // Output: [1, 2, 3]
}
~~~