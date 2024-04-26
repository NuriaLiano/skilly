# Monitorización del Sistema en Linux

Este documento proporciona una visión general de las herramientas y técnicas básicas para la monitorización del sistema en Linux, incluyendo el directorio `/proc` y los archivos de registro.

## Herramientas Básicas de Monitorización

Linux ofrece varias herramientas de línea de comandos para la monitorización del sistema. A continuación, se presentan algunas de las más comunes:

### 1. `top`

El comando `top` proporciona una vista en tiempo real de la actividad del sistema, incluyendo información sobre procesos, uso de CPU, memoria y más.

### 2. `htop`

`htop` es una versión mejorada de `top`, con una interfaz más amigable y funciones adicionales.

### 3. `vmstat`

`vmstat` informa sobre procesos, memoria, paginación, bloques de E/S, interrupciones y actividad de la CPU.

### 4. `iostat`

`iostat` es útil para monitorear el uso de la CPU y la actividad de E/S para dispositivos, particiones y redes de archivos.

## Directorio `/proc`

El directorio `/proc` contiene una estructura de sistema de archivos virtual que proporciona información del sistema en tiempo real. Algunos archivos y directorios relevantes incluyen:

* `/proc/meminfo`: Muestra información de la memoria del sistema.
* `/proc/cpuinfo`: Muestra información detallada de la CPU.
* `/proc/partitions`: Lista de las particiones detectadas por el sistema.
* `/proc/loadavg`: Muestra los promedios de carga del sistema.

Explora este directorio para obtener información detallada sobre el sistema.

## Archivos de Registro (Syslog)

Los archivos de registro en Linux son cruciales para entender lo que está sucediendo en el sistema. El archivo `syslog` es uno de los más importantes para la monitorización:

### Ubicación del archivo syslog:

Este archivo registra una variedad de eventos del sistema, incluyendo arranque del sistema, mensajes de programas y errores del sistema.

### Comandos útiles para trabajar con syslog:

* `tail` para ver las últimas líneas del archivo de registro:
* `grep` para buscar mensajes específicos dentro de los archivos de registro:

> :books: **PARA SABER MÁS**
>
> Linux mantiene varios archivos de registro en `/var/log`. Explora esta carpeta para encontrar registros relacionados con diferentes servicios y aplicaciones.

## Punto de control

Antes de concluir, asegúrate de:

* Conocer las herramientas básicas de monitorización y cómo utilizarlas.
* Entender la estructura y propósito del directorio `/proc`.
* Saber cómo acceder y analizar los archivos de registro del sistema, especialmente `/var/log/syslog`.

[Ver solución](soluciones/ejer08.md)
