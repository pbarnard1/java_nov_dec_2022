<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyles.css">
<title>Home page</title>
</head>
<body>
	<h1>This is my home page!  This page was made by <c:out value="${userName}"/>.  Your favorite number is <c:out value="${number}"/></h1>
	<p class="blue">This is in blue.</p>
	<c:if test="${salary > 30000}">
		<p>You're making more than $30,000!</p>
	</c:if>
	<!-- if/else if/else with c tags -->
	<c:choose>
		<c:when test="${salary > 100000}">
			<p>Wow - that's a lot of money - more than $100,000!</p>
		</c:when>
		<c:when test="${salary > 80000 }">
			<p>You're making more than $80,000!</p>
		</c:when>
		<c:otherwise>
			<p>You're making $80,000 or less.</p>
		</c:otherwise>
	</c:choose>
	<!-- Demo of a loop through an array, ArrayList, Map, etc. -->
	<c:forEach var="quote" items="${quotes}">
		<p><c:out value="${quote}"/></p>
	</c:forEach>
</body>
</html>