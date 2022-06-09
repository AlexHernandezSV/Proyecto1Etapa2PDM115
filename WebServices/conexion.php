<?php

$hostname='localhost';
$database="grupo12";
$username='root';
$password='';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
	echo "Conexión fallida";
}

?>