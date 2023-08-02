---
author: "@nurialiano"
license: "Creative Commons Attribution-NonCommercial 4.0 International"
---

# Ingreso de datos (input)

1. [Ingreso de datos (input)](#ingreso-de-datos-input)
   1. [Uso básico](#uso-básico)
   2. [Mensaje opcional](#mensaje-opcional)
   3. [Conversión de tipo de datos](#conversión-de-tipo-de-datos)
      1. [A tener en cuenta con bool(input())](#a-tener-en-cuenta-con-boolinput)
   4. [Entradas con salto de línea](#entradas-con-salto-de-línea)

## Uso básico

La función input() no toma ningún argumento y devuelve el valor ingresado por el usuario como una cadena. Puedes asignar este valor a una variable para usarlo posteriormente en tu programa.

~~~py
nombre = input()
print(f"Hola, {nombre}!")
~~~

## Mensaje opcional

El argumento de input() es un mensaje opcional que se muestra al usuario para solicitar la entrada. Este mensaje puede ser una cadena de texto que ayude al usuario a entender qué tipo de información se espera.

~~~py
edad = input("Ingresa tu edad: ")
print(f"Tienes {edad} años.")
~~~

## Conversión de tipo de datos

El valor ingresado por el usuario es siempre tratado como una cadena, incluso si es numérico. Si necesitas trabajar con otros tipos de datos (como enteros, flotantes, etc.), debes convertir la entrada del usuario al tipo de dato adecuado usando funciones de conversión como int() o float().

~~~py
numero = int(input("Ingresa un número entero: "))
print(f"El doble del número ingresado es: {numero * 2}")
~~~

### A tener en cuenta con bool(input())

En Python, la función bool() se utiliza para obtener el valor booleano de una expresión o variable. El resultado de bool() es True si la expresión o variable es evaluada como verdadera, y False si es evaluada como falsa.
En el contexto del input(), es importante tener en cuenta que cualquier cadena no vacía se considera verdadera al convertirla a booleano usando bool(). Esto significa que si el usuario ingresa cualquier texto, incluso si no es "True" o "False", el resultado de bool(input("mete")) será True.

~~~py
texto = input("Ingresa algo: ")
valor_booleano = bool(texto)
print("El valor booleano es:", valor_booleano)
~~~

Si el usuario ingresa "Hola", el resultado será:

~~~py
El valor booleano es: True
~~~

Si el usuario no ingresa nada (pulsa Enter sin escribir nada), el resultado será:

~~~py
El valor booleano es: True
~~~

Es importante tener en cuenta esta particularidad de bool() al solicitar entrada al usuario y al interpretar sus respuestas como valores booleanos. Si deseas obtener un valor booleano explícito basado en la entrada del usuario ("True" o "False"), debes realizar una manipulación previa del texto ingresado para asegurarte de que coincida con los valores booleanos que deseas considerar como verdaderos o falsos.

~~~py
def obtener_booleano(entrada):
    if entrada.lower() == "true":
        return True
    elif entrada.lower() == "false":
        return False
    else:
        raise ValueError("La entrada debe ser 'True' o 'False'.")

try:
    texto = input("Ingresa 'True' o 'False': ")
    valor_booleano = obtener_booleano(texto)
    print("El valor booleano es:", valor_booleano)
except ValueError as error:
    print("Error:", error)
~~~

## Entradas con salto de línea

El input() captura toda la entrada del usuario hasta que se presione la tecla "Enter" o "Return". Si deseas capturar múltiples entradas o líneas de texto, puedes utilizar bucles para leer varias líneas hasta que el usuario ingrese un valor específico que indique la finalización de la entrada.

~~~py
lineas = []
print("Ingresa varias líneas de texto. Escribe 'fin' para terminar.")
while True:
    linea = input()
    if linea.lower() == "fin":
        break
    lineas.append(linea)

print("Las líneas ingresadas son:")
for linea in lineas:
    print(linea)
~~~

