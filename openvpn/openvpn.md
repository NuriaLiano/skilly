# Configuración del Endpoint VPN

## Requisitos previos

1. Preparación del entorno:

- Endpoint VPN:
Debe tener dos tarjetas de red:
LAN (Red Interna): Elige la dirección IP que desees.
WAN (Modo puente): Se conectará a Internet.

- Servidor en la red de la empresa:

Una máquina virtual con servicios SSH y Web. Elige una dirección IP.

Puede ser otra máquina virtual en el mismo anfitrión o una máquina virtual de un compañero en otro anfitrión. Debe estar en modo puente (WAN).

## Configuración del Endpoint VPN

### Instala OpenVPN

~~~sh
sudo apt update
sudo apt install openvpn
~~~

### Copia los archivos de ejemplo a /etc/openvpn

~~~sh
sudo cp /usr/share/doc/openvpn/examples/sample-config-files/server.conf.gz /etc/openvpn/
sudo gzip -d /etc/openvpn/server.conf.gz
~~~

### Modifica el archivo de configuración según tus necesidades (puedes usar nano o tu editor favorito)

~~~sh
sudo nano /etc/openvpn/server.conf
~~~

### Configuración del cliente

#### Copia los archivos de configuración necesarios del servidor a la máquina cliente

#### Instala el cliente OpenVPN

~~~sh
sudo apt update
sudo apt install openvpn
~~~

#### Conéctate al servidor VPN

sudo openvpn --config /ruta/a/tu/archivo/config-cliente.ovpn

## Pruebas

- Una vez que el cliente esté conectado, intenta acceder al servidor web y SSH en la máquina virtual de la red de la empresa. Si todo está configurado correctamente, deberías poder acceder sin problemas.
