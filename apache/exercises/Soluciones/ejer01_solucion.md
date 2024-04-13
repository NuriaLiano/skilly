# [Solución] Instalación de Apache

## Objetivo

## Pasos a seguir

### Preparación del entorno

- Elige un sistema Linux para la instalación (yo trataré los ejercicios con Ubuntu 22). Puede ser una máquina virtual o un servidor dedicado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Instalación básica y pruebas

> :mag_right: **INVESTIGA**
> ¿Existen otros servidores web aparte de Apache?
> **Solución**:
> Sí, existen muchos más servidores web. Algunos son: Nginx, ISS (Microsoft), Lighttpd, Tomcat, entre otros.

1. Actualiza el sistema

~~~sh
sudo apt update && sudo apt upgrade
~~~

2. Instala apache

~~~sh
sudo apt install apache2
~~~

3. Comprueba que el servicio está ejecutándose

~~~sh
sudo systemctl status apache2
~~~

4. Comprueba el fichero de log de apache
~~~sh
sudo cat /var/log/apache2/error.log
~~~

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache2/error.log``
