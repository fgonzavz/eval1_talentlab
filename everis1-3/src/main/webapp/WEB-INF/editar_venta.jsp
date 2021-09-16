<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>venta editar</title>
</head>
<body>
	<div>
		<form:form action="/venta/modificar" method="post" modelAttribute="venta">
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			<form:label path="codigo">codigo:</form:label>
			<form:input type="text" path="codigo"/><br>
			
			<form:label path="cantidad_vendida">cantidad_vendida:</form:label>
			<form:input type="text" path="cantidad_vendida"/><br>
			
			
			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			
			
			<input type="submit" value="Modificar Venta">
		</form:form>
		
	</div>
</body>
</html>>