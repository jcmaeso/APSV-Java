<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Crear Researcher</h3>
	
	<form action="CreateResearcherServlet" method="post">
		
		<p>
			ID: <input type="text" name="id" placeholder="User Id"/>
		</p>
		<p>
			Email: <input type="text" name="email" placeholder="User Email"/>
		</p>
		<p>
			Primer apellido: <input type="text" name="lastname" placeholder="User Last Name" />
		</p>
		<p>
			Nombre: <input type="text" name="name" placeholder="User Name"/>
		</p>
		<p>
			Password: <input type="password" name="password" placeholder="User Password"/>
		</p>
		<p>
			<button type="submit">Crear Researcher</button>
		</p>
	</form>
</body>
</html>