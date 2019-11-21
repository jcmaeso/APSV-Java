<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResearcherView</title>
</head>
<body>
		<%@ include file="header.jsp"%>
		

	<h2>Researcher Information</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>ScoupusURL</th>
			
		</tr>
		<tr>
			<td>${researcherid.id}</td>
			<td>${researcherid.name}</td>
			<td>${researcherid.lastname}</td>
			<td><a href=${researcherid.scopusURL}> ${researcherid.scopusURL} </a></td>
			
		</tr>
	</table>
		
	<h2>Publications</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Titulo</th>
			<th>Fecha</th>	
		</tr>
		<c:forEach items="${researcherid.publications}" var="pi">
		<tr>
			<td>${pi.id}</td>
			<td>${pi.title}</td>
			<td>${pi.publicationName}</td>
			<td>${pi.publicationDate}</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>Crear Publicación</h3>
	
	<c:if test="${(user.id).equals(researcherid.id)}">
	
	<form action="CreatePublicationServlet" method="post">
		
		<p>
			ID: <input type="text" name="id" placeholder="User Id"/>
		</p>
		<p>
			Título: <input type="text" name="title" placeholder="Publication Title"/>
		</p>
		<p>
			Nombre de la Publicación: <input type="text" name="publicationName" placeholder="Publication Name" />
		</p>
		<p>
			Fecha de la publicación: <input type="text" name="publicationDate" placeholder="Publication Date"/>
		</p>
		<p>
			Autor: <input type="text" name="authors" placeholder="Publication Authors"/>
		</p>
		<p>
			<button type="submit">Crear Publicación</button>
		</p>
	</form>
	</c:if>
	
</body>
</html>