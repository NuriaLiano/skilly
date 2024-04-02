# Entendiendo BIND9: Configuración básica de un dominio

## Objetivo

El objetivo de este ejercicio es familiarizarte con la configuración básica de BIND9, el software de servidor DNS más utilizado en sistemas UNIX-like. Aprenderás a configurar un dominio de ejemplo, "skilly.local", en BIND9. Este ejercicio te permitirá explorar los archivos de configuración de BIND9, entender cómo se estructuran las zonas DNS y practicar la verificación del funcionamiento del servidor DNS.

## Requisitos previos

Antes de empezar vamos a revisar que tenemos todo a punto. Es necesario:

- Disponer de una máquina virtual o servidor dedicado con sistema operativo GNU-Linux (yo trataré los ejercicios con Ubuntu 22).
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Tener instalado BIND9.

> :brain: **RECUERDA**
> Si no está instalado, puedes hacerlo con el comando ``sudo apt install bind9 bind9utils bind9-doc dnsutils``.

## Pasos a seguir

### Preparación del entorno

1. Verifica que BIND9 esté instalado y corriendo en tu sistema
2. Asigna una ip estática a tu servidor.

### Configuración de zona para "skilly.local"

2. Edita el archivo named.conf.local para añadir una zona para "skilly.local". Esta zona será de tipo "master"

### Creación del archivo de zona

3. Crea un nuevo archivo en el directorio de BIND9 para tu zona, por ejemplo, /etc/bind/db.skilly.local.
4. Define el SOA (Start of Authority) y los registros NS (Name Server) para tu dominio. También añade un registro A para "www.skilly.local" y apúntalo a una dirección IP ficticia (p.ej., 192.168.1.10).

### Actualización del archivo de configuración principal de BIND9

5. Asegúrate de que BIND9 esté configurado para leer tu archivo de zona. Esto generalmente se hace automáticamente, pero es bueno verificar.

### Reinicio y verificación

6. Reinicia el servicio de BIND9 para aplicar los cambios.
7. Utiliza herramientas como dig o nslookup para verificar que tu dominio "skilly.local" resuelve correctamente al IP que configuraste.
