# Ejercicios sencillos Python

## 1. Calculadora de IMC (Índice de Masa Corporal)

~~~py
# Se ejecutará en un bucle para permitir al usuario probar diferentes valores.
continuar = 's'
while continuar == 's':
    # Solicita al usuario que ingrese su peso en kilogramos.
    peso = float(input("Ingresa tu peso en kilogramos: "))

    # Solicita al usuario que ingrese su altura en metros.
    altura = float(input("Ingresa tu altura en metros: "))

    # Calcula el IMC usando la fórmula IMC = peso / (altura al cuadrado).
    imc = peso / (altura ** 2)

    # Muestra el IMC calculado.
    print("Tu Índice de Masa Corporal es:", imc)

    # Pregunta al usuario si quiere calcular otro IMC.
    continuar = input("¿Quieres calcular otro IMC? (s/n): ")
~~~

## Conversor de Monedas

- Solicita al usuario una cantidad de dinero y la moneda de origen y destino (por ejemplo, de USD a EUR).
- Utiliza un bucle para realizar varias conversiones.
- Integra un paquete como forex-python para obtener tasas de cambio actualizadas.

## Generador de Contraseñas

~~~py
import random

#almacena en una variable el numero que introduce el usuario por teclado
longitudPassword = int(input("Introduce la longitud de la password: "))

letras="abcdefghijklmnnopqrstuvwxyzABCDEFGHIJKLMNNOPQRSTUVWXYZ"
numeros="0123456789"
simbolos="@#$%&*+"

#juntar todas las listar
caracteres =letras+numeros+simbolos

contraseña = ""

for i in range(longitudPassword):
    caracter_aleatorio = random.choice(caracteres)
    contraseña += caracter_aleatorio

print(contraseña)
~~~

## Juego de Adivinanza de Números

~~~py
# Importa la librería random para generar números aleatorios.
import random

# El programa elige un número aleatorio entre 1 y 100.
numero_secreto = random.randint(1, 100)

# Inicializa una variable para almacenar la adivinanza del usuario.
adivinanza = None

# Inicia un bucle para permitir múltiples intentos.
while adivinanza != numero_secreto:
    # Solicita al usuario que ingrese su adivinanza.
    adivinanza = int(input("Adivina el número entre 1 y 100: "))

    # Compara la adivinanza del usuario con el número secreto y proporciona retroalimentación.
    if adivinanza < numero_secreto:
        print("Demasiado bajo, intenta de nuevo.")
    elif adivinanza > numero_secreto:
        print("Demasiado alto, intenta de nuevo.")

# Felicita al usuario por adivinar correctamente.
print("¡Felicidades! Adivinaste el número.")
~~~

## Análisis de Texto Básico

~~~py
# Solicita al usuario ingresar un texto.
texto = input("Ingresa un texto para analizar: ")

# Inicializa el contador de palabras y frases.
numero_palabras = len(texto.split())
numero_frases = texto.count('.') + texto.count('?') + texto.count('!')

# Inicializa un diccionario para llevar la cuenta de la frecuencia de cada letra.
frecuencia_letras = {}

# Usa un bucle para iterar a través de cada letra en el texto.
for letra in texto:
    # Convierte todas las letras a minúsculas para la consistencia.
    letra = letra.lower()
    # Incrementa el conteo de la letra si es alfabética.
    if letra.isalpha():
        if letra in frecuencia_letras:
            frecuencia_letras[letra] += 1
        else:
            frecuencia_letras[letra] = 1

# Muestra los resultados del análisis.
print(f"Número de palabras: {numero_palabras}")
print(f"Número de frases: {numero_frases}")
print("Frecuencia de cada letra:")
for letra, frecuencia in frecuencia_letras.items():
    print(f"{letra}: {frecuencia}")
~~~
