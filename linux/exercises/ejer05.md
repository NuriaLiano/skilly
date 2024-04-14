# Discos, Particiones y FSTAB

## 1. Enumera los discos y particiones disponibles en el sistema

```sh
lsblk
```

> :books: **PARA SABER MÁS**
>
> El comando `lsblk` lista todos los dispositivos de bloque disponibles, incluyendo discos y particiones.

## 2. Verifica el sistema de archivos de las particiones disponibles

```sh
sudo blkid
```

## 3. Crea una nueva partición en un disco disponible

> :warning: **ADVERTENCIA**
>
> Asegúrate de realizar esto en un disco que no contenga datos importantes, ya que podrías perderlos.

```sh
sudo fdisk /dev/sdx  # Reemplaza 'x' con la letra correspondiente al disco
```

## 4. Formatea la nueva partición con un sistema de archivos de tu elección (ejemplo: ext4)

```sh
sudo mkfs.ext4 /dev/sdxY  # Reemplaza 'xY' con la letra del disco y el número de la partición
```

## 5. Crea un punto de montaje para la nueva partición

```sh
sudo mkdir /mnt/mi_nueva_particion
```

## 6. Monta la nueva partición en el punto de montaje creado

```sh
sudo mount /dev/sdxY /mnt/mi_nueva_particion
```

## 7. Añade la nueva partición al archivo fstab para que se monte automáticamente en el arranque

```sh
echo '/dev/sdxY /mnt/mi_nueva_particion ext4 defaults 0 2' | sudo tee -a /etc/fstab
```

## 8. Verifica que la nueva entrada en fstab es correcta y no producirá errores en el arranque

```sh
sudo mount -a
```

## 9. Reinicia tu máquina y verifica que la partición se monta automáticamente

```sh
reboot
```

> :pencil: **NOTA**
>
> Después de reiniciar, usa `lsblk` o `df -h` para verificar que la partición se ha montado automáticamente.

## Punto de control

Reflexiona y verifica lo siguiente [Ver solución](soluciones/ejer05.md):

* ¿Puedes identificar y listar todos los discos y particiones en tu sistema?
* ¿Entiendes cómo formatear y montar una nueva partición?
* ¿Comprendes el propósito y la estructura del archivo fstab y cómo este afecta el proceso de arranque?
* ¿Puedes asegurar que una partición nueva se monte automáticamente al inicio?
