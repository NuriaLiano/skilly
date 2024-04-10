# Ejercicio de registro de usuarios con sesiones y cookies

Crea una aplicación web en PHP que permita a los usuarios registrarse e iniciar sesión. La aplicación debe cumplir con los siguientes requisitos:

1. Registro de Usuarios: Los nuevos usuarios pueden registrarse proporcionando un nombre de usuario y contraseña. Los detalles del usuario deben almacenarse en una base de datos.
2. Inicio de Sesión: Los usuarios pueden iniciar sesión utilizando su nombre de usuario y contraseña. Utiliza sesiones para mantener el estado del inicio de sesión.
3. Recordar Usuario: Al iniciar sesión, los usuarios pueden marcar una casilla para "Recordar" su sesión. Utiliza cookies para implementar esta funcionalidad.
4. Validación de Entradas: Utiliza isset() y empty() para validar los datos del formulario tanto en el registro como en el inicio de sesión.

## Base de datos

~~~sql
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS usuarios_db;
USE usuarios_db;

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar datos de ejemplo (opcional)
INSERT INTO usuarios (username, password) VALUES ('usuario1', MD5('contraseña1')), ('usuario2', MD5('contraseña2'));
~~~
