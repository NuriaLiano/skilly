# Instalación y configuración de cliente FTP (Filezilla)

## Objetivo

Aprender a instalar y configurar el cliente FTP FileZilla en Ubuntu para gestionar transferencias de archivos entre tu máquina local y un servidor FTP.

## Pasos a seguir

### Preparación del entorno

- Asegúrate de tener instalado y configurada una máquina virtual o contenedor con el sistema operativo Ubuntu 22 actualizado.
- Asegúrate de que el sistema esté actualizado y de que tienes permisos de administrador (root).
- Confirma que tienes instalado el servidor FTP y funciona correctamente.

### Instalación y configuración

1. Abre FileZilla desde el menú de aplicaciones o usando el comando filezilla.
2. En la barra de menú, selecciona Archivo y luego Administrador de sitios.
3. En el Administrador de sitios, haz clic en Nuevo sitio y configura los siguientes parámetros
   1. Servidor: Introduce la dirección del servidor FTP (por ejemplo, ftp.server.com).
   2. Puerto: Deja este campo vacío para usar el puerto predeterminado (21 para FTP).
   3. Protocolo: Selecciona FTP - Protocolo de Transferencia de Archivos.
   4. Cifrado: Selecciona Usar si está disponible o Requiere FTP sobre TLS explícito para conexiones seguras.
   5. Modo de acceso: Selecciona Normal e introduce tu Nombre de usuario y Contraseña.
4. Guarda la configuración haciendo clic en Aceptar.

### Preguntas de trivial 🤓

- ¿Qué problemas encontraste al intentar conectarte al servidor FTP y cómo los solucionaste?
- ¿Cómo verificaste que las transferencias de archivos se realizaron correctamente?
- ¿Qué beneficios tiene usar una conexión FTP segura (TLS/SSL) en comparación con una conexión FTP no segura?
- ¿Cómo puedes ajustar FileZilla para optimizar la velocidad de transferencia de archivos?

### Verificación y pruebas

1. Conexión al servidor FTP
   1. Abre el Administrador de sitios en FileZilla y selecciona el sitio que configuraste.
   2. Haz clic en Conectar y verifica que la conexión se establezca correctamente.
   3. Si se establece una conexión segura, verifica el uso de TLS/SSL en los registros de FileZilla.
2. Transferencia de archivos
   1. Navega por los directorios locales y remotos usando las ventanas de FileZilla.
   2. Arrastra y suelta un archivo desde tu máquina local a un directorio en el servidor para subirlo.
   3. Verifica que los archivos se hayan transferido correctamente y compáralos con los originales.
3. Verificación de permisos y configuraciones
   1. Intenta cambiar los permisos de un archivo en el servidor haciendo clic derecho sobre el archivo y seleccionando Permisos de archivo.
   2. Ajusta los permisos según sea necesario y verifica que los cambios se apliquen correctamente.
4. Revisa los logs de FileZilla para asegurarte de que no hay errores durante las transferencias. 