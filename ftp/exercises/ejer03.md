# Configuración avanzada de vsFTP

## Objetivo

Configurar un servidor vsFTP de manera avanzada, asegurando la transferencia de archivos segura y gestionando permisos de usuarios.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Confirma que tienes instalado el servidor FTP y funciona correctamente.

### Configuración

Edita el fichero de configuración y añade las siguientes políticas:
   1. Permitir acceso local
   2. Permitir escritura
   3. Configurar la máscara de umask para los archivos subidos
   4. Deshabilitar el acceso anónimo
   5. Activar chroot
   6. Habilitar SSL/TLS
   7. Crear un archivo de usuariops virtuales y sus contraseñas (/etc/vsftpd/virtusers)
   8. Crear base de datos de usuarios virtuales
   9. Editar el archivo PAM para vsFTP (/etc/pam.d/vsftpd)


### Verificación y pruebas

1. Prueba la conexión FTP
2. Prueba la transferencia de archivos
3. Verifica el uso de SSL/TLS
4. Revisa los logs