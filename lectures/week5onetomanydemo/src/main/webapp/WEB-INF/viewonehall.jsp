<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>About ${thisHall.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">University Directory</a>
			<ul class="nav nav-pills">
				<li class="nav-item">
					<a class="nav-link" href="/halls">All halls</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<h1>About <c:out value="${thisHall.name}"/></h1>
		<p>Located at <c:out value="${thisHall.university.name}"/></p>
		<p>Is a residential hall: <c:out value="${thisHall.isResidential}"/></p>
		<p>Floors: <c:out value="${thisHall.floors}"/></p>
		<p>Has lecture rooms: <c:out value="${thisHall.hasLectureRooms}"/></p>
	</div>
</body>
</html>