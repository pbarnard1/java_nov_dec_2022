<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- For displaying values, using if statements, etc. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  For formatting Dates among other things -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--  For our form:??? tags  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!--  For rendering errors with PUT routes  -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>View plant</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>About <c:out value="${thisPlant.name}"/>:</h1>
		<p>Is perennial: <c:out value="${thisPlant.isPerennial}"/></p>
		<p>Color: <c:out value="${thisPlant.color}"/></p>
		<p><a href="/" class="btn btn-primary">All plants</a>
	</div>
</body>
</html>