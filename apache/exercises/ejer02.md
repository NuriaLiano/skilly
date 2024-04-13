# Configuración básica de Apache

## Objetivo

El objetivo de este ejercicio es configurar un sitio web básico utilizando el servidor web Apache en un sistema Ubuntu 22. Aprenderás a crear y configurar un Virtual Host para alojar un sitio web, además de modificar algunos aspectos básicos de seguridad y rendimiento. Al final podrás comprobar su funcionamiento a través de un navegador.s

## Pasos a seguir

### Preparación del entorno

- Elige un sistema Linux para la instalación (yo trataré los ejercicios con Ubuntu 22). Puede ser una máquina virtual o un servidor dedicado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Creación y configuración del Virtual Host

1. Crea un directorio para tu sitio web
2. Asigna permisos a Apache al directorio

> :mag_right: **INVESTIGA**
> ¿Qué usuario usa por defecto Apache?

3. Crea un archivo de configuración para el Virtual Host
4. Habilita el sitio
5. Reinicia Apache

### Verificación y pruebas

> :brain: **RECUERDA**
> El log de apache se encuentra en el siguiente path ``/var/log/apache/error.log``

1. Verifica que el sitio web está activo
2. Comprueba que el servicio ``apache2`` sigue activo y sin errores
3. Revisa los archivos de log