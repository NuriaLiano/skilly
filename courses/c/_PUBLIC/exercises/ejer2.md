# Ejercicio 2 - Calculadora de descuentos (Variables, constantes e IFs)

## Enunciado

Crear un programa en C que determine el precio final de un producto tras aplicarle un descuento. El programa pedirá al usuario el precio original del producto y, basándose en el rango de precio, aplicará un descuento determinado.

Las reglas de descuento son:

- Si el precio está entre 1 y 50, no se aplica descuento.
- Si el precio está entre 51 y 100, se aplica un 5% de descuento.
- Si el precio es superior a 100, se aplica un 10% de descuento.

## Ejemplo de salida

~~~c
Introduce el precio original del producto: 60
El precio final tras aplicar el descuento es: 57
~~~

## Resultado

~~~c
#include <stdio.h>

// Definición de constantes
#define SIN_DESCUENTO 50
#define DESCUENTO_5 100
#define PORCENTAJE_DESCUENTO_5 0.05
#define PORCENTAJE_DESCUENTO_10 0.10

int main() {
    float precioOriginal, precioFinal;

    // Solicitar al usuario el precio original
    printf("Introduce el precio original del producto: ");
    scanf("%f", &precioOriginal);

    // Determinar el descuento basado en el precio original
    if (precioOriginal <= SIN_DESCUENTO) {
        precioFinal = precioOriginal; // No se aplica descuento
    } else if (precioOriginal <= DESCUENTO_5) {
        precioFinal = precioOriginal * (1 - PORCENTAJE_DESCUENTO_5); // 5% de descuento
    } else {
        precioFinal = precioOriginal * (1 - PORCENTAJE_DESCUENTO_10); // 10% de descuento
    }

    // Mostrar el precio final tras el descuento
    printf("El precio final tras aplicar el descuento es: %.2f\n", precioFinal);

    return 0;
}
~~~
