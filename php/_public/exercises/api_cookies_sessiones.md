# Ejercicio de Programación PHP: Sistema de Consulta del Clima con Favoritos

Desarrolla un sistema web en PHP que permita a los usuarios consultar el clima actual de diferentes ciudades utilizando una API externa, guardar sus ciudades favoritas en una base de datos, y recordar su última búsqueda a través de sesiones y cookies. El sistema debe cumplir con las siguientes especificaciones:

## Formulario de Búsqueda

Implementa un formulario HTML que permita a los usuarios introducir el nombre de una ciudad para consultar su clima.

## Petición a la API de Clima

Utiliza cURL o file_get_contents para realizar una petición GET a una API de clima como OpenWeatherMap, y muestra la información del clima (temperatura, humedad, etc.) de la ciudad buscada.

## Manejo de Sesiones y Cookies

Implementa sesiones para mantener el estado de la sesión del usuario.
Usa cookies para recordar la última ciudad buscada por el usuario durante 30 días.

## Base de Datos

Crea una tabla ciudades_favoritas que contenga al menos las columnas id, nombre_ciudad, y usuario_id.
Implementa funcionalidades para que los usuarios puedan añadir o remover ciudades de su lista de favoritos.

## Consulta a la Base de Datos

Realiza consultas SELECT para mostrar las ciudades favoritas del usuario.

## Consideraciones Adicionales

Asegúrate de manejar errores y excepciones adecuadamente, especialmente al realizar peticiones a la API y al interactuar con la base de datos.
Implementa medidas de seguridad para prevenir inyecciones SQL y asegura que el manejo de sesiones y cookies sea seguro.
Organiza tu código de manera clara y mantenible, utilizando funciones o clases según sea apropiado.