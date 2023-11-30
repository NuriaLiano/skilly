// Objetivo: Crear un programa en C que calcule el área y el perímetro de diferentes figuras geométricas utilizando funciones con parámetros.

// Descripción:

// Funciones a Implementar:

// calcularAreaCirculo(double radio, double* area): Esta función debe calcular el área de un círculo y usar un parámetro de salida para devolver el resultado.
// calcularPerimetroCirculo(double radio, double* perimetro): Esta función debe calcular el perímetro de un círculo y usar un parámetro de salida para devolver el resultado.
// calcularAreaRectangulo(double largo, double ancho, double* area): Esta función debe calcular el área de un rectángulo y usar un parámetro de salida para devolver el resultado.
// calcularPerimetroRectangulo(double largo, double ancho, double* perimetro): Esta función debe calcular el perímetro de un rectángulo y usar un parámetro de salida para devolver el resultado.
// Funcionamiento del Programa:

// El programa debe pedir al usuario que elija una figura geométrica (círculo o rectángulo).
// Según la elección, el programa debe solicitar los datos necesarios (radio para el círculo, largo y ancho para el rectángulo).
// El programa debe llamar a las funciones correspondientes para calcular el área y el perímetro de la figura seleccionada.
// Finalmente, el programa debe mostrar los resultados calculados.

#include <stdio.h>
#include "calculadora.h"

int main(){
    //variables
    int opcion;
    double area, perimetro, radio, largo, ancho;

    printf("Selecciona una figura \n");

    printf("1. Círculo \n");
    printf("2. Rectángulo \n");
    scanf ("%d", &opcion);

    switch (opcion){
        case 1:
            printf("Dime el radio del circulo");
            scanf("%lf", &radio);
            calcularAreaCirculo(radio, &area);
            calcularPerimetroCirculo(radio, &perimetro);
            printf("El area del circulo es: %lf \n", area);
            printf("El perimetro del circulo es: %lf \n", perimetro);
            break;
        case 2:
            printf("Dime el largo del rectángulo");
            scanf("%lf", &largo);
            printf("Dime el ancho del rectángulo");
            scanf("%lf", &ancho);
            calcularAreaRectangulo(largo, ancho, &area);
            calcularPerimetroRectangulo(largo, ancho, &perimetro);
            printf("El area del rectángulo es: %lf \n", area);
            printf("El perimetro del rectángulo es: %lf \n", perimetro);
            break;
    }
    return 0;
}
