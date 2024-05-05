#  [Solución] Validador de Correos Electrónicos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Escribe una función llamada esCorreoValido que verifique si una dirección de correo electrónico dada es válida.

> :black_joker: **PISTA**
> Utiliza expresiones regulares para validar el formato del correo electrónico.
> r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'

~~~dart
bool esCorreoValido(String correo) {
  // Expresión regular para validar el formato del correo electrónico
  RegExp regex = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
  
  // Verificar si el correo coincide con el formato esperado
  return regex.hasMatch(correo);
}

void main() {
  String correo = 'usuario@example.com'; // Ejemplo de dirección de correo electrónico
  bool resultado = esCorreoValido(correo);
  
  print('¿Es un correo electrónico válido? $resultado');
}
~~~
