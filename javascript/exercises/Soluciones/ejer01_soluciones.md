# Ejercicios básicos de bucles

> :back: **PARA ENTRAR EN CONTEXTO**
> Te recomiendo que antes de empezar con los ejercicios hayas echado un vistazo a la estructuras y los operadores (te van a hacer falta :wink:)
> [Volver a Introducción a Javascript II](https://skilly.gitbook.io/javascript/v/teoria-7/01_introduccion)
> [Volver a Estructuras de control](https://skilly.gitbook.io/javascript/v/teoria-7/02_estructuras_control)

> :brain: **RECUERDA**
> Si tienes cualquier duda puedes resolverlo por Whatsapp o reservando una clase

## 1. Escribe un programa que clasifique un número como 'positivo', 'negativo' o 'cero'

~~~js
let numero = // asigna un valor al número
if (numero > 0) {
  console.log("Positivo");
} else if (numero < 0) {
  console.log("Negativo");
} else {
  console.log("Cero");
}
~~~

## 2.  Crea un programa que determine si una persona es mayor de edad basándose en la edad proporcionada. Considera la mayoría de edad a partir de los 18 años

~~~js
let edad = // asigna la edad
if (edad >= 18) {
  console.log("Mayor de edad");
} else {
  console.log("Menor de edad");
}
~~~

## 3.  Implementa una calculadora básica que realice operaciones de suma, resta, multiplicación y división, dependiendo de una variable de operación. Usa if, else if, else

~~~js
let operacion = // "suma", "resta", "multiplicacion", "division"
let a = // primer número
let b = // segundo número
if (operacion === "suma") {
  console.log(a + b);
} else if (operacion === "resta") {
  console.log(a - b);
} else if (operacion === "multiplicacion") {
  console.log(a * b);
} else if (operacion === "division") {
  console.log(a / b);
} else {
  console.log("Operación no válida");
}
~~~

## 4. Utiliza un bucle do...while para crear un juego simple donde el usuario debe adivinar un número generado aleatoriamente

~~~js
let numeroSecreto = Math.floor(Math.random() * 10) + 1; // Número entre 1 y 10
let adivinanza;
do {
  adivinanza = prompt("Adivina el número entre 1 y 10:");
} while (parseInt(adivinanza) !== numeroSecreto);
console.log("¡Adivinaste!");
~~~

## 5. Escribe un programa que valide la fortaleza de una contraseña utilizando un bucle do...while. La contraseña es fuerte si tiene al menos 8 caracteres

~~~js
let contraseña;
do {
  contraseña = prompt("Crea tu contraseña:");
} while (contraseña.length < 8);
console.log("Contraseña fuerte.");
~~~

## 6. Escribe un bucle for que imprima los números del 1 al 10 en la consola

~~~js
for (let i = 1; i <= 10; i++) {
  console.log(i);
}
~~~

## 7. Usa un bucle for para sumar los números del 1 al 100 y luego imprime el resultado

~~~js
let suma = 0;
for (let i = 1; i <= 100; i++) {
  suma += i;
}
console.log(suma);
~~~

## 8. Escribe un bucle while que imprima los números del 10 al 1 en orden descendente

~~~js
let i = 10;
while (i > 0) {
  console.log(i);
  i--;
}
~~~

## 9. Utiliza un bucle while para encontrar el primer número divisible por 5 y 7 entre 1 y 100, e imprime ese número

~~~js
let numero = 1;
while (numero <= 100) {
  if (numero % 5 === 0 && numero % 7 === 0) {
    console.log(numero);
    break; // Salimos del bucle una vez encontrado el número
  }
  numero++;
}
~~~

## 10. Escribe un bucle while que continúe ejecutándose hasta que el usuario ingrese "salir" usando prompt(). En cada iteración, pide al usuario que ingrese un valor o que escriba "salir" para terminar el bucle

~~~js
let valor;
while (valor !== "salir") {
  valor = prompt("Ingresa un valor o escribe 'salir' para terminar:");
}
~~~

## 11. Imprimir los Números Pares del 2 al 100 Usando un Bucle while

~~~js
let numero = 2;
while (numero <= 10) {
    if (numero % 2 == 0) {
        console.log(numero + " es par");
    } else {
        console.log(numero + " es impar");
    }
    numero++; // Incrementa el valor de numero en 1 en cada iteración
}
~~~

## 12. Encontrar el Factorial de un Número Usando while Imprimir la Serie Fibonacci Hasta el Décimo Término Usando for

> :woman_teacher: **EXPLICACIÓN**
> El factorial de un número es el producto de todos los números hasta ese número. Por ejemplo, el factorial de 5 (5!) es 5 × 4 × 3 × 2 × 1 = 120.

~~~js
let numero = 5; // Cambia este valor para calcular otro factorial
let factorial = 1;
let i = 1;
while (i <= numero) {
  factorial *= i;
  i++;
}
console.log(factorial);
~~~

## 13. Imprimir la Serie Fibonacci Hasta el Décimo Término Usando for

> :woman_teacher: **EXPLICACIÓN**
> La serie de Fibonacci es una secuencia donde cada número es la suma de los dos anteriores, empezando por 0 y 1. Por ejemplo, los primeros diez términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.

~~~js
let n1 = 0, n2 = 1, siguienteTermino;
console.log(n1); // Imprime el primer término
console.log(n2); // Imprime el segundo término

for (let i = 3; i <= 10; i++) {
  siguienteTermino = n1 + n2;
  console.log(siguienteTermino);
  n1 = n2;
  n2 = siguienteTermino;
}
~~~

## 14. Imprimir todos los múltiplos de 3 menores a 100 usando un bucle for

~~~js
for (let i = 3; i < 100; i += 3) {
  console.log(i);
}
~~~

## 15. Calcular la suma de todos los números impares entre 1 y 50 usando un bucle while

~~~js
let i = 1;
let suma = 0;
while (i <= 50) {
  if (i % 2 !== 0) {
    suma += i;
  }
  i++;
}
console.log(suma);
~~~