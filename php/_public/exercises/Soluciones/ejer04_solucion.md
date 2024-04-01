# [Solución] Ejercicio POO. Sistema de gestión de Podcast

Para desarrollar el sistema de gestión de podcasts usando Programación Orientada a Objetos (POO) en PHP, dividiremos el código en tres archivos principales, cada uno correspondiente a una clase: Podcast.php, Episodio.php, y GestorPodcasts.php. Esto no solo mantiene el código organizado, sino que también facilita la reutilización y mantenimiento.

## Podcast.php

Este archivo define la clase Podcast, que representa un podcast individual. Incluye propiedades para almacenar el título, la descripción, y un arreglo de episodios. También contiene métodos para añadir episodios y obtener información del podcast.

~~~php
<?php
class Podcast {
    private $titulo;
    private $descripcion;
    private $episodios = [];

    public function __construct($titulo, $descripcion) {
        $this->titulo = $titulo;
        $this->descripcion = $descripcion;
    }

    public function añadirEpisodio($episodio) {
        $this->episodios[] = $episodio;
    }

    public function obtenerInformacion() {
        echo "Podcast: {$this->titulo}\nDescripción: {$this->descripcion}\n";
        foreach ($this->episodios as $episodio) {
            echo $episodio->obtenerInformacion();
        }
    }
}
?>
~~~

## Episodio.php

Este archivo define la clase Episodio, que representa un episodio individual de un podcast. Contiene propiedades para el título, la duración, y la fecha de publicación del episodio, junto con un método para obtener la información del episodio.

~~~php
<?php
class Episodio {
    private $titulo;
    private $duracion; // Duración en minutos
    private $fechaPublicacion;

    public function __construct($titulo, $duracion, $fechaPublicacion) {
        $this->titulo = $titulo;
        $this->duracion = $duracion;
        $this->fechaPublicacion = $fechaPublicacion;
    }

    public function obtenerInformacion() {
        return "Episodio: {$this->titulo}, Duración: {$this->duracion} minutos, Publicado: {$this->fechaPublicacion}\n";
    }
}
?>
~~~

## GestorPodcast.php

~~~php
<?php
require_once 'Podcast.php';
require_once 'Episodio.php';

class GestorPodcasts {
    private $podcasts = [];

    public function añadirPodcast($podcast) {
        $this->podcasts[] = $podcast;
    }

    public function listarPodcasts() {
        foreach ($this->podcasts as $podcast) {
            $podcast->obtenerInformacion();
        }
    }
}
?>
~~~

## index.php

~~~php
<?php
require_once 'GestorPodcasts.php';

// Crear gestor de podcasts
$gestor = new GestorPodcasts();

// Crear y añadir podcasts
$podcast1 = new Podcast("Aprende PHP", "Un podcast para aprender PHP desde cero.");
$episodio1 = new Episodio("Introducción a PHP", 30, "2023-01-01");
$episodio2 = new Episodio("Variables en PHP", 25, "2023-01-08");
$podcast1->añadirEpisodio($episodio1);
$podcast1->añadirEpisodio($episodio2);

$gestor->añadirPodcast($podcast1);

// Listar podcasts y sus episodios
$gestor->listarPodcasts();
?>
~~~
