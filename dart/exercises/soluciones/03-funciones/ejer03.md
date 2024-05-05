#  [Solución] Generador de Contraseñas Aleatorias

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña una función llamada generaContraseña que genere una contraseña aleatoria de longitud variable.

> :black_joker: **PISTA**
> Utiliza la clase Random para generar caracteres aleatorios y crea una cadena con ellos

~~~dart
import 'dart:math';

String generaContraseña(int longitud) {
  const caracteres =
      'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
  Random random = Random();
  String contraseña = '';

  for (int i = 0; i < longitud; i++) {
    int indice = random.nextInt(caracteres.length);
    contraseña += caracteres[indice];
  }

  return contraseña;
}

void main() {
  int longitud = 8; // Longitud de la contraseña
  String contraseña = generaContraseña(longitud);

  print('La contraseña generada es: $contraseña');
}
~~~
