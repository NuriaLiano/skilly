#  [Solución] Contador de Vocales

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada cuentaVocales que cuente el número de vocales en una cadena dada.

> :black_joker: **PISTA**
>  Utiliza un bucle for para recorrer la cadena y un contador para contar las vocales.

~~~dart
int cuentaVocales(String cadena) {
  int contador = 0;

  // Convertimos la cadena a minúsculas para simplificar la comparación
  cadena = cadena.toLowerCase();

  // Iteramos sobre cada caracter de la cadena
  for (int i = 0; i < cadena.length; i++) {
    // Verificamos si el caracter es una vocal
    if (cadena[i] == 'a' || cadena[i] == 'e' || cadena[i] == 'i' || cadena[i] == 'o' || cadena[i] == 'u') {
      contador++;
    }
  }

  return contador;
}

void main() {
  String texto = 'Hola Mundo'; // Ejemplo de cadena
  int numeroVocales = cuentaVocales(texto);

  print('El número de vocales en "$texto" es: $numeroVocales');
}

~~~
