# Solución de Ejercicio de Comunicación y Sincronización entre Tres Procesos en Java

~~~java
package Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ejercicioProcesos3 {

    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("ls", "-l");
        ProcessBuilder pb2 = new ProcessBuilder("grep", "^-");
        ProcessBuilder pb3 = new ProcessBuilder("wc", "-l");

        try {
            // Iniciar primer proceso
            Process process1 = pb1.start();
            OutputStream os1 = process1.getOutputStream();

            // Iniciar segundo proceso y conectar salida del proceso 1 con entrada del proceso 2
            Process process2 = pb2.start();
            InputStream is1 = process1.getInputStream();
            OutputStream os2 = process2.getOutputStream();
            transferStream(is1, os2);

            // Iniciar tercer proceso y conectar salida del proceso 2 con entrada del proceso 3
            Process process3 = pb3.start();
            InputStream is2 = process2.getInputStream();
            OutputStream os3 = process3.getOutputStream();
            transferStream(is2, os3);

            // Leer y mostrar la salida del tercer proceso
            InputStream is3 = process3.getInputStream();
            BufferedReader br3 = new BufferedReader(new InputStreamReader(is3));
            String line;
            while ((line = br3.readLine()) != null) {
                System.out.println("Número de archivos regulares: " + line);
            }

            // Esperar a que los procesos terminen y obtener los códigos de salida
            int exitValue1 = process1.waitFor();
            int exitValue2 = process2.waitFor();
            int exitValue3 = process3.waitFor();

            System.out.println("Proceso 1 terminado con código: " + exitValue1);
            System.out.println("Proceso 2 terminado con código: " + exitValue2);
            System.out.println("Proceso 3 terminado con código: " + exitValue3);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void transferStream(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
    }
}
~~~