import java.util.Scanner;
import java.lang.Math;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.mycompany.ejercicio1;

 /**
  *
  * @author will1
  */
 public class Ejercicio1 {
 
    public static void main(String[] args) {
        Scanner recogerNumeros = new Scanner(System.in);

        //solicitar dos numeros
        System.out.println("Introduce un numero: ");
        double num1 = recogerNumeros.nextDouble();
        System.out.println("Introduce otro numero: ");
        double num2 = recogerNumeros.nextDouble();

        //operaciones
        double suma = num1 + num2;
        double resta = num1 - num2;
        double multiplicacion = num1 * num2;
        double division = num1 / num2;
        double raizNum1 = Math.sqrt(num1);
        double raizNum2 = Math.sqrt(num2);
        double potenciaNum1 = Math.pow(num1, 2);
        double potenciaNum2 = Math.pow(num2, 2);

        //Mostrar los resultados
        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
        System.out.println("La multiplicacion es: " + multiplicacion);
        System.out.println("La division es: " + division);
        System.out.println("La raiz de " + num1 + " es: " + raizNum1);
        System.out.println("La raiz de " + num2 + " es: " + raizNum2);
        System.out.println("La potencia de " + num1 + " es: " + potenciaNum1);
        System.out.println("La potencia de " + num2 + " es: " + potenciaNum2);
    }
}