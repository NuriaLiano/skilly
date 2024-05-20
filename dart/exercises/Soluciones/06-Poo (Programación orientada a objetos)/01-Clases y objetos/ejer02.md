#  [Solución] Clase Básica de Usuario

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una clase Producto con un campo privado _precio. Añade un setter que no permita asignar valores negativos al precio y un getter para obtener el valor del precio.

> :black_joker: **PISTA**
> Recuerda que los setters pueden incluir lógica para validar o modificar el valor antes de asignarlo a una variable.

~~~dar
class Producto {
  // Campo privado
  double _precio;

  // Constructor
  Producto(this._precio);

  // Setter para 'precio' que valida el valor antes de asignarlo
  set precio(double nuevoPrecio) {
    if (nuevoPrecio >= 0) {
      _precio = nuevoPrecio;
    } else {
      print('El precio no puede ser negativo.');
    }
  }

  // Getter para 'precio'
  double get precio => _precio;
}

void main() {
  Producto producto = Producto(50);
  print('Precio: ${producto.precio}'); // Debe imprimir: Precio: 50

  producto.precio = -10;  // Intenta establecer un precio negativo, debería mostrar un mensaje de error
  print('Precio: ${producto.precio}'); // Debe imprimir: Precio: 50
}
~~~