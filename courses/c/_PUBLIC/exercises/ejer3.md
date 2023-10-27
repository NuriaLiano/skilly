# Ejercicio 3 - Variables, constantes e IFs

## Enunciado - Calculadora simple

Escribe un programa en C que actúe como una calculadora simple. El programa debe realizar cuatro operaciones básicas: suma, resta, multiplicación y división. Debe mostrar un menú de opciones al usuario, permitirle seleccionar una operación y luego solicitar dos números para realizar la operación seleccionada. A continuación, muestra el resultado de la operación o un mensaje de error si es aplicable.

### Especificaciones

1. El programa debe mostrar un menú de opciones que incluya las siguientes operaciones:
   - Suma
   - Resta
   - Multiplicación
   - División
2. El usuario debe seleccionar una operación ingresando un número (1 para suma, 2 para resta, 3 para multiplicación y 4 para división).
3. El programa debe solicitar al usuario que ingrese dos números después de seleccionar una operación.
4. El programa debe realizar la operación correspondiente según la opción seleccionada por el usuario y mostrar el resultado.

## Ejemplo de salida

~~~c
Calculadora Simple
1. Suma
2. Resta
3. Multiplicación
4. División
Seleccione una opción (1/2/3/4): 3
Ingrese el primer número: 5
Ingrese el segundo número: 4
El resultado es: 20.00
~~~

> :pencil: **NOTA** Apunta cualquier duda que tengas sobre el ejercicio y lo repasaremos en clase o preguntame a hola@skilly.es

## Resultado

~~~c
#include <stdio.h>

int main() {
    // Declaración de variables
    int opcion;
    float num1, num2, resultado;

    // Menú de opciones
    printf("Calculadora Simple\n");
    printf("1. Suma\n");
    printf("2. Resta\n");
    printf("3. Multiplicación\n");
    printf("4. División\n");
    printf("Seleccione una opción (1/2/3/4): ");
    scanf("%d", &opcion);

    // Captura de números
    printf("Ingrese el primer número: ");
    scanf("%f", &num1);
    printf("Ingrese el segundo número: ");
    scanf("%f", &num2);

    // Realizar la operación seleccionada
    if (opcion == 1) {
        resultado = num1 + num2;
    } else if (opcion == 2) {
        resultado = num1 - num2;
    } else if (opcion == 3) {
        resultado = num1 * num2;
    } else {
        resultado = num1 / num2;
    }

    // Mostrar el resultado
    printf("El resultado es: %.2f\n", resultado);

    return 0; // Salir del programa sin errores
}
~~~
