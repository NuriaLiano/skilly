<?php
    include "bbdd.php";

    try{
        $pdo = new PDO("mysql:host=localhost;dbname=bbdd",$username,$password);

        //obtener las familias de los productos
        $consulta = $pdo->query("SELECT id, nombre FROM familias");
        $familias = $cosulta->fetch(PDO::FETCH_ASSOC);
    }catch(PDOException $e){
        die("Error al conectar");
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
    <form action="insertar_producto.php" method="post">
        Codigo: <input type="text" name="codigo"><br>
        Nombre: <input type="text" name="nombre"><br>
        Precio: <input type="text" name="nombre"><br>
        Familias: <select name="familias">
            <?php foreach($familia as $familias){?>
                <option value="<?php $familias['id'] ?>"><?php $familias['nombre'] ?></option>
            <?php } ?>
        </select>
        <input type="submit" value="Insertar">
    </form>
</body>
</html>

<?php
//cerrar la conexion a la bbdd
unset($pdo);
?>