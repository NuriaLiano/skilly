<?php
session_start();

// Conexión a la base de datos
function connectToDB() {
    $host = 'localhost';
    $db   = 'nombre_de_tu_base_de_datos';
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
        return new PDO($dsn, $user, $pass, $options);
    } catch (\PDOException $e) {
        throw new \PDOException($e->getMessage(), (int)$e->getCode());
    }
}

// Registrar usuario
function registerUser($username, $password) {
    $pdo = connectToDB();
    $hashedPassword = password_hash($password, PASSWORD_DEFAULT);
    $sql = "INSERT INTO users (username, password) VALUES (?, ?)";
    $stmt = $pdo->prepare($sql);
    $stmt->execute([$username, $hashedPassword]);
}

// Iniciar sesión
function loginUser($username, $password) {
    $pdo = connectToDB();
    $sql = "SELECT id, username, password FROM users WHERE username = ?";
    $stmt = $pdo->prepare($sql);
    $stmt->execute([$username]);
    $user = $stmt->fetch();

    if ($user && password_verify($password, $user['password'])) {
        $_SESSION['user_id'] = $user['id'];
        return true;
    }
    return false;
}

// Verificar si el usuario está logueado
function isUserLoggedIn() {
    return isset($_SESSION['user_id']);
}

// Obtener lista de usuarios
function getUsers() {
    $pdo = connectToDB();
    $stmt = $pdo->query("SELECT id, username FROM users");
    return $stmt->fetchAll();
}

// Eliminar usuario
function deleteUser($userId) {
    $pdo = connectToDB();
    $sql = "DELETE FROM users WHERE id = ?";
    $stmt = $pdo->prepare($sql);
    $stmt->execute([$userId]);
}
?>