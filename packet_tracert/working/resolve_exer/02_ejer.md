# Ejercicio: Conexión de Dos Redes Usando Dos Routers

Objetivos:

Crear dos redes separadas.
Conectar las redes mediante dos routers.
Comprobar la conectividad entre las redes.
Instrucciones:

Creación de la Red:
a. Abre Packet Tracer.
b. Coloca cuatro PCs en el área de trabajo.
c. Coloca dos routers (puedes usar el modelo 2811, por ejemplo).

Conexión de los Dispositivos:
a. Conecta dos PCs a un router y los otros dos PCs al otro router usando conectores de cobre directo.
b. Usa un cable serial (representado con un ícono que parece un reloj) para conectar los dos routers entre sí. Por lo general, usarías los puertos "Serial" para esta conexión.

Configuración de los PCs y Redes:
a. Configura los dos PCs conectados al primer router con direcciones IP en la red 192.168.1.0/24 (por ejemplo, 192.168.1.10 y 192.168.1.11 con máscara 255.255.255.0).
b. Configura los dos PCs conectados al segundo router con direcciones IP en la red 192.168.2.0/24 (por ejemplo, 192.168.2.10 y 192.168.2.11 con máscara 255.255.255.0).

Configuración de Routers:
a. Configura el primer router con la dirección IP 192.168.1.1/24 en el puerto que conecta a los PCs y con la dirección 10.0.0.1/30 en el puerto serial.
b. Configura el segundo router con la dirección IP 192.168.2.1/24 en el puerto que conecta a los PCs y con la dirección 10.0.0.2/30 en el puerto serial.
c. Configura las rutas estáticas o un protocolo de enrutamiento (como RIP, OSPF, etc.) en los routers para que sepan cómo alcanzar la red del otro router. Por simplicidad, puedes usar rutas estáticas:

En el primer router:
ip route 192.168.2.0 255.255.255.0 10.0.0.2
En el segundo router:
Copy code
ip route 192.168.1.0 255.255.255.0 10.0.0.1
Verificar Conectividad:
a. Desde un PC en la red 192.168.1.0/24, haz ping a un PC en la red 192.168.2.0/24.
b. Desde un PC en la red 192.168.2.0/24, haz ping a un PC en la red 192.168.1.0/24.