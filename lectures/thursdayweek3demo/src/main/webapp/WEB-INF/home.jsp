<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basic form page</title>
</head>
<body>
	<form action="/processform" method="POST">
		<div>
			<p><c:out value="${usernameMessage}"/></p>
			<label for="username">User name:</label>
			<input type="text" name="username" id="username">
		</div>
		<div>
			<label for="email">Email:</label>
			<input type="email" name="email" id="email">
		</div>
		<div>
			<p><c:out value="${ageMessage}"/></p>
			<label for="age">Age:</label>
			<input type="number" name="age" id="age">
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password">
		</div>
		<input type="submit" value="Send">
	</form>
</body>
</html>