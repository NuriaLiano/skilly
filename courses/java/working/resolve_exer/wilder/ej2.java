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
        System.out.println("Introduce un numero: ");
        numero = recogerNumeros.nextInt();
        //separar los digitos
        int decenasMillar = numero /10000;
        int unidadesMillar = (numero/1000)%10;
        int centenas = (numero/100)%10;
        int decenas = (numero/10)%10;
        int unidades = numero%10;

        //imprimir los digitos
        System.out.println("Decenas de millar" + decenasMillar);
        System.out.println("Unidades de millar" + unidadesMillar);
        System.out.println("Centenas" + centenas);
        System.out.println("Decenas" + decenas);
        System.out.println("Unidades" + unidades);

        System.out.println(decenasMillar + " " + unidadesMillar + " " + centenas + " " + decenas + " " + unidades);
    }
}