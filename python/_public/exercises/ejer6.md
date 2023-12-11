# Ejercicio: Sistema de Gestión de Biblioteca

**Objetivo:** Crear un sistema simple para gestionar libros en una biblioteca.

**Descripción:**

1. **Crear un diccionario de libros:** Cada libro tendrá un `ID` único como clave y un diccionario como valor. Este diccionario interno incluirá detalles como el `título` del libro y si está `disponible` o no (booleano).

2. **Listar libros disponibles:** Usar un bucle `for` para recorrer el diccionario de libros y mostrar los libros que están disponibles.

3. **Buscar un libro:** Permitir al usuario buscar un libro por su título utilizando un bucle `while`. Si el libro existe y está disponible, mostrar un mensaje de éxito. Si no está disponible o no existe, mostrar un mensaje adecuado.

4. **Actualizar la disponibilidad de un libro:** Cambiar el estado de disponibilidad de un libro usando un `if`. Por ejemplo, si un libro está siendo prestado, cambiar su estado a no disponible.

**Requisitos adicionales:**

- La lista de libros debe estar predefinida con al menos 5 libros.
- Utilizar `input()` para permitir al usuario buscar libros.
- Asegurarse de que el programa no se rompa si el usuario introduce un ID de libro que no existe.
