---
author: "@nurialiano"
license: "Creative Commons Attribution-NonCommercial 4.0 International"
---

# Excepciones

1. [Excepciones](#excepciones)
   1. [Lanzamiento de excepciones](#lanzamiento-de-excepciones)
   2. [Captura de excepciones](#captura-de-excepciones)
   3. [Bloque finally](#bloque-finally)
   4. [Excepciones múltiples](#excepciones-múltiples)
   5. [Exception](#exception)
   6. [Raising in except](#raising-in-except)
   7. [Else](#else)
   8. [Crear tu propia excepción](#crear-tu-propia-excepción)

Las excepciones en Python son eventos que ocurren durante la ejecución de un programa y que interrumpen el flujo normal de ejecución. Cuando se produce una excepción, Python genera un objeto que representa el error ocurrido y busca una sección de código que maneje o capture dicha excepción. Si no se maneja, el programa se detendrá y mostrará un mensaje de error en la consola.
Las excepciones son fundamentales para manejar errores y situaciones inesperadas en el código, lo que permite que el programa no se bloquee por completo y pueda recuperarse de posibles problemas.

## Lanzamiento de excepciones

Puedes lanzar una excepción manualmente en Python utilizando la palabra clave raise. Puedes crear tus propias clases de excepción personalizadas para manejar casos específicos.

~~~py
def dividir(a, b):
    if b == 0:
        raise ValueError("No se puede dividir entre cero.")
    return a / b

try:
    resultado = dividir(10, 0)
except ValueError as error:
    print("Error:", error)
~~~

## Captura de excepciones

Para manejar excepciones, se utiliza un bloque try junto con uno o más bloques except. En el bloque try, se coloca el código que podría generar una excepción, y en el bloque except, se coloca el código que se ejecutará en caso de que se produzca esa excepción.

~~~py
try:
    numero = int(input("Ingresa un número: "))
    resultado = 10 / numero
except ValueError:
    print("Error: Debes ingresar un número entero.")
else:
    print("El resultado es:", resultado)
~~~

## Bloque finally

Puedes utilizar un bloque finally para definir código que se ejecutará independientemente de si se produce una excepción o no. El bloque finally se utiliza para limpiar recursos o realizar acciones que deben ocurrir sin importar el resultado del bloque try.

~~~py
try:
    archivo = open("mi_archivo.txt", "r")
    contenido = archivo.read()
except FileNotFoundError:
    print("Error: El archivo no existe.")
finally:
    archivo.close()  # Se cierra el archivo en cualquier caso
~~~

## Excepciones múltiples

Puedes capturar múltiples excepciones en un solo bloque except separándolas con paréntesis o en varios bloques except.

~~~py
try:
    numero = int(input("Ingresa un número: "))
    resultado = 10 / numero
except (ValueError, ZeroDivisionError):
    print("Error: Debes ingresar un número entero diferente de cero.")

 #otra opcion
try:
    numero = int(input("Ingresa un número: "))
    resultado = 10 / numero
except ValueError:
    print("Error: Debes ingresar un número entero.")
except ZeroDivisionError:
    print("Error: No se puede dividir entre cero.")
~~~

## Exception

es una clase base en Python que se utiliza para capturar cualquier tipo de excepción que ocurra en un programa. Puedes usar Exception en el bloque except para capturar cualquier error que se produzca durante la ejecución del código. Es útil cuando no sabes exactamente qué tipo de excepción esperar o cuando deseas capturar cualquier excepción de manera genérica.

> :warning: **ADVERTENCIA** Siempre se debe tener cuidado al capturar excepciones genéricas como Exception, ya que esto puede ocultar errores que deberían ser manejados de manera específica. Es preferible capturar excepciones específicas siempre que sea posible, para que el programa pueda manejar adecuadamente diferentes situaciones de error.

~~~py
try:
    numero = int(input("Ingresa un número positivo: "))
    if numero < 0:
        raise ValueError("Debes ingresar un número positivo.")
    resultado = 10 / numero
except Exception as error:
    print("Ocurrió un error:", error)
~~~

## Raising in except

Puedes volver a lanzar una excepción dentro de un bloque except para propagarla a un nivel superior y manejarla en otro lugar del programa.

~~~py
try:
    numero = int(input("Ingresa un número positivo: "))
    if numero < 0:
        raise ValueError("Debes ingresar un número positivo.")
except ValueError as error:
    print("Error:", error)
    # Aquí podríamos hacer algo más con la excepción si es necesario
    raise  # Propagar la excepción a un nivel superior
~~~

## Else

El bloque else en las excepciones se utiliza para definir un conjunto de instrucciones que se ejecutarán solo si no se produce ninguna excepción en el bloque try. En otras palabras, el código dentro del bloque else se ejecutará si el bloque try se ejecuta correctamente sin lanzar ninguna excepción.
El bloque else es opcional y puede omitirse si no se requiere ejecutar código adicional cuando no se producen excepciones. Sin embargo, es útil para realizar acciones específicas o proporcionar retroalimentación adicional en caso de que el bloque try se ejecute correctamente.

~~~py
try:
    # Código que puede generar una excepción
except Excepcion1:
    # Código para manejar Excepcion1
except Excepcion2:
    # Código para manejar Excepcion2
else:
    # Código que se ejecutará si no se produce ninguna excepción en el bloque try
~~~

## Crear tu propia excepción

Con la clase Exception como base, puedes crear tus propias excepciones personalizadas en Python. Esto te permite definir errores específicos que pueden ocurrir en tu programa y capturarlos de manera distintiva para manejarlos adecuadamente.

Para crear tu propia excepción personalizada, simplemente debes crear una nueva clase que herede de Exception. Puedes personalizar el comportamiento de tu excepción agregando atributos, métodos y mensajes de error específicos según tus necesidades.

~~~py
class MiError(Exception):
    def __init__(self, mensaje):
        self.mensaje = mensaje

    def __str__(self):
        return f"Ha ocurrido un error personalizado: {self.mensaje}"

def dividir(a, b):
    if b == 0:
        raise MiError("No se puede dividir entre cero.")
    return a / b

try:
    resultado = dividir(10, 0)
except MiError as error:
    print(error)  # Salida: Ha ocurrido un error personalizado: No se puede dividir entre cero.
~~~

En este ejemplo, hemos creado la clase MiError, que hereda de Exception. Hemos agregado un constructor `__init__` para inicializar el mensaje de error y un método `__str__` para devolver el mensaje personalizado cuando la excepción se imprima como una cadena. Cuando llamamos a la función dividir con el segundo argumento igual a cero, se lanza nuestra excepción personalizada MiError con el mensaje "No se puede dividir entre cero." Luego, capturamos la excepción en el bloque except y mostramos el mensaje personalizado.
