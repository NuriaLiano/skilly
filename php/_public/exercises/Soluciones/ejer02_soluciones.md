# [Solución] Ejercicio de bases de datos en PHP

## Conexión a la Base de Datos

~~~php
<?php
$host = 'localhost';
$db   = 'tu_base_de_datos';
$user = 'tu_usuario';
$pass = 'tu_contraseña';
$charset = 'utf8mb4';

$dsn = "mysql:host=$host;dbname=$db;charset=$charset";
$options = [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES   => false,
];

try {
     $pdo = new PDO($dsn, $user, $pass, $options);
     echo "Conexión exitosa";
} catch (\PDOException $e) {
     throw new \PDOException($e->getMessage(), (int)$e->getCode());
}
?>
~~~

## Consulta Básica de Selección

~~~php
<?php
// Utiliza el código de conexión aquí

$stmt = $pdo->query("SELECT id, nombre, email FROM usuarios");
echo "<table>";
while ($row = $stmt->fetch()) {
    echo "<tr><td>{$row['id']}</td><td>{$row['nombre']}</td><td>{$row['email']}</td></tr>";
}
echo "</table>";
?>
~~~

## Inserción de Datos

~~~php
<?php
// Utiliza el código de conexión aquí

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $_POST['nombre'];
    $email = $_POST['email'];

    $sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
    $stmt= $pdo->prepare($sql);
    $stmt->execute([$nombre, $email]);

    echo "Registro insertado con éxito";
}
?>

<form method="post">
    Nombre: <input type="text" name="nombre"><br>
    Email: <input type="email" name="email"><br>
    <input type="submit">
</form>
~~~

## Actualización de Datos

~~~php
<?php
// Utiliza el código de conexión aquí

$id = 1; // ID del registro a actualizar
$nombreNuevo = 'Nuevo Nombre';

$sql = "UPDATE usuarios SET nombre=? WHERE id=?";
$stmt= $pdo->prepare($sql);
$stmt->execute([$nombreNuevo, $id]);

echo "Registro actualizado con éxito";
?>
~~~

## Borrado de Datos

~~~php
<?php
// Utiliza el código de conexión aquí

$id = 1; // ID del registro a borrar

$sql = "DELETE FROM usuarios WHERE id=?";
$stmt= $pdo->prepare($sql);
$stmt->execute([$id]);

echo "Registro eliminado con éxito";
?>
~~~

## Consulta con Parámetros

~~~php
<?php
// Utiliza el código de conexión aquí

$nombreBuscado = 'Nombre Ejemplo';
$sql = "SELECT * FROM usuarios WHERE nombre = ?";
$stmt = $pdo->prepare($sql);
$stmt->execute([$nombreBuscado]);
$usuarios = $stmt->fetchAll();

foreach ($usuarios as $usuario) {
    echo $usuario['nombre'] . ' - ' . $usuario['email'] . "<br>";
}
?>
~~~
