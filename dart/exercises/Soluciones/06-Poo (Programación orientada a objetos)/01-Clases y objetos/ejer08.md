#  [Solución] Clase con Métodos y Campos Encapsulados

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Diseña una clase Motor que tenga un campo privado _temperatura y métodos para aumentarTemperatura y enfriar.

> :black_joker: **PISTA**
> Asegúrate de que la temperatura no exceda ciertos límites al aumentar o disminuir.

~~~dart
class Motor {
  int _temperatura = 20;

  void aumentarTemperatura(int incremento) {
    _temperatura += incremento;
  }

  void enfriar(int decremento) {
    _temperatura -= decremento;
  }

  int get temperatura => _temperatura;
}

void main() {
  Motor motor = Motor();
  motor.aumentarTemperatura(100);
  motor.enfriar(20);
  print('Temperatura del motor: ${motor.temperatura}');
}
~~~