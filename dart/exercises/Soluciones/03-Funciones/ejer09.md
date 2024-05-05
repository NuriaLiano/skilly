#  [Solución] Calculadora de Estadísticas de Estudiantes

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña una función llamada calcularEstadisticas que reciba una lista de calificaciones de estudiantes y devuelva varias estadísticas útiles, como el promedio, la calificación más alta y la más baja.

> :black_joker: **PISTA**
> Utiliza métodos de la lista, como reduce, para calcular el promedio y las funciones max y min para encontrar las calificaciones más altas y más bajas. 

~~~dart
double calcularPromedio(List<int> calificaciones) {
  double suma = calificaciones.reduce((value, element) => value + element);
  return suma / calificaciones.length;
}

int encontrarCalificacionMaxima(List<int> calificaciones) {
  return calificaciones.reduce((value, element) => value > element ? value : element);
}

int encontrarCalificacionMinima(List<int> calificaciones) {
  return calificaciones.reduce((value, element) => value < element ? value : element);
}

void main() {
  List<int> calificaciones = [80, 90, 75, 85, 95];
  double promedio = calcularPromedio(calificaciones);
  int calificacionMaxima = encontrarCalificacionMaxima(calificaciones);
  int calificacionMinima = encontrarCalificacionMinima(calificaciones);

  print('Promedio: $promedio');
  print('Calificación más alta: $calificacionMaxima');
  print('Calificación más baja: $calificacionMinima');
}
~~~
