# Copias de Seguridad Básicas en Linux

Este documento describe métodos básicos para realizar copias de seguridad en sistemas Linux utilizando comandos de terminal. Cubriremos el uso de `rsync`, `tar` y `cp`.

## 1. Copias de seguridad con `rsync`

`rsync` es una herramienta de copia muy versátil que permite hacer copias incrementales y mantener sincronizados los archivos entre dos directorios.

### Ejemplo de uso de `rsync`:

- `-a` activa el modo de archivo para copiar archivos de manera recursiva y preservar símbolos, permisos, etc.
- `-v` incrementa la verbosidad.
- `-h` muestra el tamaño de los archivos en un formato legible.
- `--progress` muestra el progreso de la copia de cada archivo.

> :books: **PARA SABER MÁS**
>
> `rsync` tiene muchas opciones que se pueden adaptar a diferentes necesidades, como excluir archivos, operar a través de la red, y realizar copias de seguridad incrementales.

## 2. Copias de seguridad con `tar`

`tar` es una herramienta para empaquetar un conjunto de archivos en un solo archivo (conocido como tarball), que es útil para agrupar archivos para una copia de seguridad.

### Crear un archivo `tar`:

- `-c` crea un nuevo archivo.
- `-v` muestra el proceso.
- `-z` comprime el archivo resultante usando gzip.
- `-f` permite especificar el nombre del archivo de salida.

### Restaurar desde un archivo `tar`:

- `-x` extrae archivos del archivo tar.
- `-C` cambia al directorio especificado antes de extraer.

## 3. Copias de seguridad con `cp`

Para copias sencillas de archivos o directorios, el comando `cp` puede ser suficiente.

### Ejemplo de uso de `cp` para copias de seguridad:

- `-r` copia directorios de manera recursiva.

> :warning: **ADVERTENCIA**
>
> `cp` es una herramienta más básica y no ofrece tantas opciones como `rsync` o `tar` para copias de seguridad.

## Punto de control

Antes de concluir, verifica lo siguiente:

- ¿Has elegido el método de copia de seguridad más adecuado para tus necesidades?
- ¿Comprendes las diferencias y los casos de uso de `rsync`, `tar` y `cp`?
- ¿Has verificado que los datos se han copiado correctamente y sin errores?

[Ver solución](Soluciones/ejer07.md)
