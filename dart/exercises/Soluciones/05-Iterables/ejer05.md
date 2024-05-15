# [Solución] Clientes del Banco Santander

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Ejercicio

Implementa una función llamada clientesPreferentes que reciba una lista de clientes del Banco Santander, donde cada cliente es un mapa que incluye nombre, saldo y tipoCuenta. La función debe retornar una

> :black_joker: **PISTA**
Usa map para extraer los precios y reduce para sumarlos.

~~~dart
List<String> clientesPreferentes(List<Map<String, dynamic>> clientes) {
  return clientes
    .where((cliente) => cliente['saldo'] > 5000)
    .map((cliente) => cliente['nombre'] as String)
    .toList();
}

void main() {
  List<Map<String, dynamic>> clientes = [
    {'nombre': 'Juan', 'saldo': 3000, 'tipoCuenta': 'Corriente'},
    {'nombre': 'María', 'saldo': 6000, 'tipoCuenta': 'Ahorro'},
    {'nombre': 'Luis', 'saldo': 7000, 'tipoCuenta': 'Corriente'}
  ];
  print('Clientes preferentes: ${clientesPreferentes(clientes)}');
}
~~~