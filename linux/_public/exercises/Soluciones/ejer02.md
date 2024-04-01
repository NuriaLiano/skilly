# [Solución] Gestión de usuarios y grupos

## 1. Crea un nuevo usuario con useradd y adduser (en Debian y derivados adduser es más interactivo)

> :books: **PARA SABER MÁS**
> Compara las diferencias en el proceso entre useradd y adduser.

~~~sh
sudo useradd nuevoUsuario
sudo adduser nuevoUsuarioInteractivo
~~~

## 2. Establece o cambia la contraseña del usuario

~~~sh
sudo passwd nuevoUsuario
~~~

## 3. Modifica la información del nuevo usuario (por ejemplo, el nombre completo)

~~~sh
sudo usermod -c "Nombre Completo del Usuario" nuevoUsuario
~~~

## 4. Cambia el shell predeterminado del usuario a /sbin/nologin y luego a /bin/bash

> :books: **PARA SABER MÁS**
> Comprueba qué diferencias notas al intentar iniciar sesión con cada uno de los shells.

~~~sh
sudo usermod -s /sbin/nologin nuevoUsuario
sudo usermod -s /bin/bash nuevoUsuario
~~~

## 5. Crea un nuevo grupo

~~~sh
sudo groupadd nuevoGrupo
~~~

## 6. Añade el usuario al grupo creado

~~~sh
sudo usermod -aG nuevoGrupo nuevoUsuario
~~~

## 7. Verifica que el usuario se haya añadido correctamente al grupo

~~~sh
groups nuevoUsuario
~~~

## 8. Elimina al usuario del grupo

~~~sh
sudo gpasswd -d nuevoUsuario nuevoGrupo
~~~

## 9. Elimina el grupo

~~~sh
sudo groupdel nuevoGrupo
~~~

## 10. Elimina el usuario (sin eliminar su directorio de inicio)

~~~sh
sudo userdel nuevoUsuario
~~~

## 11. Elimina el usuario y su directorio de inicio

~~~sh
sudo userdel -r nuevoUsuario
~~~

## 12. Cambia a otro usuario utilizando el comando su

> :pencil: **NOTA**
> Debes conocer la contraseña del otro usuario.

~~~sh
su -l otroUsuario
~~~

## 13. Explora los directorios de inicio y los archivos de configuración de usuario. Vuelve a tu usuario original saliendo de la sesión su

~~~sh
exit
~~~

## Punto de control

- ¿Cuál es la diferencia entre useradd y adduser?

Respuesta:
useradd es un comando de bajo nivel (más básico) que se utiliza para crear nuevos usuarios en el sistema Linux. adduser es una versión de más alto nivel (más amigable) que está basada en useradd, pero con valores predeterminados y opciones interactivas adicionales para facilitar el proceso.

- ¿Qué efecto tiene establecer el shell del usuario en /sbin/nologin?

Respuesta:
Establecer el shell del usuario en /sbin/nologin impide que el usuario inicie sesión en el sistema. Es una manera de desactivar una cuenta para que no se pueda usar para iniciar sesión interactivamente.

- ¿Cómo afecta el cambio del shell a la capacidad del usuario para iniciar sesión?

Respuesta:
Cambiar el shell a /sbin/nologin deshabilita la capacidad de inicio de sesión del usuario. Cambiarlo a /bin/bash (o a otro shell válido) permite al usuario iniciar sesión y usar la terminal.

- ¿Qué sucede cuando eliminas un usuario sin la opción -r?

Respuesta:
Si eliminas un usuario sin la opción -r, el usuario se elimina del sistema, pero su directorio de inicio y los archivos permanecen intactos en el sistema. La opción -r se usa para eliminar también el directorio de inicio y los archivos del usuario.

- ¿Cómo aseguras que un usuario pertenezca a varios grupos?

Respuesta:
Para asegurar que un usuario pertenezca a varios grupos, puedes usar el comando usermod -aG grupo1,grupo2,grupo3 nombre_de_usuario, donde grupo1, grupo2, grupo3, etc., son los nombres de los grupos a los que quieres que el usuario pertenezca.
