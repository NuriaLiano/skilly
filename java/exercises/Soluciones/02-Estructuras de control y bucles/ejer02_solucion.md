# [Solución] Ejercicios de estructuras de control II

## 1. Pedir una cadena de caracteres al usuario

Se dirá:
1- Cuántos espacios tiene
2- Cuántas mayúsculas tiene
3- Cuántas minúsculas tiene

~~~java
import java.util.Scanner;

public class AnalisisCadena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena de caracteres:");
        String cadena = scanner.nextLine();

        int espacios = 0;
        int mayusculas = 0;
        int minusculas = 0;

        // Iteramos sobre cada carácter de la cadena.
        for (char c : cadena.toCharArray()) {
            if (c == ' ') {
                espacios++; // Contamos los espacios.
            } else if (Character.isUpperCase(c)) {
                mayusculas++; // Contamos las mayúsculas.
            } else if (Character.isLowerCase(c)) {
                minusculas++; // Contamos las minúsculas.
            }
        }

        // Mostramos los resultados.
        System.out.println("Espacios: " + espacios);
        System.out.println("Mayúsculas: " + mayusculas);
        System.out.println("Minúsculas: " + minusculas);
    }

~~~

## 2. Pedir una frase al usuario y mostrar cada palabra en una línea distinta y numerada

~~~java
import java.util.Scanner;

public class SepararFrase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = scanner.nextLine();

        // Separamos la frase en palabras.
        String[] palabras = frase.split(" ");

        // Mostramos cada palabra en una nueva línea, numerada.
        int numero = 1;
        for (String palabra : palabras) {
            System.out.println(numero + ". " + palabra);
            numero++;
        }
    }
}
~~~

## 3. Pedir una frase al usuario y contar el número de vocales que tiene

~~~java
import java.util.Scanner;

public class ContarVocales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = scanner.nextLine();

        int vocales = 0;

        // Convertimos la frase a minúsculas para hacer la comprobación más fácil.
        frase = frase.toLowerCase();

        // Contamos las vocales.
        for (char c : frase.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            }
        }

        // Mostramos el número de vocales.
        System.out.println("Número de vocales: " + vocales);
    }
}
~~~

## 4. Pedir una frase y una letra al usuario, contar el número de repeticiones de esa letra en la frase

~~~java
import java.util.Scanner;

public class ContarLetras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = scanner.nextLine();
        System.out.println("Introduce una letra:");
        char letra = scanner.next().charAt(0);

        int repeticiones = 0;

        // Contamos las repeticiones de la letra.
        for (char c : frase.toCharArray()) {
            if (c == letra) {
                repeticiones++;
            }
        }

        // Mostramos el número de repeticiones.
        System.out.println("Número de repeticiones de la letra '" + letra + "': " + repeticiones);
    }
}
~~~

## 5. Cadena espejo. Crea un programa que reciba una cadena de caracteres y la devuelva invertida con efecto espejo, esto es, se concatena a la palabra original su inversa, compartiendo la última letra, que hará de espejo, por lo que la palabra obtenida se lee igual hacia adelante que hacia atrás

Por ejemplo, al introducir “teclado” devolverá “tecladodalcet” y al introducir
“goma” devolverá “gomamog”

~~~java
import java.util.Scanner;

public class CadenaEspejo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una palabra:");
        String palabra = scanner.nextLine();

        // Construimos la cadena espejo.
        String inversa = new StringBuilder(palabra).reverse().toString();
        String espejo = palabra + inversa.substring(1);

        // Mostramos la cadena espejo.
        System.out.println("Cadena espejo: " + espejo);
    }
}
~~~

## 6. Pedir al usuario dos palabras y dos letras:

a. Mostrar al usuario todas las posiciones de la primera letra en la primera palabra.
b. Mostrar la primera palabra sustituyendo la primera letra por la segunda.
c. Mostrar la primera palabra al revés.
d. Mostrar la segunda palabra en mayúsculas.
e. Concatenar a continuación de la primera palabra la segunda.
f. Mostrar la segunda palabra omitiendo las veces que aparezca la segunda letra.

### Ejemplo de ejecución

~~~sh
Introduce la palabra 1:
cocacola
Introduce la palabra 2:
adios
Introduce el caracter 1:
o
Introduce el caracter 2:
a
a: Posiciones de la letra 'o' en 'cocacola': 1,5
b: Cocacola cambiando 'o' por 'a': cacacala
c: Cocacola al revés: alocacoc
d: Adios en mayusculas: ADIOS
e: Cocacolaadios
f: Adios omitiendo la a: dios
~~~

~~~java
import java.util.Scanner;

public class OperacionesPalabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la palabra 1:");
        String palabra1 = scanner.nextLine();
        System.out.println("Introduce la palabra 2:");
        String palabra2 = scanner.nextLine();
        System.out.println("Introduce el caracter 1:");
        char caracter1 = scanner.next().charAt(0);
        System.out.println("Introduce el caracter 2:");
        char caracter2 = scanner.next().charAt(0);

        // a. Mostrar todas las posiciones del caracter1 en palabra1.
        System.out.print("Posiciones de la letra '" + caracter1 + "' en '" + palabra1 + "': ");
        for (int i = 0; i < palabra1.length(); i++) {
            if (palabra1.charAt(i) == caracter1) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Salto de línea.

        // b. Mostrar palabra1 sustituyendo caracter1 por caracter2.
        System.out.println("Palabra cambiando '" + caracter1 + "' por '" + caracter2 + "': " +
                palabra1.replace(caracter1, caracter2));

        // c. Mostrar palabra1 al revés.
        System.out.println("Palabra al revés: " + new StringBuilder(palabra1).reverse().toString());

        // d. Mostrar palabra2 en mayúsculas.
        System.out.println("Palabra en mayúsculas: " + palabra2.toUpperCase());

        // e. Concatenar palabra2 al final de palabra1.
        System.out.println("Concatenación: " + palabra1 + palabra2);

        // f. Mostrar palabra2 omitiendo el caracter2.
        System.out.println("Palabra omitiendo '" + caracter2 + "': " +
                palabra2.replace(String.valueOf(caracter2), ""));
    }
}
~~~
