# Entendiendo BIND9: Zonas inversas

## Objetivo

Este ejercicio tiene como objetivo enseñarte a configurar una zona inversa en BIND9, permitiendo que las direcciones IP se mapeen a nombres de dominio. Este tipo de configuración es crucial para la resolución inversa de DNS, que puede ser necesaria por razones de seguridad, registro o simplemente para cumplir con ciertos protocolos de red. Posteriormente, verificarás la configuración utilizando un cliente para asegurarte de que la resolución inversa funciona correctamente.

## Requisitos previos

- Tener un servidor DNS con BIND9 configurado y funcionando, sirviendo el dominio "skilly.local".
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Tener acceso a un cliente Ubuntu para la verificación
- Tener acceso a un cliente Ubuntu para la verificación.
- Asegúrate que tu servidor DNS y el cliente Ubuntu 22 estén en la misma red.

## Pasos a seguir

### Determinar el Bloque de Red para la Zona Inversa

1. Basándote en las direcciones IP utilizadas por tu servidor DNS y los dispositivos en tu red, determina el bloque de red para el cual configurarás la resolución inversa.

### Configuración de la Zona Inversa en BIND9

2. Añade la configuración necesaria en BIND9 para habilitar la resolución inversa de DNS para tu bloque de red.

### Creación del Archivo de Zona Inversa

3. Crea y configura el archivo de zona inversa correspondiente en el servidor DNS.

### Reiniciar BIND9

4. Reinicia BIND9 para aplicar y activar las configuraciones.

### Configuración del Cliente para Pruebas

5. Asegurarte de que tu cliente esté configurado para utilizar tu servidor DNS BIND9.

### Verificación de la Zona Inversa

1. Verifica desde el cliente que la resolución inversa de DNS funciona correctamente.