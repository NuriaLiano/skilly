# Aventuras en el Laberinto Encantado

## Objetivo

El objetivo de la aplicación "Aventuras en el Laberinto Encantado" es proporcionar una experiencia interactiva y divertida al usuario, donde este debe navegar a través de un laberinto lleno de misterios, puzzles y criaturas fantásticas. El jugador utilizará una serie de comandos para explorar habitaciones, interactuar con objetos y personajes, y resolver acertijos para avanzar en el juego.

## Clases y métodos

### PalabrasComando

Esta clase gestiona los comandos que el jugador puede utilizar en el juego. Contiene una lista de comandos válidos (como "ir", "fin", "ayuda", "mirar") y proporciona métodos para verificar si una cadena de texto es un comando válido y para mostrar todos los comandos disponibles junto con una descripción de su uso.

- **Atributos**: Incluye constantes para los comandos "ir", "fin", "ayuda", y "mirar".
- **Métodos**:
  - **esComando(String comando)**: Retorna true si el comando es reconocido por la aplicación; de lo contrario, retorna false.
  - **mostrarTodos()**: Muestra todos los comandos disponibles y una breve descripción de su uso.

### Comando

Representa un comando ingresado por el jugador, dividido en una palabra principal (el comando) y una palabra secundaria (usualmente un complemento o dirección). Proporciona métodos para obtener estas palabras y verificar si el comando y la palabra secundaria están presentes.

- **Atributos**: Dos cadenas comando y segundaPalabra.
- **Métodos**:
  - **Constructor completo**.
  - **Getters para ambas propiedades**.
  - **hayComando()**: Retorna true si comando no es nulo y es una PalabraComando válida.
  - **haySegundaPalabra()**: Retorna true si segundaPalabra no es nula.

### Transformar

Esta clase se utiliza para convertir una entrada de texto del jugador en un objeto Comando. Se encarga de analizar la cadena de texto ingresada y verificar si corresponde a un comando válido, y luego lo descompone en la acción principal y sus complementos si es necesario.

- **Atributos**: PalabraComando palabraComando.
- **Métodos**:
  - **Constructor por defecto**.
  - **getCommand(String entradaUsuario)**: Toma una entrada del usuario, la divide en dos Strings y verifica si son comandos válidos, luego retorna un objeto Comando.

### Habitación

Define las áreas individuales dentro del laberinto, cada una con su propia descripción y posibles salidas a otras habitaciones. Incluye métodos para establecer estas salidas, obtener una descripción larga de la habitación que incluya posibles direcciones de salida y obtener la habitación que se encuentra en una dirección específica.

- **Atributos**: Descripción, y referencias a otras Habitaciones (norte, sur, este, oeste).
- **Métodos**:
  - **Constructor que recibe la descripción**.
  - **setSalida(String dirección, Habitación habitación)**.
  - **Getters para ambas propiedades**.
  - **getDescripciónLarga()**: Muestra la descripción de la habitación y las salidas posibles.
  - **getStringDeSalidas()**: Retorna las salidas posibles de la habitación.
  - **getSalida(String dirección)**: Retorna la habitación correspondiente a la dirección dada.

### Subclases de Habitación

Implementa al menos dos subclases que añadan características específicas (como un cofre o una trampa).
Estas clases son extensiones de la clase Habitación y añaden características especiales o elementos adicionales a ciertas habitaciones, como cofres, trampas, o enemigos. Se utilizan para personalizar la experiencia en diferentes áreas del laberinto.

Métodos según las características añadidas y constructor que incluya estas nuevas propiedades.

### Juego

Es la clase principal que controla la lógica del juego. Mantiene la pista de la ubicación actual del jugador en el laberinto, procesa los comandos ingresados por el jugador y ejecuta las acciones correspondientes. Además, inicializa el laberinto y maneja la secuencia de juego principal, incluidas la bienvenida, la solicitud de comandos y la ejecución de estos.

- **Atributos**: Transformar transformar y Habitacion habitacionActual.
- **Métodos**:
  - **Constructor por defecto que inicializa el laberinto.**.
  - **crearHabitaciones()**: Define el laberinto y sus conexiones.
  - **juego()**: Bucle principal del juego.
  - **bienvenido()**: Muestra las instrucciones del juego.
  - **procesarComando(Comando c)**: Procesa el comando ingresado por el usuario
  - **Métodos específicos para cada comando (ayuda, irA, fin, luz)**.

### Run

Esta es la clase que pone en marcha el juego. Crea una instancia del juego y comienza el bucle principal del juego, actuando como punto de entrada para que el jugador empiece a explorar el laberinto.

- Inicia el juego creando una instancia de Juego y llamando al método juego().

## Recomendaciones

- Asegúrate de que el código esté bien organizado y siga buenas prácticas de programación, evitando redundancias y errores.
- Utiliza la herencia de manera efectiva para extender la funcionalidad de las clases base.
- Diseña un laberinto que sea interesante de explorar, con al menos 10 habitaciones y caminos que despierten la curiosidad del jugador.
- Añade funcionalidades adicionales a los comandos básicos para enriquecer la experiencia del usuario.
Considera implementar varios finales para aumentar la rejugabilidad del juego.