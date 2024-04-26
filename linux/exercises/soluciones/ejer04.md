# [Solución] Manejo de permisos y rutas

## 1. Visualiza los permisos actuales de todos los archivos en tu directorio personal

~~~sh
ls -l ~
~~~

## 2. Crea un archivo llamado `archivoSecreto.txt` en tu directorio personal y muestra sus permisos

~~~sh
touch ~/archivoSecreto.txt
ls -l ~/archivoSecreto.txt
~~~

## 3. Cambia los permisos del `archivoSecreto.txt` para que solo el propietario pueda leer y escribir en él

~~~sh
chmod 600 ~/archivoSecreto.txt
ls -l ~/archivoSecreto.txt
~~~

## 4. Crea un directorio llamado `CarpetaPrivada` en tu directorio personal y muestra sus permisos

~~~sh
mkdir ~/CarpetaPrivada
ls -ld ~/CarpetaPrivada
~~~

## 5. Cambia los permisos de `CarpetaPrivada` para que solo el propietario pueda ver y entrar en el directorio

~~~sh
chmod 700 ~/CarpetaPrivada
ls -ld ~/CarpetaPrivada
~~~

## 6. Mueve `archivoSecreto.txt` a `CarpetaPrivada` usando una ruta relativa y muestra los permisos de los archivos dentro de `CarpetaPrivada`

~~~sh
mv ~/archivoSecreto.txt ~/CarpetaPrivada/
ls -l ~/CarpetaPrivada
~~~

## 7. Crea un enlace simbólico llamado `EnlaceSecreto` en tu directorio personal que apunte a `archivoSecreto.txt` dentro de `CarpetaPrivada`

~~~sh
ln -s ~/CarpetaPrivada/archivoSecreto.txt ~/EnlaceSecreto
ls -l ~/EnlaceSecreto
~~~

## Punto de control

Reflexiona sobre lo que has aprendido y verifica:

- ¿Cuál es la diferencia entre una ruta absoluta y una relativa?

Respuesta:
Una ruta absoluta especifica la ubicación de un archivo o directorio desde el directorio raíz del sistema de archivos. Comienza con / (por ejemplo, /home/usuario/documentos). En cambio, una ruta relativa especifica la ubicación de un archivo o directorio en relación con el directorio actual en el que te encuentras, y no comienza con / (por ejemplo, documentos si estás en el directorio /home/usuario).

- ¿Cómo afectan los permisos de un directorio a los archivos y subdirectorios contenidos dentro?

Respuesta:
Los permisos de un directorio afectan la capacidad de los usuarios para listar sus contenidos (permiso de lectura), crear o eliminar archivos y subdirectorios dentro de él (permiso de escritura), y entrar o acceder al directorio mismo (permiso de ejecución). Sin embargo, los permisos específicos de los archivos y subdirectorios dentro de él no cambian automáticamente con los permisos del directorio contenedor; son independientes y deben ser configurados individualmente.

- ¿Qué comando usaste para cambiar los permisos de un archivo o directorio?

Respuesta:
El comando utilizado para cambiar los permisos de un archivo o directorio es chmod. Por ejemplo, chmod 755 archivo cambiará los permisos del archivo a lectura, escritura y ejecución para el propietario, y lectura y ejecución para el grupo y otros usuarios.

- ¿Qué sucede cuando intentas acceder a un directorio sin los permisos necesarios?

Respuesta:
Si intentas acceder a un directorio sin los permisos necesarios, recibirás un mensaje de error que indica que no tienes permiso para hacerlo. Si te falta el permiso de lectura, no podrás ver los contenidos del directorio. Si te falta el permiso de ejecución, no podrás ingresar o usar el directorio como tu directorio de trabajo actual.
