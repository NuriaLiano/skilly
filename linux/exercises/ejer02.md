# Gestión de usuarios y grupos

## 1. Crea un nuevo usuario con useradd y adduser (en Debian y derivados adduser es más interactivo)

> :books: **PARA SABER MÁS** Compara las diferencias en el proceso entre useradd y adduser.

## 2. Establece o cambia la contraseña del usuario

## 3. Modifica la información del nuevo usuario (por ejemplo, el nombre completo)

## 4. Cambia el shell predeterminado del usuario a /sbin/nologin y luego a /bin/bash

> :books: **PARA SABER MÁS** Comprueba qué diferencias notas al intentar iniciar sesión con cada uno de los shells.

## 5. Crea un nuevo grupo

## 6. Añade el usuario al grupo creado

## 7. Verifica que el usuario se haya añadido correctamente al grupo

## 8. Elimina al usuario del grupo

## 9. Elimina el grupo

## 10. Elimina el usuario (sin eliminar su directorio de inicio)

## 11. Elimina el usuario y su directorio de inicio

## 12. Cambia a otro usuario utilizando el comando su

> :pencil: **NOTA** Debes conocer la contraseña del otro usuario.

## 13. Explora los directorios de inicio y los archivos de configuración de usuario. Vuelve a tu usuario original saliendo de la sesión su

## Punto de control

En este punto vamos a hacer un poco de reflexión para autocomprobar si hemos entendido los comandos que hemos visto. Responde a estas preguntas y revisa el resultado en la solución del ejercicio. [Ver solucion](soluciones/ejer02.md)

* ¿Cuál es la diferencia entre useradd y adduser?
* ¿Qué efecto tiene establecer el shell del usuario en /sbin/nologin?
* ¿Cómo afecta el cambio del shell a la capacidad del usuario para iniciar sesión?
* ¿Qué sucede cuando eliminas un usuario sin la opción -r?
* ¿Cómo aseguras que un usuario pertenezca a varios grupos?
