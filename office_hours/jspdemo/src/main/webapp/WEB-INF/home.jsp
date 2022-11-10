<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<c:forEach var="currentCount" begin="1" end="${repetitions}">
	    <p>Hello <c:out value="${firstName}"></c:out>!  Your favorite color is <c:out value="${favColor}"></c:out>.</p>
	</c:forEach>
</body>
</html>