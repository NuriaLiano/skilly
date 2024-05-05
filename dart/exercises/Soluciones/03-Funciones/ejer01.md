#  [Solución] Calculadora de Impuestos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Diseña una función llamada calculaImpuestos que calcule el monto de impuestos a pagar sobre un salario dado. Imagina que estás desarrollando una herramienta de software para un departamento de contabilidad.

> :black_joker: **PISTA**
> Utiliza una fórmula de cálculo de impuestos (por ejemplo, el 10% del salario).

~~~dart
double calculaImpuestos(double salario) {
  // Definimos la tasa de impuestos como el 10%
  double tasaImpuestos = 0.10;
  
  // Calculamos el monto de impuestos aplicando la tasa al salario
  double impuestos = salario * tasaImpuestos;
  
  return impuestos;
}

void main() {
  double salario = 3000; // Ejemplo de salario
  double impuestos = calculaImpuestos(salario);
  
  print('Los impuestos a pagar son: \$$impuestos');
}
~~~
