# Ejercicio: Conexión de Tres Redes A, B y C Usando Routers

Objetivos:

Crear tres redes separadas: A, B y C.
Conectar la red A con la red B, y la red B con la red C usando routers.
Comprobar la conectividad entre las tres redes.
Instrucciones:

Creación de la Red:
a. Abre Packet Tracer.
b. Coloca tres PCs para representar cada red (total de 9 PCs).
c. Coloca tres routers (por ejemplo, el modelo 2811).

Conexión de los Dispositivos:
a. Conecta tres PCs a cada router usando conectores de cobre directo.
b. Conecta el primer router (Red A) al segundo router (Red B) usando un cable serial.
c. Conecta el segundo router (Red B) al tercer router (Red C) usando otro cable serial.

Configuración de los PCs y Redes:
a. PCs en la red A (primer router): direcciones IP en la red 192.168.1.0/24.
b. PCs en la red B (segundo router): direcciones IP en la red 192.168.2.0/24.
c. PCs en la red C (tercer router): direcciones IP en la red 192.168.3.0/24.

Configuración de Routers:
a. Configura las interfaces de cada router que conecta a los PCs con direcciones IP apropiadas para cada red (por ejemplo, 192.168.1.1, 192.168.2.1, 192.168.3.1).
b. Configura las interfaces seriales entre los routers con redes de tránsito, por ejemplo:

Router A a B: 10.0.0.0/30 (Router A tiene 10.0.0.1 y Router B tiene 10.0.0.2).
Router B a C: 10.0.0.4/30 (Router B tiene 10.0.0.5 y Router C tiene 10.0.0.6).
c. Configura rutas estáticas o un protocolo de enrutamiento en los routers para que sepan cómo alcanzar las demás redes.
Verificar Conectividad:
a. Desde un PC en la red A, haz ping a un PC en la red B y a un PC en la red C.
b. Desde un PC en la red B, haz ping a un PC en la red A y a un PC en la red C.
c. Desde un PC en la red C, haz ping a un PC en la red A y a un PC en la red B.