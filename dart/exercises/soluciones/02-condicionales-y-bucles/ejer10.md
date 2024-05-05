# [Solución]  El Viaje en Tren

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Estás planeando un emocionante viaje en tren y necesitas un programa para ayudarte a elegir el destino correcto. Escribe un programa que solicite al usuario ingresar un número que represente diferentes destinos en el tren. Muestra información sobre el destino seleccionado, como la duración del viaje, los lugares de interés y las actividades disponibles.

> :black_joker: **PISTA**
> Utiliza una declaración switch para manejar diferentes opciones de destino y mostrar información correspondiente a cada destino seleccionado.

~~~dart
void main() {
  print('¡Bienvenido al Viaje en Tren!');
  print('Selecciona tu destino:');
  print('1. París');
  print('2. Roma');
  print('3. Berlín');
  stdout.write('Por favor, ingresa el número de tu destino: ');
  int destino = int.parse(stdin.readLineSync()!);

  switch (destino) {
    case 1:
      print('¡Destino seleccionado: París!');
      print('Duración del viaje: 6 horas');
      print('Lugares de interés: Torre Eiffel, Museo del Louvre, Notre Dame');
      print('Actividades disponibles: Cruceros por el Sena, Cata de vinos');
      break;
    case 2:
      print('¡Destino seleccionado: Roma!');
      print('Duración del viaje: 8 horas');
      print('Lugares de interés: Coliseo, Fontana di Trevi, Vaticano');
      print('Actividades disponibles: Tours históricos, Degustación de gelato');
      break;
    case 3:
      print('¡Destino seleccionado: Berlín!');
      print('Duración del viaje: 10 horas');
      print('Lugares de interés: Puerta de Brandeburgo, Muro de Berlín, Museo de Pérgamo');
      print('Actividades disponibles: Recorridos en bicicleta, Visitas a museos');
      break;
    default:
      print('Destino inválido. Por favor, selecciona un número del 1 al 3.');
  }
}
~~~
