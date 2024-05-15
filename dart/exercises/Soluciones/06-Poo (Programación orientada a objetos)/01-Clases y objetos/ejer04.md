#  [Solución] Constructor Semántico

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

En una clase Empleado, crea un constructor semántico que permita crear un Empleado a tiempo completo o parcial.

> :black_joker: **PISTA**
> Utiliza constructores nombrados para crear diferentes versiones del objeto basado en el tipo de empleo

~~~dart
class Empleado {
  String nombre;
  String tipo;

  Empleado.tiempoCompleto(this.nombre) : tipo = 'Tiempo Completo';
  Empleado.tiempoParcial(this.nombre) : tipo = 'Tiempo Parcial';
}

void main() {
  Empleado john = Empleado.tiempoCompleto('John');
  Empleado doe = Empleado.tiempoParcial('Doe');
  print(john.nombre);
  print(doe.nombre);
}
~~~