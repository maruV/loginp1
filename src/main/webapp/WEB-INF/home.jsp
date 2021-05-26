<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1> Welcome, this is the Home Page </h1>
	
	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	%>
	
	<form action="About" method="get">
		<input type="submit" value="About">
	</form>
	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>