# Calculadora de iniciación

## index.html

~~~html
<!DOCTYPE html>
<html>
<head>
  <title>Calculadora Simple</title>
  <link rel="stylesheet" type="text/css" href="main.css">
  <script src="index.js"></script>
</head>
<body>
  <h1>Calculadora Simple</h1>
  
  <label for="numero1">Número 1:</label>
  <input type="number" id="numero1">
  
  <label for="numero2">Número 2:</label>
  <input type="number" id="numero2">
  
  <button onclick="calcular()">Calcular</button>
  
  <h2>Resultado:</h2>
  <p id="resultado"></p>
</body>
</html>
~~~

## main.js

~~~js
// Definición de la función calcular que se ejecuta cuando se hace clic en el botón
function calcular() {
  // Recogemos el primer número usando getElementById
  // La variable numero1 almacena el valor del primer input
  var numero1 = document.getElementById('numero1').value;
  
  // Recogemos el segundo número usando querySelector
  // La variable numero2 almacena el valor del segundo input
  // querySelector permite seleccionar elementos usando la sintaxis de CSS
  var numero2 = document.querySelector('#numero2').value;
  
  // Convertimos los valores recogidos a números usando parseFloat
  // Esto es necesario porque los valores de los inputs son cadenas de texto (string)
  var num1 = parseFloat(numero1);
  var num2 = parseFloat(numero2);
  
  // Realizamos la suma de los dos números y almacenamos el resultado en una variable
  var resultado = num1 + num2;
  
  // Mostramos el resultado en el elemento <p> con id "resultado"
  // Utilizamos getElementById para seleccionar el elemento y cambiar su contenido
  document.getElementById('resultado').innerText = 'El resultado es: ' + resultado;
}

// Notas:
// - Las variables son usadas para almacenar los valores recogidos de los inputs y el resultado de la suma.
// - getElementById y querySelector son métodos para seleccionar elementos del DOM.
// - La función calcular() se ejecuta cuando el usuario hace clic en el botón "Calcular".
// - El método parseFloat convierte las cadenas de texto de los inputs en números para poder sumarlos.
// - innerText cambia el contenido de texto del elemento seleccionado, mostrando el resultado de la suma.
~~~
