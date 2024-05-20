#  [Solución] Constructor Factory

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Implementa un constructor factory en la clase Ventana que devuelva instancias de diferentes tipos de ventanas basado en un parámetro de tipo.

> :black_joker: **PISTA**
> Utiliza un constructor factory para decidir qué subclase de Ventana instanciar basado en el parámetro dado.

~~~dart
class Ventana {
  String tipo;

  Ventana(this.tipo);

  factory Ventana.crear(String tipo) {
    return Ventana(tipo);
  }
}

void main() {
  Ventana ventana = Ventana.crear('deslizante');
  print(ventana.tipo);
}
~~~