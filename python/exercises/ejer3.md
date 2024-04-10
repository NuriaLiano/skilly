# Suma de positivos

- El programa comienza con una suma inicial de 0.
- Entra en un bucle while que pide al usuario que introduzca un número.
- Si el número es positivo, se suma al total.
- Si el número es negativo, el programa termina y muestra la suma total

~~~py
suma = 0

print ("Introduce numeros para sumar")

while True: #bucle infinito hasta que el usuario introduzca un num negativo

    #OPCION 1 -> print ("Introduce un numero")
    #pido el numero al usuario
   

    numero = int(input("Introduce de nuevo un numero: "))
    #print (type(numero)) # <class 'str'>
    #print (type(int(numero))) #<class 'int'>
    if numero > 0: #positivos
        suma = suma + numero
    else: 
        break
    
    
print(f"La suma total es : {suma}")
~~~
