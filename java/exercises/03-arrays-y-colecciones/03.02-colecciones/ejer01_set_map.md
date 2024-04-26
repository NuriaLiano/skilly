# Sistema de Gestión de Canales de YouTube

## Objetivo

Desarrollar una aplicación en Java que gestione canales de YouTube, permitiendo al usuario añadir y quitar canales, así como consultar videos populares. La aplicación debe utilizar colecciones para almacenar los canales de YouTube (asegurando que no haya duplicados) y  para asociar cada canal con sus videos más populares.

## Métodos

- agregarCanal(String nombreCanal): Añade un nuevo canal de YouTube a la colección. Si el canal ya existe, no debe ser añadido nuevamente.
- eliminarCanal(String nombreCanal): Elimina un canal de YouTube de la colección si este existe.
- agregarVideoACanal(String nombreCanal, String tituloVideo): Añade un video a un canal específico. Si el canal no existe, no hace nada.
- eliminarVideoACanal(String nombreCanal, String tituloVideo): Elimina un video de un canal específico, si el canal y el video existen.
- obtenerVideosPopulares(String nombreCanal): Devuelve una lista de videos populares para un canal específico.
- obtenerTodosLosCanales(): Devuelve un conjunto de todos los canales.

## Recomendaciones

- Asegúrate de manejar correctamente los casos en que se intenten añadir canales o videos que ya existen, o eliminar canales o videos que no existen.
- Prueba tu aplicación con varios canales y videos para asegurarte de que los métodos funcionan como se espera.

## Extra

- Validación de Entradas: Asegúrate de que tu aplicación maneje adecuadamente entradas inválidas, como cadenas vacías o nulas.
- Interfaz de Usuario: Considera desarrollar una sencilla interfaz de usuario en la consola para permitir al usuario interactuar con tu sistema de gestión de canales de YouTube.
- Pruebas: Incluye un conjunto de pruebas unitarias para asegurarte de que tus métodos funcionan correctamente bajo diferentes circunstancias.
