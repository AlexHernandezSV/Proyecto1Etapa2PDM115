<?php

include 'conexion.php';

$id_horario=$_POST['id_horario'];
$desde_horario=$_POST['desde_horario'];
$hasta_horario=$_POST['hasta_horario'];


$consulta="insert into horario values('".$id_horario."','".$desde_horario."','".$hasta_horario."')";
mysqli_query($conexion,$consulta) or die(mysql_error());
mysql_close();

?>