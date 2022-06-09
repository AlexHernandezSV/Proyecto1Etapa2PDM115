<?php

include 'conexion.php';

$id_tipo_actividad = $_GET['id_tipo_actividad'];

$consulta = "select * from tipo_actividad where id_tipo_actividad = '$id_tipo_actividad'";
$resultado = $conexion -> query($consulta);

while($fila = $resultado -> fetch_array())
{
	$tipo_actividad[] = array_map('utf8_encode', $fila);
}

echo json_encode($tipo_actividad);
$resultado -> close();

?>