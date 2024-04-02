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

Esto se hace añadiendo una directiva ``allow-transfer`` en la configuración de la zona dentro de ``/etc/bind/named.conf.local``

~~~sh
zone "skilly.local" {
    type master;
    file "/etc/bind/db.skilly.local";
    allow-transfer { 192.168.1.11; };
};
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.11 con la dirección IP real de tu servidor DNS esclavo.

### Preparación del Servidor DNS Esclavo

2. Instalar BIND9 en la segunda máquina, que actuará como servidor DNS esclavo

~~~sh
sudo apt update
sudo apt install bind9 bind9utils bind9-doc dnsutils
~~~

### Configuración de la Zona Esclava en el Servidor DNS Esclavo

3. Configurar la zona "skilly.local" en el servidor esclavo, especificando que es una zona esclava y designando la dirección IP del servidor maestro

En el servidor esclavo, configura la zona "skilly.local" como esclava dentro de ``/etc/bind/named.conf.local``

~~~sh
zone "skilly.local" {
    type slave;
    file "db.skilly.local";
    masters { 192.168.1.10; };
};
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.10 con la dirección IP real de tu servidor DNS principal.

### Reiniciar los Servicios de BIND9 en Ambos Servidores

4. Aplicar y activar las configuraciones reiniciando BIND9 en ambos el servidor maestro y el servidor esclavo

~~~sh
sudo systemctl restart bind9
~~~

### Verificación y Pruebas

5. Verifica que el servidor esclavo ha replicado la zona "skilly.local" del maestro.

~~~sh
dig @192.168.1.10 skilly.local
dig @192.168.1.11 skilly.local
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar las ips con las que correspondan en tu caso.