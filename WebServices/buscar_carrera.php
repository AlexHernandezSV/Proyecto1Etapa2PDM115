<?php

include 'conexion.php';

$id_carrera = $_GET['id_carrera'];

$consulta = "select * from carrera where id_carrera = '$id_carrera'";
$resultado = $conexion -> query($consulta);

while($fila = $resultado -> fetch_array())
{
	$carrera[] = array_map('utf8_encode', $fila);
}

echo json_encode($carrera);
$resultado -> close();

?>