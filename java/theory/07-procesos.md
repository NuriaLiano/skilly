# Procesos en Java

## ¿Qué son los procesos?

Los procesos son una parte fundamental de cualquier sistema operativo y entorno de programación, incluido Java.

Un proceso es una instancia de un programa en ejecución. Es una unidad básica de ejecución que el sistema operativo gestiona. Cada proceso tiene su propio espacio de memoria y uno o más hilos (threads) de ejecución. Cada proceso posee atributos como un identificador único (PID), estado del proceso (ejecutándose, esperando, terminado), contador de programa, registros y gestión de memoria.

### Importancia de la gestión de procesos

1. **Multitarea y Concurrencia**: Permiten ejecutar múltiples tareas de forma concurrente o en paralelo.
2. **Aislamiento y Seguridad**: Operan en espacios de memoria separados, aumentando la seguridad y estabilidad.
3. **Gestión de Recursos**: Facilitan la asignación y liberación eficiente de recursos del sistema.
4. **Comunicación Interprocesos (IPC)**: Permiten la comunicación entre procesos para tareas colaborativas.
5. **Facilidad de Desarrollo**: Simplifican el desarrollo, la depuración y el mantenimiento de software.
6. **Escalabilidad y Rendimiento**: Claves para construir aplicaciones que escalan y manejan múltiples tareas.
7. **Aplicaciones en Tiempo Real**: Esenciales en aplicaciones que requieren respuestas rápidas y precisas.

## Conceptos básicos

* Cada proceso tiene su propio espacio de memoria, separado de los demás procesos.
* Un número único asignado a cada proceso para su identificación y gestión.
* Estado del Proceso
* **Nuevo**: Proceso creado, pendiente de asignación.
* **Ejecutándose**: Proceso en ejecución activa.
* **Esperando**: Proceso en espera de una condición.
* **Listo**: Proceso listo para ejecutar cuando la CPU esté disponible.
* **Terminado**: Proceso que ha completado su ejecución.
* Unidades más pequeñas de procesamiento dentro de un proceso, compartiendo su espacio de memoria.
* Los procesos requieren recursos como tiempo de CPU, memoria y dispositivos de E/S, gestionados por el sistema operativo.
* El 'program counter' señala la próxima instrucción a ejecutar; el contexto incluye este contador y otros estados del proceso.
* Proceso de cambiar de un proceso a otro, guardando y cargando sus contextos respectivamente.
* Técnicas de IPC (Inter-Process Communication) para la comunicación y sincronización.
* El aislamiento entre procesos ayuda a mantener la seguridad y estabilidad del sistema.

### Hilo vs Proceso

#### Proceso

* **Definición**: Una instancia de un programa en ejecución. Unidad independiente que contiene un programa en ejecución.
* **Espacio de Memoria**: Tiene su propio espacio de memoria aislado.
* **Recursos**: Requiere una cantidad significativa de recursos del sistema.
* **Creación y Gestión**: Más costoso y complejo de crear y gestionar.
* **Comunicación**: La comunicación entre procesos es más compleja, generalmente a través de IPC.

#### Hilo

* **Definición**: La unidad más pequeña de ejecución dentro de un proceso.
* **Espacio de Memoria**: Comparte el espacio de memoria del proceso al que pertenece.
* **Recursos**: Menos recursos requeridos en comparación con un proceso.
* **Creación y Gestión**: Más ligero y eficiente en la creación y gestión.
* **Comunicación**: La comunicación entre hilos es más fácil y directa, dado que comparten el mismo espacio de memoria.

## Clase `ProcessBuilder`

La clase `ProcessBuilder` en Java se utiliza para crear y gestionar procesos y proporciona una manera más conveniente y flexible de crear procesos en comparación con `Runtime.exec()`.

### Características Principales

* **Configuración de Comandos**: Permite especificar el comando y los argumentos del proceso.
* **Redirección de Entrada/Salida**: Facilita la redirección de los streams de entrada, salida y error estándar del proceso.
* **Entorno de Ejecución**: Permite modificar o consultar el entorno de ejecución del proceso (variables de entorno).

### Ejemplo de uso

Crear un proceso para ejecutar un comando del sistema (como ls en sistemas Unix) y redirigir su salida a un archivo

```java
    ProcessBuilder builder = new ProcessBuilder("ls"); // crear la instancia
    builder.redirectOutput(new File("salida.txt")); //redirigir la salida a un fichero
    Process process = builder.start(); // iniciar el proceso
```

## Comunicación entre procesos (IPC)

Ell IPC (Inter-Process Communication) es un conjunto de técnicas que permiten a los procesos en ejecución intercambiar datos y señales y son fundamentales para la colaboración y coordinación en sistemas multitarea y multiusuario.

### Mecanismos Comunes de IPC

1. **Tuberías (Pipes)**:
   * Permite la comunicación unidireccional o bidireccional entre procesos.
   * Utilizado comúnmente para pasar la salida de un proceso a otro.
2. **Sockets**:
   * Facilita la comunicación entre procesos en diferentes máquinas a través de la red.
   * Ampliamente usado en aplicaciones cliente-servidor.
3. **Memoria Compartida**:
   * Permite a múltiples procesos acceder a una misma sección de memoria.
   * Útil para el intercambio de grandes cantidades de datos.
4. **Colas de Mensajes**:
   * Los procesos pueden enviar y recibir mensajes a través de colas.
   * Ofrece un enfoque de comunicación basado en mensajes.
5. **Semáforos**:
   * Mecanismo de sincronización que ayuda a controlar el acceso a recursos compartidos.
   * Evita conflictos y condiciones de carrera.
6. **Señales**:
   * Un proceso puede enviar señales a otro para indicar eventos o cambios de estado.
   * Común en la gestión de eventos y control de procesos.

### Consideraciones de Diseño

* **Seguridad y Aislamiento**: Importante asegurar que la comunicación no comprometa la seguridad del sistema.
* **Rendimiento**: Algunos métodos de IPC pueden ser más adecuados dependiendo del tamaño y la frecuencia de los datos intercambiados.
* **Complejidad**: La implementación y gestión de IPC puede aumentar la complejidad del sistema.

## Manejo de errores y excepciones

1. **Errores de Sintaxis**: Relacionados con la escritura incorrecta del código.
2. **Errores de Ejecución (Excepciones)**: Surgen durante la ejecución del programa debido a condiciones anómalas.
3. **Errores Lógicos**: Resultan en comportamiento incorrecto o resultados inesperados.

## Métodos básicos sobre procesos

| Método              | Descripción                                                         |
| ------------------- | ------------------------------------------------------------------- |
| `start()`           | Inicia el proceso.                                                  |
| `waitFor()`         | Hace que el hilo actual espere hasta que el proceso haya terminado. |
| `exitValue()`       | Devuelve el código de salida del proceso.                           |
| `destroy()`         | Termina el proceso.                                                 |
| `isAlive()`         | Verifica si el proceso está vivo.                                   |
| `getInputStream()`  | Obtiene el `InputStream` del proceso.                               |
| `getErrorStream()`  | Obtiene el `ErrorStream` del proceso.                               |
| `getOutputStream()` | Obtiene el `OutputStream` del proceso.                              |
| `redirectInput()`   | Redirige el `InputStream` del proceso.                              |
| `redirectOutput()`  | Redirige el `OutputStream` del proceso.                             |
| `redirectError()`   | Redirige el `ErrorStream` del proceso.                              |

## Ejemplo

En este caso, vamos a ejecutar un proceso simple (por ejemplo, el comando echo en sistemas Unix o Linux), leer su salida y finalmente obtener su código de salida

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessExample {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("echo", "Hola Mundo");

        try {
            // Iniciar el proceso
            Process process = processBuilder.start();

            // Obtener el InputStream del proceso
            InputStream inputStream = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            // Leer y mostrar la salida del proceso
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine y obtener el código de salida
            int exitCode = process.waitFor();
            System.out.println("El proceso terminó con el código de salida: " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
```

**¿Qué tenemos en el código?**

* Se crea un ProcessBuilder para ejecutar el comando echo "Hola Mundo".
* Se inicia el proceso con start().
* Se obtiene el InputStream del proceso, que se usa para leer la salida estándar del proceso (en este caso, el mensaje "Hola Mundo").
* Se espera a que el proceso termine con waitFor() y se obtiene su código de salida.
* Se manejan las posibles excepciones IOException (relacionadas con la E/S) y InterruptedException (si el hilo actual es interrumpido mientras espera).
