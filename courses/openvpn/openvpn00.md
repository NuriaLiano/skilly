# OpenVPN en Ubuntu: Introducción, Uso y Configuración

## 1. ¿Qué es OpenVPN?

OpenVPN es una solución VPN (Virtual Private Network) de código abierto que permite crear conexiones seguras punto a punto o sitio a sitio con configuraciones enrutadas o en puente. Utiliza una arquitectura cliente-servidor para mantener la confidencialidad, autenticar a los usuarios y mantener la integridad de los datos.

## 2. ¿Por qué usar OpenVPN?

- Seguridad: OpenVPN ofrece cifrado y autenticación de alto nivel.
- Versatilidad: Funciona a través de NAT y firewalls.
- Código abierto: Permite una adaptación y revisión completa.
- Multiplataforma: Disponible para Linux, Windows, macOS, iOS y Android.

## 3. Instalación de OpenVPN en Ubuntu

~~~sh
sudo apt update
sudo apt install openvpn
~~~

## 4. Configuración del servidor OpenVPN

### Copia los archivos de ejemplo a /etc/openvpn

~~~sh
sudo cp /usr/share/doc/openvpn/examples/sample-config-files/server.conf.gz /etc/openvpn/
sudo gzip -d /etc/openvpn/server.conf.gz
~~~

### b. Modifica el archivo de configuración según tus necesidades

~~~sh
sudo nano /etc/openvpn/server.conf
~~~

### Algunas configuraciones recomendadas (adapta según tu red y preferencias)

~~~sh
dh dh2048.pem
push "route 192.168.X.X 255.255.255.0" 
~~~

### c. Inicia el servicio OpenVPN

~~~sh
sudo systemctl start openvpn@server
~~~

### (Opcional) Para que se inicie automáticamente al arranque

~~~sh
sudo systemctl enable openvpn@server
~~~

## 5. Configuración del cliente OpenVPN

### a. Asegúrate de tener los archivos de configuración del cliente proporcionados por el servidor

### b. Instala el cliente OpenVPN:

### c. Conéctate al servidor VPN usando

## 6. Consejos de uso

- Verificar la conexión: Una vez que el cliente esté conectado, puedes verificar la conexión a través de comandos como ifconfig o ip a para ver la interfaz tun/tap creada por OpenVPN.
- Logs: Los registros de OpenVPN suelen estar en /var/log/syslog en sistemas Ubuntu/Debian. Puedes monitorearlos para diagnosticar problemas.
