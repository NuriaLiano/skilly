---
author: '@nurialiano'
license: Creative Commons Attribution-NonCommercial 4.0 International
---

# Ejercicio 1: Comandos Básicos de UFW (Uncomplicated Firewall)

Objetivo: Aprender a instalar, habilitar, deshabilitar y configurar reglas básicas usando UFW en Ubuntu.

1. Instalación de UFW:

~~~bash
sudo apt update
sudo apt install ufw
~~~

2. Habilitar UFW

~~~sh
sudo ufw enable
~~~

3. Verificar el estado de UFW

~~~sh
sudo ufw status
~~~

4. Permitir tráfico SSH (esto es importante para evitar bloquearse si están usando una conexión SSH)

~~~sh
sudo ufw allow ssh
~~~

5. Bloquear un puerto específico (por ejemplo, el puerto 8080)

~~~sh
sudo ufw deny 8080
~~~

6. Eliminar una regla (para revertir el bloqueo anterior)

~~~sh
sudo ufw delete deny 8080
~~~

7. Deshabilitar UFW

~~~sh
sudo ufw disable
~~~
