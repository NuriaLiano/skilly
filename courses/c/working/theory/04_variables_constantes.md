# Variables y constantes

En programación, las variables son esenciales para almacenar y manipular datos. Piensa en ellas como contenedores en los que puedes almacenar valores para usarlos y modificarlos a lo largo de tu programa. En C, cada variable tiene un tipo, un nombre y, opcionalmente, un valor inicial. Vamos a explorar en detalle cómo se usan y se definen las variables en C.

## Variables

### Declaración de variables

Antes de que una variable pueda ser utilizada en C, debe ser declarada. La declaración informa al compilador el nombre de la variable y el tipo de dato que almacenará.

~~~c
int edad;
float salario;
char inicial;
~~~

### Inicialización de Variables

Puedes asignar un valor a la variable en el momento de la declaración, lo que se conoce como inicialización.

~~~c
int edad = 25;
float salario = 5000.50;
char inicial = 'A';
~~~

### Tipos de Variables

El tipo de una variable determina qué tipo de datos puede almacenar y el espacio que ocupará en memoria.

- **int**: Para almacenar números enteros.
- **float**: Para almacenar números decimales con precisión simple.
- **double**: Para almacenar números decimales con mayor precisión.
- **char**: Para almacenar caracteres individuales.

### Nombres de Variables (Identificadores)

Los nombres de las variables tienen que cumplir unos requistos para que puedan ser declaradas

- Deben comenzar con una letra o un guion bajo _, seguido de letras, números o guiones bajos.
- C es un lenguaje sensible a mayúsculas y minúsculas, por lo que edad y Edad serían consideradas dos variables diferentes.

### Ámbito de las variables (Scope de las variables)

El ámbito de una variable se refiere al contexto dentro del cual la variable es conocida y puede ser accedida.

- **Variables locales**: Se declaran dentro de una función y sólo pueden ser utilizadas en esa función.

~~~c
int sumar (int a, int b){
    int resultado = 0;
    resultado = a + b;
    return resultado;
}
int restart (int a, int b){
    int resultado = 0;
    resultado = a - b;
    return resultado;
}

~~~

- **Variables globales**: Se declaran fuera de todas las funciones y pueden ser accedidas desde cualquier función en el archivo.

~~~c
int resultado = 0;

int sumar (int a, int b){
    resultado = a + b;
    return resultado;
}
int restar (int a, int b){
    resultado = a - b;
    return resultado;
}
~~~

### Almacenamiento y Modificadores de Duración

En C, los modificadores de almacenamiento determinan cómo y dónde el compilador almacena una variable, cómo se inicializa, y cuál es su ámbito y duración. Estos modificadores añaden una capa adicional de control sobre cómo se manejan las variables.

- **auto**: Es el predeterminado para todas las variables locales. De hecho, es tan predeterminado que raramente se ve en el código moderno porque se asume implícitamente.

~~~c
void funcion() {
    auto int numero = 42;
}
~~~

- **register**: Sugiere (no garantiza) al compilador que la variable se almacene en un registro del procesador, lo que podría permitir un acceso más rápido. Sin embargo, los compiladores modernos suelen optimizar el código por sí mismos, y este modificador **se ha vuelto menos relevante con el tiempo**.

~~~c
register int cuentaRapida;
~~~

- **static**: Tiene dos usos principales
  - Cuando se aplica a una variable local dentro de una función, hace que la variable retenga su valor entre llamadas a la función. La variable se inicializa solo una vez, y su valor persiste entre llamadas.
  - Cuando se aplica a una variable global, limita su ámbito al archivo actual, lo que significa que no puede ser accesible desde otros archivos.

~~~c
void incrementar() {
    static int cuenta = 0;  // Se inicializa solo una vez
    cuenta++;
    printf("%d\n", cuenta);
}
~~~

Si llamas a incrementar() varias veces, verás que cuenta sigue incrementando en lugar de reiniciarse.

- **extern**: Se utiliza para declarar una variable que se define en otro archivo. Esto es útil cuando tienes variables globales que necesitas compartir entre varios archivos de código fuente.

~~~c
extern int global;
~~~

## Constantes

Mientras que las variables en programación son esenciales para almacenar y manipular datos, a menudo hay valores que no queremos que cambien durante la ejecución del programa. Aquí es donde entran las constantes. Las constantes son identificadores cuyo valor se fija al inicio y no se puede alterar posteriormente.

### Constantes literales

Las constantes literales son valores que se escriben directamente en el código y representan a sí mismos. No tienen un nombre o identificador asociado, y su valor se determina directamente por cómo se escriben en el código.

~~~c
    #include <stdio.h>

    int main() {
        printf("%d\n", 7);  // 7 es una constante literal entera
        printf("%.2f\n", 2.5);  // 2.5 es una constante literal de punto flotante
        printf("%c\n", 'E');  // 'E' es una constante literal de carácter
        printf("%s\n", "Hola");  // "Hola" es una constante literal de cadena de caracteres
        return 0;
    }
~~~

### Definición de constantes con `#declare`

Se utiliza el preprocesador #define para definir constantes. No se asigna espacio de almacenamiento cuando se usa #define, y el compilador reemplaza directamente las ocurrencias en el código.

~~~c
#define PI 3.14159
#define NOMBRE "Skilly"
~~~

### Constantes con `const`

La palabra clave const se utiliza para declarar variables cuyo valor no debe modificarse. Una vez que una constante ha sido declarada con const, cualquier intento de cambiar su valor resultará en un error de compilación.

~~~c
const int edadMaxima = 100;
const float gravedad = 9.81;
~~~

> :woman_teacher: **EXPLICACIÓN**
> Entonces... ¿cuál es el diferencia entre `#declare` y `const`?
>
> - #define se maneja durante el preprocesamiento, mientras que const se maneja durante la compilación.
> - #define no usa memoria porque es una sustitución textual, mientras que const sí utiliza memoria.
> - Las constantes const tienen un tipo de dato, mientras que las definiciones #define no lo tienen
> - #define tiene un alcance global en el archivo, mientras que const puede tener un alcance local o global según dónde se declare.

### Enumeraciones

Las enumeraciones son un conjunto de constantes enteras representadas por identificadores. Permiten que el código sea más legible al dar nombres significativos a conjuntos de valores relacionados.

Por defecto, LUNES será 0, MARTES será 1, y así sucesivamente, aunque puedes asignar valores específicos si lo prefieres.

~~~c
enum dias {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
~~~
