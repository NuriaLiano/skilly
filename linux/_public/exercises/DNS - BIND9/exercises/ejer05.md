# Entendiendo BIND9: Configuración de un servidor DNS esclavo

## Objetivo

El objetivo de este ejercicio es configurar un servidor DNS esclavo para el dominio "skilly.local", utilizando BIND9. Aprenderás cómo configurar la replicación de zonas entre un servidor DNS maestro y uno esclavo, mejorando la disponibilidad y redundancia de tu infraestructura DNS. Este ejercicio te ayudará a comprender el funcionamiento y la configuración de servidores DNS esclavos, una parte esencial de la administración de servidores DNS para entornos de producción.

## Requisitos previos

- Tener un servidor DNS maestro configurado y funcionando con BIND9, sirviendo el dominio "skilly.local".
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Tener acceso a un cliente Ubuntu para la verificación.
- Asegúrate que tu servidor DNS y el cliente Ubuntu 22 estén en la misma red.

## Pasos a seguir

### Configuración del Servidor DNS Maestro

1. Asegurarte de que el servidor DNS maestro tenga configurada correctamente la zona "skilly.local" y permita las transferencias de zona al servidor esclavo.

### Preparación del Servidor DNS Esclavo

2. Instalar BIND9 en la segunda máquina, que actuará como servidor DNS esclavo

### Configuración de la Zona Esclava en el Servidor DNS Esclavo

3. Configurar la zona "skilly.local" en el servidor esclavo, especificando que es una zona esclava y designando la dirección IP del servidor maestro

### Reiniciar los Servicios de BIND9 en Ambos Servidores

4. Aplicar y activar las configuraciones reiniciando BIND9 en ambos el servidor maestro y el servidor esclavo

### Verificación y Pruebas

5. Verifica que el servidor esclavo ha replicado la zona "skilly.local" del maestro.
