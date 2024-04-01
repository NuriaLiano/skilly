# Ejercicios básicos sobre POO

Estos dos ejercicios están preparados para que aprendas e interiorices POO en Java. En el primer ejercicio aprenderás a crear clases sencillas con atributos, constructores y métodos. 
A continuación, en el siguiente ejercicio vas a poder implementar más de una clase para gestionar estudiantes. 

## Ejercicio 1: Crear una Clase Libro

En este ejercicio, crearás una clase Libro que represente los detalles básicos de un libro. La clase debe tener las siguientes propiedades:

- Título del libro (titulo)
- Autor del libro (autor)
- Año de publicación (anioPublicacion)

### Métodos

- Un constructor que inicialice las propiedades del libro.
- Un método mostrarDetalles() que imprima los detalles del libro en la consola.

### Requisitos

1. Define la clase Libro con las propiedades mencionadas.
2. Implementa el constructor para inicializar las propiedades del libro.
3. Implementa el método mostrarDetalles() para que imprima los detalles del libro.
4. Crea un objeto de la clase Libro en tu método main y llama al método mostrarDetalles() para probar que tu clase funciona correctamente.

## Sistema Básico de Gestión de Estudiantes

En este segundo ejercicio, expandirás lo que aprendiste creando un sistema básico de gestión de estudiantes. Este sistema involucrará dos clases: Estudiante y Curso.

### Clases

#### Estudiante

La clase Estudiante debe tener las siguientes propiedades:

- Nombre del estudiante (nombre)
- Edad del estudiante (edad)
- Grado del estudiante (grado)

Y un método para mostrar los detalles del estudiante.

#### Curso

La clase Curso representará un curso que tiene estudiantes inscritos. Debe tener:

- Un nombre de curso (nombreCurso)
- Una lista de estudiantes inscritos (estudiantes), utiliza un ArrayList<Estudiante> para esto.

Y los siguientes métodos:

- Un método para agregar estudiantes al curso.
- Un método para mostrar los detalles de todos los estudiantes inscritos.

### Requisitos

1. Define la clase Estudiante con las propiedades y métodos mencionados.
2. Define la clase Curso con su propiedad y métodos.
3. En el método main, crea varios objetos Estudiante y un objeto Curso.
4. Agrega los estudiantes al curso utilizando el método correspondiente.
5. Llama al método para mostrar los detalles de todos los estudiantes inscritos en el curso y verifica que todo funcione correctamente.

## Consejos antes de comenzar

- Familiarízate con el uso de ArrayList en Java para manejar la lista de estudiantes en la clase Curso.
- Practica la creación de constructores en ambas clases para facilitar la inicialización de los objetos.
- Asegúrate de probar cada parte de tu código a medida que avanzas para asegurarte de que todo esté funcionando como se espera.