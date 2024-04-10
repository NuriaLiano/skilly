# Entendiendo BIND9: Configuración de un cliente DNS

## Objetivo

El objetivo de este ejercicio es configurar un cliente Ubuntu 22 para resolver nombres de dominio utilizando el servidor DNS que has configurado con BIND9 para el dominio "skilly.local". Este ejercicio te permitirá entender cómo los sistemas cliente interactúan con un servidor DNS específico para la resolución de nombres y cómo configurar manualmente los ajustes de DNS en sistemas basados en Linux.

## Requisitos previos

- Haber completado el ejercicio de [Entendiendo BIND9: Configuración básica de un dominio](./ejer02.md)
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).

## Pasos a seguir

### Preparación del cliente

> :pencil: **NOTA**
> En este caso mi cliente será un Ubuntu 22 pero puedes utilizar cualquier distribución basada en Debian
>
> :sparkles: **IMPORTANTE**
> Si usas distribuciones no basadas en Debian algunos comandos podrían no servirte pero échale un poco más de tiempo e investiga que comandos necesitas.
> Si quieres colaborar envíanos tu solución con la distrubución que utilices y lo subiremos a la página :wink:

1. Instala Ubuntu 22 en una máquina virtual o en tu servidor dedicado
2. Asegúrate de que el cliente ubuntu 22 esté actualizado y tenga conexión a internet
3. Comprueba que tu servidor DNS y el cliente Ubuntu 22 estén en la misma red
4. Comprueba que tienes permisos de administrador (root).

### Configuración estática del dns del cliente

5. Modifica la configuración de red de tu cliente Ubuntu 22 para utilizar tu servidor DNS como servidor DNS primario.

### Verificación y pruebas

6. Comprueba la configuración DNS
7. Prueba la resolución de nombres