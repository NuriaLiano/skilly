#  [Solución] Constructor Constante

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una clase `Punto` con campos `x` e `y`. Implementa un constructor constante para que las instancias de `Punto` puedan ser constantes si se pasan valores constantes.

> :black_joker: **PISTA**
> Utiliza la palabra clave `const` en el constructor para permitir la creación de instancias inmutables.

~~~dart
class Punto {
  final int x;
  final int y;

  const Punto(this.x, this.y);
}

void main() {
  const punto = Punto(2, 3);
  print('punto x: ${punto.x}');
  print('punto y: ${punto.y}');
}
~~~