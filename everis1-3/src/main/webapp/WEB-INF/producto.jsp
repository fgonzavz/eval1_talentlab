<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
</head>
<body>
	<form:form action="/producto/crear" method="post"
		modelAttribute="producto">
		
		<h2><c:out value="${mensaje}"></c:out></h2>
		<form:label path="codigo">codigo:</form:label>
		<form:input type="text" path="codigo" />
		<br>
		
		
		<br>
		<form:label path="nombre">nombre:</form:label>
		<form:input type="text" path="nombre" />
		<br>
		
	
		
		
		<form:label path="precio">precio:</form:label>
		<form:input type="text" path="precio" />
		
		
		<br>
		<form:label path="Stock">Stock:</form:label>
		<form:input type="text" path="Stock" />
		<br>
		

		<input type="submit" value="Crear Producto">

	</form:form>

	<br>
	<hr>
	<h1>Lista Empleados</h1>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>codigo producto</th>
				<th>nombre</th>
				<th>precio</th>
				<th>Stock</th>
				
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="producto" items="${lista_productos}">
				<tr>
					<td><c:out value="${producto.id}" /></td>
					<td><c:out value="${producto.codigo}" /></td>
					<td><c:out value="${producto.nombre}" /></td>
					<td><c:out value="${producto.precio}" /></td>
					<td><c:out value="${producto.stock}" /></td>
					
					
					<td>
					
					<a href="/producto/actualizar/${producto.id}">Editar</a>
					
					<!-- ELIMINAR UN REGISTRO POR EL ID -->
						

						<form action="/producto/eliminar2/${producto.id}" method="POST">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Eliminar">
						</form></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>