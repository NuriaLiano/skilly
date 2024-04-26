# [Solución] Configuración de hosts virtuales

## Objetivo

El objetivo de este ejercicio es configurar un virtual hosts utilizando el servidor web Apache en un sistema Ubuntu 22. Aprenderás a crear y configurar un Virtual Host para alojar un sitio web, además de modificar algunos aspectos básicos de seguridad y rendimiento. Al final podrás comprobar su funcionamiento a través de un navegador.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurado correctamente el servidor Apache. Si has seguido las actividades hasta aquí este paso ya le tienes hecho.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Crear y configurar un Virtual Host

1. Crear directorios para los sitios web

~~~sh
sudo mkdir -p /var/www/lubina.com/public_html
sudo mkdir -p /var/www/cangrejo.com/public_html
sudo mkdir -p /var/www/salmon.com/public_html
~~~

2. Asignar permisos a los directorios

> :brain: **RECUERDA**
> El usuario y grupo ``www-data`` es el que usa por defecto Apache


~~~sh
sudo chown -R www-data:www-data /var/www/lubina.com/public_html
sudo chown -R www-data:www-data /var/www/cangrejo.com/public_html
sudo chown -R www-data:www-data /var/www/salmon.com/public_html
~~~

3. Crear archivos de configuración para los virtual hosts

~~~sh
sudo cp /etc/apache2/sites-available/000-default.conf //etc/apache2/sites-available/lubina.com.conf
sudo cp /etc/apache2/sites-available/000-default.conf //etc/apache2/sites-available/cangrejo.com.conf
sudo cp /etc/apache2/sites-available/000-default.conf //etc/apache2/sites-available/salmon.com.conf
~~~

4. Editar los archivos de configuración que se han creado en el punto anterior. 

> :brain: **RECUERDA**
> `ServerName`: Establece el nombre de dominio principal para el sitio web
> `ServerAlias`: Especifíca un alias opcional para el sitio web
> `DocumentRoot`: Especifíca la ubicación del directorio raíz del sitio web
> `<Directory>`: Define las directivas de acceso y configuración para el directorio raíz del sitio web
> `Errorlog` y `CustomLog`: especifíca las ubicaciones de los archivos de registro de errores y acceso

**lubina.com**
~~~sh
<VirtualHost *:80>
    ServerAdmin webmaster@example.com
    ServerName lubina.com
    ServerAlias www.lubina.com

    DocumentRoot /var/www/lubina.com/public_html

    <Directory /var/www/lubina.com/public_html>
        Options -Indexes +FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>

    ErrorLog ${APACHE_LOG_DIR}/lubina.com_error.log
    CustomLog ${APACHE_LOG_DIR}/lubina.com_access.log combined
</VirtualHost>
~~~

**cangrejo.com**
~~~sh
<VirtualHost *:80>
    ServerAdmin webmaster@example.com
    ServerName cangrejo.com
    ServerAlias www.cangrejo.com

    DocumentRoot /var/www/cangrejo.com/public_html

    <Directory /var/www/cangrejo.com/public_html>
        Options -Indexes +FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>

    ErrorLog ${APACHE_LOG_DIR}/cangrejo.com_error.log
    CustomLog ${APACHE_LOG_DIR}/cangrejo.com_access.log combined
</VirtualHost>
~~~

**salmon.com**
~~~sh
<VirtualHost *:80>
    ServerAdmin webmaster@example.com
    ServerName salmon.com
    ServerAlias www.salmon.com

    DocumentRoot /var/www/salmon.com/public_html

    <Directory /var/www/salmon.com/public_html>
        Options -Indexes +FollowSymLinks
        AllowOverride All
        Require all granted
    </Directory>

    ErrorLog ${APACHE_LOG_DIR}/salmon.com_error.log
    CustomLog ${APACHE_LOG_DIR}/salmon.com_access.log combined
</VirtualHost>
~~~

5. Habilitar los virtual hosts

> :note: **NOTA**
> Si quieres desactivar el sitio web por defecto puedes ejecutar este comando `sudo a2dissite 000-default.conf`.

~~~sh
sudo a2ensite lubina.com.conf
sudo a2ensite cangrejo.com.conf
sudo a2ensite salmon.com.conf
~~~

6. Reiniciar Apache

~~~sh
sudo systemctl restart apache2
~~~

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que los sitios web estan activos

Accede desde tu navegador a ``http://lubina.com``. Si puedes ver el html que has creado anteriormente es que el servidor está configurador correctamente

2. Comprueba que el servicio ``apache2`` sigue activo y sin errores

~~~sh
sudo systemctl status apache2
~~~

3. Revisa los archivos de log

~~~sh
sudo cat /var/log/apache2/error.log
~~~
