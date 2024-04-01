# [Solución] Copias de Seguridad con Clonezilla

## Introducción a Clonezilla

Clonezilla es una herramienta de clonación y creación de imágenes de disco/partición. Es útil para copias de seguridad completas de todo el sistema.

## 1. Preparación para la copia de seguridad con Clonezilla

Antes de iniciar, asegúrate de tener:

- Un medio de arranque con Clonezilla (CD, USB, etc.).
- Un disco o partición destino con suficiente espacio para almacenar la copia de seguridad.

## 2. Arranque desde el medio de Clonezilla

Reinicia tu máquina y elige arrancar desde el medio de Clonezilla.

## 3. Seleccionar modo de operación en Clonezilla

Selecciona "device-image" para crear una imagen de tu disco o partición.

## 4. Elegir el origen y destino de la copia

Selecciona el disco o partición que deseas respaldar y elige dónde quieres guardar la imagen.

## 5. Iniciar el proceso de copia de seguridad

Sigue las instrucciones en pantalla para comenzar la creación de la imagen.

## 6. Finalización y verificación

Una vez completado, verifica que la imagen se ha creado correctamente y guárdala en un lugar seguro.

> :books: **PARA SABER MÁS**
>
> Clonezilla permite varias opciones de compresión y cifrado para las copias de seguridad, aumentando la seguridad y reduciendo el tamaño del archivo de imagen.

## Punto de control

Reflexiona y verifica lo siguiente:

- ¿Has completado una copia de seguridad exitosa con Clonezilla?

Si has seguido las instrucciones de Clonezilla sin errores y has verificado que la imagen de la copia de seguridad se ha creado y almacenado correctamente en la ubicación designada, entonces sí, has completado una copia de seguridad exitosa con Clonezilla.

- ¿Puedes identificar y listar todos los discos y particiones en tu sistema?

Si utilizaste comandos como lsblk, fdisk -l o blkid y pudiste ver la lista de dispositivos de almacenamiento y sus particiones correspondientes, entonces sí, puedes identificar y listar todos los discos y particiones en tu sistema.

- ¿Comprendes cómo formatear y montar una nueva partición?

Si sabes cómo usar comandos como sudo fdisk para crear una nueva partición, sudo mkfs para formatearla con un sistema de archivos específico y sudo mount para montarla en un directorio de tu elección, entonces sí, comprendes cómo formatear y montar una nueva partición.

- ¿Entiendes el propósito y la estructura del archivo fstab y cómo este afecta el proceso de arranque?

Si sabes que el archivo /etc/fstab contiene información sobre las particiones, sistemas de archivos y opciones de montaje, y comprendes que este archivo se utiliza durante el proceso de arranque para montar automáticamente las particiones y sistemas de archivos especificados, entonces sí, entiendes el propósito y la estructura del archivo fstab.

- ¿Puedes asegurar que una partición nueva se monte automáticamente al inicio?

Si has añadido correctamente la nueva partición al archivo /etc/fstab con todos los detalles necesarios (como el dispositivo, punto de montaje, tipo de sistema de archivos, opciones de montaje y parámetros de volcado y de chequeo) y has verificado que se monta automáticamente después de reiniciar, entonces sí, puedes asegurar que una nueva partición se monte automáticamente al inicio.
