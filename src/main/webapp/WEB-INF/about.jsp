<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
</head>
<body>
	<h1> This is the about page</h1>
	
	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	%>
	
	<form action="Home" method="get">
		<input type="submit" value="Home">
	</form>
	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
	
</body>
</html>