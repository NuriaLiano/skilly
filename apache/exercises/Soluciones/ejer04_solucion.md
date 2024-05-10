# [Solución] Configuración avanzada de Apache

## Objetivo

El objetivo de este ejercicio es crear un sito web personalizado en el servidor Apache en un entorno Ubuntu 22. Aprendrás a apalicar configuraciones avanzadas con el bloque `<Directory>` y podrás personalizar los archivos de error para proporcionar una mejor experiencia al usuario final. 

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurado correctamente el servidor Apache. Si has seguido las actividades hasta aquí este paso ya le tienes hecho.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Creación y configuración avanzada de un sitio web

1. Crear directorios para el sitio web

~~~sh
sudo mkdir -p /var/www/skilly/public_html
~~~

2. Asigna permisos a los directorios

~~~sh
sudo chown -R www-data:www-data /var/www/skilly
sudo chmod -R 755 /var/www/skilly
~~~

3. Crea el archivo de configuración del virtual host

~~~sh
nano /etc/apache2/sites-available/skilly.conf
~~~

4. Configura el virtual host aplicando estas directivas:
    4.1 Desactiva la opción de listar el contenido de los directorios.
    4.2 Permite que los archivos .htaccess modifiquen la configuración.
    4.3 Define un orden de acceso que niega el acceso a todos por defecto y luego permite el acceso solo desde la red específica 192.168.1.0/24.

    > :pencil: **NOTA**
    >
    > La dirección `192.168.1.0/24` es falsa pero puedes crear una máquina virtual o contenedor y asignarle esa ip para comprobar realmente si prohibe el acceso. 

    4.4 Limita el tamaño máximo de carga de archivos a 10 MB.
    4.5 Deshabilita la ejecución de scripts PHP en el directorio especificado.
    4.6 Especifica una lista de extensiones de archivo que serán denegadas para acceder directamente.
    4.7 Establece el orden de acceso para permitir a todos los usuarios de la red 192.168.1.0/24 acceder al directorio.
    4.8 Permite que los archivos .htaccess y .htpasswd modifiquen la configuración y se niega el acceso a otros archivos específicos.

~~~sh
<VirtualHost *:80>
    ServerAdmin webmaster@example.com
    ServerName skilly.local

    DocumentRoot /var/www/skilly/public_html

    <Directory /var/www/skilly/public_html>
        Options -Indexes
        AllowOverride All
        Require ip 192.168.1.0/24
        LimitRequestBody 10485760
        php_admin_flag engine off

        <FilesMatch "\.(htaccess|htpasswd)$">
            Require all denied
        </FilesMatch>

        <FilesMatch "\.(php|pl|py|cgi)$">
            Require all denied
        </FilesMatch>
    </Directory>

    ErrorDocument 404 /error/404.html
    ErrorDocument 500 /error/500.html

    ErrorLog ${APACHE_LOG_DIR}/error.log
    CustomLog ${APACHE_LOG_DIR}/access.log combined
</VirtualHost>
~~~

5. Crea un directorio para almacenar los archivos de error personalizados
   
~~~sh
sudo mkdir /var/www/misitio/error
~~~

6. Habilita el Virtual Host

~~~sh
sudo a2ensite skilly.conf
sudo a2dissite 000-default.conf
~~~

7. Reinicia el servicio Apache

~~~sh
sudo systemctl restart apache2
~~~

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que el sitio web está activo y todas las restricciones se cumplen.

~~~sh
sudo systemctl status apache2
~~~

2. Comprueba que el servicio ``apache2`` sigue activo y sin errores

3. Revisa los archivos de logs

~~~sh
cat /var/log/apache2/error.log
~~~