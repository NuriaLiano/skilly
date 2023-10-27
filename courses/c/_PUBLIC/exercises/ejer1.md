# Ejercicio 1 - Variables, constantes

## Enunciado - Cálculo del Área de un Círculo

Escribe un programa en C que calcule el área de un círculo. El programa debe solicitar al usuario que ingrese el radio del círculo y luego calcular y mostrar el área correspondiente.

### Especificaciones

1. Solicita al usuario que ingrese el radio del círculo como un número decimal.
2. Calcula el área del círculo utilizando la fórmula A = π * r^2, donde π (pi) es una constante aproximada de 3.14159 y r es el radio proporcionado por el usuario.
3. Muestra el resultado del cálculo del área en la pantalla.
4. El programa debe manejar números decimales para el radio y el área.

## Ejemplo de salida

Ahora se trata de que compruebes los errores que acabamos de añadir.

~~~c
Calculadora de Área de Círculo
Ingrese el radio del círculo: 5.0
El área del círculo con radio 5.0 es aproximadamente 78.53975 unidades cuadradas.
~~~

> :pencil: **NOTA** Apunta cualquier duda que tengas sobre el ejercicio y lo repasaremos en clase o preguntame a hola@skilly.es
>
> :black_joker: **PISTA**
> Este código utiliza una constante PI para representar el valor de pi (π) y calcula el área del círculo utilizando la fórmula A = π * r^2

## Resultado

~~~c
#include <stdio.h>

int main() {
    double radio;
    const double PI = 3.14159;
    
    printf("Calculadora de Área de Círculo\n");
    printf("Ingrese el radio del círculo: ");
    scanf("%lf", &radio);
    
    double area = PI * radio * radio;
    
    printf("El área del círculo con radio %.2lf es aproximadamente %.5lf unidades cuadradas.\n", radio, area);
    
    return 0;
}
~~~
