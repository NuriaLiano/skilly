# [Solución] Sistema de Gestión de Cine

Espero que no estés por aquí para echar un vistazo a la solución antes de resolverlo ... :wink:
En caso de que le hayas terminado ¡Enhorabuena! ya queda menos, aquí te dejo la solución para que puedas comprobar otra forma de resolver el mismo problema.

> :brain: **RECUERDA**
> Hay más de una solución posible para el mismo ejercicio, si funciona y cumples las buenas prácticas de programación ¡Te lo compro, aprobado!

Este ejercicio se ha desarrollado en una sola clase main donde se han ido declarando los métodos necesarios. 

## Recursos ASCII

~~~java

    ```java
String header = """
 ______        _   _            _    ____        _          _____ _     _           
|  ____|      | | (_)          | |  / __ \\      | |        / ____| |   (_)          
| |__ ___  ___| |_ ___   ____ _| | | |  | |_ __ | |_   _  | (___ | |__  _ _ __  ___ 
|  __/ _ \\/ __| __| \\ \\ / / _` | | | |  | | '_ \\| | | | |  \\___ \\| '_ \\| | '_ \\/ __|
| | |  __/\\__ \\ |_| |\\ V / (_| | | | |__| | | | | | |_| |  ____) | | | | | |_) \\__ \\
|_|  \\___||___/\\__|_| \\_/ \\__,_|_|  \\____/|_| |_|_|\\__, | |_____/|_| |_|_| .__/|___/
                                                    __/ |                | |        
                                                   |___/                 |_|        
""";

String title = """
   #                                                                                                                                                       
  # #   #      # ###### #    #        ###### #          ####   ####  #####   ##   #    #  ####     #####    ##    ####    ##        # ###### #####   ####  
 #   #  #      # #      ##   #        #      #         #    # #    #   #    #  #  #    # #    #    #    #  #  #  #       #  #       # #      #    # #    # 
#     # #      # #####  # #  #        #####  #         #    # #        #   #    # #    # #    #    #    # #    #  ####  #    #      # #####  #    # #    # 
####### #      # #      #  # # ###    #      #         #    # #        #   ###### #    # #    #    #####  ######      # ######      # #      #####  #    # 
#     # #      # #      #   ## ###    #      #         #    # #    #   #   #    #  #  #  #    #    #      #    # #    # #    # #    # #      #   #  #    # 
#     # ###### # ###### #    #  #     ###### ######     ####   ####    #   #    #   ##    ####     #      #    #  ####  #    #  ####  ###### #    #  ####  
                               #
""";

String monster = """
    ,'\"   _      _   \"`.
    /.__, ._  -=- _\"`    Y
   (.____.-.`      \"\"`   j
    VvvvvvV`.Y,.    _.,-'       ,     ,     ,
       Y    ||,   '\"\\         ,/    ,/    ./
       |   ,'  ,     `-..,'_,'/___,'/   ,'/   ,
  ..  ,;,,',-'\"\\,'  ,  .     '     ' \"\"' '--,/    .. ..
,'. `.`---'     `, /  , Y -=-    ,'   ,   ,. .`-..||_|| ..
ff\\\\`. `._        /f ,'j j , ,' ,   , f ,  \\=\\ Y   || ||`||_..
l` \\` `.`.\"`-..,-' j  /./ /, , / , / /l \\   \\=\\l   || `' || ||...
`  `   `-._ `-.,-/ ,' /\"/-/-/-/-\"'''\"`.`.  `'.\\--`'--..`'_`' || ,
          \"`-_,',  ,'  f    ,   /      `._    ``._     ,  `-.`'//         ,
        ,-\"'' _.,-'    l_,-'_,,'          \"`-._ . \"`. /|     `.'\\ ,       |
      ,',.,-'\"          \\=) ,`-.         ,    `-'._`.V |       \\ // .. . /j
      |f\\\\               `._ )-.\"`.     /|         `.| |        `.`-||-\\\\/
      l` \\`                 \"`._   \"`--' j          j' j          `-`---'
       `  `                     \"`,-  ,'/       ,-'\"  /
                               ,'\",__,-'       /,, ,-'
                               Vvv'            VVv'
""";
~~~

## Cine.java (main)

~~~java
import java.util.Scanner;

public class cine {
    static char[][] sala = new char[12][20];
    static int recaudacion = 0;
    public static void main(String[] args) {
        // Definir el tamaño del rectángulo
        int ancho = 70;
        int alto = 8;
        int opcion;
        
        //llamar al metodo para rellenar el array de 0
        rellenarArray();

       String caratula = """
     ______        _   _            _    ____        _          _____ _     _           
    |  ____|      | | (_)          | |  / __ \\      | |        / ____| |   (_)          
    | |__ ___  ___| |_ ___   ____ _| | | |  | |_ __ | |_   _  | (___ | |__  _ _ __  ___ 
    |  __/ _ \\/ __| __| \\ \\ / / _` | | | |  | | '_ \\| | | | |  \\___ \\| '_ \\| | '_ \\/ __|
    | | |  __/\\__ \\ |_| |\\ V / (_| | | | |__| | | | | | |_| |  ____) | | | | | |_) \\__ \\
    |_|  \\___||___/\\__|_| \\_/ \\__,_|_|  \\____/|_| |_|_|\\__, | |_____/|_| |_|_| .__/|___/
                                                        __/ |                | |        
                                                       |___/                 |_|        
""";
        
do {
            System.out.println(caratula);
            // Dibujar el rectángulo con el texto

            menu(ancho, alto, "1-Mostrar pelicula en cartelera", "2-Mostrar estado de la sala", "3-Comprar entrada", "4-Devolver entrada", "5-Mostrar la recaudación hasta el momento", "0-Salir");

          
            System.out.println("\n");
            System.out.println("Introduce una opción :");
            Scanner sc=new Scanner(System.in);
            opcion=sc.nextInt(); 
            switch (opcion) { //determino el switch en funcion de la opcion elegida
                case 1: 
                
                mostrarPelicula();
                
                break;
                case 2 :

                mostrarButacas();
                 break;
                case 3 :
                comprarEntrada();
                 break;
                case 4 :
                devolverEntrada();
                 break;
                case 5 :
                mostrarRecaudacion();
                 break;
                case 0 : System.out.println(" Salir\n");
                 break;
                default: System.out.println("No coincide con ninguna de las opciones");
                 break;

            }
            //determino el switch en funcion de la opcion elegida
                    } while (opcion != 0);

    }

    // Método para dibujar el rectángulo con texto en los lados
    public static void menu(int ancho, int alto, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5, String opcion6) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                // Imprimir asteriscos en los bordes superior e inferior del rectángulo
                if (i == 0 || i == alto - 1) {
                    System.out.print("*");
                } else {
                    // Imprimir espacios en blanco y texto en las posiciones correctas
                    if (j == 0 || j == ancho - 1) {
                        System.out.print("*");
                    } else if (i == 1 && j == 15) { // Posición de la primera opción
                        System.out.print(opcion1);
                        j += opcion1.length() - 1; // Saltar la longitud de la opción1
                    } else if (i == 2 && j == 15) { // Posición de la segunda opción
                        System.out.print(opcion2);
                        j += opcion2.length() - 1; // Saltar la longitud de la opción2
                    } else if (i == 3 && j == 15) { // Posición de la segunda opción
                        System.out.print(opcion3);
                        j += opcion3.length() - 1;
                    } else if (i == 4 && j == 15) { // Posición de la segunda opción
                        System.out.print(opcion4);
                        j += opcion4.length() - 1;
                    } else if (i == 5 && j == 15) { // Posición de la segunda opción
                        System.out.print(opcion5);
                        j += opcion5.length() - 1;
                    } else if (i == 6 && j == 15) { // Posición de la segunda opción
                        System.out.print(opcion6);
                        j += opcion6.length() - 1;
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            // Nueva línea después de cada fila
            System.out.println();
        }
    }
    
    public static void mostrarPelicula() {
    
    String titulo= ("   #                                                                                                                                                       \n" +
"  # #   #      # ###### #    #        ###### #          ####   ####  #####   ##   #    #  ####     #####    ##    ####    ##        # ###### #####   ####  \n" +
" #   #  #      # #      ##   #        #      #         #    # #    #   #    #  #  #    # #    #    #    #  #  #  #       #  #       # #      #    # #    # \n" +
"#     # #      # #####  # #  #        #####  #         #    # #        #   #    # #    # #    #    #    # #    #  ####  #    #      # #####  #    # #    # \n" +
"####### #      # #      #  # # ###    #      #         #    # #        #   ###### #    # #    #    #####  ######      # ######      # #      #####  #    # \n" +
"#     # #      # #      #   ## ###    #      #         #    # #    #   #   #    #  #  #  #    #    #      #    # #    # #    # #    # #      #   #  #    # \n" +
"#     # ###### # ###### #    #  #     ###### ######     ####   ####    #   #    #   ##    ####     #      #    #  ####  #    #  ####  ###### #    #  ####  \n" +
"                               #");
    String monstruo=("     ,'\"   _      _   \"`.\n" +
"     /.__, ._  -=- _\"`    Y\n" +
"    (.____.-.`      \"\"`   j\n" +
"     VvvvvvV`.Y,.    _.,-'       ,     ,     ,\n" +
"        Y    ||,   '\"\\         ,/    ,/    ./\n" +
"        |   ,'  ,     `-..,'_,'/___,'/   ,'/   ,\n" +
"   ..  ,;,,',-'\"\\,'  ,  .     '     ' \"\"' '--,/    .. ..\n" +
" ,'. `.`---'     `, /  , Y -=-    ,'   ,   ,. .`-..||_|| ..\n" +
"ff\\\\`. `._        /f ,'j j , ,' ,   , f ,  \\=\\ Y   || ||`||_..\n" +
"l` \\` `.`.\"`-..,-' j  /./ /, , / , / /l \\   \\=\\l   || `' || ||...\n" +
" `  `   `-._ `-.,-/ ,' /`\"/-/-/-/-\"'''\"`.`.  `'.\\--`'--..`'_`' || ,\n" +
"            \"`-_,',  ,'  f    ,   /      `._    ``._     ,  `-.`'//         ,\n" +
"          ,-\"'' _.,-'    l_,-'_,,'          \"`-._ . \"`. /|     `.'\\ ,       |\n" +
"        ,',.,-'\"          \\=) ,`-.         ,    `-'._`.V |       \\ // .. . /j\n" +
"        |f\\\\               `._ )-.\"`.     /|         `.| |        `.`-||-\\\\/\n" +
"        l` \\`                 \"`._   \"`--' j          j' j          `-`---'\n" +
"         `  `                     \"`,-  ,'/       ,-'\"  /\n" +
"                                 ,'\",__,-'       /,, ,-'\n" +
"                                 Vvv'            VVv'");
    
            System.out.println(titulo);
            System.out.println(monstruo);
    
}

public static void rellenarArray(){
    for (int i = 0; i < sala.length; i++) {
        for (int j = 0; j < sala[i].length; j++) {
            sala[i][j] = '0';
        }
    }
}

public static void mostrarButacas(){
    for (int i = 0; i < sala.length; i++) {
        for (int j = 0; j < sala[i].length; j++) {
            System.out.print(sala[i][j] + " ");
        }
        System.out.println(); //salto de linea despues de imprimir 20 ceros
    }
}

public static void comprarEntrada(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce  el numero de fila");
    int fila = sc.nextInt()-1;
    System.out.println("Introduce el numero de butaca");
    int butaca = sc.nextInt()-1;
    sc.nextLine(); //limpiar buffer
    System.out.println("La entrada son 3 euros, ¿está de acuerdo? (s/n)");
    String decision = sc.nextLine();

    if(decision.equals("s")){
        if(sala[fila][butaca] == '0'){
            System.out.println("IMPRIMIENDO ENTRADA");
            System.out.println("--------------------------");
            System.out.println("***************************************************************");
            System.out.println("* Festival Only Ships                   Sala: Nostrono        *");
            System.out.println("* Fila: " + fila + " Butaca: " + butaca + "                   Precio: 3 euros        *");
            System.out.println("***************************************************************");
            System.out.println("--------------------------");

            sala[fila][butaca] = 'X';
            recaudacion = recaudacion + 3;
            mostrarButacas();
        }else{
            System.out.println("Transacción no pudo realizarse por que la entrada ya esta vendida");
        }
    }else if(decision.equals("n")){
        System.out.println("Entrada no aceptada");
        return;
    }

}

public static void devolverEntrada(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce  el numero de fila");
    int fila = sc.nextInt()-1;
    System.out.println("Introduce el numero de butaca");
    int butaca = sc.nextInt()-1;
    sc.nextLine(); //limpiar buffer
    System.out.println("Se devolverá 3 euros, ¿está de acuerdo? (s/n)");
    String decision = sc.nextLine();

    if(decision.equals("s")){
        if(sala[fila][butaca] == 'X'){
            sala[fila][butaca] = '0';
            recaudacion = recaudacion - 3;
            System.out.println("Entrada devuelta");
        }else{
            System.out.println("Transacción no pudo realizarse por que la entrada no había sido vendida");
        }
    }
    
}
public static void mostrarRecaudacion(){
    System.out.println("La recaudación es de: " + recaudacion + " euros");
}
}
~~~
