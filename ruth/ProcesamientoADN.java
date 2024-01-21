package ruth;

import java.util.ArrayList;

public class ProcesamientoADN {
    
    //constantes
    private static final double MASA_A = 135.128;
    private static final double MASA_C = 111.144;
    private static final double MASA_G = 103.093;
    private static final double MASA_T = 101.047;
    private static final double MASA_BASURA = 100.000;

    //calcular la frecuencia de cada nucleotido
    public int[] calcularFrecuenciaNeoclotido(String secuencia){
        //array de frecuencias [4] contador
        int [] frecuencias = new int [4]; //A,C,G,T

        //divido la secuencia en letras
        char [] letras = secuencia.toUpperCase().toCharArray();

        //switch voy sumando el contador de cada una
        for (char nuclotido: letras){
            switch(nuclotido){
                case 'A': 
                    frecuencias[0]++;
                    break;
                case 'C': 
                    frecuencias[1]++;
                    break;
                case 'G': 
                    frecuencias[2]++;
                    break;
                case 'T': 
                    frecuencias[3]++;
                    break;
                default:
                    break;
            }
        }
        return frecuencias;
    }

    //calcular la masa
    public double[] calcularPorcentajeMasa(String secuencia, int[] frecuencias){

        //contador del total de la masa
        double masaTotal = 0;

        //array de porcentajes de masa [4] porcentaje
        double [] porcentajeMasa = new double [4];

        masaTotal += frecuencias[0] * MASA_A;
        masaTotal += frecuencias[1] * MASA_C;
        masaTotal += frecuencias[2] * MASA_G;
        masaTotal += frecuencias[3] * MASA_T;

        //divido la secuencia en letras
        char [] letras = secuencia.toUpperCase().toCharArray();

        //contar la masa basura -
        for (char nucleotido : letras){
            if(nucleotido == '-'){
                masaTotal += MASA_BASURA;
            }
        }

        //calculo el porcentaje de masa
        for(int i = 0; i <4; i++){
            porcentajeMasa[i] = (frecuencias[i] * obtenerMasaNucleotido(i)) / masaTotal;
        }
        
        System.out.println(porcentajeMasa);
        return porcentajeMasa;
        
        
    }

    //metodo auxiliar para devolver el valor de las constantes
    public double obtenerMasaNucleotido(int nucleotido){
        switch (nucleotido) {
            case 0:
                return MASA_A;
            case 1:
                return MASA_C;
            case 2:
                return MASA_G;
            case 3:
                return MASA_T;
            default:
                return 0;
        }
    }

    //obtener codones
    public ArrayList<String> getCodones(String secuencia){
        ArrayList<String> codones = new ArrayList<>();
        String secuenciaSinBarra = secuencia.replace("-", "");

        for(int i = 0; i < secuenciaSinBarra.length(); i+=3){
            String codon = secuenciaSinBarra.substring(i, i+3); // hace grupos de 3
            codones.add(codon);
        }
        return codones;
    }

    public boolean esProteina(String secuencia, int[] frecuencias){
        // comienza con codon ATG
        // termina con codon TAA, TAG o TGA
        // contiene al menos 5 codones incluidos el de inicio y el de fin
        // C y G juntos suponen al menos el 30% del total de la masa

        if(!secuencia.startsWith("ATG")){
            return false;
        }
        if(!secuencia.endsWith("TAA") || secuencia.endsWith("TAG") || secuencia.endsWith("TGA")){
            return false;
        }

        String secuenciaSinBarra = secuencia.replace("-", "");
        //contiene al menos 5 codones incluidos el de inicio y el de fin
        if(secuenciaSinBarra.length() / 3 < 5){
            return false; //da error si no los tiene
        }

        double [] porcentajeMasa = calcularPorcentajeMasa(secuencia, frecuencias);
        double porcentajeCG = porcentajeMasa[1]+porcentajeMasa[2];

        return porcentajeCG > 0.3; // si esto falla poner 30.0
    }
}
