# [Solución] Registro de Temperaturas

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña una función llamada registrarTemperaturas que tome como parámetro una lista de temperaturas y las clasifique según rangos en un mapa.

> :black_joker: **PISTA**
Usa un mapa para categorizar las temperaturas en 'Bajo', 'Medio', y 'Alto'. Itera sobre la lista de temperaturas y clasifícalas en el mapa según el rango al que pertenecen.

~~~dart
Map<String, int> registrarTemperaturas(List<int> temperaturas) {
  Map<String, int> categorias = {"Bajo": 0, "Medio": 0, "Alto": 0};
  for (var temp in temperaturas) {
    if (temp < 15) {
      categorias["Bajo"] += 1;
    } else if (temp >= 15 && temp <= 25) {
      categorias["Medio"] += 1;
    } else {
      categorias["Alto"] += 1;
    }
  }
  return categorias;
}

void main() {
  List<int> temperaturas = [10, 20, 30, 15, 25, 5, 35];
  print(registrarTemperaturas(temperaturas));
}
~~~