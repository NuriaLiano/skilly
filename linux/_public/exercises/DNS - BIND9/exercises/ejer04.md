# Entendiendo BIND9: configuración de subdominios

## Objetivo

El objetivo de este ejercicio es avanzar en tu habilidad configurando BIND9, aprendiendo a configurar subdominios dentro de tu dominio principal "skilly.local". Luego, verificarás la configuración utilizando un cliente Ubuntu para asegurarte de que el subdominio se resuelve correctamente. Este ejercicio profundiza en la gestión de zonas DNS y la resolución de nombres, habilidades cruciales para la administración de redes.

## Requisitos previos

- Haber completado el ejercicio de [Entendiendo BIND9: Configuración de un cliente DNS](./ejer03.md)
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Tener acceso a un cliente Ubuntu para la verificación

## Pasos a seguir

### Configuración de subdominios en BIND9

1. Asumiendo que ya tienes configurado el dominio "skilly.local", crearás un subdominio llamado "dev.skilly.local".

### Creación del archivo de zona para el subdominio

2. Crea y configura un nuevo archivo de zona para "dev.skilly.local", siguiendo una estructura similar a la del dominio principal.
3. Actualiza ``named.conf.local`` para incluir el nuevo subdominio, asegurando que BIND9 pueda gestionar las consultas para este

### Reiniciar el Servidor BIND9

4. Reinicia BIND9 para aplicar los cambios y cargar la nueva configuración de zona.

### Configuración del Cliente Ubuntu

5. Asegurarte de que tu cliente Ubuntu está configurado para utilizar tu servidor DNS BIND9

### Verificación y Pruebas

6. Desde tu cliente Ubuntu, verifica la resolución del subdominio