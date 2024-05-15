#  [Solución] Clase Básica de Usuario

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una clase llamada Usuario con campos para nombre y edad. Usa un constructor por defecto para inicializar estos campos.

> :black_joker: **PISTA**
> Define los campos de la clase y utiliza un constructor simple para inicializarlos.

~~~dar
class Usuario {
  String nombre;
  int edad;

  // Constructor por defecto
  Usuario(this.nombre, this.edad);
}

void main() {
  Usuario usuario = Usuario('Alice', 30);
  print(usuario.nombre); // Debe imprimir: Alice
  print(usuario.edad);   // Debe imprimir: 30

~~~