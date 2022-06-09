<?php

include 'conexion.php';

$id_horario = $_GET['id_horario'];

$consulta = "select * from horario where id_horario = '$id_horario'";
$resultado = $conexion -> query($consulta);

while($fila = $resultado -> fetch_array())
{
	$horario[] = array_map('utf8_encode', $fila);
}

echo json_encode($horario);
$resultado -> close();

?>