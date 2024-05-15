#  [Solución] Uso de Getters y Setters en Clase Persona

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una clase Persona con campos privados _nombre y _edad. Usa getters y setters para asegurarte de que el nombre siempre se almacene en mayúsculas y la edad no pueda ser negativa.

~~~dart
class Persona {
  String _nombre;
  int _edad;

  set nombre(String nombre) {
    _nombre = nombre.toUpperCase();
  }

  set edad(int edad) {
    _edad = edad < 0 ? 0 : edad;
  }

  String get nombre => _nombre;
  int get edad => _edad;
}

void main() {
  Persona persona = Persona();
  persona.nombre = 'john';
  persona.edad = -5;
  print(persona.nombre);
  print(persona.edad);
}
~~~