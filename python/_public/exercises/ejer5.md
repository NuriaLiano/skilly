# División de una frase en palabras

- Pide al usuario que introduzca una frase.
- Divide la frase en palabras.
- Usa un diccionario para contar la cantidad de veces que cada palabra aparece en la frase.
- Imprime las palabras y sus respectivos conteos.

~~~py

#print("Introduce una frase")
frase = input("Introduce una frase: ") #pedir al usuario que introduzca una frase

#dividir la frase en palabras
listaPalabras = frase.split() #palabras va a ser una lista  de palabras

#diccionario para guardar las palabras que coincidan
contar_palabras = {} #diccionario vacio

#contar cuantas veces aparece una palabra en una frase
for palabra in listaPalabras:
    if palabra in contar_palabras:
        contar_palabras[palabra] += 1 #suma de uno en uno si coincide
    else:
        contar_palabras[palabra] = 1 #primera vez que aparece la palabra

for palabra, repeticiones in contar_palabras.items():
    print(f"La palabra '{palabra}' aparece {repeticiones} veces")
~~~