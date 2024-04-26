# Configuración avanzada de Apache

## Objetivo

El objetivo de este ejercicio es crear un sito web personalizado en el servidor Apache en un entorno Ubuntu 22. Aprendrás a apalicar configuraciones avanzadas con el bloque `<Directory>` y podrás personalizar los archivos de error para proporcionar una mejor experiencia al usuario final. 

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurado correctamente el servidor Apache. Si has seguido las actividades hasta aquí este paso ya le tienes hecho.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Creación y configuración avanzada de un sitio web

1. Crear directorios para el sitio web
2. Asigna permisos a los directorios
3. Crea el archivo de configuración del virtual host
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

5. Crea un directorio para almacenar los archivos de error personalizados
6. Habilita el Virtual Host
7. Reinicia el servicio Apache

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que el sitio web está activo y todas las restricciones se cumplen.
2. Comprueba que el servicio ``apache2`` sigue activo y sin errores
3. Revisa los archivos de logs