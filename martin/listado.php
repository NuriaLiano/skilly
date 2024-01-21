<?php
   //incluir fichero de conexion a la bbdd
   include "bbdd.php";

   try{
    // $pdo = new PDO("mysql:host=localhost;dbname=bbdd",$username,$password);
    
    $consulta = $pdo->query("SELECT id, codigo, nombre FROM productos");
    //print_r($consulta)
    echo "<a href='crear.php'>Crear</a>"; // imprimir un boton en html
    echo "<table>";
    echo "<tr><th>Codigo</th><th>Nombre</th><th>Acciones</th></tr>";
    //FETCH convierte la consulta en un array 
    //PDO::FETCH_ASSOC: devuelve un array asociativo
    //row es el array asociativo resultado de la conversion de la consulta
    $row = $consulta->fetch(PDO::FETCH_ASSOC);
    while($row){
        echo "<tr>";
        echo "<td>".$row["codigo"]."</td>";
        echo "<td>".$row["nombre"]."</td>";
        echo "<td>";
        echo "<a href='actualizar.php?id=".$row["id"]."'>Actualizar</a>"; // se usa ? pasar como parametro el id del producto en concreto
        echo "<a href='borrar.php?id=".$row["id"]."'>Borrar</a>"; 
        echo "</td>";
        echo "</tr>";
    }
    echo "</table>";


   }catch(PDOException $e){
        die("Error al conectar " . $e->getMessage());
   }

   //cerrar la conexion a la bbdd
   unset($pdo);


?>