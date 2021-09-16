<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
</head>
<body>
	<form:form action="/usuario/crear" method="post"
		modelAttribute="usuario">
		
		<h2><c:out value="${mensaje}"></c:out></h2>
		<form:label path="rut">RUT:</form:label>
		<form:input type="text" path="rut" />
		<br>
		
		
		<br>
		<form:label path="nombre">NOMBRE:</form:label>
		<form:input type="text" path="nombre" />
		<br>
		
	
		
		
		<form:label path="apellido">APELLIDO:</form:label>
		<form:input type="text" path="apellido" />
		
		
		<br>
		<form:label path="edad">EDAD:</form:label>
		<form:input type="text" path="edad" />
		<br>
		

		<input type="submit" value="Crear Usuario">

	</form:form>

	<br>
	<hr>
	<h1>Lista Usuarios</h1>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Rut</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
				
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${lista_usuarios}">
				<tr>
					<td><c:out value="${usuario.id}" /></td>
					<td><c:out value="${usuario.rut}" /></td>
					<td><c:out value="${usuario.nombre}" /></td>
					<td><c:out value="${usuario.apellido}" /></td>
					<td><c:out value="${usuario.edad}" /></td>
					
					
					<td>
					
					<a href="/usuario/actualizar/${usuario.id}">Editar</a>
					
					<!-- ELIMINAR UN REGISTRO POR EL ID -->
						

						<form action="/usuario/eliminar2/${usuario.id}" method="POST">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Eliminar">
						</form></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>