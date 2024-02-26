# Calculadora de iniciación

## Objetivo

Deberás crear una página web que contenga dos campos de entrada (input) donde los usuarios puedan introducir números. Habrá un botón que, al ser presionado, ejecutará una función de JavaScript que sumará los números introducidos y mostrará el resultado en la página.

## Archivos necesarios

- index.html: Este archivo contendrá la estructura básica de tu calculadora. Deberás incluir dos elementos input para que el usuario introduzca los números, un botón para realizar la suma y un elemento p donde se mostrará el resultado de la operación. Asegúrate de vincular correctamente tu hoja de estilos CSS y tu archivo JavaScript.
- main.js: Este archivo contendrá la lógica para realizar la suma de los dos números introducidos por el usuario. Deberás escribir una función llamada calcular que se ejecutará cuando el usuario haga clic en el botón "Calcular". Esta función recogerá los valores de los campos de entrada, los convertirá a números (ya que inicialmente son cadenas de texto), realizará la suma y mostrará el resultado en el elemento p destinado para ello.

## Instrucciones

- index.html: Asegúrate de que el DOCTYPE esté declarado correctamente y de que tu documento HTML esté estructurado con las etiquetas head y body apropiadas. Dentro del body, crea los elementos necesarios mencionados anteriormente y asigna los identificadores correctos a cada elemento para que puedan ser fácilmente seleccionados con JavaScript.
- main.js: Empieza declarando la función calcular que se llamará al hacer clic en el botón. Utiliza document.getElementById para recoger el valor del primer input y document.querySelector para el segundo, demostrando así dos formas de seleccionar elementos en el DOM. Convierte los valores recogidos a números con parseFloat, suma ambos números y muestra el resultado utilizando innerText para modificar el contenido del elemento p con id "resultado".