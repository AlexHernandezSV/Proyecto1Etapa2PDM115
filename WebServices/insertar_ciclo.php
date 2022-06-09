<?php

include 'conexion.php';

$id_ciclo=$_POST['id_ciclo'];
$ciclo=$_POST['ciclo'];
$fecha_inicio=$_POST['fecha_inicio'];
$fecha_fin=$_POST['fecha_fin'];

$consulta="insert into ciclo values('".$id_ciclo."','".$ciclo."','".$fecha_inicio."','".$fecha_fin."')";
mysqli_query($conexion,$consulta) or die(mysql_error());
mysql_close();

?>