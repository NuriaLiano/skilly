# Calculadora de iniciación con métodos

## Objetivo

El propósito de esta práctica es crear una calculadora avanzada capaz de realizar operaciones matemáticas básicas como sumar, restar, multiplicar, dividir, y calcular porcentajes entre dos números introducidos por el usuario. Este ejercicio te permitirá profundizar en el manejo de eventos en JavaScript, la validación de entradas del usuario y la manipulación del Document Object Model (DOM) para mostrar resultados dinámicamente en la página web.

## Archivos necesarios

- index.html: Este archivo contendrá la estructura HTML de la calculadora, incluyendo campos de entrada para los números, un botón para ejecutar los cálculos y un elemento para mostrar los resultados.
- main.css: Este archivo será utilizado para aplicar estilos a tu calculadora, mejorando la experiencia del usuario mediante una interfaz más atractiva.
- index.js: Aquí se desarrollará toda la lógica de la calculadora, incluyendo las funciones para realizar las operaciones matemáticas, validar las entradas del usuario y mostrar los resultados.

## Instrucciones

- index.html: Estructura la página con los elementos necesarios para recibir la entrada de los números, un botón para iniciar los cálculos y un área para mostrar los resultados. Asegúrate de incluir las referencias a los archivos CSS y JavaScript correspondientes.
- main.css: Define los estilos básicos para tu calculadora. Puedes establecer tamaños, colores, márgenes, y cualquier otro estilo que consideres necesario para hacer la interfaz más amigable y visualmente atractiva.
- index.js: Implementa las funciones descritas anteriormente. Asegúrate de enlazar correctamente este archivo con tu archivo HTML para que los scripts se carguen y ejecuten correctamente. Usa addEventListener('load', main, false); para asegurarte de que tus scripts se ejecutan después de que todos los elementos de la página se hayan cargado completamente.

## Métodos

- sumar(a, b): Recibe dos números como argumentos y devuelve su suma. Esta función es utilizada para calcular la suma de los valores introducidos por el usuario.
- restar(a, b): Similar a la función anterior, pero para realizar la resta de los dos números proporcionados.
- multiplicar(a, b): Toma dos números y devuelve su producto, permitiendo al usuario multiplicar valores.
- dividir(a, b): Devuelve el resultado de dividir el primer número por el segundo. Es importante manejar el caso en que el divisor sea cero para evitar errores en la operación.
- calcularPorcentaje(a, b): Calcula qué porcentaje representa el primer número respecto al segundo y devuelve este valor.
- validarNumeros(numero1, numero2): Verifica si los valores introducidos son números válidos, devolviendo true si ambos lo son, o false en caso contrario. Esta validación es crucial para evitar errores durante los cálculos.
- calcular(): Esta es la función principal que se ejecuta al hacer clic en el botón "Calcular". Recoge y convierte los valores de los inputs, valida estos números y, si son correctos, realiza todas las operaciones llamando a las funciones correspondientes. Finalmente, llama a mostrarResultado para mostrar los cálculos en la página.
- mostrarResultado(suma, resta, producto, division, porcentaje): Recibe los resultados de las operaciones matemáticas y actualiza el contenido del elemento HTML destinado a mostrar los resultados, formateando adecuadamente cada uno para su presentación.
- realizarCalculos(): Aunque esta función parece redundante con calcular(), podría utilizarse para realizar preparaciones adicionales antes de ejecutar los cálculos, como limpiar mensajes de error previos o verificar condiciones específicas.

