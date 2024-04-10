<?php
require 'functions.php';

// Manejar el registro
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['register'])) {
    registerUser($_POST['username'], $_POST['password']);
}

// Manejar el inicio de sesión
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['login'])) {
    if (loginUser($_POST['username'], $_POST['password'])) {
        header("Location: index.php"); // Redirige a la página principal
        exit();
    } else {
        echo "Error en el inicio de sesión";
    }
}

// Manejar la eliminación de usuarios
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['delete'])) {
    deleteUser($_POST['user_id']);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Gestión de Usuarios</title>
</head>
<body>

<!-- Formulario de Registro -->
<h2>Registrar Usuario</h2>
<form method="post">
    Username: <input type="text" name="username" required>
    Password: <input type="password" name="password" required>
    <input type="submit" name="register" value="Registrar">
</form>

<!-- Formulario de Inicio de Sesión -->
<h2>Iniciar Sesión</h2>
<form method="post">
    Username: <input type="text" name="username" required>
    Password: <input type="password" name="password" required>
    <input type="submit" name="login" value="Iniciar Sesión">
</form>

<?php if (isUserLoggedIn()): ?>
    <!-- Lista de Usuarios -->
    <h2>Lista de Usuarios</h2>
    <?php
    $users = getUsers();
    foreach ($users as $user) {
        echo "<p>" . htmlspecialchars($user['username']) . " - <form method='post'><input type='hidden' name='user_id' value='" . $user['id'] . "'><input type='submit' name='delete' value='Eliminar'></form></p>";
    }
    ?>
<?php endif; ?>

</body>
</html>