# Entendiendo BIND9: Delegación de zona

## Objetivo

Este ejercicio tiene como objetivo enseñarte a configurar la delegación de una subzona dentro de tu dominio principal usando BIND9. Aprenderás a dividir el espacio de nombres de DNS de manera que una porción específica del dominio sea gestionada por otro servidor DNS. Este proceso es esencial para la administración distribuida de nombres de dominio, permitiendo una mayor flexibilidad y escalabilidad.

## Requisitos previos

- Tener acceso a dos servidores con BIND9 instalado: uno actuará como el servidor DNS principal y el otro como el servidor DNS secundario (o delegado) para la subzona.
- El servidor DNS principal debe tener configurado y funcionando el dominio principal, por ejemplo, "skilly.local".
- Tener permisos de administrador (root) en ambos servidores.

## Pasos a seguir

### Configuración del Servidor DNS Principal para la Delegación

1. En el servidor DNS principal, edita la configuración de la zona "skilly.local" para incluir registros NS y A (o AAAA para IPv6) que apunten a tu servidor DNS secundario.

### Configuración del Servidor DNS Secundario para la Subzona

2. En el servidor DNS secundario, configura BIND9 para servir la subzona "dev.skilly.local".

### Verificación y Pruebas

3. Desde un cliente, realiza una consulta DNS para verificar la delegación.
4. También puedes hacer una consulta directamente al servidor DNS secundario para asegurarte de que responde por la subzona