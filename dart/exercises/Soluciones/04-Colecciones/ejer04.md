# [Solución] Filtrado de Números Únicos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe una función llamada filtrarUnicos que tome una lista de números enteros, algunos de los cuales se repiten, y retorne una lista de números sin duplicados, conservando el orden original en que aparecen por primera vez.

> :black_joker: **PISTA**
Puedes utilizar un conjunto para ayudar a identificar los elementos únicos y una lista para mantener el orden de aparición.

~~~dart
List<int> filtrarUnicos(List<int> numeros) {
  var resultado = <int>[];
  var visto = Set<int>();

  for (var numero in numeros) {
    if (!visto.contains(numero)) {
      resultado.add(numero);
      visto.add(numero);
    }
  }
  return resultado;
}

void main() {
  print(filtrarUnicos([1, 3, 5, 3, 7, 9, 1]));  // Output: [1, 3, 5, 7, 9]
}
~~~