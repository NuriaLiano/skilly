#  [Solución] Constructor con Parámetros

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Diseña una clase Libro que tenga un constructor con parámetros para inicializar el título y el autor del libro.

~~~dart
class Libro {
  String titulo;
  String autor;

  // Constructor con parámetros
  Libro(this.titulo, this.autor);
}

void main() {
  Libro libro = Libro('1984', 'George Orwell');
  print(libro.titulo);  // Debe imprimir: 1984
  print(libro.autor);   // Debe imprimir: George Orwell
}
~~~