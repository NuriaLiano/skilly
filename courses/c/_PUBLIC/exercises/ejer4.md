# Ejercicio 4 - Calculadora un poco mejorada :smile: (Variables, constantes e IFs anidados)

## Enunciado

En este ejercicio vamos a repasar el [ejercicio 2](ejer2.md) y vamos a agregar dos nuevas condiciones para validar los números que introduce el usuario:

> :100: **TIP** nunca te fies del usuario, compruéba siempre que los valores que introduce cumplen tus requisitos :wink:
>
> :black_joker: **PISTA** Sí, puedes reutilizar el ejercicio anterior.

### Especificaciones

1. Si el usuario selecciona la opción de división (4), el programa debe verificar que el segundo número no sea cero antes de realizar la operación. Si el segundo número es cero, debe mostrar un mensaje de error y terminar la ejecución del programa.
2. Si el usuario selecciona una opción no válida, el programa debe mostrar un mensaje de error y terminar la ejecución del programa.

## Ejemplo de salida

Ahora se trata de que compruebes los errores que acabamos de añadir.

~~~c
Calculadora Simple
1. Suma
2. Resta
3. Multiplicación
4. División
Seleccione una opción (1/2/3/4): 4
Ingrese el primer número: 10
Ingrese el segundo número: 0
Error: No se puede dividir por cero.

Calculadora Simple
1. Suma
2. Resta
3. Multiplicación
4. División
Seleccione una opción (1/2/3/4): 5
Opción no válida
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
    } else if (opcion == 4) {
        if (num2 != 0) {
            resultado = num1 / num2;
        } else {
            printf("Error: No se puede dividir por cero.\n");
            return 1; // Salir del programa con un código de error
        }
    } else {
        printf("Opción no válida\n");
        return 1; // Salir del programa con un código de error
    }

    // Mostrar el resultado
    printf("El resultado es: %.2f\n", resultado);

    return 0; // Salir del programa sin errores
}
~~~
