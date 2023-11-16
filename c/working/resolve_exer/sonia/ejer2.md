Una matriz simétrica de orden 3 es una matriz cuadrada que satisface𝐴 = 𝑎𝑖 , 𝑗( ) ∈ 𝑀3 𝑥 3
que . Por ejemplo, la siguiente matriz de orden 3 es∀ 𝑖 , 𝑗 ∈ 1, 2, 3{ }: 𝑎𝑖 , 𝑗 = 𝑎𝑗 , 𝑖
simétrica:
Os pedimos que implementéis un programa C que indique si una matriz determinada de
orden 3 es simétrica.
Para desarrollar este programa, sólo se permite usar los conceptos estudiados hasta
ahora. Siempre que sea posible, se debe evitar el uso de valores numéricos directos y
utilizar en su sitio constantes previamente definidas.
Entrada de datos
Para cada elemento de la matriz, se entrará desde teclado:
● La posición i (fila) de la coordenada: [1 .. 3].
● La posición j (columna) de la coordenada: [1 .. 3].
● El valor entero que contiene la coordenada i , j.
Los valores de entrada siempre serán correctos, por lo que no es preciso realizar ninguna
validación.
Salida de datos
Se mostrará por pantalla si la matriz es o no simétrica.
Ejemplo de ejecución
En el anexo del final de este documento podéis consultar un ejemplo de ejecución del
programa en lenguaje C: revisadlo para utilizar los literales exactos para resolver el
ejercicio.
2

anexo: (el resultado tiene que ser igual que el anexo)
INPUT
I-COORD?
1
J-COORD?
1
VALUE?
10
I-COORD?
1
J-COORD?
2
VALUE?
2
I-COORD?
1
J-COORD?
3
VALUE?
13
I-COORD?
2
J-COORD?
1
VALUE?
2
I-COORD?
2
J-COORD?
2
VALUE?
8
I-COORD?
2
J-COORD?
3
4