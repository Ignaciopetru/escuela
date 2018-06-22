<?php
//conexion con base de datos
	$conexion = mysqli_connect('localhost','root','','messuputo') or die ('No se puede conectar'.mysqli_error($conexion));
//peticion del primer arma requerida a la base de datos
	$pedirn = 'SELECT id, name, description FROM armas WHERE id= "'.$_POST['id'].'"';
	$result = mysqli_query($conexion, $pedirn);
	$row = mysqli_fetch_array($result);
//almasenaje en la estructura data(json)
	$data['id'] = $row['id'];
	$data['name'] = $row['name'];
	$data['description'] = $row['description'];
	$array[1] = $data;
	$i = $_POST['id'] + 1;
//peticion de las otras 15 armas
	while($i<=($_POST['id']+15)){
		$pedirn = 'SELECT name, description FROM armas WHERE id="'.$i.'"';
		$result = mysqli_query($conexion, $pedirn);
		$row = mysqli_fetch_array($result);
		$data['name'] = $row['name'];
		$data['description'] = $row['description'];
		$array[$i] = $data;
		$i++;
	}
//devolucion
	echo json_encode($array);
?>
