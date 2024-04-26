# [Solución] Entendiendo BIND9: Configuración básica de un dominio

## Pasos a seguir

### Preparación del entorno

1. Verifica que BIND9 esté instalado y corriendo en tu sistema

~~~sh
systemctl status bind9
~~~

### Configuración de zona para "skilly.local"

2. Edita el archivo named.conf.local para añadir una zona para "skilly.local". Esta zona será de tipo "master"

~~~sh
zone "skilly.local" {
    type master;
    file "/etc/bind/db.skilly.local";
};
~~~

### Creación del archivo de zona

> :pencil: **NOTA**
> Copio el fichero ``db.local`` para utilizarlo como plantilla y no sobreescribir el original que trae bind9

3. Crea un nuevo archivo en el directorio de BIND9 para tu zona, por ejemplo, /etc/bind/db.skilly.local.

~~~sh
sudo cp /etc/bind/db.local /etc/bind/db.skilly.local
~~~

4. Define el SOA (Start of Authority) y los registros NS (Name Server) para tu dominio. También añade un registro A para "www.skilly.local" y apúntalo a una dirección IP ficticia (p.ej., 192.168.1.10).

~~~sh
;
; BIND data file for local loopback interface
;
$TTL    604800
@       IN      SOA     ns.skilly.local. admin.skilly.local. (
                              2         ; Serial
                         604800         ; Refresh
                          86400         ; Retry
                        2419200         ; Expire
                         604800 )       ; Negative Cache TTL
; nameservers
@       IN      NS      ns.skilly.local.

; addresses
ns      IN      A       192.168.1.10
www     IN      A       192.168.1.10
~~~

### Actualización del archivo de configuración principal de BIND9

5. Asegúrate de que BIND9 esté configurado para leer tu archivo de zona. Esto generalmente se hace automáticamente, pero es bueno verificar.

Si seguiste los pasos anteriores, esto ya debería estar configurado correctamente pero, por si acaso, revisa los ficheros que has configurado previamente.

> :brain: **RECUERDA**
> Para verificar el archivo de zona puedes utilizar el comando ``sudo named-checkzone skilly.local /etc/bind/db.skilly.local``

### Reinicio y verificación

6. Reinicia el servicio de BIND9 para aplicar los cambios.

~~~sh
sudo systemctl restart bind9
~~~

7. Utiliza herramientas como dig o nslookup para verificar que tu dominio "skilly.local" resuelve correctamente al IP que configuraste.

~~~sh
dig @localhost www.skilly.local A
~~~

~~~sh
nslookup www.skilly.local 127.0.0.1
~~~

> :black_joker: **PISTA**
> Sí encuentras algún problema con el servicio puedes revisar los logs del sistema, los mensajes te darán pistas sobre lo que necesitas corregir.
> ``cat /var/log/syslog``
