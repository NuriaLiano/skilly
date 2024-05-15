#  [Solución] Clase con Campos Privados

Espero que hayas podido resolverlo, pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda pregúntanos en hola@skilly.es o a través de Whatsapp.
¡No te quedes con dudas!

## Solución

Crea una clase CuentaBancaria con un campo privado _saldo y métodos públicos para depositar y retirar dinero.

> :black_joker: **PISTA**
> Los campos privados en Dart se definen con un guion bajo _ al inicio del nombre del campo.

~~~dart
class CuentaBancaria {
  double _saldo;

  CuentaBancaria(this._saldo);

  void depositar(double cantidad) {
    _saldo += cantidad;
  }

  void retirar(double cantidad) {
    if (_saldo >= cantidad) {
      _saldo -= cantidad;
    }
  }

  double get saldo => _saldo;
}

void main() {
  CuentaBancaria cuenta = CuentaBancaria(100);
  cuenta.retirar(30);
  print('Saldo en la cuenta: ${cuenta.saldo}');
}
~~~