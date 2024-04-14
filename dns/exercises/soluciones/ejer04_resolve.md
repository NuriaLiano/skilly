# \[Solución] Entendiendo BIND9: configuración de subdominios

## Objetivo

El objetivo de este ejercicio es avanzar en tu habilidad configurando BIND9, aprendiendo a configurar subdominios dentro de tu dominio principal "skilly.local". Luego, verificarás la configuración utilizando un cliente Ubuntu para asegurarte de que el subdominio se resuelve correctamente. Este ejercicio profundiza en la gestión de zonas DNS y la resolución de nombres, habilidades cruciales para la administración de redes.

## Requisitos previos

* Haber completado el ejercicio de [Entendiendo BIND9: Configuración de un cliente DNS](../Soluciones/ejer03.md)
* Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
* Tener acceso a un cliente Ubuntu para la verificación

## Pasos a seguir

### Configuración de subdominios en BIND9

1.  Asumiendo que ya tienes configurado el dominio "skilly.local", crearás un subdominio llamado "dev.skilly.local".

    1.1 Edita `named.conf.local` para añadir el subdominio "dev.skilly.local"

    ```sh
    sudo nano /etc/bind/named.conf.local
    ```

    1.2 Añade la siguiente zona para el subdominio

    ```sh
    zone "dev.skilly.local" {
        type master;
        file "/etc/bind/zones/db.dev.skilly.local";
    };
    ```

### Creación del archivo de zona para el subdominio

2.  Crea y configura un nuevo archivo de zona para "dev.skilly.local", siguiendo una estructura similar a la del dominio principal.

    2.1 Primero, crea el directorio si no existe

    ```sh
    sudo mkdir -p /etc/bind/zones
    ```

    2.2 Copia un archivo de zona existente como base

    ```sh
    sudo cp /etc/bind/db.local /etc/bind/zones/db.dev.skilly.local
    ```

    2.3 Edita el nuevo archivo de zona

    ```sh
    sudo nano /etc/bind/zones/db.dev.skilly.local
    ```

    2.4 Configura los registros DNS para el subdominio, asegurándote de definir al menos el SOA, registros NS, y un registro A para el subdominio

    ```sh
    @       IN      SOA     ns.dev.skilly.local. admin.skilly.local. (
                             3         ; Serial
                        604800         ; Refresh
                        86400          ; Retry
                        2419200        ; Expire
                        604800 )       ; Negative Cache TTL
    @       IN      NS      ns.dev.skilly.local.
    ns      IN      A       192.168.1.10
    www     IN      A       192.168.1.11
    ```

### Reiniciar el Servidor BIND9

4. Reinicia BIND9 para aplicar los cambios y cargar la nueva configuración de zona.

```sh
sudo systemctl restart bind9
```

### Configuración del Cliente Ubuntu

5. Asegurarte de que tu cliente Ubuntu está configurado para utilizar tu servidor DNS BIND9

Si ya has configurado tu cliente Ubuntu en ejercicios anteriores para apuntar a tu servidor BIND9, no deberías necesitar hacer cambios aquí. De lo contrario, revisa los pasos en ejercicios previos para ajustar tu configuración DNS en Ubuntu

### Verificación y Pruebas

6. Desde tu cliente Ubuntu, verifica la resolución del subdominio

```sh
dig @192.168.1.10 www.dev.skilly.local
nslookup www.dev.skilly.local 192.168.1.10
```

> :sparkles: **IMPORTANTE** Asegúrate de reemplazar 192.168.1.10 con la dirección IP real de tu servidor DNS.
