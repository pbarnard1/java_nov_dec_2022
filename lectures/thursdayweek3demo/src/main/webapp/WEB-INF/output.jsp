<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Values from form</title>
</head>
<body>
	<h1>Here are the values from your form:</h1>
	<p>Username: <c:out value="${username}"/></p>
	<p>Email: <c:out value="${email}"/></p>
	<p>Age: <c:out value="${age}"/></p>
	<p>Password: <c:out value="${password}"/></p>
</body>
</html>