# [Solución] Ejercicio iniciación de DNS

## Instalación y configuración

> :mag_right: **INVESTIGA**
> ¿Existen varias herramientas para la gestión de servidores DNS?
> **Solución**:
> dnsmasq, PowerDNS, entre otros.

1. Instala BIND9

   ~~~sh
   sudo apt update
   sudo apt install bind9 bind9utils bind9-doc dnsutils
   ~~~

2. Configura el servidor DNS para que actúe como un servidor autoritativo para un dominio de ejemplo (p. ej., "skilly.local").

    2.1 Primero es necesario editar el archivo ``named.conf.local`` para añadir la zona del dominio "skilly.local".

   ~~~sh
   sudo nano /etc/bind/named.conf.local
   ~~~

    2.2 Añade lo siguiente al archivo

   ~~~sh
   zone "skilly.local" {
    type master;
    file "/etc/bind/zones/db.skilly.local";
    };
   ~~~

    2.3 Después, crea el directorio para las zonas si aún no existe y copia el archivo de base de datos de ejemplo para tu zona

   ~~~sh
    sudo mkdir -p /etc/bind/zones
    sudo cp /etc/bind/db.local /etc/bind/zones/db.skilly.local
   ~~~

3. Añade registros DNS básicos a tu zona, incluyendo al menos un registro A y, opcionalmente, un registro MX y un registro CNAME.

    3.1 Edita el archivo de la zona para configurar los registros DNS

   ~~~sh
    sudo nano /etc/bind/zones/db.skilly.local
   ~~~

    3.2 Dentro de ``/etc/bind/zones/db.skilly.local``, configura tus registros. Por ejemplo

   ~~~sh
    @       IN      SOA     skilly.local. root.skilly.local. (
                          2023040101         ; Serial
                          604800             ; Refresh
                          86400              ; Retry
                          2419200            ; Expire
                          604800 )           ; Negative Cache TTL
    ;
    @       IN      NS      ns.skilly.local.
    ns      IN      A       192.168.1.2
    @       IN      A       192.168.1.2
    www     IN      A       192.168.1.2
    mail    IN      A       192.168.1.3
    @       IN      MX 10   mail.skilly.local.
   ~~~

    > :sparkles: **IMPORTANTE**
    > Reemplaza 192.168.1.2 con la dirección IP del servidor DNS y ajusta los registros según lo que necesites.

4. Configura el sistema local (o un sistema cliente en la misma red) para usar el servidor DNS que acabas de configurar como su servidor DNS primario.

    4.1 Edita el archivo de la zona para configurar los registros DNS

   ~~~sh
    sudo nano /etc/resolv.conf
   ~~~

    4.2 Añade la línea

   ~~~sh
    nameserver 192.168.1.2
   ~~~

    > :sparkles: **IMPORTANTE**
    > Cambia 192.168.1.2 por la dirección IP de tu servidor DNS.

## Verificación y pruebas

> :brain: **RECUERDA**
> Las herramientas necesarias para comprobar que el servidor DNS funciona correctamente son:
> - dig
> - nslookup
> - systemctl status bind9

6. Verifica que el servidor DNS esté funcionando correctamente y que sea capaz de resolver el nombre de dominio que configuraste a la dirección IP correspondiente.

   ~~~sh
   systemctl status bind9
   ~~~

7. Utiliza herramientas de diagnóstico DNS para realizar consultas al servidor y verificar las respuestas.

    7.1 Para verificar la resolución del nombre de dominio

   ~~~sh
    dig @localhost skilly.local A
   ~~~

    7.2 Para usar nslookup

   ~~~sh
    nslookup skilly.local 192.168.1.2
   ~~~
