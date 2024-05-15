# [Solución] Asistencia al Partido del FC Barcelona

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Escribe una función llamada asistenciaPartido que tome una lista de asistentes al partido del FC Barcelona, donde cada asistente es un mapa que incluye edad y sector. La función debe retornar el promedio de edad de los asistentes.

> :black_joker: **PISTA**
Combina map para extraer las edades y reduce para calcular el promedio.

~~~dart
double asistenciaPartido(List<Map<String, dynamic>> asistentes) {
  var totalEdad = asistentes.fold(0, (sum, next) => sum + next['edad']);
  return totalEdad / asistentes.length;
}

void main() {
  List<Map<String, dynamic>> asistentes = [
    {'edad': 25, 'sector': 'Norte'}, {'edad': 34, 'sector': 'Sur'}, {'edad': 29, 'sector': 'Este'}
  ];
  print('Promedio de edad de los asistentes: ${asistenciaPartido(asistentes).toStringAsFixed(2)}');
}
~~~