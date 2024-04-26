# Ejercicio de Pasapalabra

## Objetivo

El objetivo de este ejercicio es desarrollar una breve simulación del juego del rosco del programa de televisión "Pasapalabra". La aplicación permitirá a un jugador responder a una serie de preguntas, las cuales están asociadas a letras del alfabeto. El objetivo es simular la mecánica del juego, donde cada respuesta correcta, incorrecta o pasada (pasapalabra) modificará el estado de la pregunta.

## Clases y métodos necesarios

### Clase Pregunta

- Constructor: Inicializa el objeto con Identificador, Enunciado y Respuesta. Respuesta_correcta se inicializa en "Azul".
- cambiaRespuestaCorrecta: Cambia el estado de Respuesta_correcta a "Verde".
- cambiaRespuestaIncorrecta: Cambia el estado de Respuesta_correcta a "Rojo".
- cambiaPasapalabra: Reestablece el estado de Respuesta_correcta a "Azul".
- getIdentificador: Retorna el identificador.
- getEnunciado: Retorna el enunciado.
- getRespuesta: Retorna la respuesta.
- getRespuesta_correcta: Retorna el estado de la pregunta.

### Clase GeneraListaPreguntas

- Constructor: Crea y carga cinco objetos de tipo pregunta en la lista.
- getLista: Devuelve la lista con las preguntas cargadas.

### Clase ProtoPasapalabra

- Utiliza un objeto de tipo GeneraListaPreguntas para que el jugador responda a las preguntas.
- Modifica el estado de las preguntas según las respuestas del jugador.
- Al final, muestra el estado de cada pregunta respondida por el jugador.

## Ejemplo de ejecución

~~~sh
Resultado del Juego del Rosco de Pasapalabra:
-----------------------------------------------
A: Arquitectura - Estado: Verde (Correcto)
B: Biblioteca - Estado: Rojo (Incorrecto)
C: Cetáceo - Estado: Azul (Pasapalabra)
D: Diamante - Estado: Verde (Correcto)
E: Eucalipto - Estado: Rojo (Incorrecto)
Y así sucesivamente para el resto de las letras.

Resumen del juego:
Preguntas totales: 5
Respuestas correctas: 2
Respuestas incorrectas: 2
Pasapalabras: 1
~~~
