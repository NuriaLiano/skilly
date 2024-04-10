<?php
//iniciar la session
session_start();

//verificar si se han enviado los datos del formulario
if($SERVER['REQUEST_METHOD'] == 'POST'){
    $_SESSION['idioma'] = $_POST['idioma'];
    $_SESSION['perfil'] = $_POST['perfil'];
    $_SESSION['zona'] = $_POST['zona'];
    $mensaje = 'Las preferencias se han guardado correctamente';
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
    <!--este bloque solo se muestra si la variable mensaje contiene informacion-->
    <?php if(!empty($mensaje)){?>  <!--comprobamos que la variable no esta vacia-->
        <div>
            <i> <?php echo $mensaje; ?></i> <!--imprimimos el valor de la variable-->
        </div>
    <?php }; ?> <!--cerramos el if de comprobacion de la variable-->

    <form action="" method="POST">
        <div>
            <label for="idioma">Idioma</label>
            <select name="idioma" id="idioma">
                <option value="es">Espanol</option>
                <option value="en">Ingles</option>
                <option value="de">Aleman</option>
                <option value="fr">Frances</option>
                <option value="it">Italiano</option>
            </select>
            <label for="perfil">Perfil</label>
            <select name="perfil" id="perfil">
                <option value="si">Si</option>
                <option value="no">No</option>
            </select>
            <label for="zona">Zona</label>
            <select name="zona" id="zona">
                <option value="GMT0">GMT0</option>
                <option value="GMT1">GMT1</option>
                <option value="GMT2">GMT2</option>
            </select>

            <a href="mostrar.php">Mostrar Preferencias</a>
            <button type="submit">Establecer Preferencias</button>
        </div>

    </form>
</body>
</html>