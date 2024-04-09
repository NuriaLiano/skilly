# [Solución] Ejercicio de registro de usuarios con sesiones y cookies

## Registro e inicio de sesión

~~~php
<?php
session_start();

$host = "localhost"; // o tu servidor de base de datos
$dbname = "usuarios_db";
$username = "tu_usuario";
$password = "tu_contraseña";
$conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Registro de usuarios
if (isset($_POST['register'])) {
    if (!empty($_POST['username']) && !empty($_POST['password'])) {
        $username = $_POST['username'];
        $password = md5($_POST['password']); // Encriptación simple para el ejemplo, considera usar password_hash en producción
        $stmt = $conn->prepare("INSERT INTO usuarios (username, password) VALUES (?, ?)");
        if ($stmt->execute([$username, $password])) {
            echo "Usuario registrado con éxito.";
        } else {
            echo "Error al registrar el usuario.";
        }
    } else {
        echo "El nombre de usuario y la contraseña son obligatorios.";
    }
}

// Inicio de sesión
if (isset($_POST['login'])) {
    if (!empty($_POST['username']) && !empty($_POST['password'])) {
        $username = $_POST['username'];
        $password = md5($_POST['password']);
        $stmt = $conn->prepare("SELECT * FROM usuarios WHERE username = ? AND password = ?");
        $stmt->execute([$username, $password]);
        $user = $stmt->fetch();

        if ($user) {
            $_SESSION['user_id'] = $user['id'];
            $_SESSION['username'] = $user['username'];

            // Recordar usuario
            if (!empty($_POST['remember'])) {
                setcookie('user_login', $username, time() + (86400 * 30), "/"); // 86400 = 1 día
            }

            echo "Inicio de sesión exitoso.";
        } else {
            echo "Nombre de usuario o contraseña incorrectos.";
        }
    } else {
        echo "El nombre de usuario y la contraseña son obligatorios para iniciar sesión.";
    }
}

// Cerrar sesión
if (isset($_POST['logout'])) {
    session_destroy();
    setcookie('user_login', '', time() - 3600, "/"); // Eliminar cookie
    echo "Sesión cerrada con éxito.";
}
?>
~~~