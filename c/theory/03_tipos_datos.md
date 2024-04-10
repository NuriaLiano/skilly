# Tipos de datos

Los tipos de datos en C definen una variedad de formas en las que se pueden almacenar y manipular datos dentro del programa. Proporcionan información al compilador sobre cómo el programador pretende usar los datos, permitiendo al compilador reservar la cantidad adecuada de memoria y tomar decisiones de optimización.

## Tipos de datos básicos

Son los datos más esenciales para almacenar información como números enteros, caracteres, numeros de punto flotante entre otros.

| Tipo  | Descripción                             | Declaración                           |
|-------|-----------------------------------------|---------------------------------------|
| int   | Representa números enteros.             | `int numero = 10;`                    |
| float | Números de punto flotante de precisión simple. | `float pi = 3.14f;`                |
| double| Números de punto flotante de precisión doble. | `double pi_preciso = 3.141592653589793;`|
| char  | Representa un solo carácter.           | `char letra = 'A';`                   |
| _Bool | Valores booleanos (requiere `stdbool.h`).| `bool flag = true;`      |

## Modificadores de tipo

Permiten ajustar los tipos de datos básicos a las diferentes necesidades del código. Se utilizan cuando se necesita un rango específico de valores o tamaños.

| Modificador | Descripción                        | Declaración                                      |
|-------------|------------------------------------|--------------------------------------------------|
| short       | Enteros más pequeños que `int`.    | `short int pequeno_numero = 32767;`              |
| long        | Enteros más grandes que `int`.     | `long int gran_numero = 2147483647L;`            |
| long long   | Enteros más grandes que `long`.    | `long long int numero_muy_grande = 9223372036854775807LL;`|
| unsigned    | Números sin signo.                 | `unsigned int positivo = 100;`                   |

## Tipos de datos derivados

Proporcionan estructuras más complejas contruuidas a partir de los tipos de datos básicos. Se utilizan para organizar y manipular datos de formas más avanzadas que con los tipos de datos solos.

| Tipo      | Descripción                                        | Declaración                               |
|-----------|----------------------------------------------------|-------------------------------------------|
| Arrays    | Colección de elementos del mismo tipo.             | `int numeros[5] = {1, 2, 3, 4, 5};`      |
| Punteros  | Almacenan direcciones de memoria.                  | `int x = 10;`<br>`int *puntero = &x;`    |
| Estructuras | Agrupación de variables de diferentes tipos.      | `struct Persona {`<br>`char nombre[50];`<br>`int edad;`<br>`} persona1;`|
| Uniones   | Como estructuras, pero sólo un miembro a la vez.   | `union Ejemplo {`<br>`int i;`<br>`double d;`<br>`};`|

## Tipos de datos definidos por el usuario

Permiten a los programadores crear sus propias estructuras de datos a partir de los tipos existentes. Facilitan la escritura de código legible y que el diseño de estructuras de datos se ajuste a las necesidades del programa

| Tipo       | Descripción                                       | Declaración                                     |
|------------|---------------------------------------------------|-------------------------------------------------|
| typedef    | Crea un alias para un tipo existente.             | `typedef unsigned long ulong;`<br>`ulong numero = 5000;`|
| Enumeraciones | Conjunto de valores enteros representados por símbolos. | `enum dias {LUN, MAR, MIE, JUE, VIE, SAB, DOM};`|
