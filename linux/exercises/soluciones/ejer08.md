# [Solución] Monitorización del Sistema en Linux

Este documento proporciona una visión general de las herramientas y técnicas básicas para la monitorización del sistema en Linux, incluyendo el directorio `/proc` y los archivos de registro.

## Herramientas Básicas de Monitorización

Linux ofrece varias herramientas de línea de comandos para la monitorización del sistema. A continuación, se presentan algunas de las más comunes:

### 1. `top`

El comando `top` proporciona una vista en tiempo real de la actividad del sistema, incluyendo información sobre procesos, uso de CPU, memoria y más.

~~~sh
top
~~~

### 2. `htop`

`htop` es una versión mejorada de `top`, con una interfaz más amigable y funciones adicionales.

~~~sh
htop
~~~

### 3. `vmstat`

`vmstat` informa sobre procesos, memoria, paginación, bloques de E/S, interrupciones y actividad de la CPU.

~~~sh
vmstat 1
~~~

### 4. `iostat`

`iostat` es útil para monitorear el uso de la CPU y la actividad de E/S para dispositivos, particiones y redes de archivos.

~~~sh
iostat
~~~

## Directorio `/proc`

El directorio `/proc` contiene una estructura de sistema de archivos virtual que proporciona información del sistema en tiempo real. Algunos archivos y directorios relevantes incluyen:

- `/proc/meminfo`: Muestra información de la memoria del sistema.
- `/proc/cpuinfo`: Muestra información detallada de la CPU.
- `/proc/partitions`: Lista de las particiones detectadas por el sistema.
- `/proc/loadavg`: Muestra los promedios de carga del sistema.

Explora este directorio para obtener información detallada sobre el sistema.

## Archivos de Registro (Syslog)

Los archivos de registro en Linux son cruciales para entender lo que está sucediendo en el sistema. El archivo `syslog` es uno de los más importantes para la monitorización:

### Ubicación del archivo syslog:

~~~sh
/var/log/syslog
~~~

Este archivo registra una variedad de eventos del sistema, incluyendo arranque del sistema, mensajes de programas y errores del sistema.

### Comandos útiles para trabajar con syslog:

- `tail` para ver las últimas líneas del archivo de registro:
  
  ~~~sh
  tail -f /var/log/syslog
  ~~~

- `grep` para buscar mensajes específicos dentro de los archivos de registro:
  
  ~~~sh
  grep "palabra_clave" /var/log/syslog
  ~~~

> :books: **PARA SABER MÁS**
>
> Linux mantiene varios archivos de registro en `/var/log`. Explora esta carpeta para encontrar registros relacionados con diferentes servicios y aplicaciones.

## Punto de control

Antes de concluir, asegúrate de:

- Conocer las herramientas básicas de monitorización y cómo utilizarlas.

Las herramientas básicas de monitorización en Linux incluyen top, htop, vmstat, e iostat:

- top: Muestra la actividad de los procesos del sistema en tiempo real, incluyendo el uso de CPU y memoria.
- htop: Es similar a top pero con una interfaz más amigable y opciones adicionales para gestionar procesos.
- vmstat: Proporciona información sobre procesos, memoria, rendimiento del sistema, E/S, y actividad de la CPU.
- iostat: Ofrece estadísticas detalladas sobre el rendimiento de la CPU y la actividad de E/S para dispositivos de almacenamiento.

Puedes utilizar estas herramientas ejecutándolas directamente en la terminal. Por ejemplo, simplemente teclea top en la terminal y presiona Enter para iniciar la herramienta.

- Entender la estructura y propósito del directorio `/proc`.

El directorio /proc es un sistema de archivos virtual que no ocupa espacio en disco y proporciona una interfaz al núcleo y los datos de estado del sistema Linux. Dentro de /proc, puedes encontrar información en tiempo real sobre el sistema, como:

- `/proc/meminfo`: Información de la memoria.
- `/proc/cpuinfo`: Detalles sobre la CPU.
- `/proc/partitions`: Lista de particiones detectadas por el sistema.
No necesitas herramientas especiales para acceder a esta información; puedes usar comandos como cat para leer estos archivos. Por ejemplo, cat /proc/meminfo te mostrará información sobre la memoria del sistema.

- Saber cómo acceder y analizar los archivos de registro del sistema, especialmente `/var/log/syslog`.

Los archivos de registro del sistema, como /var/log/syslog, contienen una amplia gama de mensajes del sistema, incluidos mensajes de inicio, errores de aplicaciones y mensajes del kernel:
Para acceder a este archivo, puedes utilizar herramientas de línea de comandos como less, cat, o tail. Por ejemplo, sudo tail -f /var/log/syslog te permite ver los mensajes más recientes y seguir añadiendo nuevos en tiempo real.
Analizar estos archivos puede ayudarte a diagnosticar problemas y entender la actividad del sistema. Busca mensajes de error o advertencias y correlaciónalos con los problemas del sistema para solucionarlos.
