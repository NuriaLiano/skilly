# Ejercicio: Sistema de Gestión de Usuarios

## Objetivo

Crear un sistema básico de gestión de usuarios que permita registrar nuevos usuarios, iniciar sesión, ver una lista de usuarios y eliminar usuarios. Este sistema utilizará sesiones para mantener el estado del usuario y PDO para interactuar con una base de datos MySQL.

## Pasos

1. Crear la Base de Datos y la Tabla de Usuarios

Primero, necesitarás una base de datos MySQL y una tabla de usuarios. La tabla de usuarios podría tener una estructura simple como la siguiente:

~~~sql
CREATE DATABASE IF NOT EXISTS GestionUsuarios;

--Usar la base de datos que acabas de crear
USE GestionUsuarios;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);
~~~

2. Conectar a la Base de Datos con PDO
3. Manejar Sesiones para Usuarios
4. Funcionalidades de Usuario:
   1. Registrar: Inserta un nuevo usuario en la base de datos.
   2. Iniciar Sesión: Verifica las credenciales del usuario y comienza una sesión.
   3. Ver Usuarios: Muestra una lista de usuarios (solo si el usuario ha iniciado sesión).
   4. Eliminar Usuario: Elimina un usuario de la base de datos.
5. Frontend
Crea formularios HTML básicos para permitir la entrada de datos del usuario (registro y login) y mostrar la lista de usuarios.
