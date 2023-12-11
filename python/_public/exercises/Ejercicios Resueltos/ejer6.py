
#diccionarios
mi_diccionario = {
    1: {"titulo": "el señor de los anillos",
         "disponible": True},
    2: {"titulo": "El principito", "disponible":True},
    3: {"titulo": "El resplandor", "disponible":True},
    4: {"titulo": "La sombra", "disponible":False},
    5: {"titulo": "La niebla", "disponible":True}
}

def listar_libros():
    for id, detalles in  mi_diccionario.items():
        if detalles["disponible"]:
            print(f"ID: {id}, Titulo: {detalles['titulo']}")

def buscar_libro():
    while True:
        print("Para salir introduce 'salir'")
        titulo_libro = input("Introduce el titulo del libro")
        encontrado = False

        if titulo_libro == "salir":
            break

        for detalles in mi_diccionario.values():
            if detalles["titulo"] == titulo_libro and detalles["disponible"]:
                print("El libro está disponible en el catálogo")
                encontrado = True
                break
        if not encontrado:
            print("El libro no está disponible en el catálogo")

def disponibilidad():
    id_libro = int(input("Introduce el ID del libro para cambiar la disponibilidad"))
    if mi_diccionario[id_libro]["disponible"]:
        mi_diccionario[id_libro]["disponible"] = False
        print("El libro ha sido prestado")
    else:
        mi_diccionario[id_libro]["disponible"] = True
        print("El libro ha sido devuelto")


def principal():
    while True:
        print("1. Listar libros")
        print("2. Buscar libro")
        print("3. Prestar/devolver libro")
        print("4. Salir")

        eleccion = int(input("Elige una opción"))

        if eleccion == 1:
            listar_libros()
        elif eleccion == 2:
            buscar_libro()
        elif eleccion == 3:
            disponibilidad()
        elif eleccion == 4:
            print("Saliendo")
            break
        else:
            print("Opción incorrecta")
        
if __name__ == "__main__":
    principal()
    