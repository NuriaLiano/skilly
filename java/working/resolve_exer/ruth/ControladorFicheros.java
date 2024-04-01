package java.working.resolve_exer.ruth;
/*
 * 
 * ¿CALCULAR MASA?
 * 1. main
 * 2- manejo de ficheros (leer y escribir)
 * 3- contar caracteres (ATGC) mayus y min - de la muestra para calcular la masa
 * 4- guion basura 
 * 5- agrupar nuclotidos de 3 en 3 y formar codones
 * 6- gen que codifica proteina o no
 * 7- condon valido atg
 * 8- Finaliza con un codón válido, es decir el último codón será TAA, TAG o TGA
 * 9- Contiene al menos 5 codones incluidos el de inicio y el de fin
 * 10- Citosina (C) y Guanina (G) juntos suponen al menos el 30% del total de la masa
 * 
 */

import java.io.*;
import java.util.*;

public class ControladorFicheros{

    public ArrayList<String> leerFichero(String nombreFichero){
        
        ArrayList <String> secuencias = new ArrayList<>();

        try {
            File file = new File (nombreFichero);
            Scanner sc = new Scanner (file);

            while(sc.hasNextLine()){
                String descripcion = sc.nextLine();
                String secuencia = sc.nextLine();
                secuencias.add(descripcion);
                secuencias.add(secuencia);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        return secuencias;
    }

    public void escribirFichero(String nombreFichero, ArrayList<String> secuencias){
        try{
            File file = new File (nombreFichero);
            PrintStream printStream = new PrintStream(file);
            for (String secuencia : secuencias) {
                System.out.println(secuencia);
                printStream.println(secuencia);
            }
            printStream.close();
        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
    }
}

