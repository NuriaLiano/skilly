---
author: "@nurialiano"
license: "Creative Commons Attribution-NonCommercial 4.0 International"
---

# Módulos

1. [Módulos](#módulos)
   1. [Crear Módulos](#crear-módulos)
   2. [Importar Módulos](#importar-módulos)
      1. [Alias en importación](#alias-en-importación)
      2. [Importar funciones o variables específicas](#importar-funciones-o-variables-específicas)
      3. [Importar todas las definiciones](#importar-todas-las-definiciones)
   3. [Tipos de módulos](#tipos-de-módulos)
      1. [Módulos estándar](#módulos-estándar)
      2. [Módulos de terceros (Pip)](#módulos-de-terceros-pip)

## Crear Módulos

Un módulo se crea simplemente creando un archivo con extensión .py que contenga las definiciones de funciones, clases y variables que desees utilizar en otros programas.

~~~py
# mi_modulo.py

def saludar(nombre):
    return f"Hola, {nombre}!"

PI = 3.14159
~~~

## Importar Módulos

Para utilizar las definiciones dentro de un módulo en otro programa, primero debes importar el módulo. Puedes hacerlo utilizando la instrucción import seguida del nombre del archivo del módulo (sin la extensión .py).

~~~py
import mi_modulo

nombre = "Juan"
saludo = mi_modulo.saludar(nombre)
print(saludo)
~~~

### Alias en importación

Puedes utilizar un alias (nombre corto) para referenciar el módulo al importarlo. Esto es útil si el nombre del módulo es largo o si deseas evitar conflictos de nombres con otros módulos. Se utiliza la palabra clave as para asignar un alias

~~~py
import mi_modulo as mm

nombre = "María"
saludo = mm.saludar(nombre)
print(saludo)
~~~

### Importar funciones o variables específicas

En lugar de importar todo el módulo, también puedes importar funciones o variables específicas. Esto te permite usarlas directamente sin tener que escribir el nombre del módulo cada vez que las llamas

~~~py
from mi_modulo import saludar

nombre = "Pedro"
saludo = saludar(nombre)
print(saludo)
~~~

### Importar todas las definiciones

Si deseas importar todas las definiciones de un módulo sin tener que utilizar el nombre del módulo, puedes usar el asterisco *.

> :heavy_exclamation_mark: **NO RECOMENDADO** Sin embargo, esto no se recomienda en general, ya que puede causar conflictos de nombres y hacer que el código sea menos legible

~~~py
from mi_modulo import *

nombre = "Laura"
saludo = saludar(nombre)
print(saludo)
~~~

## Tipos de módulos

### Módulos estándar

Python viene con una gran cantidad de módulos estándar que proporcionan funcionalidades adicionales y herramientas listas para usar. Puedes encontrar una lista completa de los módulos estándar en la documentación oficial de Python.

Aquí tienes una lista con los principales módulos estándar.

1. **os:** Proporciona una interfaz para interactuar con el sistema operativo. Permite trabajar con directorios, archivos, procesos y variables de entorno.
2. **sys:** Proporciona acceso a variables y funciones específicas del intérprete de Python. Permite controlar la ejecución del programa y manipular la secuencia de búsqueda de módulos.
3. **math:** Proporciona funciones matemáticas avanzadas, como funciones trigonométricas, exponenciales, logarítmicas, entre otras.
4. **random:** Genera números aleatorios y permite trabajar con secuencias aleatorias. Útil para aplicaciones que requieren aleatoriedad.
5. **datetime:** Permite trabajar con fechas y horas. Proporciona clases para representar fechas, horas, intervalos de tiempo y operaciones relacionadas.
6. **json:** Proporciona funciones para trabajar con datos en formato JSON (JavaScript Object Notation), muy común en el intercambio de datos en aplicaciones web.
7. **csv:** Permite trabajar con archivos CSV (Comma-Separated Values), utilizados para almacenar datos tabulares en formato de texto plano.
8. **re:** Proporciona soporte para expresiones regulares, lo que permite realizar búsquedas y manipulaciones de patrones en cadenas de texto.
9. **requests:** Facilita el envío de solicitudes HTTP a través de la red. Útil para acceder a recursos web y trabajar con APIs.
10. **sqlite3:** Proporciona una interfaz para trabajar con bases de datos SQLite, un motor de base de datos ligero y ampliamente utilizado.
11. **pickle:** Permite serializar y deserializar objetos Python, lo que facilita el almacenamiento y recuperación de datos complejos.
12. **time:** Proporciona funciones para trabajar con el tiempo, como pausar la ejecución del programa o medir el tiempo de ejecución.
13. **collections:** Contiene clases adicionales que amplían las capacidades de las estructuras de datos incorporadas, como `defaultdict`, `Counter`, `deque`, entre otras.
14. **argparse:** Facilita el análisis de argumentos de línea de comandos, permitiendo que tus programas acepten opciones y argumentos personalizados.
15. **logging:** Proporciona funciones para generar mensajes de registro (logs), lo que facilita la depuración y el seguimiento del comportamiento de tus programas.
16. **io:** Proporciona clases y funciones para trabajar con operaciones de entrada/salida, como trabajar con archivos y flujos de datos.
17. **subprocess:** Permite crear y controlar procesos secundarios desde tu programa, lo que te permite ejecutar comandos externos y acceder a sus resultados.
18. **unittest:** Facilita la creación y ejecución de pruebas unitarias, lo que ayuda a garantizar la calidad y robustez de tu código.
19. **socket:** Proporciona soporte para la comunicación de red mediante sockets, lo que permite construir aplicaciones cliente-servidor
20. **xml.etree.ElementTree:** Permite analizar y crear documentos XML, útil para trabajar con datos estructurados en formato XML.

### Módulos de terceros (Pip)

Además de los módulos estándar, también puedes instalar módulos de terceros utilizando el administrador de paquetes **pip**. Estos módulos son desarrollados por la comunidad y ofrecen una amplia variedad de funcionalidades para tareas específicas.

Al administrador de paquetes PIP le dedicaremos una sección para detallar el uso, instalación, configuración y buenas prácticas.
