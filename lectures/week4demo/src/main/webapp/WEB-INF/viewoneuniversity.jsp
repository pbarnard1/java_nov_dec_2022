<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>About ${thisUniversity.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<a href="/universities" class="btn btn-primary">All universities</a>
		<h1>About <c:out value="${thisUniversity.name}"/></h1>
		<p>City: <c:out value="${thisUniversity.city}"/></p>
		<p>Offers online courses: <c:out value="${thisUniversity.isOnline}"/></p>
		<p>Offers in-person courses: <c:out value="${thisUniversity.isInPerson}"/></p>
		<p>Enrollment: <c:out value="${thisUniversity.enrollment}"/></p>
		<p>Year established: <c:out value="${thisUniversity.yearFounded}"/></p>
		
	</div>
</body>
</html>