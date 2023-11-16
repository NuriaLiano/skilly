# Solución al ejercicio 1 de Python

## Calculadora de IMC (Índice de Masa Corporal)

~~~py
def calcular_imc(peso, altura):
    return peso / (altura ** 2)

def main():
    while True:
        peso = float(input("Ingrese su peso en kilogramos: "))
        altura = float(input("Ingrese su altura en metros: "))
        imc = calcular_imc(peso, altura)
        print(f"Su IMC es: {imc:.2f}")

        otra_operacion = input("¿Desea calcular otro IMC? (s/n): ")
        if otra_operacion.lower() != 's':
            break

if __name__ == "__main__":
    main()
~~~

## Conversor de Monedas

~~~py
from forex_python.converter import CurrencyRates

def convertir_moneda(cantidad, de_moneda, a_moneda):
    c = CurrencyRates()
    return c.convert(de_moneda, a_moneda, cantidad)

def main():
    while True:
        cantidad = float(input("Ingrese la cantidad de dinero: "))
        de_moneda = input("Ingrese la moneda de origen (ejemplo: 'USD'): ")
        a_moneda = input("Ingrese la moneda de destino (ejemplo: 'EUR'): ")

        resultado = convertir_moneda(cantidad, de_moneda, a_moneda)
        print(f"{cantidad} {de_moneda} son {resultado:.2f} {a_moneda}")

        otra_operacion = input("¿Desea realizar otra conversión? (s/n): ")
        if otra_operacion.lower() != 's':
            break

if __name__ == "__main__":
    main()
~~~

## Generador de Contraseñas

Este programa pedirá al usuario que ingrese la longitud deseada para la contraseña y generará una contraseña aleatoria utilizando una combinación de letras, números y símbolos.

~~~py
import random

def generar_contrasena(longitud):
    caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()"
    contrasena = ''.join(random.choice(caracteres) for i in range(longitud))
    return contrasena

def main():
    longitud = int(input("Ingrese la longitud deseada para la contraseña: "))
    contrasena = generar_contrasena(longitud)
    print(f"Su nueva contraseña es: {contrasena}")

if __name__ == "__main__":
    main()
~~~

## Juego de Adivinanza de Números

~~~py
import random

def main():
    numero_secreto = random.randint(1, 100)
    intento = None

    while intento != numero_secreto:
        intento = int(input("Adivina el número (entre 1 y 100): "))
        if intento < numero_secreto:
            print("Demasiado bajo.")
        elif intento > numero_secreto:
            print("Demasiado alto.")
    
    print("¡Felicidades! Adivinaste el número.")

if __name__ == "__main__":
    main()
~~~

## Análisis de Texto Básico

~~~py
def analizar_texto(texto):
    palabras = texto.split()
    num_palabras = len(palabras)
    num_frases = texto.count('.') + texto.count('!') + texto.count('?')
    frecuencia_letras = {letra: texto.count(letra) for letra in set(texto) if letra.isalpha()}
    
    return num_palabras, num_frases, frecuencia_letras

def main():
    texto = input("Ingrese un texto para analizar: ")
    num_palabras, num_frases, frecuencia_letras = analizar_texto(texto)

    print(f"Número de palabras: {num_palabras}")
    print(f"Número de frases: {num_frases}")
    print("Frecuencia de cada letra:")
    for letra, frecuencia in frecuencia_letras.items():
        print(f"{letra}: {frecuencia}")

if __name__ == "__main__":
    main()
~~~
