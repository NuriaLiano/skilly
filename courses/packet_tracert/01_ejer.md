# Ejercicio: Creación y Configuración de una Red Básica

Objetivos:

Crear una red pequeña con dos PCs y un switch.
Configurar las PCs con direcciones IP estáticas.
Comprobar la conectividad entre ambas PCs.
Instrucciones:

Creación de la Red:
a. Abre Packet Tracer.
b. Desde la barra lateral izquierda, selecciona un dispositivo PC y colócalo en el área de trabajo.
c. Repite para tener un segundo PC.
d. Ahora, selecciona un switch (por ejemplo, el 2960) y colócalo en el área de trabajo.

Conexión de los Dispositivos:
a. Elige el conector de cobre directo (representado por un ícono de un rayo).
b. Conecta cada PC al switch. Por lo general, conectas el puerto FastEthernet del PC al switch.

Configuración de las PCs:
a. Haz clic en el primer PC.
b. Ve a la pestaña "Desktop" y luego haz clic en "IP Configuration".
c. Asigna la siguiente dirección IP: 192.168.1.10 y una máscara de subred: 255.255.255.0.
d. Repite para el segundo PC, pero utiliza la dirección IP: 192.168.1.11.

Verificar Conectividad:
a. Regresa a la pestaña "Desktop" en cualquiera de las PCs.
b. Abre el "Command Prompt" (Símbolo del sistema).
c. Ingresa el comando: ping 192.168.1.11 si estás en el primer PC o ping 192.168.1.10 si estás en el segundo.
d. Deberías ver respuestas si todo se configuró correctamente.
