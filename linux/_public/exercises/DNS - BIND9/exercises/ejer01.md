# Iniciación en DNS

## Objetivo

El objetivo de esta actividad es instalar y configurar un servidor DNS básico en un sistema Linux. Aprenderás a configurar una zona DNS para un dominio de ejemplo, permitiéndote entender cómo se resuelven los nombres de dominio a través de DNS. Además, utilizarás comandos útiles para verificar la configuración y el funcionamiento de tu servidor DNS. Esto proporcionará una base sólida sobre cómo funciona DNS en la práctica y te familiarizará con algunas herramientas esenciales para la administración de DNS.

## Pasos a seguir

### Preparación del entorno

- Elige un sistema Linux para la instalación (yo trataré los ejercicios con Ubuntu 22). Puede ser una máquina virtual o un servidor dedicado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

### Instalación y configuración

> :mag_right: **INVESTIGA**
> ¿Existen varias herramientas para la gestión de servidores DNS?

1. Instala BIND9
2. Configura el servidor DNS para que actúe como un servidor autoritativo para un dominio de ejemplo (p. ej., "skilly.local").
3. Añade registros DNS básicos a tu zona, incluyendo al menos un registro A y, opcionalmente, un registro MX y un registro CNAME.
4. Configura el sistema local (o un sistema cliente en la misma red) para usar el servidor DNS que acabas de configurar como su servidor DNS primario.

### Verificación y pruebas

> :brain: **RECUERDA**
> Las herramientas necesarias para comprobar que el servidor DNS funciona correctamente son:
> - dig
> - nslookup
> - systemctl status bind9

6. Verifica que el servidor DNS esté funcionando correctamente y que sea capaz de resolver el nombre de dominio que configuraste a la dirección IP correspondiente.
7. Utiliza herramientas de diagnóstico DNS para realizar consultas al servidor y verificar las respuestas.