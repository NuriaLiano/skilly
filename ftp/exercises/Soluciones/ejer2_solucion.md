# [Solución] Interacción de comandos de vsFTP

## Objetivo

Familiarizarse con el uso de comandos de vsFTP en la consola de Ubuntu para gestionar transferencias de archivos, navegar por directorios, y realizar operaciones básicas en un servidor FTP, asegurando una comprensión práctica y aplicada de las funcionalidades básicas y avanzadas de vsFTP.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- 

### Comandos

1. Conectate al servidor FTP

~~~sh
ftp ftp.server.com
~~~

2. Navega por los directorios del servidor FTP

~~~sh
ls
cd docs
cd ..
~~~

3. Descarga archivos desde el servidor FTP

~~~sh
get example.txt
~~~

4. Sube archivos al servidor

~~~sh
put upload.txt
~~~

5. Renombra un archivo en el servidor

~~~sh
rename oldname.txt newname.txt

~~~

6. Elimina un archivo del servidor

~~~sh
delete deletefile.txt

~~~

7. Crea un nuevo directorio `skillyFTP`

~~~sh
mkdir skillyFTP


~~~

8. Elimina el directorio `skillyFTP`

~~~sh
rmdir skillyFTP

~~~

9.  Finaliza la sesión FTP

~~~sh
bye

~~~

### Preguntas de trivial 🤓

- ¿Qué comando has utilizado para cambiar de directorio y cómo supiste en qué directorio estabas?

Para cambiar de directorio se utiliza el comando `cd` y para saber en que directorio estaba usé el comando `pwd`.

- ¿Cúales son los comandos que has usado para subir y descargar archivos? ¿En que se diferencian?

Para subir archivos al servidor FTP, usé el comando `put` y para descargar archivos desde el servidor FTP, usé el comando `get`.
La diferencia en su uso es que put se usa para enviar un archivo desde el cliente al servidor, mientras que get se utiliza para recibir un archivo desde el servidor al cliente.

- ¿Qué consideraciones de seguridad crees que son importantes? Sólo dá tu opinión o enuméralas
1. Deshabilitar el acceso anónimo
2. Habilitar SSL/TLS
3. Utilizar contraseñas fuertes
4. Configurar chroot para usuarios
5. Monitorear y registrar la actividad
6. Actualizar regularmente