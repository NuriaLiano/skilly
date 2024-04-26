# Configuración de hosts virtuales

## Objetivo

El objetivo de este ejercicio es configurar un virtual hosts utilizando el servidor web Apache en un sistema Ubuntu 22. Aprenderás a crear y configurar un Virtual Host para alojar un sitio web, además de modificar algunos aspectos básicos de seguridad y rendimiento. Al final podrás comprobar su funcionamiento a través de un navegador.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurado correctamente el servidor Apache. Si has seguido las actividades hasta aquí este paso ya le tienes hecho.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Crear y configurar un Virtual Host

1. Crear directorios para los sitios web
2. Asignar permisos a los directorios
3. Crear archivos de configuración para los virtual hosts
4. Editar los archivos de configuración que se han creado en el punto anterior. 
5. Habilitar los virtual hosts
6. Reiniciar Apache

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que los sitios web estan activos
2. Comprueba que el servicio ``apache2`` sigue activo y sin errores
3. Revisa los archivos de logs