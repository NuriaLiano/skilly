# [Solución] Manejo de permisos de ficheros y rutas. Parte II

## 1. Crea un directorio llamado PermisosPrueba en tu directorio personal

~~~sh
mkdir ~/PermisosPrueba
~~~

## 2. Dentro de PermisosPrueba, crea un archivo llamado archivoPrueba.txt
 
~~~sh
touch ~/PermisosPrueba/archivoPrueba.txt

~~~

## 3. Cambia los permisos del archivo archivoPrueba.txt para que solo el propietario pueda leer y escribir en el archivo

~~~sh
chmod 600 ~/PermisosPrueba/archivoPrueba.txt

~~~

## 4. Verifica los permisos del archivo archivoPrueba.txt utilizando un comando

~~~sh
ls -l ~/PermisosPrueba/archivoPrueba.txt

~~~

## 5. Cambia la ruta al directorio PermisosPrueba utilizando una ruta relativa desde tu directorio personal

~~~sh
cd PermisosPrueba

~~~

## 6. Cambia los permisos del directorio PermisosPrueba para que solo el propietario pueda leer, escribir y ejecutar en el directorio

~~~sh
chmod 700 ~/PermisosPrueba

~~~

## 7. Muestra los permisos del directorio PermisosPrueba para verificar tus cambios

~~~sh
ls -ld ~/PermisosPrueba

~~~

## 8. Intenta acceder al directorio PermisosPrueba utilizando otra cuenta de usuario (si es posible)

~~~sh
su otro_usuario
cd ~/PermisosPrueba
exit
~~~

## 9. Regresa a tu directorio personal y elimina el directorio PermisosPrueba junto con su contenido

~~~sh
rm -r ~/PermisosPrueba
~~~

## 10. Crea un grupo nuevo llamado grupo_prueba, añade algunos usuarios a este grupo y cambia el grupo propietario de archivoPrueba.txt a grupo_prueba

~~~sh
sudo groupadd grupo_prueba
sudo usermod -a -G grupo_prueba usuario
sudo chgrp grupo_prueba ~/PermisosPrueba/archivoPrueba.txt
chmod 640 ~/PermisosPrueba/archivoPrueba.txt
~~~

## 11. Configura un cron job que cambie los permisos de un directorio específico a las 3 AM todos los días. Asegúrate de que solo el propietario pueda acceder durante la noche, pero todos los usuarios puedan leer los archivos durante el día.

~~~sh
crontab -e
~~~

Añade la siguiente línea para cambiar los permisos durante la noche y luego restablecerlos por la mañana:

~~~sh
0 3 * * * chmod 700 ~/PermisosPrueba
0 8 * * * chmod 755 ~/PermisosPrueba
~~~


## Pista sobre los permisos

![imagen permisos](https://gitlab.com/Nuria_Liano/skilly/-/raw/023ab0707fc4a6ff18f1cc831777c7a8fd94a70c/img/permisos.png)

## Punto de control
Reflexiona sobre lo que has aprendido y responde a las siguientes preguntas [Ver solución]():

- ¿Cuál es la diferencia entre una ruta absoluta y una relativa?

Una **ruta absoluta** especifica la ubicación de un archivo o directorio desde el directorio raíz del sistema de archivos, comenzando con /. Por ejemplo, /home/usuario/PermisosPrueba/archivoPrueba.txt es una ruta absoluta que indica exactamente dónde se encuentra el archivo, independientemente de la ubicación actual del usuario en el sistema de archivos.

Una **ruta relativa** especifica la ubicación de un archivo o directorio en relación con el directorio de trabajo actual del usuario. No comienza con /. Por ejemplo, si estás en /home/usuario, puedes referirte al mismo archivo anterior con la ruta relativa PermisosPrueba/archivoPrueba.txt.

- ¿Cómo afectan los permisos de un directorio a los archivos y subdirectorios contenidos dentro?

Los permisos de un directorio influyen en la capacidad de los usuarios para listar su contenido, acceder a subdirectorios y abrir archivos dentro de él. Si un directorio tiene permisos de acceso restringidos (por ejemplo, solo lectura para el propietario), aunque los archivos dentro de él puedan tener permisos más permisivos, los usuarios no podrán ver ni acceder a estos archivos a menos que también tengan permisos adecuados en el directorio. Además, los permisos de ejecución en un directorio son necesarios para hacerlo el directorio de trabajo actual.

- ¿Qué comando usaste para cambiar los permisos de un archivo o directorio?

Utilicé el comando chmod para cambiar los permisos de archivos y directorios. Este comando permite especificar quién puede leer, escribir o ejecutar un archivo o acceder a un directorio. Por ejemplo, chmod 700 archivo establece que solo el propietario puede leer, escribir y ejecutar el archivo.

- ¿Qué sucede cuando intentas acceder a un directorio sin los permisos necesarios?

Si intentas acceder a un directorio sin los permisos necesarios, el sistema te denegará el acceso, mostrando un mensaje de error como "Permission denied". Esto significa que no tienes los permisos adecuados para realizar la acción deseada en ese directorio, como listar su contenido, acceder a subdirectorios o leer archivos dentro de él.


