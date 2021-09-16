<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Venta</title>
</head>
<body>
	<form:form action="/venta/crear" method="post"
		modelAttribute="venta">
		
		<h2><c:out value="${mensaje}"></c:out></h2>
		<form:label path="codigo">codigo:</form:label>
		<form:input type="text" path="codigo" />
		<br>
		
		
		<br>
		<form:label path="cantidad_vendida">cantidad vendida:</form:label>
		<form:input type="text" path="cantidad_vendida" />
		<br>
		
	
		
		
		<form:label path="precio">precio:</form:label>
		<form:input type="text" path="precio" />
		
		
		<br>
		
		

		<input type="submit" value="Crear Venta">

	</form:form>

	<br>
	<hr>
	<h1>Lista Ventas</h1>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>codigo</th>
				<th>cantidad vendida</th>
				<th>precio</th>
			
				
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="venta" items="${lista_ventas}">
				<tr>
					<td><c:out value="${venta.id}" /></td>
					<td><c:out value="${venta.codigo}" /></td>
					<td><c:out value="${venta.cantidad_vendida}" /></td>
					<td><c:out value="${venta.precio}" /></td>
					
					
					
					<td>
					
					<a href="/venta/actualizar/${venta.id}">Editar</a>
					
					<!-- ELIMINAR UN REGISTRO POR EL ID -->
						

						<form action="/venta/eliminar2/${venta.id}" method="POST">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Eliminar">
						</form></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>