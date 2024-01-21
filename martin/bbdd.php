<?php

//declarar las constantes globales
$host = "localhost";
$database = "proyecto";
$username = "gestor";
$password = "secreto";
$charset = "utf8mb4";

$opciones = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES => false
];

$dsn = "mysql:host=$host;dbname=$database;charset=$charset";
try{
    $pdo = new PDO ($dsn, $username, $password, $opciones);
}catch (PDOException $e){
    throw new PDOException($e->getMessage());
}


?>