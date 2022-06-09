<?php

include 'conexion.php';

$id_tipo_actividad=$_POST['id_tipo_actividad'];
$nombre_tipo_actividad=$_POST['nombre_tipo_actividad'];


$consulta="insert into tipo_actividad values('".$id_tipo_actividad."','".$nombre_tipo_actividad."')";
mysqli_query($conexion,$consulta) or die(mysql_error());
mysql_close();

?>