# [Solución] Copias de Seguridad Básicas en Linux

Este documento describe métodos básicos para realizar copias de seguridad en sistemas Linux utilizando comandos de terminal. Cubriremos el uso de `rsync`, `tar` y `cp`.

## 1. Copias de seguridad con `rsync`

`rsync` es una herramienta de copia muy versátil que permite hacer copias incrementales y mantener sincronizados los archivos entre dos directorios.

### Ejemplo de uso de `rsync`:

~~~sh
rsync -avh --progress /origen/ /destino/
~~~

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

~~~sh
tar -cvzf copia_seguridad.tar.gz /origen/
~~~

- `-c` crea un nuevo archivo.
- `-v` muestra el proceso.
- `-z` comprime el archivo resultante usando gzip.
- `-f` permite especificar el nombre del archivo de salida.

### Restaurar desde un archivo `tar`:

~~~sh
tar -xvzf copia_seguridad.tar.gz -C /destino/
~~~

- `-x` extrae archivos del archivo tar.
- `-C` cambia al directorio especificado antes de extraer.

## 3. Copias de seguridad con `cp`

Para copias sencillas de archivos o directorios, el comando `cp` puede ser suficiente.

### Ejemplo de uso de `cp` para copias de seguridad:

~~~sh
cp -r /origen/* /destino/
~~~

- `-r` copia directorios de manera recursiva.

> :warning: **ADVERTENCIA**
>
> `cp` es una herramienta más básica y no ofrece tantas opciones como `rsync` o `tar` para copias de seguridad.

## Punto de control

Antes de concluir, verifica lo siguiente:

- ¿Has elegido el método de copia de seguridad más adecuado para tus necesidades?
  
Si has elegido un método de copia de seguridad basado en tus necesidades específicas, como el tamaño de los datos, la necesidad de versiones incrementales o la facilidad de restauración, entonces sí, has elegido el método más adecuado. Por ejemplo, rsync para copias incrementales, tar para archivar múltiples archivos en uno, y cp para copias simples y directas.ç

- ¿Comprendes las diferencias y los casos de uso de `rsync`, `tar` y `cp`?

Rsync es para sincronización y copias incrementales, tar para crear archivos comprimidos que agrupan varios archivos o directorios, y cp para copiar archivos y directorios de forma sencilla.

- ¿Has verificado que los datos se han copiado correctamente y sin errores?

Si has comprobado los archivos o directorios destino después de la copia para asegurarte de que todos los archivos esperados están presentes y sin corrupción, y si has comparado el tamaño y número de archivos (por ejemplo, usando ls, du, o comprobaciones de integridad como md5sum), entonces sí, has verificado que los datos se han copiado correctamente y sin errores.
