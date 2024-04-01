# Sistema de Gestión de Cine

## Objetivos

Desarrollar un sistema de gestión para un cine que permita mostrar las películas en cartelera, el estado de las butacas de la sala, realizar la compra y devolución de entradas, y mostrar la recaudación total.

## Funciones

1. **rellenarArray()**:
    - **Objetivo**: Inicializar la sala de cine con todas las butacas disponibles (marcadas con '0').
    - **Proceso**: Recorre el arreglo bidimensional `sala`, asignando el carácter '0' a cada elemento para indicar que la butaca está libre.

2. **mostrarPelicula()**:
    - **Objetivo**: Mostrar la película actualmente en cartelera.
    - **Proceso**: Imprime en consola el título y una imagen representativa de la película en cartelera.

3. **mostrarButacas()**:
    - **Objetivo**: Mostrar el estado actual de las butacas en la sala.
    - **Proceso**: Recorre el arreglo `sala` e imprime el estado de cada butaca, donde '0' indica una butaca libre y 'X' una butaca ocupada.

4. **comprarEntrada()**:
    - **Objetivo**: Permitir la compra de entradas, actualizando el estado de las butacas y la recaudación.
    - **Proceso**: Solicita al usuario la fila y el número de butaca, verifica si está disponible ('0'), si es así, marca la butaca como ocupada ('X'), imprime la entrada, y actualiza la recaudación.

5. **devolverEntrada()**:
    - **Objetivo**: Permitir la devolución de entradas, actualizando el estado de las butacas y la recaudación.
    - **Proceso**: Solicita al usuario la fila y el número de butaca, verifica si está ocupada ('X'), si es así, marca la butaca como libre ('0') y actualiza la recaudación restándole el valor de la entrada.

6. **mostrarRecaudacion()**:
    - **Objetivo**: Mostrar la recaudación total hasta el momento.
    - **Proceso**: Imprime el total de la recaudación acumulada por la venta de entradas.

## Descripción General del Programa

El sistema interactúa con el usuario a través de un menú principal que permite acceder a las diferentes funcionalidades: ver la película en cartelera, el estado de las butacas, comprar o devolver entradas, y consultar la recaudación total. Utiliza un arreglo bidimensional para gestionar el estado de las butacas y variables para controlar la recaudación. La interacción se realiza mediante la consola, y se espera que el usuario introduzca los datos solicitados para cada operación.
