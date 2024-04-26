# [Solución] Sistema de Gestión de Canales de YouTube

## GestionCanalesYoutube.java

~~~java
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestionCanalesYouTube {

    // Utilizamos un HashSet para almacenar los nombres de los canales de YouTube.
    private Set<String> canales;
    
    // Utilizamos un HashMap para asociar cada canal con una lista de videos populares.
    private Map<String, List<String>> videosPopulares;

    // Constructor para inicializar las colecciones.
    public GestionCanalesYouTube() {
        this.canales = new HashSet<>();
        this.videosPopulares = new HashMap<>();
    }

    // Método para agregar un canal a la colección.
    public void agregarCanal(String nombreCanal) {
        // Solo añade el canal si aún no existe.
        if (nombreCanal != null && !nombreCanal.isEmpty() && canales.add(nombreCanal)) {
            System.out.println("Canal agregado: " + nombreCanal);
        } else {
            System.out.println("El canal ya existe o es inválido.");
        }
    }

    // Método para eliminar un canal de la colección.
    public void eliminarCanal(String nombreCanal) {
        // Elimina el canal si existe.
        if (canales.remove(nombreCanal)) {
            // También elimina los videos asociados a ese canal.
            videosPopulares.remove(nombreCanal);
            System.out.println("Canal eliminado: " + nombreCanal);
        } else {
            System.out.println("El canal no existe o es inválido.");
        }
    }

    // Método para agregar un video a un canal específico.
    public void agregarVideoACanal(String nombreCanal, String tituloVideo) {
        // Verifica si el canal existe.
        if (canales.contains(nombreCanal) && tituloVideo != null && !tituloVideo.isEmpty()) {
            // Añade el video al canal. Si el canal no tiene videos, crea una nueva lista.
            videosPopulares.computeIfAbsent(nombreCanal, k -> new ArrayList<>()).add(tituloVideo);
            System.out.println("Video agregado al canal " + nombreCanal + ": " + tituloVideo);
        } else {
            System.out.println("El canal no existe o el video es inválido.");
        }
    }

    // Método para eliminar un video de un canal específico.
    public void eliminarVideoACanal(String nombreCanal, String tituloVideo) {
        // Verifica si el canal y el video existen.
        if (canales.contains(nombreCanal) && videosPopulares.containsKey(nombreCanal)) {
            List<String> videos = videosPopulares.get(nombreCanal);
            if (videos.remove(tituloVideo)) {
                System.out.println("Video eliminado del canal " + nombreCanal + ": " + tituloVideo);
            } else {
                System.out.println("El video no existe o es inválido.");
            }
        } else {
            System.out.println("El canal no existe.");
        }
    }

    // Método para obtener los videos populares de un canal específico.
    public List<String> obtenerVideosPopulares(String nombreCanal) {
        // Devuelve los videos del canal si existen.
        if (canales.contains(nombreCanal)) {
            return videosPopulares.getOrDefault(nombreCanal, new ArrayList<>());
        } else {
            System.out.println("El canal no existe.");
            return new ArrayList<>();
        }
    }

    // Método para obtener todos los canales.
    public Set<String> obtenerTodosLosCanales() {
        return new HashSet<>(canales); // Devuelve una copia del set de canales.
    }
}
~~~

## main.java

~~~java
public class Main {
    public static void main(String[] args) {
        GestionCanalesYouTube gestion = new GestionCanalesYouTube();

        // Agregando algunos canales
        gestion.agregarCanal("CanalEducacion");
        gestion.agregarCanal("CanalEntretenimiento");
        gestion.agregarCanal("CanalCocina");
        // Intentando agregar un canal duplicado
        gestion.agregarCanal("CanalEducacion");

        // Agregando videos a los canales
        gestion.agregarVideoACanal("CanalEducacion", "Aprende Java en 30 minutos");
        gestion.agregarVideoACanal("CanalEntretenimiento", "Top 10 Películas de 2024");
        gestion.agregarVideoACanal("CanalCocina", "Receta de paella para principiantes");

        // Intentando agregar un video a un canal que no existe
        gestion.agregarVideoACanal("CanalViajes", "Los mejores destinos de 2024");

        // Obteniendo y mostrando los videos populares de un canal
        System.out.println("Videos populares en CanalEducacion: " + gestion.obtenerVideosPopulares("CanalEducacion"));

        // Eliminando un video de un canal
        gestion.eliminarVideoACanal("CanalEducacion", "Aprende Java en 30 minutos");

        // Intentando eliminar un video que no existe
        gestion.eliminarVideoACanal("CanalEducacion", "Aprende Python en 30 minutos");

        // Mostrando todos los canales
        System.out.println("Todos los canales: " + gestion.obtenerTodosLosCanales());

        // Eliminando un canal
        gestion.eliminarCanal("CanalCocina");

        // Intentando eliminar un canal que no existe
        gestion.eliminarCanal("CanalViajes");

        // Mostrando todos los canales después de la eliminación
        System.out.println("Todos los canales después de eliminar: " + gestion.obtenerTodosLosCanales());
    }
}
~~~
