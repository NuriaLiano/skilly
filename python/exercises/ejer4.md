# Calcular Factorial

- El programa pide al usuario que ingrese un número entero no negativo.
- Calcula el factorial de ese número. Recuerda que el factorial de un número n (representado como n!) es el producto de todos los números enteros positivos desde 1 hasta n.
- Muestra el resultado al usuario.

~~~py
print("Calcula el factorial")

#pedir al usuario que introduzca un numero
numero =  int(input("Introduce un numero: "))

#validar que el numero sea mayor que positivo
if numero < 0:
    print("No se puede calcular el factorial de un numero negativo")

else:
    print("Calculando el factorial")
    #inicializar la variable factorial
    factorial = 1

    for i in range(1, numero + 1):
        factorial = factorial *i

    #print("El factorial es: ", factorial)
    print(f"El factorial es: {factorial}")
~~~
