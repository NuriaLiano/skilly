#  [Solución] Constructor Semántico en Clase Vehículo

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Implementa una clase Vehículo con diferentes constructores nombrados para crear un vehículo como carro, bicicleta o motocicleta.

> :black_joker: **PISTA**
> Cada constructor nombrado puede inicializar la instancia de Vehículo con diferentes valores predeterminados para propiedades como tipo y ruedas

~~~dart
class Vehiculo {
  String tipo;
  int ruedas;

  Vehiculo.carro() : tipo = 'Carro', ruedas = 4;
  Vehiculo.bicicleta() : tipo = 'Bicicleta', ruedas = 2;
  Vehiculo.motocicleta() : tipo = 'Motocicleta', ruedas = 2;
}

void main() {
  Vehiculo carro = Vehiculo.carro();
  Vehiculo bicicleta = Vehiculo.bicicleta();
  Vehiculo motocicleta = Vehiculo.motocicleta();
  print('Tipo: ${carro.tipo}');
  print('Tipo: ${bicicleta.tipo}');
  print('Tipo: ${motocicleta.tipo}');
}
~~~