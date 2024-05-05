# [Solución]  El Show de Talentos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Estás organizando un show de talentos en tu comunidad y necesitas un programa para manejar las actuaciones de los participantes. Escribe un programa que muestre el nombre y el talento de cada participante en el orden de su actuación.

> :black_joker: **PISTA**
> Utiliza un bucle for para recorrer la lista de participantes y mostrar sus actuaciones en orden.

~~~dart
void main() {
  List<String> participantes = ['Juan', 'María', 'Pedro'];
  List<String> talentos = ['Malabares con pelotas', 'Canto', 'Baile'];

  print('¡Bienvenidos al show de talentos!');
  for (int i = 0; i < participantes.length; i++) {
    print('Actuación de ${participantes[i]}: ${talentos[i]}');
  }
}
~~~

