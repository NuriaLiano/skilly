# [Solución] Entendiendo BIND9: Configuración de un cliente DNS

## Pasos a seguir

### Preparación del cliente

> :pencil: **NOTA**
> En este caso mi cliente será un Ubuntu 22 pero puedes utilizar cualquier distribución basada en Debian
>
> :sparkles: **IMPORTANTE**
> Si usas distribuciones no basadas en Debian algunos comandos podrían no servirte pero échale un poco más de tiempo e investiga que comandos necesitas.
> Si quieres colaborar envíanos tu solución con la distrubución que utilices y lo subiremos a la página :wink:

1. Instala Ubuntu 22 en una máquina virtual o en tu servidor dedicado

Puedes descargar la iso desde [este enlace](https://releases.ubuntu.com/jammy/ubuntu-22.04.4-desktop-amd64.iso) e instalarlo en tu máquina virtual o servidor dedicado
2. Asegúrate de que el cliente ubuntu 22 esté actualizado y tenga conexión a internet

~~~sh
sudo apt update && apt upgrade
ping www.google.es
ping 8.8.8.8
~~~

3. Comprueba que tu servidor DNS y el cliente Ubuntu 22 estén en la misma red

~~~sh
ping 192.168.1.10
~~~

> :sparkles: **IMPORTANTE**
> Cambia esta ip por la ip de tu servidor dns

4. Comprueba que tienes permisos de administrador (root).

Si has hecho los comandos anteriores ya está comprobado que tienes permiso de administrador.

### Configuración estática del dns del cliente

5. Modifica la configuración de red de tu cliente Ubuntu 22 para utilizar tu servidor DNS como servidor DNS primario.

    5.1 Edita el archivo ``/etc/systemd/resolved.conf``

    ~~~sh
    sudo nano /etc/systemd/resolved.conf
    ~~~

    5.2 Añade o modifica la línea DNS= para incluir la dirección IP de tu servidor BIND9. Asegúrate de añadir la línea FallbackDNS= si deseas tener un DNS secundario como backup. Por ejemplo

    ~~~sh
    [Resolve]
    DNS=192.168.1.10
    FallbackDNS=8.8.8.8
    ~~~

    5.3 Guarda y cierra el archivo

    5.4 Aplica los cambios reiniciando systemd-resolved

    ~~~sh
    sudo systemctl restart systemd-resolved
    ~~~

### Verificación y pruebas

6. Comprueba la configuración DNS

Deberías ver tu servidor DNS listado bajo "DNS Servers".

~~~sh
systemd-resolve --status
~~~

7. Prueba la resolución de nombres

~~~sh
dig @192.168.1.10 www.skilly.local
nslookup www.skilly.local 192.168.1.10
~~~

> :sparkles: **IMPORTANTE**
> Asegúrate de reemplazar 192.168.1.10 con la dirección IP real de tu servidor DNS.
