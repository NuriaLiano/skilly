# [Solución] Ejercicio de Programación PHP: Sistema de Consulta del Clima con Favoritos

## db.php

~~~php
<?php
// db.php: Configuración de conexión a la base de datos y funciones de acceso a datos.

function conectaDb() {
    try {
        $pdo = new PDO('mysql:host=localhost;dbname=nombre_de_tu_base_de_datos;charset=utf8', 'usuario', 'contraseña');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        exit("Error: " . $e->getMessage());
    }
}

function obtenerCiudadesFavoritas($usuarioId) {
    $db = conectaDb();
    $consulta = "SELECT nombre_ciudad FROM ciudades_favoritas WHERE usuario_id = :usuario_id";
    $stmt = $db->prepare($consulta);
    $stmt->execute(['usuario_id' => $usuarioId]);
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

function agregarCiudadFavorita($nombreCiudad, $usuarioId) {
    $db = conectaDb();
    $consulta = "INSERT INTO ciudades_favoritas (nombre_ciudad, usuario_id) VALUES (:nombre_ciudad, :usuario_id)";
    $stmt = $db->prepare($consulta);
    $stmt->execute(['nombre_ciudad' => $nombreCiudad, 'usuario_id' => $usuarioId]);
    return $stmt->rowCount();
}

function removerCiudadFavorita($nombreCiudad, $usuarioId) {
    $db = conectaDb();
    $consulta = "DELETE FROM ciudades_favoritas WHERE nombre_ciudad = :nombre_ciudad AND usuario_id = :usuario_id";
    $stmt = $db->prepare($consulta);
    $stmt->execute(['nombre_ciudad' => $nombreCiudad, 'usuario_id' => $usuarioId]);
    return $stmt->rowCount();
}
~~~

## funciones.php

~~~php
<?php
// funciones.php: Funciones para manejar peticiones a la API, sesiones y cookies.

function consultarClimaAPI($ciudad) {
    $apiKey = "tu_api_key_aquí";
    $url = "http://api.openweathermap.org/data/2.5/weather?q={$ciudad}&appid={$apiKey}&units=metric&lang=es";
    $resultado = file_get_contents($url);
    return json_decode($resultado, true);
}

function iniciarSesionYCookie($ciudad) {
    if (!isset($_SESSION)) {
        session_start();
    }
    $_SESSION['ultima_busqueda'] = $ciudad;
    setcookie('ultima_ciudad', $ciudad, time() + 86400 * 30, "/");
}
~~~

## index.php

~~~php
<?php
// index.php: Punto de entrada, muestra el formulario y procesa las búsquedas.

require_once "funciones.php";
require_once "db.php";

// Manejar la sesión y la cookie de la última ciudad buscada.
session_start();
$ultimaCiudad = $_SESSION['ultima_busqueda'] ?? $_COOKIE['ultima_ciudad'] ?? '';

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['ciudad'])) {
    $ciudad = $_POST['ciudad'];
    iniciarSesionYCookie($ciudad);
    header("Location: clima.php?ciudad=" . urlencode($ciudad));
    exit();
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta del Clima</title>
</head>
<body>
    <h1>Consulta del Clima</h1>
    <form method="post">
        Ciudad: <input type="text" name="ciudad" value="<?php echo htmlspecialchars($ultimaCiudad); ?>" required>
        <button type="submit">Buscar Clima</button>
    </form>
</body>
</html>
~~~

## clima.php

~~~php
require_once "funciones.php";
require_once "db.php";

session_start();
$usuarioId = $_SESSION['usuario_id'] ?? 1; // Asumimos un usuario por defecto o implementa tu lógica de autenticación

if (isset($_GET['ciudad'])) {
    $ciudad = $_GET['ciudad'];
    $resultadoClima = consultarClimaAPI($ciudad);

    // Procesa y muestra la información del clima de forma más amigable
    $temperatura = $resultadoClima['main']['temp'] ?? 'No disponible';
    $descripcion = $resultadoClima['weather'][0]['description'] ?? 'No disponible';
    echo "<h2>Clima en $ciudad</h2>";
    echo "<p>Temperatura: $temperatura °C</p>";
    echo "<p>Descripción: $descripcion</p>";

    // Botones para añadir o remover de favoritos
    echo "<form method='post' action='favoritos.php'>";
    echo "<input type='hidden' name='ciudad' value='$ciudad'>";
    echo "<input type='hidden' name='usuario_id' value='$usuarioId'>";
    echo "<button type='submit' name='accion' value='añadir'>Añadir a Favoritos</button>";
    echo "<button type='submit' name='accion' value='remover'>Remover de Favoritos</button>";
    echo "</form>";
} else {
    header("Location: index.php");
    exit();
}
~~~

## favoritos.php

~~~php
<?php
// favoritos.php: Maneja añadir y remover ciudades de los favoritos.

require_once "db.php";
session_start();

$usuarioId = $_POST['usuario_id'] ?? null;
$ciudad = $_POST['ciudad'] ?? null;
$accion = $_POST['accion'] ?? null;

if ($ciudad && $usuarioId) {
    switch ($accion) {
        case 'añadir':
            if (agregarCiudadFavorita($ciudad, $usuarioId)) {
                $_SESSION['mensaje'] = "Ciudad añadida a favoritos.";
            } else {
                $_SESSION['error'] = "Error al añadir ciudad a favoritos.";
            }
            break;
        case 'remover':
            if (removerCiudadFavorita($ciudad, $usuarioId)) {
                $_SESSION['mensaje'] = "Ciudad removida de favoritos.";
            } else {
                $_SESSION['error'] = "Error al remover ciudad de favoritos.";
            }
            break;
    }
}

header("Location: index.php");
exit();
~~~

