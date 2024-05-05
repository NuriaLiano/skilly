#  [Solución] Comprobador de Palíndromos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada esPalindromo que reciba una cadena como parámetro y devuelva true si la cadena es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda) y false en caso contrario.

> :black_joker: **PISTA**
>  Puedes usar la función split('').reversed.join('') para invertir la cadena.

~~~dart
bool esPalindromo(String cadena) {
  // Convertimos la cadena a minúsculas y eliminamos los espacios en blanco
  cadena = cadena.toLowerCase().replaceAll(' ', '');
  
  // Invertimos la cadena
  String cadenaInvertida = cadena.split('').reversed.join('');
  
  // Comparamos la cadena original con la invertida para determinar si es un palíndromo
  return cadena == cadenaInvertida;
}

void main() {
  String palabra = 'Anita lava la tina'; // Ejemplo de cadena
  bool resultado = esPalindromo(palabra);
  
  print('¿Es un palíndromo? $resultado');
}
~~~
