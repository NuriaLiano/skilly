# Soluciones a los ejercicios de repaso estructuras de control y bucles

## 1. Determina si un número es positivo o negativo

~~~py
numero = int(input("Inserta un numero: "))
if numero > 0:
    print("el numero es positivo")
elif numero < 0:
    print("el numero es negativo")
~~~

## 2. Imprime los primeros 10 números multiplos de 3

~~~py
for valor in range(1,11):
    print(valor * 3)
~~~

## 3. Haz un conteo regresivo desde 10 hasta 1

~~~py
for i in range(10,1, -1):
    print(i)
~~~

Otra solución puede ser:

~~~py
i = 10
while i > 0:
    print(i)
    i = i-1
~~~

## 4. Crea un pequeño juego donde el usuario debe adivinar un número secreto entre 1 y 5

~~~py
if numero == numero_secreto:
    print("El numero es correcto")
else:
    print("El numero no es correcto")
~~~

Otra solución

~~~py
if numero <= 3 or numero >= 5:
    print("el numero no es correcto")  
elif numero == numero_secreto:
    print("el numero es correcto")
~~~

Otra solución con bucle infinito

~~~py
numero_secreto = 4
while True:
    print("Introduce un 0 para salir")
    numero = int(input("Inserte numero: ")) 
    
    #salir del programa
    if numero == 0:
        break

    #comprobar el numero secreto
    if numero == numero_secreto:
        print("El numero es correcto")
        break
    else:
        print("El numero no es correcto")
~~~

## 5. Suma los numeros del 1 al 10

~~~py
suma = 0

for i in range(1,11):
    suma += i
    
print(suma)
~~~

## 6. Cuenta el número de vocales en una palabra que introduzca el usuario

~~~py
palabra = input("Introduce una palabra: ")

contadorVocales = 0

for vocal in palabra:
    if vocal == "a":
        contadorVocales += 1
    elif vocal == "e":
        contadorVocales += 1
    elif vocal == "i":
        contadorVocales += 1
    elif vocal == "o":
        contadorVocales += 1
    elif vocal == "u":
        contadorVocales += 1
    elif vocal == "A":
        contadorVocales += 1
    elif vocal == "E":
        contadorVocales += 1
    elif vocal == "I":
        contadorVocales += 1
    elif vocal == "O":
        contadorVocales += 1
    elif vocal == "U":
        contadorVocales += 1
        
print("La palabra", palabra, "tiene", contadorVocales, "vocales")
~~~

Otra solución

~~~py
palabra = input("Introduce una palabra: ")

contadorVocales = 0

for vocal in palabra:
    if vocal in "aeiouAEIOU":
        contadorVocales += 1
        
print("La palabra", palabra, "tiene", contadorVocales, "vocales")
~~~

## 7. Pide dos números al usuario e imprime el menor

~~~py
numero = input("Introduce un número: ")
numeroDos = input("Introduce otro número: ")

if numero < numeroDos:
    print("El menor es:", numero)
else:
    print("El menor es:", numeroDos)
~~~

## 8. Imprime la tabla de multiplicar del número que prefiera el usuario

~~~py
num = int(input("Ingresa un número para ver su tabla de multiplicar: "))
for i in range(1, 11):
    print(f"{num} x {i} = {num * i}")
~~~

## 9. Cuenta cuántos números pares e impares hay entre 1 y 100

~~~py
i = 1
pares = 0
impares = 0
while i <= 100:
    if i % 2 == 0:
        pares += 1
    else:
        impares += 1
    i += 1
print("Pares:", pares)
print("Impares:", impares)
~~~
