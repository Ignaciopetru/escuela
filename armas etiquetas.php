<?php
	$conexion = mysqli_connect('localhost','root','','messuputo') or die ('No se puede conectar'.mysqli_error($conexion));

	$pedirn = 'SELECT name, description FROM armas WHERE id= "'.$_POST['id'].'"';
	$result = mysqli_query($conexion, $pedirn);
	$row = mysqli_fetch_array($result);
	$data['name'] = $row['name'];
	$data['description'] = $row['description'];
	$array[1] = $data;
	$i = $_POST['id'] + 1;
	while($i<=(15)){
		$pedirn = 'SELECT name, description FROM armas WHERE id="'.$i.'"';
		$result = mysqli_query($conexion, $pedirn);
		$row = mysqli_fetch_array($result);
		$data['name'] = $row['name'];
		$data['description'] = $row['description'];
		$array[$i] = $data;
		$i++;
	}
	echo json_encode($array);
?>
