# Entendiendo BIND9: Zonas inversas

## Pasos a seguir

### Determinar el Bloque de Red para la Zona Inversa

1. Basándote en las direcciones IP utilizadas por tu servidor DNS y los dispositivos en tu red, determina el bloque de red para el cual configurarás la resolución inversa.

Supongamos que tu servidor DNS maneja direcciones en el rango ``192.168.1.0/24``. Tu bloque de red para la zona inversa sería ``1.168.192.in-addr.arpa``

### Configuración de la Zona Inversa en BIND9

2. Añade la configuración necesaria en BIND9 para habilitar la resolución inversa de DNS para tu bloque de red.

Edita el archivo named.conf.local para añadir la zona inversa

~~~sh
zone "1.168.192.in-addr.arpa" {
    type master;
    file "/etc/bind/db.192.168.1";
    allow-transfer { none; }; // Ajusta si necesitas transferencia
};
~~~

### Creación del Archivo de Zona Inversa

3. Crea y configura el archivo de zona inversa correspondiente en el servidor DNS.

    3.1 Crea el archivo de zona inversa /etc/bind/db.192.168.1 basado en la plantilla db.127 de BIND

    ~~~sh
    sudo cp /etc/bind/db.127 /etc/bind/db.192.168.1
    ~~~

    3.2 Edita el archivo /etc/bind/db.192.168.1 para configurar los registros PTR para la resolución inversa

    ~~~sh
    @       IN      SOA     ns.skilly.local. admin.skilly.local. (
                            2023100401 ; Serial
                            604800     ; Refresh
                            86400      ; Retry
                            2419200    ; Expire
                            604800 )   ; Negative Cache TTL
    @       IN      NS      ns.skilly.local.
    10      IN      PTR     www.skilly.local.
    ~~~

    > :sparkles: **IMPORTANTE**
    > Asegúrate de reemplazar 10 con el último octeto de la dirección IP del servidor o dispositivo que deseas resolver inversamente.

### Reiniciar BIND9

4. Reinicia BIND9 para aplicar y activar las configuraciones.

~~~sh
sudo systemctl restart bind9
~~~

### Configuración del Cliente para Pruebas

5. Asegurarte de que tu cliente esté configurado para utilizar tu servidor DNS BIND9.

Para asegurarte de que tu cliente Ubuntu esté utilizando tu servidor DNS para la resolución de nombres, necesitas configurar tu sistema para que apunte a la dirección IP de tu servidor DNS.

Revisa la solución del ejercicio [Entendiendo BIND9: Configuración de un cliente DNS](./ejer03_resolve.md) para comprobar que el cliente está bien configurado

### Verificación de la Zona Inversa

1. Verifica desde el cliente que la resolución inversa de DNS funciona correctamente.

~~~sh
dig -x 192.168.1.20 @192.168.1.10
~~~
