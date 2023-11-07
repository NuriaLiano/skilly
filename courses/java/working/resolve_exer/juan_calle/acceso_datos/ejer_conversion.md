# Conversión de archivo TXT a Properties

## Resumen

### Flujos de entrada (`InputStream`)

- **InputStream**: Clase abstracta principal para representar flujos de entrada de bytes.
  - **FileInputStream**: Lee bytes desde un archivo.
  - **PipedInputStream**: Lee datos escritos en un `PipedOutputStream` correspondiente.
  - **FilterInputStream**: Superclase de flujos de entrada filtrados.
    - **DataInputStream**: Lee tipos de datos primitivos.
    - **BufferedInputStream**: Almacena datos en un búfer.
    - **LineNumberInputStream**: (Deprecado) Contaba líneas.
    - **PushbackInputStream**: Permite devolver un byte a la secuencia.
  - **ByteArrayInputStream**: Lee bytes de un array de bytes en memoria.
  - **SequenceInputStream**: Combina múltiples flujos de entrada.
  - **StringBufferInputStream**: (Deprecado) Lee bytes de un StringBuffer.
  - **ObjectInputStream**: Lee objetos serializados.

### Flujos de salida (`OutputStream`)

- **OutputStream**: Clase abstracta principal para flujos de salida.
  - **FileOutputStream**: Escribe bytes a un archivo.
  - **PipedOutputStream**: Escribe datos a ser leídos por un `PipedInputStream` correspondiente.
  - **FilterOutputStream**: Superclase de flujos de salida filtrados.
    - **DataOutputStream**: Escribe tipos de datos primitivos.
    - **BufferedOutputStream**: Almacena datos en un búfer.
    - **PushbackOutputStream**: (No estándar) Similar a `PushbackInputStream` para salidas.
  - **ByteArrayOutputStream**: Escribe bytes a un array de bytes en memoria.
  - **ObjectOutputStream**: Escribe objetos serializados.

## Leer .txt

~~~java
public static List<String> leerArchivoTxt(String ruta) throws IOException {
    return Files.readAllLines(Paths.get(ruta));
}
~~~

## Validar el formato

~~~java
public static boolean esFormatoValido(List<String> lineas) {
    for (String linea : lineas) {
        if (!linea.contains(":")) return false;
    }
    return true;
}
~~~

## Leer el archivo .txt usando FileInputStream y BufferedReader

~~~java
public static List<String> leerArchivoTxtConInputStream(String ruta) throws IOException {
    List<String> lineas = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream(ruta);
         InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
         BufferedReader br = new BufferedReader(isr)) {
         
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    }
    return lineas;
}
~~~

## Guardar en archivo .properties

~~~java
public static void guardarEnProperties(List<String> lineas, String rutaDestino) throws IOException {
    Properties propiedades = new Properties();

    for (String linea : lineas) {
        if(linea.contains(":")) {
            String[] partes = linea.split(":");
            propiedades.setProperty(partes[0].trim(), partes[1].trim());
        }
    }

    try (FileOutputStream out = new FileOutputStream(rutaDestino)) {
        propiedades.store(out, null);
    }
}
~~~

## Main

~~~java
public static void main(String[] args) {
    String rutaOrigen = "origen.txt"; // Asumimos que ya tienes la ruta.
    
    try {
        List<String> lineas = leerArchivoTxtConInputStream(rutaOrigen);
        
        // Si quieres verificar el formato aquí, puedes hacerlo.
        // Si no es válido y quieres convertir, puedes usar la función convertirAFormatoValido mencionada anteriormente.

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo properties de destino:");
        String rutaDestino = sc.nextLine();
        
        guardarEnProperties(lineas, rutaDestino + ".properties");
        System.out.println("El archivo se ha convertido con éxito.");
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}
~~~

## Solución alumno

~~~java
public class txt_a_properties {
    public static void main(String[] args) {
        // Crear un objeto File con la ruta del archivo txt que queremos leer.
        File f = new File("G:\\23_24_2DAMD\\AD\\UD1\\Ejercicios_t1\\Ejercicio_PROYECTOUD1\\txt\\txt_a_properties.txt");
        // Obtener la extensión del archivo.
        String path = f.getAbsolutePath();
        String fileExtension = getExtension(path);
        // Comprobar si la extensión del archivo es válida (debería ser ".txt").
        if (!validarExtension(fileExtension)) {
            System.out.println("Extensión no válida!");
        }
        
        // Leer el contenido del archivo txt.
        ArrayList<String> lecTxt = lecturaTxt(path); // contiene un arraylist  de las lineas del fichero .txt
        // Escribir el contenido leído en un archivo .properties.
        escribirProperties(lecTxt, "G:\\23_24_2DAMD\\AD\\UD1\\Ejercicios_t1\\Ejercicio_PROYECTOUD1\\txt\\txt_a_properties.properties");
    }
    // Coge la ruta del "." hasta el final para verificar que la extensión sea ".txt". De otra forma no sirve
    // Función que devuelve la extensión de un archivo.
    public static String getExtension(String path) {
        int indice = path.lastIndexOf(".");//posicion del último "." // Buscar la última aparición del "." en la ruta.
        if (indice > 0) {
            return path.substring(indice); // Si se encuentra el ".", extraer y devolver la extensión.
        }else{
            return ""; // Si no se encuentra el ".", devolver una cadena vacía.
        }
    }
    // Función que comprueba si la extensión proporcionada es ".txt".
    public static boolean validarExtension(String extension) {
        if (extension.equals(".txt")) {
            return true;
        }else{
            return false;
        }
    }
    // Función que lee el contenido de un archivo txt y devuelve una lista con las líneas leídas.
    public static ArrayList<String> lecturaTxt(String path) {
        ArrayList<String> filas = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                filas.add(linea); // Añadir cada línea leída a la lista.
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(txt_a_properties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(txt_a_properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas; // Devolver la lista con las líneas leídas.
    }
     // Función que escribe el contenido de una lista en un archivo .properties.
    private static void escribirProperties(ArrayList<String> lineasFichTxt, String ruta) {
        Properties conf = new Properties();
        for (String linea: lineasFichTxt) {
            if (linea.contains(":")) {
                String[] claveValor = linea.split(":");
                conf.setProperty(claveValor[0], claveValor[1]); // Establecer cada par clave-valor en el objeto Properties.
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            conf.store(fos, null); // Almacenar el objeto Properties en el archivo sin comentarios.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(txt_a_properties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(txt_a_properties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
~~~
