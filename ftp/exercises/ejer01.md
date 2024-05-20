# Instalacion y configuración inicial vsFTP

## Objetivo

Instalar y configurar el servidor vsFTP en un sistema Ubuntu, permitiendo el acceso anónimo y configurando un usuario específico para el acceso FTP, asegurando que los permisos y las políticas de acceso estén correctamente establecidas. Verificar la correcta operación del servicio mediante pruebas de conexión y transferencia de archivos, y revisar los registros para identificar posibles errores o incidencias.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Instalación y configuración

1. Instalar vsFTP
2. Edita el archivo de configuración principal y establece estos requisitos:

> :black_joker: **PISTA**
> El archivo de configuración está en el directorio: `/etc/vsftpd.conf`
   
   1. Habilita el acceso anónimo
   2. Establece una política de escritura para los usuarios anónimos.

3. Configura el usuario 'Jana' para el acceso a FTP
4. Establece un directorio raíz para el usuario y asegúrate de que tiene los permisos adecuados.
5. Reinicia el servicio para aplicar los cambios

### Verificación y pruebas

1. Comprueba que el servicio ``vsftpd`` sigue activo y sin errores.
2. Intenta conectarte al servidor por línea de comandos desde otra máquina virtual
3. Sube archivos con ambos usuarios y comprueba las limitaciones
4. Revisa los archivos de logs