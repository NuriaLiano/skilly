---
author: '@nurialiano'
license: Creative Commons Attribution-NonCommercial 4.0 International
---

# Ejercicio 2: Bloquear una Página Web

Objetivo: Aprender a bloquear el acceso a un sitio web específico utilizando UFW e iptables.

> :pencil: **NOTA**
> : Es esencial que los alumnos se den cuenta de que un sitio web puede tener múltiples direcciones IP (por ejemplo, debido a la utilización de CDNs) y que bloquear una sola IP podría no ser suficiente para bloquear el acceso al sitio completo. También es importante destacar que las direcciones IP asociadas a un dominio pueden cambiar con el tiempo, por lo que es una buena idea revisar regularmente las reglas de bloqueo para asegurarse de que siguen siendo efectivas.

1. Bloqueo usando /etc/hosts (método simple)
   - Abre el archivo /etc/hosts con un editor de texto con privilegios de superusuario

~~~sh
sudo nano /etc/hosts
~~~

   - Al final del archivo, añade la siguiente línea para bloquear el acceso a **marca.com**

~~~sh
127.0.0.1 marca.com www.marca.com
~~~

   - Guarda y cierra el archivo. Ahora, cualquier intento de acceso a **marca.com** o **www.marca.com** desde ese sistema se redireccionará a la dirección IP local (127.0.0.1)

1. Bloqueo usando iptables
   - Primero, encuentra la dirección IP del sitio web que deseas bloquear. Supongamos que la dirección IP obtenida es 172.23.128.1 (la IP real podría variar)

~~~sh
nslookup marca.com
~~~

   - Usa iptables para bloquear el tráfico hacia esa dirección IP

~~~sh
sudo iptables -A OUTPUT -d x.x.x.x -j DROP
~~~

3. Aplicar la regla en UFW

~~~sh
sudo ufw reload
~~~