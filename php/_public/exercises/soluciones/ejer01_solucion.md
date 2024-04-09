# [Solución] Ejercicio con objetos, sesiones, conexión a base de datos, consultas y subconsultas

## index.html

~~~php
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta de Series de TV</title>
</head>
<body>
    <form action="consultar_series.php" method="post">
        <label for="genero">Género de la serie:</label>
        <input type="text" id="genero" name="genero">
        <button type="submit" name="action" value="consultar">Consultar</button>
        <button type="submit" name="action" value="aleatoria">Mostrar Serie Aleatoria</button>
    </form>
</body>
</html>
~~~

## conexion_db.php

~~~php
<?php
class ConexionDB {
    private $host = 'tu_host';
    private $db = 'series_tv';
    private $user = 'tu_usuario';
    private $password = 'tu_contraseña';
    public $conexion;

    public function __construct() {
        try {
            $this->conexion = new PDO("mysql:host=$this->host;dbname=$this->db", $this->user, $this->password);
        } catch (PDOException $e) {
            echo "Error en la conexión: " . $e->getMessage();
        }
    }

    public function getConexion() {
        return $this->conexion;
    }
}
?>
~~~

## consultar_serie.php

~~~php
<?php
session_start();
require 'conexionDB.php';

$db = new ConexionDB();
$conn = $db->getConexion();

$accion = $_POST['action'];
$genero = htmlspecialchars($_POST['genero']);

if ($accion == 'consultar') {
    $consulta = $conn->prepare("SELECT * FROM Series WHERE genero = :genero");
    $consulta->execute(['genero' => $genero]);
    $_SESSION['resultados'] = $consulta->fetchAll();
    header('Location: resultados.php');
} elseif ($accion == 'aleatoria') {
    $consulta = $conn->query("SELECT * FROM Series ORDER BY RAND() LIMIT 1");
    $_SESSION['serie_aleatoria'] = $consulta->fetch();
    header('Location: serie_aleatoria.php');
}
?>
~~~

## resultados.php

~~~php
<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultados de Series</title>
</head>
<body>
    <?php
    if (!empty($_SESSION['resultados'])) {
        echo "<ul>";
        foreach ($_SESSION['resultados'] as $serie) {
            echo "<li>{$serie['nombre']} - {$serie['genero']} ({$serie['anio_lanzamiento']})</li>";
        }
        echo "</ul>";
    } else {
        echo "<p>No se encontraron series.</p>";
    }
    ?>
</body>
</html>
~~~

## serie_aleatoria.php

~~~php
<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Serie Aleatoria</title>
</head>
<body>
    <?php
    if (!empty($_SESSION['serie_aleatoria'])) {
        $serie = $_SESSION['serie_aleatoria'];
        echo "<p>Nombre: {$serie['nombre']}</p>";
        echo "<p>Género: {$serie['genero']}</p>";
        echo "<p>Año de Lanzamiento: {$serie['anio_lanzamiento']}</p>";
    } else {
        echo "<p>No se encontró una serie.</p>";
    }
    ?>
</body>
</html>
~~~