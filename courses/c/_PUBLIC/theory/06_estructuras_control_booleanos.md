# Estructuras de control y booleans

Acabas de llegar a un punto muy importante que te servirá para cualquier lenguaje de programación asique presta atención y toma nota :pencil:

Las estructuras de control en C son fundamentales para dirigir el flujo de ejecución de un programa. Estas estructuras permiten a los programas tomar decisiones, repetir acciones y saltar a diferentes partes del código según ciertas condiciones.

## Estructuras de decisión

Permiten que un programa tome decisiones y ejecute ciertos bloques de código basándose en condiciones específicas.

### IF

Ejecuta un bloque de código si una condición es verdadera.

**Sintaxis**

~~~c
if (condición) {
    // Bloque de código a ejecutar si la condición es verdadera
}
~~~

**Ejemplo**

~~~c
int a = 5;
if (a > 3) {
    printf("a es mayor que 3\n");
}
~~~

### IF - ELSE

Permite ejecutar un bloque de código si una condición es verdadera y otro si es falsa.

**Sintaxis**

~~~c
if (condición) {
    // Bloque de código si la condición es verdadera
} else {
    // Bloque de código si la condición es falsa
}
~~~

**Ejemplo**

~~~c
int b = 2;
if (b > 3) {
    printf("b es mayor que 3\n");
} else {
    printf("b no es mayor que 3\n");
}
~~~

### IF - ELSE IF - ELSE

Usado para múltiples condiciones.

**Sintaxis**

~~~c
if (condición1) {
    // Bloque de código si condición1 es verdadera
} else if (condición2) {
    // Bloque de código si condición2 es verdadera
} else {
    // Bloque de código si ninguna de las condiciones anteriores es verdadera
}
~~~

**Ejemplo**

~~~c
int c = 5;
if (c > 7) {
    printf("c es mayor que 7\n");
} else if (c < 3) {
    printf("c es menor que 3\n");
} else {
    printf("c está entre 3 y 7\n");
}
~~~

### SWITCH - CASE

Permite a un programa evaluar una expresión y ejecutar diferentes bloques de código en función del valor de esa expresión.

**Sintaxis**

~~~c
switch (expresión) {
    case valor1:
        // Bloque de código para valor1
        break;
    case valor2:
        // Bloque de código para valor2
        break;
    ...
    default:
        // Bloque de código si ningún caso coincide
}
~~~

**Ejemplo**

~~~c
int d = 2;
switch (d) {
    case 1:
        printf("d es 1\n");
        break;
    case 2:
        printf("d es 2\n");
        break;
    default:
        printf("d no es 1 ni 2\n");
}
~~~

## Estructuras de bloque

Estas estructuras permiten repetir bloques de código múltiples veces.

### FOR

Es ideal cuando sabes cuántas veces quieres que se ejecute un bloque de código.

**Sintaxis**

~~~c
for (inicialización; condición; actualización) {
    // Bloque de código a repetir
}
~~~

**Ejemplo**

~~~c
for (int i = 0; i < 3; i++) {
    printf("Iteración número %d\n", i);
}
~~~

### WHILE

Ejecuta un bloque de código mientras una condición sea verdadera.

**Sintaxis**

~~~c
while (condición) {
    // Bloque de código a repetir
}
~~~

**Ejemplo**

~~~c
int e = 0;
while (e < 3) {
    printf("Iteración número %d\n", e);
    e++;
}
~~~

### DO-WHILE

Similar al bucle while, pero garantiza que el bloque de código se ejecute al menos una vez, ya que la condición se evalúa después de la ejecución del bloque.

**Sintaxis**

~~~c
do {
    // Bloque de código a repetir
} while (condición);
~~~

**Ejemplo**

~~~c
int f = 0;
do {
    printf("Iteración número %d\n", f);
    f++;
} while (f < 3);
~~~

## Control de Flujo

### BREAK

Se utiliza para salir inmediatamente de un bucle o una estructura switch.

~~~c
for (int j = 0; j < 5; j++) {
    if (j == 3) {
        break;
    }
    printf("Iteración número %d\n", j);
}
~~~

### CONTINUE

Salta a la siguiente iteración del bucle, omitiendo cualquier código que le siga en la actual iteración.

~~~c
for (int k = 0; k < 5; k++) {
    if (k == 3) {
        continue;
    }
    printf("Iteración número %d\n", k);
}
~~~

### GOTO

> :heavy_exclamation_mark: **NO RECOMENDADO**

Permite saltar a otra parte del programa. Aunque está disponible en C, su uso generalmente se desaconseja porque puede hacer que el código sea difícil de seguir y mantener.

**Ejemplo**

~~~c
int l = 0;
inicio:  // etiqueta
if (l < 3) {
    printf("Iteración número %d con goto\n", l);
    l++;
    goto inicio;  // salto a la etiqueta "inicio"
}
~~~
