# [Solución] Manejo de ficheros y rutas

## 1. Muestra la ruta absoluta de tu directorio actual

> :books: **PARA SABER MÁS**
> 
> Una ruta absoluta comienza desde la raíz del sistema de archivos (denotado por `/`), mientras que una ruta relativa comienza desde el directorio actual.

~~~sh
pwd
~~~

## 2. Cambia al directorio raíz y luego vuelve a tu directorio personal utilizando una ruta relativa

~~~sh
cd /
cd ~
~~~

## 3. Crea un directorio llamado `Archivos` en tu directorio personal

~~~sh
mkdir ~/Archivos
~~~

## 4. Dentro de `Archivos`, crea un archivo vacío llamado `Texto.txt`

~~~sh
touch ~/Archivos/Texto.txt
~~~

## 5. Mueve el archivo `Texto.txt` al directorio padre (fuera de `Archivos`) usando una ruta relativa

~~~sh
mv ~/Archivos/Texto.txt ~/
~~~

## 6. Cambia el nombre del archivo `Texto.txt` a `NuevoTexto.txt`

~~~sh
mv ~/Texto.txt ~/NuevoTexto.txt
~~~

## 7. Crea una copia de `NuevoTexto.txt` en el directorio `Archivos` y renómbralo como `CopiaTexto.txt`

~~~sh
cp ~/NuevoTexto.txt ~/Archivos/
mv ~/Archivos/NuevoTexto.txt ~/Archivos/CopiaTexto.txt
~~~

## 8. Elimina el directorio `Archivos` junto con todos los archivos que contiene

~~~sh
rm -r ~/Archivos
~~~

## Punto de control

- ¿Cómo se diferencia una ruta relativa de una ruta absoluta?
  - Respuesta: Una ruta relativa se basa en la ubicación actual y no comienza con `/`, mientras que una ruta absoluta comienza desde la raíz del sistema de archivos.

- ¿Qué comando utilizas para volver a tu directorio personal desde cualquier lugar?
  - Respuesta: `cd ~` o simplemente `cd` sin argumentos.

- ¿Cómo puedes mover archivos entre diferentes directorios?
  - Respuesta: Utilizando el comando `mv` seguido de la ruta del archivo original y la ruta de destino.

- ¿Qué sucede con el contenido de un directorio si lo eliminas con `rm -r`?
  - Respuesta: El directorio y todo su contenido son eliminados permanentemente.
