# [Solución]  Números pares

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Estás debatiendo con un amigo cuales serían los 5 primeros números pares. Sabes que tienes razón y quiere demostrárselo a tu amigo de una forma par-ticular. Escribe un programa que genere los 5 primeros números pares e imprime cada número par generado para callar a tu amigo y llevarte la razón. ¡No te preocupes, no necesitas ser un genio matemático para participar!"
Escribe un programa que genere los primeros 5 números pares. 

> :black_joker: **PISTA**
> Utiliza una variable de iteración para generar los números pares y una condición dentro del bucle para detenerlo después de generar la cantidad deseada.

~~~dart
void main() {
  int contador = 0;
  int numero = 2;

  print('Los primeros 5 números pares son:');
  while (contador < 5) {
    print(numero);
    numero += 2;
    contador++;
  }
}
~~~

