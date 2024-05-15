# [Solución] Conteo de votos

Espero que lo hayas podido resolver pero si se te ha hecho cuesta arriba no te preocupes, tienes que ir cogiendo la dinámica. Revisa el código, pruébalo y si tienes cualquier duda preguntanos en **hola@skilly.es** o en a través de **Whatsapp**.
¡No te quedes con dudas!

## Solución

Crea una función llamada contarVotos que reciba una lista de nombres de candidatos y devuelva un mapa con el total de votos que recibió cada candidato.

> :black_joker: **PISTA**
Utiliza un mapa para contabilizar los votos, donde las claves son los nombres de los candidatos y los valores son el total de votos que cada uno recibió. Si el nombre del candidato ya existe en el mapa, incrementa su conteo de votos.

~~~dart
Map<String, int> contarVotos(List<String> votos) {
  Map<String, int> resultado = {};
  for (var voto in votos) {
    if (!resultado.containsKey(voto)) {
      resultado[voto] = 1;
    } else {
      resultado[voto] += 1;
    }
  }
  return resultado;
}

void main() {
  List<String> votos = ["Ana", "Carlos", "Marta", "Ana", "Marta", "Marta"];
  print(contarVotos(votos));
}
~~~