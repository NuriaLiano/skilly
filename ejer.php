<?php


//iniciar la session
session_start();


if(isset($_POST["borrar"])){
    session_unset();
    echo "<p>Idioma: </p>
    <p>Perfil público: </p>
    <p>Zona horaria:</p>";
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <h2>Preferencias</h2>
        <div>
            <p>Idioma: <?php echo $_SESSION['idioma']; ?></p>
            <p>Perfil público: <?php echo $_SESSION['perfil']; ?></p>
            <p>Zona horaria: <?php echo $_SESSION['zona']; ?></p>
        </div>
        

        <form action="" method="post">
            <button type="submit">Establecer</button>
            <button type="submit" name="borrar">Borrar</button>
        </form>
        
    </div>
</body>
</html>