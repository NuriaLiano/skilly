package ruth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ControladorFicheros controladorFicheros = new ControladorFicheros();
        ProcesamientoADN procesamientoADN = new ProcesamientoADN();
        ArrayList <String> resultados = new ArrayList<>();
        
        System.out.println("Introduce el nombre del fichero a leer: ");
        String entrada = sc.nextLine();

        System.out.println("Introduce el nombre del fichero para escribir: ");
        String salida = sc.nextLine();

        //leer fichero de entrada
        ArrayList<String> secuencias = controladorFicheros.leerFichero(entrada);

        //procesar cada secuencia
        for (int i = 0; i < secuencias.size(); i+=2){
            String descripcion = secuencias.get(i);
            String secuencia = secuencias.get(i+1);

            //obtener frecuencia, masa y saber si es proteina
            int[] frecuencias = procesamientoADN.calcularFrecuenciaNeoclotido(secuencia);
            double [] porcentajeMasa = procesamientoADN.calcularPorcentajeMasa(secuencia, frecuencias);
            ArrayList<String> codones = procesamientoADN.getCodones(secuencia);
            boolean esProteina = procesamientoADN.esProteina(secuencia, frecuencias);

            StringBuilder resultado = new StringBuilder();

            resultado.append("Descripcion: " ).append(descripcion).append("\n");
            resultado.append("Nucleotidos: ").append(secuencia.toUpperCase()).append("\n");
            resultado.append("Contadores: ").append(Arrays.toString(frecuencias)).append(("\n"));
            resultado.append("Masa %: ").append(Arrays.toString(porcentajeMasa)).append(("\n"));
            resultado.append("Codones: ").append(codones.toString()).append(("\n"));
            resultado.append("Es proteina: ").append(esProteina ? "SI": "NO").append(("\n"));

            resultados.add(resultado.toString());
            
        }

        //escribimos los resultados en archivo y consola
        controladorFicheros.escribirFichero(salida, resultados);

        sc.close();

    }
}
