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