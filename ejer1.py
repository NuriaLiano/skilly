#CREAR LA FUNCIÓN ES PALINDROMO
def es_palindromo(texto):
    #limpiar el texto de espacios, signos de puntuacion, convertir a minusculas
    texto_minusculas = texto.lower()
    texto_sin_espacios = texto_minusculas.replace(" ", "")

    #texto -> "HOLA "
    #texto_sin_espacios -> "HOLA"
    #texto_sin_espacios[::-1]-> "OLAH"

    return texto_sin_espacios == texto_sin_espacios[::-1]

print(es_palindromo("Anita lava la tina")) #devuelve TRUE
print(es_palindromo("hola")) #devuelve FALSE




