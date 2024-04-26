# Configuración básica de Apache

## Objetivo

El objetivo de este ejercicio es configurar un sitio web básico utilizando el servidor web Apache en un sistema Ubuntu 22. Aprenderás a crear y configurar un Virtual Host para alojar un sitio web, además de modificar algunos aspectos básicos de seguridad y rendimiento. Al final podrás comprobar su funcionamiento a través de un navegador.s

## Pasos a seguir

### Preparación del entorno

- Elige un sistema Linux para la instalación (yo trataré los ejercicios con Ubuntu 22). Puede ser una máquina virtual o un servidor dedicado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Creación y configuración del Virtual Host

1. Crea un directorio para tu sitio web

~~~sh
sudo mkdir -p /var/www/skilly.info/public_html
~~~

2. Crea un html para tu primera página

~~~sh
nano /var/www/skilly.info/public_html/index.html
~~~

3. Asigna permisos a Apache al directorio

> :brain: **RECUERDA**
> Puedes comprobar el propietario y los permisos del directorio con el comando ``ls -la``

~~~sh
sudo chown -R www-data:www-data /var/www/skilly.info/public_html
sudo chmod -R 755 /var/www/skilly.info
~~~

> :mag_right: **INVESTIGA**
> ¿Qué usuario usa por defecto Apache?
> **Solución**
> Apache usa el usuario www-data

3. Crea un archivo de configuración para el Virtual Host

~~~sh
sudo nano /etc/apache2/sites-available/skilly.info.conf
~~~

3.1 Añade la siguiente configuración al fichero que acabas de crear:

~~~sh
<VirtualHost *:80>
    ServerAdmin webmaster@skilly.info
    ServerName skilly.info
    ServerAlias www.skilly.info
    DocumentRoot /var/www/skilly.info/public_html
    ErrorLog ${APACHE_LOG_DIR}/skilly.info_error_log
    ErrorLog ${APACHE_LOG_DIR}/skilly.info_access_log combined
</VirtualHost>
~~~

4. Habilita el sitio

~~~sh
sudo a2ensite skilly.info.conf
~~~

5. Reinicia Apache

~~~sh
sudo systemctl restart apache2
~~~

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que el sitio web está activo

    Accede desde tu navegador a ``http://skilly.info``. Si puedes ver el html que has creado anteriormente es que el servidor está configurador correctamente
2. Comprueba que el servicio ``apache2`` sigue activo y sin errores

~~~sh
sudo systemctl status apache2
~~~

3. Revisa los archivos de log

~~~sh
sudo cat /var/log/apache2/error.log
~~~
