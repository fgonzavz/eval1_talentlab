<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>producto editar</title>
</head>
<body>
	<div>
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			<form:label path="codigo">codigo:</form:label>
			<form:input type="text" path="codigo"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			<form:label path="Stock">Stock:</form:label>
			<form:input type="text" path="Stock"/><br>
			
			
			
			<input type="submit" value="Modificar Producto">
		</form:form>
		
	</div>
</body>
</html>