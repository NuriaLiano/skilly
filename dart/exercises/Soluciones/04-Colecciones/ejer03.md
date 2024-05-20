# [Solución] Organización de Eventos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada organizarEventos que reciba una lista de eventos, donde cada evento es un mapa que incluye detalles como nombre y número de asistentes, y devuelva un mapa de eventos organizados por número de asistentes.

~~~dart
Map<String, List<Map<String, dynamic>>> organizarEventos(List<Map<String, dynamic>> eventos) {
  Map<String, List<Map<String, dynamic>>> organizados = {"Pequeño": [], "Mediano": [], "Grande": []};
  for (var evento in eventos) {
    if (evento['asistentes'] < 50) {
      organizados["Pequeño"].add(evento);
    } else if (evento['asistentes'] >= 50 && evento['asistentes'] <= 200) {
      organizados["Mediano"].add(evento);
    } else {
      organizados["Grande"].add(evento);
    }
  }
  return organizados;
}

void main() {
  List<Map<String, dynamic>> eventos = [
    {"nombre": "Concierto", "asistentes": 150},
    {"nombre": "Conferencia", "asistentes": 300},
    {"nombre": "Meetup", "asistentes": 45}
  ];
  print(organizarEventos(eventos));
}
~~~