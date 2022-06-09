<?php

include 'conexion.php';
$id_carrera=$_POST['id_carrera'];
$nombre_carrera=$_POST['nombre_carrera'];

$consulta="insert into carrera values('".$id_carrera."','".$nombre_carrera."')";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);

?>