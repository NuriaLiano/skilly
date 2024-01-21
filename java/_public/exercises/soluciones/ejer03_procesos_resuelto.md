# Solución de Ejercicio de Redirección y Comunicación entre Procesos en Java

~~~java
package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ejercicioProcesos2 {

    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("ls");
        ProcessBuilder pb2 = new ProcessBuilder("grep", "java");

        try {
            Process process1 = pb1.start();
            Process process2 = pb2.start();

            OutputStream os = process2.getOutputStream();
            InputStream is = process1.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                os.write((line + "\n").getBytes());
            }

            os.close();
            br.close();
            int exitValue1 = process1.waitFor();

            InputStream is2 = process2.getInputStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));

            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }

            int exitValue2 = process2.waitFor();

            System.out.println("Primer comando finalizado con código de salida: " + exitValue1);
            System.out.println("Segundo comando finalizado con código de salida: " + exitValue2);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
~~~