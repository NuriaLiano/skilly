# [Solución] Instalacion y configuración inicial vsFTP

## Objetivo



## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Instalación y configuración

1. Instalar vsFTP

~~~sh
sudo apt install vsftpd
~~~

2. Edita el archivo de configuración principal y establece estos requisitos:

> :black_joker: **PISTA**
> El archivo de configuración está en el directorio: `/etc/vsftpd.conf`

~~~sh
sudo nano /etc/vsftpd.conf
~~~

   1. Habilita el acceso anónimo

~~~sh
anonymous_enable=YES
~~~

   2. Establece una política de escritura para los usuarios anónimos.

~~~sh
anon_upload_enable=YES
anon_mkdir_write_enable=YES
~~~

3. Configura el usuario 'Angie' para el acceso a FTP

~~~sh
sudo adduser --disabled-password --gecos "" Angie
sudo passwd -d Angie
~~~

4. Establece un directorio raíz para el usuario y asegúrate de que tiene los permisos adecuados.

~~~sh
chroot_local_user=YES
user_sub_token=$USER
local_root=/home/$USER/ftp

#ESTABLECER LOS PERMISOS ADECUADOS
sudo mkdir /home/Angie/ftp
sudo chown nobody:nogroup /home/Angie/ftp
sudo chmod a-w /home/Angie/ftp
sudo mkdir /home/Angie/ftp/files
sudo chown Angie:Angie /home/Angie/ftp/files
~~~

5. Reinicia el servicio para aplicar los cambios

~~~sh
sudo systemctl restart vsftpd
~~~

### Verificación y pruebas

1. Comprueba que el servicio ``vsftpd`` sigue activo y sin errores.

~~~sh
sudo systemctl status vsftpd
~~~

2. Intenta conectarte al servidor por línea de comandos desde otra máquina virtual

~~~sh
ftp <IP-del-servidor>
~~~

3. Sube archivos con ambos usuarios y comprueba las limitaciones

Utiliza comandos FTP básicos como put para subir y get para descargar.

4. Revisa los archivos de logs

~~~sh
cat /var/log/vsftpd.log
~~~