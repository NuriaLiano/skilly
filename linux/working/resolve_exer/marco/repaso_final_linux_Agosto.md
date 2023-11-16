# Repaso final de Linux

## 1. Crea un usuario 'perry' de forma interactiva

~~~sh
sudo adduser perry
~~~

## 2. Crea otro usuario 'ornitorrinco' de forma NO interactiva. Es necesario que el usuario tenga consola de comandos(interprete de comandos) y home

~~~sh
sudo useradd -m -s /bin/bash ornitorrinco
sudo passwd ornitorrinco
~~~

## Crea la siguiente estructura de directorios

- examen
  - aprobado
    - seguroQueApruebo.txt
    - aprobadisimo
      - voyASacarUn10.txt
  - notas.txt

## 3. Crea un script en bash para la gestión de las notas de tus examenes. Sigue las siguientes indicaciones

> para este ejercicio usaremos el fichero 'notas.txt' que hemos creado previamente
>
> Consejo: repasa los siguientes comandos: 'sed', 'while IFS= read -r'

- Función mostrarMenu
  - 1. verNotas
  - 2. agregarNota
  - 3. modificarNota
  - 4. calcularMedia
  - 5. aprobado_o_no
  - 6. eliminarNota
  - 7. salir

- Función verNotas: tienes que mostrar el contenido completo del fichero
- Función agregarNota: agrega una nota al fichero
- Funcion modificarNota: busca una nota en el fichero y la modifica
- Función calcularMedia: lee el fichero y calcula la media de todas las notas
- Función aprobado_o_no: esta función solo se puede ejecutar si se ejecuta antes la funcion de 'calcularMedia'. recoge el resultado de la función calcularMedia y si es mayor o igual a 5 muestra un mensaje de 'He aprobado!!'
- Función eliminarNota: busca una nota en el fichero y la elimina. Cuando se ejecuta esta función es necesario ejecutar de nuevo la función de 'aprobado_o_no'.
- Salir: termina el programa si se introduce el numero 7

~~~sh
#!/bin/bash

notas_file="notas.txt"

mostrarMenu() {
    echo "1. verNotas"
    echo "2. agregarNota"
    echo "3. modificarNota"
    echo "4. calcularMedia"
    echo "5. aprobado_o_no"
    echo "6. eliminarNota"
    echo "7. salir"
}

verNotas() {
    cat "$notas_file"
}

agregarNota() {
    read -p "Ingrese la nota a agregar: " nota
    echo "$nota" >> "$notas_file"
    echo "Nota agregada: $nota"
}

modificarNota() {
    read -p "Ingrese la nota a modificar: " nota
    read -p "Ingrese la nueva nota: " nueva_nota
    sed -i "s/$nota/$nueva_nota/g" "$notas_file"
    echo "Nota modificada."
}

calcularMedia() {
    total=0
    num_notas=0
    while IFS= read -r nota; do
        total=$((total + nota))
        num_notas=$((num_notas + 1))
    done < "$notas_file"
    media=$((total / num_notas))
    echo "Media de las notas: $media"
}

aprobado_o_no() {
    calcularMedia
    if [ "$media" -ge 5 ]; then
        echo "¡He aprobado!"
    fi
}

eliminarNota() {
    read -p "Ingrese la nota a eliminar: " nota
    sed -i "/$nota/d" "$notas_file"
    echo "Nota eliminada."
}

while true; do
    mostrarMenu
    read opcion

    case $opcion in
        1) verNotas ;;
        2) agregarNota ;;
        3) modificarNota ;;
        4) calcularMedia ;;
        5) aprobado_o_no ;;
        6) eliminarNota ;;
        7) exit ;;
        *) echo "Opción inválida. Por favor, selecciona una opción válida." ;;
    esac
done
~~~

## 4. Crea un script para contar el número de vocales de una frase que el usuario introducza por teclado

> Consejo: repasa los siguientes comandos: 'tr', 'wc'

~~~sh
#!/bin/bash

echo "Ingresa una línea de texto:"
read linea

# Utilizar 'tr' para convertir todo a minúsculas
# Utilizar 'tr' para eliminar todo excepto las vocales
# Utilizar 'wc -c' para contar el número de caracteres
cantidad_vocales=$(echo "$linea" | tr '[:upper:]' '[:lower:]' | tr -cd 'aeiouáéíóú' | wc -c)

echo "Cantidad de vocales: $cantidad_vocales"
~~~

## Añade un disco de 10GB a la máquina de Ubuntu 20 para realizar particiones y formatos. De momento no hagas nada más que añadir el disco

## Añade otros 5 discos más de 10GB para crear un raid 5. De momento no hagas más que añadir los discos

## 5. Arranca la máquina virtual y realiza las siguientes particiones y formatos

- primaria 3gb ext4
- primaria 2gb ntfs
- logica 2gb fat32
- logica 1gb ext3
- logica 2gb ext4

>:warning: **¡CUIDADO!** primero hay que crear una partición extendida para almacenar las particiones lógicas

~~~bash
#Ver los discos que tenemos para saber el path
sudo fdisk -l

#Una partición primaria de 3 GiB con formato EXT4.
  #Crear la particion
    sudo fdisk /dev/sdb
    n
    p
    Enter
    +3G

  #Dar formato a la partición
   sudo mkfs.ext4 /dev/sdb1
 
#Una partición primaria de 2 GiB con formato NTFS.
    #Crear la particion
    n
    p
    Enter
    +2G

  #Dar formato a la partición
  sudo mkfs.ntfs /dev/sdb2

#una particion extendida para contener las logicas
n
e
Enter
Enter
Enter (tamaño por defecto ya que solo quedan 5GB libres)

#Una partición lógica de 2 GiB con formato FAT32.

    #Crear la particion
    n
    Enter
    +2G

  #Dar formato a la partición
   sudo mkfs.vfat /dev/sdb5

#Una partición lógica de 1 GiB con formato EXT3.
    #Crear la particion
    n
    Enter
    +1G

  #Dar formato a la partición
   sudo mkfs.ext3 /dev/sdb6

#Una partición lógica de 2 GiB con formato EXT4.
    #Crear la particion
    n
    Enter
    +2G

  #Dar formato a la partición
   sudo mkfs.ext4 /dev/sdb7
~~~

## 6. Crea un directorio 'mnt_1' en tu home y monta, de forma automática usando UUID, la primera partición (3GB) del primer disco extra

## 7. Crea un sistema RAID 5 con los 5 discos añadidos. 2 serán de reserva

## 8. Configura el archivo Crontab para que realice las siguientes tareas

>:pencil: **RECUERDA**: los comandos están configurados para ejecutarse en el huso horario del sistema, por lo que asegúrate de verificar la configuración del huso horario si es necesario para evitar confusiones con la hora de ejecución de los comandos.

### a. Borrado de los archivos localizados en /home/marco/aprobadisimo el día 1 de cada mes a las 23:00

### b. Realización de un backup normal del directorio /home/marco/aprobado. El backup debe realizarse los domingos a las 23:59 y debe guardarse en el directorio /home/marco/Desktop con el nombre marcoBackup.tar.bz2 (siendo dd día, mm mes y aa año)

## 8. Crea un script llamado comparador.sh que acepte tres parámetros al ser ejecutado: dos números y una cadena de texto. El script debe realizar las siguientes comparaciones y mostrar los resultados

- Comprobar si el primer número es mayor que el segundo número.
- Comprobar si el primer número es menor que el segundo número.
- Comprobar si la cadena de texto es igual a "bash".

## BONUS POINT. Crea un script llamado lista_colores.sh que muestre una lista de colores y permita al usuario agregar un nuevo color a la lista

> :warning: **ADVERTENCIA** el uso de funciones, identación y demás buenas prácticas será determinante para corregir el ejercicio.

El script debe comenzar mostrando una lista de colores predefinidos, por ejemplo: "rojo", "verde" y "azul".
Luego, el script debe permitir al usuario ingresar un nuevo color.
Después de que el usuario ingrese el nuevo color, el script debe mostrar nuevamente la lista actualizada de colores, incluyendo el nuevo color agregado.

> :black_joker: **PISTA** Para lograr esto, deberás utilizar un array en Bash para almacenar los colores. Cada vez que el usuario ingrese un nuevo color, este deberá ser agregado al array. El script debe usar bucles y estructuras de control adecuadas para lograr estas funcionalidades de manera sencilla y efectiva.
