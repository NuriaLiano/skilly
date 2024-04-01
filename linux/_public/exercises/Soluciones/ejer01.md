# [Solución] Comandos básicos y primera interacción con la terminal

## 1. Muestra el directorio actual en el que te encuentras

Utiliza el comando `pwd` para mostrar tu directorio actual.

> :books: **PARA SABER MÁS**
> El comando `pwd` muestra tu ubicación actual, `ls` lista los archivos y directorios en tu ubicación actual, y `ls -a` lista todos los archivos, incluyendo los ocultos.

## 2. Cambia al directorio /etc y muestra su contenido

~~~sh
cd /etc
ls
~~~

## 3. Regresa a tu directorio personal y crea un nuevo directorio llamado MiPrimerDirectorio

~~~sh
cd ~
mkdir MiPrimerDirectorio
~~~

## 4. Dentro de MiPrimerDirectorio, crea un archivo vacío llamado test.txt

~~~sh
cd MiPrimerDirectorio
touch test.txt
~~~

## 5. Añade el texto "Hola mundo" al archivo test.txt

> :books: **PARA SABER MÁS**
> El operador > redirige la salida a un archivo, sobrescribiendo el contenido actual. El operador >> añade la salida al final del archivo sin borrar el contenido existente.

~~~sh
echo "Hola mundo" > test.txt
~~~

## 6. Copia el archivo test.txt al directorio /tmp

~~~sh
cp test.txt /tmp
~~~

## 7. Mueve el archivo copiado en /tmp a un nuevo archivo llamado nuevoTest.txt

~~~sh
mv /tmp/test.txt /tmp/nuevoTest.txt
~~~

## 8. Lista todos los archivos que comiencen con "t" en tu directorio personal

~~~sh
ls ~/t*
~~~

## 9. Elimina el archivo test.txt de tu directorio MiPrimerDirectorio

~~~sh
rm ~/MiPrimerDirectorio/test.txt
~~~

## 10. Elimina el directorio MiPrimerDirectorio (asegúrate de que esté vacío)

~~~sh
rmdir ~/MiPrimerDirectorio
~~~

## 11. Cambia el nombre de nuevoTest.txt en /tmp a finalTest.txt

~~~sh
mv /tmp/nuevoTest.txt /tmp/finalTest.txt
~~~

## 12. Muestra las primeras 5 líneas de cualquier archivo de configuración dentro de /etc

> :pencil: **NOTA**
> Reemplaza {archivo_de_configuración} con el nombre real del archivo que deseas examinar.

~~~sh
head -n 5 /etc/{archivo_de_configuración}
~~~

## 13. Usa el comando find para buscar todos los archivos modificados en los últimos 7 días en tu directorio personal.

~~~sh
find ~/ -type f -mtime -7
~~~

## Punto de control

- ¿Qué comando usas para ver tu ubicación actual en el sistema de archivos?

Respuesta:
pwd

- ¿Cuál es la diferencia entre mover y copiar un archivo?

Respuesta:
Mover un archivo (mv) cambia su ubicación, mientras que copiar un archivo (cp) crea una segunda versión del archivo en una nueva ubicación.

- ¿Cómo puedes redirigir la salida de un comando a un archivo??

Respuesta:
Puedes usar el operador > para redirigir y sobrescribir o >> para redirigir y anexar.

- ¿Qué efecto tiene eliminar un directorio no vacío?

Respuesta:
No puedes eliminar un directorio no vacío con rmdir; debes vaciarlo primero o usar rm -r para eliminar tanto el directorio como su contenido.

- ¿Cómo puedes ver las primeras líneas de un archivo?

Respuesta:
Puedes usar el comando head -n {número de líneas} {nombre del archivo}.

