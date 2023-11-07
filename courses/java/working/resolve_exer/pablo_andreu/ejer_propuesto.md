# Ejercicio: Sistema de Gestión para una Biblioteca

## Descripción

Desarrolla un sistema para gestionar los libros de una biblioteca. El sistema debe permitir registrar libros, autores, préstamos y usuarios.

## Requisitos

### Persona

Clase abstracta para Usuarios y Autores

### Libro

Atributos: título, autor, año de publicación, número de copias, número de copias prestadas.
Métodos: préstamo de libro, devolución de libro.

### Autor

Atributos: nombre, país (enum), fecha de nacimiento.
Debería haber una manera de consultar todos los libros de un autor.

### Usuario

Atributos: identificación, nombre, lista de libros prestados.
Métodos: tomar prestado un libro, devolver un libro.

### Biblioteca

Atributos: nombre, dirección, lista de libros, lista de usuarios.
Métodos: agregar libro, agregar usuario, buscar libro, buscar usuario, realizar préstamo, recibir devolución.

- Utiliza ArrayList para almacenar listas de libros, autores y usuarios en la biblioteca.
- Implementa interfaces para las operaciones de préstamo y devolución.
- Usa bucles para iterar a través de los ArrayLists cuando sea necesario.
- Crea clases abstractas si identificas que hay comportamientos o atributos comunes que puedan ser abstraídos.
- Utiliza atributos y métodos static para situaciones donde una propiedad o acción pertenece a la clase en general y no a una instancia específica.
- Define las clases con sus atributos y métodos correspondientes.
- Crea una clase Main donde instancies una biblioteca, agregues usuarios, libros y realices operaciones de préstamo y devolución utilizando bucles para iterar sobre las listas de libros y usuarios.
