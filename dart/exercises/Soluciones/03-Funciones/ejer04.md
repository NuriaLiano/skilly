#  [Solución] Convertidor de Temperatura

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe una función llamada celsiusToFahrenheit que convierta una temperatura dada en grados Celsius a grados Fahrenheit. 

> :black_joker: **PISTA**
> Utiliza la fórmula de conversión: °F = °C * 9/5 + 32.

~~~dart
double celsiusToFahrenheit(double temperaturaCelsius) {
  return temperaturaCelsius * 9 / 5 + 32;
}

void main() {
  double temperaturaCelsius = 25.0; // Temperatura en grados Celsius
  double temperaturaFahrenheit = celsiusToFahrenheit(temperaturaCelsius);

  print('La temperatura en Fahrenheit es: $temperaturaFahrenheit');
}
~~~
