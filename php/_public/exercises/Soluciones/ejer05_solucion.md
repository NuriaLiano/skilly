# [Solución] Ejercicio POO y formularios. Registro de usuarios

Para implementar un sistema de registro de usuarios utilizando POO y formularios en PHP, dividiremos el código en varios archivos para mantener la estructura organizada y promover la reusabilidad del código. 

## registro.html

Este archivo HTML proporciona la interfaz de usuario para el registro de nuevos usuarios. Incluye campos para el nombre, el correo electrónico y la contraseña.

~~~php
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="procesarRegistro.php" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        <label for="email">Correo Electrónico:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="contraseña">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" required><br><br>
        <button type="submit">Registrar</button>
    </form>
</body>
</html>
~~~

## Usuario.php

Este archivo PHP define la clase Usuario, que representa a un usuario del sistema. Incluye propiedades para el nombre, correo electrónico y contraseña, junto con un constructor y métodos getters para acceder a estas propiedades.

~~~php
<?php
class Usuario {
    private $nombre;
    private $email;
    private $contraseña;

    public function __construct($nombre, $email, $contraseña) {
        $this->nombre = $nombre;
        $this->email = $email;
        $this->contraseña = $contraseña;
    }

    public function getNombre() {
        return $this->nombre;
    }

    public function getEmail() {
        return $this->email;
    }

    public function getContraseña() {
        return $this->contraseña;
    }
}
?>
~~~

## RegistroUsuario.php

Este archivo PHP contiene la clase RegistroUsuario, que procesa el registro de nuevos usuarios. Utiliza la clase Usuario para crear un nuevo objeto usuario con los datos proporcionados.

~~~php
<?php
require_once 'Usuario.php';

class RegistroUsuario {
    public function procesarRegistro($nombre, $email, $contraseña) {
        $usuario = new Usuario($nombre, $email, $contraseña);
        // Aquí iría el código para guardar el usuario en una base de datos
        echo "Usuario registrado con éxito: " . $usuario->getNombre();
        // En una aplicación real, se redirigiría al usuario o se mostraría un mensaje de éxito
    }
}
?>
~~~

## procesarRegistro.php

Finalmente, este archivo PHP recibe los datos del formulario, los valida y utiliza la clase RegistroUsuario para procesar el registro del usuario.

~~~php
<?php
require_once 'RegistroUsuario.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $_POST['nombre'];
    $email = $_POST['email'];
    $contraseña = $_POST['contraseña'];

    $registro = new RegistroUsuario();
    $registro->procesarRegistro($nombre, $email, $contraseña);
}
?>
~~~
