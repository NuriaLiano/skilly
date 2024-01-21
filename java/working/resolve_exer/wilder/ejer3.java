import java.util.Scanner;
import java.lang.Math;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



 /**
  *
  * @author will1
  */
 public class Ejercicio3 {
 
    public static void main(String[] args) {
        Scanner recogerNumeros = new Scanner(System.in);

        //imprimir mensaje inicial
        System.out.print("Introduce un numero entre 1 y 10: ");

        //declar variable para almacenar los numeros
        int numero = scanner.nextInt(); //recoger el numero

        //comprobar que el numero esta entre 1 y 10
        if(numero >=1 && numero <=10){
            //comprobar si es multiplo de 3
            if(numero % 3 == 0){ //si el resto de la division de numero entre 3 es igual a 0
                System.out.println( numero + " es multiplo de 3");
            }else{
                System.out.println( numero + " no es multiplo de 3");
            }
        }
}