## Pregunta

~~~java
public class Pregunta {
    public String p;
    private final String opcion1;
    private final String opcion2;
    private final String opcion3;
    private final String opcion4;
    private final String opcion5; // Puede ser null si solo hay 4 opciones.

     // Constructor con la pregunta y las posibles respuestas.
    public Pregunta(String p, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5) {
        this.p = p;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
    // Método para realizar una pregunta y devolver la respuesta.
    public int hacerPregunta(Scanner sc) {
        int respuesta = 0;

        // Muestra la pregunta y las opciones.
        System.out.println(p);
        
        // Imprime opciones con if-else
        if (opcion1 != null){
            System.out.println("1. " + opcion1);
        }
        if (opcion2 != null) System.out.println("2. " + opcion2);
        if (opcion3 != null) System.out.println("3. " + opcion3);
        if (opcion4 != null) System.out.println("4. " + opcion4);
        if (opcion5 != null) System.out.println("5. " + opcion5);
        
        System.out.print("Seleccione una opcion: ");
        
        respuesta = sc.nextInt();
        
        // Verifica que la respuesta sea válida con switch.
            switch (respuesta) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return respuesta;
                case 5:
                    if (opcion5 != null) {
                        return respuesta;
                    }
                    // Si la opción 5 no es válida, cae a la cláusula default.
                default:
                    System.out.println("Por favor seleccione una opcion valida.");
                    return hacerPregunta(sc); // Llama recursivamente para nueva entrada
            }    
    }
    
    
    
    
}
~~~

## Personaje

~~~java
public class Personaje {
    
    private final String nombre;
    private int r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    
    public Personaje (String nombre){
        this.nombre = nombre;
    }

    //otra forma de hacerlo sustituyendo el setRespuestas (aun que no es una opción adecuada)
    /*public Personaje(String nombre, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        this.nombre = nombre;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.r6 = r6;
        this.r7 = r7;
        this.r8 = r8;
        this.r9 = r9;
        this.r10 = r10;
    }*/
    
    
    public void setRespuestas(int r1,int r2,int r3,int r4,int r5,int r6,int r7,int r8,int r9,int r10){
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.r6 = r6;
        this.r7 = r7;
        this.r8 = r8;
        this.r9 = r9;
        this.r10 = r10;
    }

    public String getNombre() {
        return nombre;
    }

    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getR3() {
        return r3;
    }

    public int getR4() {
        return r4;
    }

    public int getR5() {
        return r5;
    }

    public int getR6() {
        return r6;
    }

    public int getR7() {
        return r7;
    }

    public int getR8() {
        return r8;
    }

    public int getR9() {
        return r9;
    }

    public int getR10() {
        return r10;
    }
    
    public void getRespuestas(){
        System.out.println("La respuestas del personaje " + nombre + "son: " + r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + r9 + r10);
    }
    
    public double cuantaAfinidad(Personaje otroPersonaje){
        int afinidad = 0;
        
        // Comparamos las respuestas de 'this' con las del 'otroPersonaje'
        if(this.r1 == otroPersonaje.getR1()){
            afinidad++;
        }
        if(this.r2 == otroPersonaje.getR2()) afinidad++;
        if(this.r3 == otroPersonaje.getR3()) afinidad++;
        if(this.r4 == otroPersonaje.getR4()) afinidad++;
        if(this.r5 == otroPersonaje.getR5()) afinidad++;
        if(this.r6 == otroPersonaje.getR6()) afinidad++;
        if(this.r7 == otroPersonaje.getR7()) afinidad++;
        if(this.r8 == otroPersonaje.getR8()) afinidad++;
        if(this.r9 == otroPersonaje.getR9()) afinidad++;
        if(this.r10 == otroPersonaje.getR10()) afinidad++;

        // Ahora convertimos la afinidad en un porcentaje
        double afinidadPorcentaje = (afinidad / 10.0) * 100;

        // Utilizamos un switch para clasificar la afinidad en rangos, por ejemplo
        switch (afinidad) {
            case 10: 
                System.out.println("Los personajes son identicos!");
                break;
            case 9: case 8:
                System.out.println("Los personajes tienen mucha afinidad!");
                break;
            case 7: case 6:
                System.out.println("Los personajes son bastante compatibles.");
                break;
            case 5: case 4:
                System.out.println("Hay algo de afinidad, pero también diferencias notables.");
                break;
            case 3: case 2:
                System.out.println("Los personajes no son muy afines.");
                break;
            case 1: case 0:
                System.out.println("Los personajes son totalmente opuestos o casi.");
                break;
            default:
                System.out.println("Ha ocurrido un error al calcular la afinidad.");
                break;
        }

        return afinidadPorcentaje;
        
    }
}
~~~

## Main

~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println(" ..........................................................");
        System.out.println("Bienvenido al cuestionario para saber que tipo de estudiante eres!!");
        System.out.println(" ..........................................................");

        // Supongamos que hay dos personajes con sus respuestas predefinidas.
        Personaje personaje1 = new Personaje("Personaje 1");
        personaje1.setRespuestas(1, 2, 3, 4, 1, 2, 3, 4, 1, 2);
        Personaje personaje2 = new Personaje("Personaje 2");
        personaje2.setRespuestas(2, 3, 4, 1, 2, 3, 4, 1, 2, 3);
        
        //Crear personaje para almacenar las respuestas del usuario
        Personaje usuario = new Personaje ("Diana");
        
        // Crear un objeto Scanner para leer de la consola.
        Scanner sc = new Scanner(System.in);

        // Variables para almacenar las respuestas del usuario.
        int r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;

        // Hacer la primera pregunta y almacenar la respuesta.
        Pregunta pregunta1 = new Pregunta("¿Tu primera pregunta aqui?", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5");
        r1 = pregunta1.hacerPregunta(sc);

        // Hacer la segunda pregunta y almacenar la respuesta.
        Pregunta pregunta2 = new Pregunta("¿Tu segunda pregunta aqui?", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", null);
        r2 = pregunta2.hacerPregunta(sc);

        // ... Repetir para las preguntas restantes ...

        // Por ejemplo, aquí te dejo hasta r3 para que veas el patrón.
        Pregunta pregunta3 = new Pregunta("¿Tu tercera pregunta aqui?", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", null);
        r3 = pregunta3.hacerPregunta(sc);

        // Suponiendo que no hay más preguntas, r4-r10 serán 0 (esto es solo un placeholder).
        r4 = r5 = r6 = r7 = r8 = r9 = r10 = 0;
        //Guardar respuestas en el personsaje Usuario
        usuario.setRespuestas(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        
        // Ahora calcularías la afinidad con los personajes usando los métodos de la clase Personaje.
        double afinidadConPersonaje1 = personaje1.cuantaAfinidad(usuario);
        double afinidadConPersonaje2 = personaje2.cuantaAfinidad(usuario);
        /*double afinidadConPersonaje3 = personaje3.cuantaAfinidad(usuario);
        double afinidadConPersonaje4 = personaje4.cuantaAfinidad(usuario);
        double afinidadConPersonaje5 = personaje5.cuantaAfinidad(usuario);*/

        // Mostrar las afinidades.
        System.out.println("Tu afinidad con " + personaje1.getNombre() + " es: " + afinidadConPersonaje1);
        System.out.println("Tu afinidad con " + personaje2.getNombre() + " es: " + afinidadConPersonaje2);

        // Determinar y mostrar con cuál personaje se tiene más afinidad.
        if (afinidadConPersonaje1 > afinidadConPersonaje2) {
            System.out.println("Tienes mas afinidad con " + personaje1.getNombre());
        } else if (afinidadConPersonaje2 > afinidadConPersonaje1) {
            System.out.println("Tienes mas afinidad con " + personaje2.getNombre());
        } else {
            System.out.println("Tienes la misma afinidad con ambos personajes.");
        }

        // Cerrar el scanner al final.
        sc.close();
    
    }
}
~~~
