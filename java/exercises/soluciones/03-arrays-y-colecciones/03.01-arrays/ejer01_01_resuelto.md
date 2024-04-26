# [Solución] Ejercicios de estructuras de control 2

## 1. Calculadora Básica

~~~java
import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        System.out.print("Ingrese la operación (suma, resta, multiplicación, división): ");
        String operacion = scanner.next();

        switch (operacion) {
            case "suma":
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case "resta":
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case "multiplicación":
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case "división":
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("No se puede dividir por cero.");
                }
                break;
            default:
                System.out.println("Operación no válida.");
                break;
        }
    }
}
~~~

## 2. Adivina el Número

~~~java
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroAdivinar = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int intento;
        do {
            System.out.print("Adivina el número (1 a 100): ");
            intento = scanner.nextInt();
            if (intento < numeroAdivinar) {
                System.out.println("Más alto.");
            } else if (intento > numeroAdivinar) {
                System.out.println("Más bajo.");
            }
        } while (intento != numeroAdivinar);
        System.out.println("¡Correcto! El número era " + numeroAdivinar);
    }
}
~~~

## 3. Tabla de Multiplicar

~~~java
import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para ver su tabla de multiplicar: ");
        int num = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }
}
~~~

## 4. Contador de Números Pares e Impares

~~~java
import java.util.Scanner;

public class ContadorParesImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero, pares = 0, impares = 0;
        System.out.println("Ingrese números (0 para terminar):");
        do {
            numero = scanner.nextInt();
            if (numero % 2 == 0 && numero != 0) {
                pares++;
            } else if (numero != 0) {
                impares++;
            }
        } while (numero != 0);
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }
}
~~~

## 5. Suma de Números Negativos y Positivos

~~~java
import java.util.Scanner;

public class SumaPositivosNegativos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero, sumaPositivos = 0, sumaNegativos = 0;
        System.out.println("Ingrese números (0 para terminar):");
        do {
            numero = scanner.nextInt();
            if (numero > 0) {
                sumaPositivos += numero;
            } else if (numero < 0) {
                sumaNegativos += numero;
            }
        } while (numero != 0);
        System.out.println("Suma de positivos: " + sumaPositivos);
        System.out.println("Suma de negativos: " + sumaNegativos);
    }
}
~~~

## 6. Verificador de Palíndromos

~~~java
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.next();
        String reversa = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            reversa += palabra.charAt(i);
        }
        if (palabra.equals(reversa)) {
            System.out.println(palabra + " es un palíndromo.");
        } else {
            System.out.println(palabra + " no es un palíndromo.");
        }
    }
}
~~~

## 7. Cálculo del Factorial

~~~java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para calcular su factorial: ");
        int num = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + num + " es: " + factorial);
    }
}
~~~

## 8. Lista de Números Primos

~~~java
import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para listar los primos hasta él: ");
        int limite = scanner.nextInt();
        System.out.println("Números primos hasta " + limite + ":");
        for (int num = 2; num <= limite; num++) {
            boolean esPrimo = true;
            for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
                if (num % divisor == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                System.out.println(num);
            }
        }
    }
}
~~~

## 9. Conversor de Temperatura

~~~java
import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la temperatura: ");
        double temperatura = scanner.nextDouble();
        System.out.print("Convertir a (C/F): ");
        char unidad = scanner.next().charAt(0);
        if (unidad == 'C' || unidad == 'c') {
            double celsius = (temperatura - 32) * 5 / 9;
            System.out.println(temperatura + " F es igual a " + celsius + " C");
        } else if (unidad == 'F' || unidad == 'f') {
            double fahrenheit = (temperatura * 9 / 5) + 32;
            System.out.println(temperatura + " C es igual a " + fahrenheit + " F");
        } else {
            System.out.println("Unidad no válida.");
        }
    }
}
~~~

## 10. Dibujando Patrones con Asteriscos

~~~java
import java.util.Scanner;

public class PatronesAsteriscos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del cuadrado: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
~~~
