#  [Solución] Generador de Recetas de Cocina

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe una función llamada generarReceta que reciba como parámetro el tipo de plato deseado (por ejemplo, postre, plato principal, etc.) y genere una receta aleatoria para ese tipo de plato.

> :black_joker: **PISTA**
> Crea listas de ingredientes y pasos de preparación para cada tipo de plato y elige aleatoriamente uno de ellos.

~~~dart
import 'dart:math';

String generarReceta(String tipoPlato) {
  // Definir listas de ingredientes y pasos de preparación para cada tipo de plato
  Map<String, List<String>> recetas = {
    'postre': ['harina', 'azúcar', 'huevos', 'leche', 'mantequilla', 'vainilla', 'levadura'],
    'plato principal': ['pollo', 'arroz', 'verduras', 'aceite de oliva', 'sal', 'pimienta'],
    'ensalada': ['lechuga', 'tomate', 'pepino', 'cebolla', 'aceitunas', 'vinagre', 'aceite'],
    'sopa': ['zanahoria', 'cebolla', 'patata', 'caldo de pollo', 'sal', 'pimienta', 'perejil']
  };

  // Verificar si el tipo de plato está en la lista de recetas
  if (!recetas.containsKey(tipoPlato)) {
    return 'Lo siento, no tenemos recetas para ese tipo de plato.';
  }

  // Elegir aleatoriamente una receta para el tipo de plato dado
  List<String> ingredientes = recetas[tipoPlato];
  List<String> pasos = [
    'Lava y prepara todos los ingredientes.',
    'Combina los ingredientes según las instrucciones.',
    'Cocina la mezcla a fuego medio durante 20 minutos.',
    'Sirve caliente y ¡disfruta!'
  ];

  // Construir la receta aleatoria
  String receta = 'Receta de $tipoPlato:\n\nIngredientes:\n';
  for (String ingrediente in ingredientes) {
    receta += '- $ingrediente\n';
  }
  receta += '\nPasos de preparación:\n';
  for (String paso in pasos) {
    receta += '- $paso\n';
  }

  return receta;
}

void main() {
  String tipoPlato = 'plato principal'; // Tipo de plato deseado
  String recetaGenerada = generarReceta(tipoPlato);
  print(recetaGenerada);
}
~~~
