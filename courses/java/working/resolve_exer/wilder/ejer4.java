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
 public class Joven {
 
    public static void main(String[] args) {
        Scanner recogerVariables = new Scanner(System.in);

        System.out.println("Introduce la edad: ");
        int edad = recogerVariables.nextInt();
        System.out.println("Introduce el nivel de estudios: ");
        int estudios = recogerVariables.nextInt();
        System.out.println("Introduce los ingresos");
        int ingresos = recogerVariables.nextInt();

        // comprobar si cumple con los requisitos
        boolean jasp = (edad <= 28) && (estudios > 3) && (ingresos > 28000);

        System.out.println("¿Esta el joven sobradamente preparado?");
        if(jasp){
            System.out.println("Verdadero.");
        }else{
            System.out.println("Falso.");
        }


    }
}