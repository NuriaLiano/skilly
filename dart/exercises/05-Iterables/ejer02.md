# [Solución] Entradas para el Concierto de Melendi

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Implementa una función llamada entradasVendidas que reciba una lista de entradas vendidas para el concierto de Melendi, cada una con un sector. La función debe retornar un mapa con la cantidad de entradas vendidas por sector.

> :black_joker: **PISTA**
Utiliza groupBy para agrupar las entradas por sector y map para contarlas.


## Ejemplo de ejecución

~~~dart
Map<String, int> entradasVendidas(List<Map<String, String>> entradas) {
  Map<String, int> resultado = {};
  for (var entrada in entradas) {
    resultado.update(entrada['sector'], (value) => value + 1, ifAbsent: () => 1);
  }
  return resultado;
}

void main() {
  List<Map<String, String>> entradas = [
    {'sector': 'General'}, {'sector': 'VIP'}, {'sector': 'General'}
  ];
  print('Entradas vendidas por sector: ${entradasVendidas(entradas)}');
}
~~~