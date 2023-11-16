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
 public class Ejercicio5 {
 
    public static void main(String[] args) {
        Scanner recogerValores = new Scanner(System.in);

        //recoger valor de a
        System.out.println("Introduce el valor de a: ");
        int a = recogerValores.nextInt();

        //recoger valor de b
        System.out.println("Introduce el valor de b: ");
        int b = recogerValores.nextInt();

        //imprimir los valores originales
        System.out.println("Los valores originales son: ");
        System.out.println("el valor de a: " + a);
        System.out.println("el valor de b: " + b);

        //intercambio de valores
        int temporal = a;
        a = b;
        b = temporal;

        //imprimir los valores intercambiados
        System.out.println("Los valores intercambiados son: ");
        System.out.println("el nuevo valor de a: " + a);
        System.out.println("el nuevo valor de b: " + b);


    }
}