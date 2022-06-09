<?php

include 'conexion.php';

$id_ciclo = $_GET['id_ciclo'];

$consulta = "select * from ciclo where id_ciclo = '$id_ciclo'";
$resultado = $conexion -> query($consulta);

while($fila = $resultado -> fetch_array())
{
	$ciclo[] = array_map('utf8_encode', $fila);
}

echo json_encode($ciclo);
$resultado -> close();

?>