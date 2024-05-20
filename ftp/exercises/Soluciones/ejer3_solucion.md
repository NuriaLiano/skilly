# [Solución] Configuración avanzada de vsFTP

## Objetivo

Configurar un servidor vsFTP de manera avanzada, asegurando la transferencia de archivos segura y gestionando permisos de usuarios.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Confirma que tienes instalado el servidor FTP y funciona correctamente.

### Configuración

Edita el fichero de configuración y añade las siguientes políticas:

~~~sh
sudo nano /etc/vsftpd.conf
~~~

   1. Permitir acceso local

~~~sh
local_enable=YES
~~~

   2. Permitir escritura

~~~sh
write_enable=YES
~~~

   3. Configurar la máscara de umask para los archivos subidos

~~~sh
local_umask=022

~~~

   4. Deshabilitar el acceso anónimo

~~~sh
anonymous_enable=NO

~~~

   5. Activar chroot

~~~sh
chroot_local_user=YES

~~~

   6. Habilitar SSL/TLS

~~~sh
ssl_enable=YES
rsa_cert_file=/etc/ssl/private/vsftpd.pem
rsa_private_key_file=/etc/ssl/private/vsftpd.pem
ssl_ciphers=HIGH

~~~

   7. Crear un archivo de usuariops virtuales y sus contraseñas (/etc/vsftpd/virtusers)

~~~sh
user1
password1
user2
password2

~~~

   8. Crear base de datos de usuarios virtuales

~~~sh
sudo db_load -T -t hash -f /etc/vsftpd/virtusers /etc/vsftpd/virtusers.db

~~~

   9.  Editar el archivo PAM para vsFTP (/etc/pam.d/vsftpd)

~~~sh
auth required pam_userdb.so db=/etc/vsftpd/virtusers
account required pam_userdb.so db=/etc/vsftpd/virtusers

~~~


### Verificación y pruebas

1. Prueba la conexión FTP

~~~sh
ftp localhost
~~~

2. Prueba la transferencia de archivos

~~~sh
put localfile.txt
get remotefile.txt

~~~

3. Verifica el uso de SSL/TLS

Usa un cliente FTP que soporte SSL/TLS (como FileZilla) para conectarte al servidor y asegúrate de que las transferencias de archivos están cifradas.

4. Revisa los logs

~~~sh
sudo tail -f /var/log/vsftpd.log
~~~
