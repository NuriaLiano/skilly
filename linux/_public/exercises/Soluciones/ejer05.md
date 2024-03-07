# [Solución] Ejercicio sobre Discos, Particiones y FSTAB

## 1. Enumera los discos y particiones disponibles en el sistema

~~~sh
lsblk
~~~

## 2. Verifica el sistema de archivos de las particiones disponibles

~~~sh
sudo blkid
~~~

## 3. Crea una nueva partición en un disco disponible

~~~sh
sudo fdisk /dev/sdx  # Reemplaza 'x' con la letra correspondiente al disco
~~~

## 4. Formatea la nueva partición con un sistema de archivos de tu elección (ejemplo: ext4)

~~~sh
sudo mkfs.ext4 /dev/sdxY  # Reemplaza 'xY' con la letra del disco y el número de la partición
~~~

## 5. Crea un punto de montaje para la nueva partición

~~~sh
sudo mkdir /mnt/mi_nueva_particion
~~~

## 6. Monta la nueva partición en el punto de montaje creado

~~~sh
sudo mount /dev/sdxY /mnt/mi_nueva_particion
~~~

## 7. Añade la nueva partición al archivo fstab para que se monte automáticamente en el arranque

~~~sh
echo '/dev/sdxY /mnt/mi_nueva_particion ext4 defaults 0 2' | sudo tee -a /etc/fstab
~~~

## 8. Verifica que la nueva entrada en fstab es correcta y no producirá errores en el arranque

~~~sh
sudo mount -a
~~~

## 9. Reinicia tu máquina y verifica que la partición se monta automáticamente

~~~sh
reboot
~~~

## Punto de control - Respuestas

- **¿Puedes identificar y listar todos los discos y particiones en tu sistema?**
  - Sí, utilizando el comando `lsblk`, puedes ver una lista de todos los dispositivos de almacenamiento disponibles y sus particiones.

- **¿Entiendes cómo formatear y montar una nueva partición?**
  - El formateo se realiza con el comando `mkfs` junto con el tipo de sistema de archivos deseado, y el montaje se lleva a cabo con el comando `mount`, seguido de la ubicación de la partición y el punto de montaje.

- **¿Comprendes el propósito y la estructura del archivo fstab y cómo este afecta el proceso de arranque?**
  - El archivo `/etc/fstab` se utiliza para definir cómo se montan automáticamente los sistemas de archivos en el arranque. La estructura de cada entrada en este archivo incluye el dispositivo, el punto de montaje, el tipo de sistema de archivos, las opciones de montaje, y las opciones de respaldo y verificación.

- **¿Puedes asegurar que una partición nueva se monte automáticamente al inicio?**
  - Sí, agregando una entrada correspondiente al archivo `/etc/fstab` y asegurándose de que no hay errores con `mount -a`, puedes hacer que la partición se monte automáticamente en cada inicio.
