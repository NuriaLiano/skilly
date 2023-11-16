# Ejercicio 5 - Año bisiesto (Variables, constantes e IFs anidados)

## Enunciado

Escribe un programa en C que determine si un año dado es un año bisiesto o no. Un año bisiesto es aquel que es divisible por 4, excepto aquellos que son divisibles por 100 pero no por 400. El programa debe solicitar al usuario que ingrese un año y luego mostrar si ese año es bisiesto o no.

### Especificaciones

1. El programa debe solicitar al usuario que ingrese un año.
2. El programa debe verificar si el año es divisible por 4. Si es divisible por 4, se considera un candidato a ser un año bisiesto.
3. Si el año es divisible por 100, el programa debe verificar si también es divisible por 400. Si es así, el año es bisiesto; de lo contrario, no lo es.
4. Si el año cumple con las condiciones anteriores, el programa debe mostrar un mensaje indicando que es un año bisiesto. De lo contrario, debe mostrar un mensaje indicando que no es un año bisiesto.

## Ejemplo de salida

Ahora se trata de que compruebes los errores que acabamos de añadir.

~~~c
Verificador de Año Bisiesto
Ingrese un año: 2020
El año 2020 es un año bisiesto.

Verificador de Año Bisiesto
Ingrese un año: 1900
El año 1900 no es un año bisiesto.

Verificador de Año Bisiesto
Ingrese un año: 2000
El año 2000 es un año bisiesto.

Verificador de Año Bisiesto
Ingrese un año: 2023
El año 2023 no es un año bisiesto.
~~~

> :pencil: **NOTA** Apunta cualquier duda que tengas sobre el ejercicio y lo repasaremos en clase o preguntame a hola@skilly.es

## Resultado

~~~c
#include <stdio.h>

int main() {
    int year;

    // Solicitar al usuario que ingrese un año
    printf("Verificador de Año Bisiesto\nIngrese un año: ");
    scanf("%d", &year);

    // Verificar si el año es divisible por 4
    if (year % 4 == 0) {
        // Si es divisible por 4, verificar si es divisible por 100
        if (year % 100 == 0) {
            // Si es divisible por 100, verificar si también es divisible por 400
            if (year % 400 == 0) {
                printf("El año %d es un año bisiesto.\n", year);
            } else {
                printf("El año %d no es un año bisiesto.\n", year);
            }
        } else {
            printf("El año %d es un año bisiesto.\n", year);
        }
    } else {
        printf("El año %d no es un año bisiesto.\n", year);
    }

    return 0;
}
~~~

> :star: **CURIOSIDAD**
> Los años bisiestos tienen un día adicional, el 29 de febrero, para corregir la desviación en el calendario solar.
> Esto ocurre aproximadamente cada 4 años, excepto en los años que son divisibles por 100 pero no por 400.
> Por ejemplo, el año 2000 fue bisiesto, pero el 1900 no lo fue.
