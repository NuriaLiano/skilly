# [Solución] Ejercicios básicos de arrays

## 1. Suma de Elementos de un Array

~~~java
public class SumaArray {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        System.out.println("La suma es: " + suma);
    }
}
~~~

## 2. Promedio de Valores

~~~java
public class PromedioArray {
    public static void main(String[] args) {
        float[] numeros = {1.5f, 2.5f, 3.5f, 4.5f, 5.5f};
        float suma = 0;
        for (float num : numeros) {
            suma += num;
        }
        float promedio = suma / numeros.length;
        System.out.println("El promedio es: " + promedio);
    }
}
~~~

## 3. Encontrar el Máximo y Mínimo

~~~java
public class MaxMinArray {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 4, 1, 2};
        int max = numeros[0];
        int min = numeros[0];
        for (int num : numeros) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Máximo: " + max + " - Mínimo: " + min);
    }
}
~~~

## 4. Invertir un Array

~~~java
public class InvertirArray {
    public static void main(String[] args) {
        char[] letras = {'a', 'b', 'c', 'd', 'e'};
        for (int i = 0; i < letras.length / 2; i++) {
            char temp = letras[i];
            letras[i] = letras[letras.length - 1 - i];
            letras[letras.length - 1 - i] = temp;
        }
        for (char c : letras) {
            System.out.print(c + " ");
        }
    }
}
~~~

## 5. Verificación de Palíndromo

~~~java
public class Palindromo {
    public static void main(String[] args) {
        char[] palabra = {'r', 'e', 'c', 'o', 'n', 'o', 'c', 'e', 'r'};
        boolean esPalindromo = true;
        for (int i = 0; i < palabra.length / 2; i++) {
            if (palabra[i] != palabra[palabra.length - 1 - i]) {
                esPalindromo = false;
                break;
            }
        }
        System.out.println("¿Es palíndromo? " + esPalindromo);
    }
}
~~~

## 6. Suma de Matrices

~~~java
public class SumaMatrices {
    public static void main(String[] args) {
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrizB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] suma = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];
                System.out.print(suma[i][j] + " ");
            }
            System.out.println();
        }
    }
}
~~~

## 7. Transposición de una Matriz

~~~java
public class TransposicionMatriz {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] transpuesta = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transpuesta[j][i] = matriz[i][j];
                System.out.print(transpuesta[j][i] + " ");
            }
            System.out.println();
        }
    }
}
~~~

## 8. Multiplicación de Matrices

~~~java
public class MultiplicacionMatrices {
    public static void main(String[] args) {
        int[][] matrizA = {{1, 2}, {3, 4}};
        int[][] matrizB = {{5, 6}, {7, 8}};
        int[][] resultado = new int[2][2];

        // Realizar la multiplicación
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        // Imprimir resultado
        System.out.println("Resultado de la multiplicación:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}
~~~

## 9. Contador de Palabras

~~~java
public class ContadorPalabras {
    public static void main(String[] args) {
        String[] palabras = {"manzana", "banana", "cereza", "manzana", "banana", "manzana"};
        String[] palabrasUnicas = new String[palabras.length];
        int[] contador = new int[palabras.length];

        int indiceUnico = 0;
        for (String palabra : palabras) {
            boolean existe = false;
            for (int j = 0; j < indiceUnico; j++) {
                if (palabra.equals(palabrasUnicas[j])) {
                    contador[j]++;
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                palabrasUnicas[indiceUnico] = palabra;
                contador[indiceUnico] = 1;
                indiceUnico++;
            }
        }

        // Imprimir resultados
        System.out.println("Frecuencia de cada palabra:");
        for (int i = 0; i < indiceUnico; i++) {
            System.out.println(palabrasUnicas[i] + ": " + contador[i]);
        }
    }
}
~~~

## 10. Agenda Telefónica Simple

~~~java
public class AgendaTelefonica {
    public static void main(String[] args) {
        String[] nombres = {"Alice", "Bob", "Charlie"};
        String[] telefonos = {"555-1234", "555-5678", "555-9012"};

        String buscarNombre = "Charlie";

        // Buscar el número telefónico
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(buscarNombre)) {
                System.out.println("El número de " + buscarNombre + " es " + telefonos[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nombre no encontrado.");
        }
    }
~~~
