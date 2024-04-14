# Entendiendo BIND9: Delegación de zona

## Objetivo

Este ejercicio tiene como objetivo enseñarte a configurar la delegación de una subzona dentro de tu dominio principal usando BIND9. Aprenderás a dividir el espacio de nombres de DNS de manera que una porción específica del dominio sea gestionada por otro servidor DNS. Este proceso es esencial para la administración distribuida de nombres de dominio, permitiendo una mayor flexibilidad y escalabilidad.

## Requisitos previos

- Tener acceso a dos servidores con BIND9 instalado: uno actuará como el servidor DNS principal y el otro como el servidor DNS secundario (o delegado) para la subzona.
- El servidor DNS principal debe tener configurado y funcionando el dominio principal, por ejemplo, "skilly.local".
- Tener permisos de administrador (root) en ambos servidores.

## Pasos a seguir

### Configuración del Servidor DNS Principal para la Delegación

1. En el servidor DNS principal, edita la configuración de la zona "skilly.local" para incluir registros NS y A (o AAAA para IPv6) que apunten a tu servidor DNS secundario.

Esto se hace en el archivo de zona correspondiente a "skilly.local".
Por ejemplo, en /etc/bind/db.skilly.local añade

~~~sh
dev           IN NS   ns2.skilly.local.
ns2           IN A    192.168.1.11
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.11 con la dirección IP real de tu servidor DNS secundario.

### Configuración del Servidor DNS Secundario para la Subzona

2. En el servidor DNS secundario, configura BIND9 para servir la subzona "dev.skilly.local".

    2.1 Esto incluye crear un nuevo archivo de zona y definirlo en ``named.conf.local`` o el archivo de configuración correspondiente.
    En ``named.conf.local``, añade

    ~~~sh
    zone "dev.skilly.local" {
        type master;
        file "/etc/bind/db.dev.skilly.local";
    };
    ~~~

    2.2 Luego, crearás y configurarás ``/etc/bind/db.dev.skilly.local`` con los registros DNS necesarios para la subzona
        2.2.1 Crear el archivo de zona

    ~~~sh
    sudo cp /etc/bind/db.local /etc/bind/db.dev.skilly.local
    ~~~

    2.2.2 Editar el archivo de zona

    ~~~sh
        sudo nano /etc/bind/db.dev.skilly.local
    ~~~

    2.2.3 Configurar el contenido del archivo para reflejar los registros DNS de la subzona "dev.skilly.local".

    ~~~sh
    $TTL    86400
    @       IN      SOA     ns2.skilly.local. admin.skilly.local. (
                                2023100801         ; Serial
                                604800             ; Refresh
                                86400              ; Retry
                                2419200            ; Expire
                                604800 )           ; Negative Cache TTL
    ; Especifica el servidor de nombres para la subzona
    @       IN      NS      ns2.skilly.local.

    ; Añade un registro A para el servidor de nombres si aún no tiene uno globalmente
    ns2     IN      A       192.168.1.11
    ; Registros adicionales para la subzona
    www     IN      A       IP_DE_EJEMPLO_PARA_WWW
    api     IN      A       IP_DE_EJEMPLO_PARA_API
    ~~~

    > :pencil: **NOTA**
    > En este ejemplo, debes reemplazar IP_DEL_SERVIDOR_SECUNDARIO con la dirección IP real de tu servidor DNS secundario. Los registros A para www y api son solo ejemplos; debes modificarlos según tus necesidades específicas para la subzona "dev.skilly.local".

    2.2.4 Reiniciar bind

    ~~~sh
    sudo systemctl restart bind9
    ~~~

### Verificación y Pruebas

3. Desde un cliente, realiza una consulta DNS para verificar la delegación.

~~~sh
dig @192.168.1.10 www.dev.skilly.local
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.10 con la dirección IP real de tu servidor DNS principal.

4. También puedes hacer una consulta directamente al servidor DNS secundario para asegurarte de que responde por la subzona

~~~sh
dig @192.168.1.11 www.dev.skilly.local
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.10 con la dirección IP real de tu servidor DNS secundario.