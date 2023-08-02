---
author: "@nurialiano"
license: "Creative Commons Attribution-NonCommercial 4.0 International"
---

# Listas, tuplas, set, arrays y diccionarios

1. [Listas, tuplas, set, arrays y diccionarios](#listas-tuplas-set-arrays-y-diccionarios)
   1. [Listas](#listas)
   2. [Tuplas](#tuplas)
   3. [Set (conjuntos)](#set-conjuntos)
   4. [Arrays](#arrays)
   5. [Diccionarios](#diccionarios)
   6. [Tabla comparativa resumen](#tabla-comparativa-resumen)

## Listas

Las listas son colecciones ordenadas y modificables de elementos en Python. Pueden contener elementos de diferentes tipos de datos, como números, cadenas, listas anidadas y más. Se definen utilizando corchetes [] y los elementos se separan por comas. Puedes acceder a los elementos de una lista utilizando su índice (empezando desde 0) y también puedes modificar o agregar elementos utilizando diferentes métodos de lista.

~~~py
mi_lista = [1, 2, 3, "Hola", [4, 5, 6]]
print(mi_lista[0])  # Salida: 1
mi_lista.append(7)  # Agregar un elemento al final de la lista
print(mi_lista)     # Salida: [1, 2, 3, 'Hola', [4, 5, 6], 7]
~~~

## Tuplas

Las tuplas son colecciones ordenadas e inmutables de elementos en Python. A diferencia de las listas, una vez que se crea una tupla, no se pueden modificar, agregar o eliminar elementos. Se definen utilizando paréntesis () y los elementos se separan por comas. Son útiles para datos que no deben cambiar durante la ejecución del programa, ya que son más rápidas y utilizan menos memoria que las listas.

~~~py
mi_tupla = (1, 2, 3, "Hola")
print(mi_tupla[0])  # Salida: 1
# Intentar modificar la tupla generaría un error, por ejemplo: mi_tupla[0] = 10
~~~

## Set (conjuntos)

Los sets son colecciones no ordenadas y no indexadas de elementos únicos en Python. No permiten elementos duplicados y son útiles para realizar operaciones matemáticas de conjuntos como unión, intersección, diferencia, etc. Se definen utilizando llaves {} o utilizando el constructor set().

~~~py
mi_set = {1, 2, 3, 4}
print(2 in mi_set)  # Salida: True
mi_set.add(5)       # Agregar un elemento al set
print(mi_set)       # Salida: {1, 2, 3, 4, 5}
~~~

## Arrays

Los arrays en Python son similares a las listas, pero están optimizados para operaciones matemáticas y de cálculo numérico. Se definen utilizando la biblioteca NumPy (import numpy as np) y se pueden realizar operaciones vectorizadas en ellos.

~~~py
import numpy as np
mi_array = np.array([1, 2, 3])
print(mi_array * 2)  # Salida: [2, 4, 6]
~~~

## Diccionarios

Los diccionarios son colecciones de pares clave-valor en Python. Se definen utilizando llaves {} y los elementos clave-valor se separan por comas. Las claves deben ser únicas y los valores pueden ser de cualquier tipo de dato. Puedes acceder a los valores a través de sus claves y también puedes modificar o agregar nuevos pares clave-valor.

~~~py
mi_diccionario = {"nombre": "Juan", "edad": 30, "ciudad": "Madrid"}
print(mi_diccionario["nombre"])  # Salida: "Juan"
mi_diccionario["edad"] = 31     # Modificar el valor de una clave existente
mi_diccionario["ocupacion"] = "Ingeniero"  # Agregar un nuevo par clave-valor
print(mi_diccionario)  # Salida: {'nombre': 'Juan', 'edad': 31, 'ciudad': 'Madrid', 'ocupacion': 'Ingeniero'}
~~~

## Tabla comparativa resumen

| Característica     | Listas                    | Sets                      | Arrays                    | Diccionarios               | Tuplas                    |
|--------------------|---------------------------|---------------------------|---------------------------|----------------------------|---------------------------|
| Tipo de datos      | Puede contener elementos de diferentes tipos de datos. | Contiene elementos únicos y no permite duplicados. | Puede contener elementos de un solo tipo de datos homogéneo. | Contiene pares clave-valor. | Puede contener elementos de diferentes tipos de datos. |
| Definición         | Definidas entre corchetes [ ] y separadas por comas. | Definidos entre llaves { } y separados por comas. | Utiliza la biblioteca NumPy, definido como np.array(). | Definidos entre llaves { } con pares clave:valor separados por comas. | Definidas entre paréntesis ( ) y separadas por comas. |
| Orden             | Mantienen el orden de inserción de los elementos. | No mantienen un orden específico. | Mantienen el orden de inserción de los elementos. | No mantienen un orden específico. | Mantienen el orden de inserción de los elementos. |
| Duplicados         | Permite elementos duplicados. | No permite elementos duplicados. | Permite elementos duplicados. | Las claves son únicas, no permite claves duplicadas. | Permite elementos duplicados. |
| Mutabilidad        | Son mutables, se pueden modificar sus elementos. | Son mutables, se pueden agregar y eliminar elementos. | Los arrays NumPy son mutables, pero su tamaño no se puede cambiar después de la creación. | Son mutables, se pueden agregar, modificar y eliminar pares clave-valor. | Son inmutables, una vez creadas no pueden modificarse. |
| Indexación         | Se accede a los elementos mediante su índice numérico. | No permite la indexación, ya que no tiene un orden específico. | Se accede a los elementos mediante su índice numérico. | Se accede a los valores mediante sus claves. | Se accede a los elementos mediante su índice numérico. |
| Uso de memoria     | Requiere más memoria debido a su flexibilidad con diferentes tipos de datos. | Requiere menos memoria debido a que solo almacena elementos únicos. | Requiere menos memoria que las listas estándar, especialmente con grandes conjuntos de datos. | Requiere más memoria que las listas debido al almacenamiento de claves y valores. | Requiere menos memoria debido a su naturaleza inmutable. |
| Utilidad          | Utilizadas para almacenar y manipular colecciones de elementos. | Utilizados para asegurar que no haya duplicados en un conjunto de elementos. | Utilizados para realizar operaciones numéricas eficientes en grandes conjuntos de datos homogéneos. | Utilizados para almacenar datos asociados con claves únicas para una búsqueda eficiente. | Utilizadas para crear estructuras inmutables y para asegurar que los datos no cambien. |
