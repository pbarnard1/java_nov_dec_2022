<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All universities page</title>
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
					<a class="nav-link" href="/universities">All universities</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<h1>All universities</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>University name</th>
					<th>City</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="university" items="${universities}">
					<tr class="align-middle">
						<td><c:out value="${university.id}"/></td>
						<td><c:out value="${university.name}"/></td>
						<td><c:out value="${university.city}"/></td>
						<td>
							<a href="/universities/${university.id}" class="btn btn-primary">View</a>
							<a href="/universities/${university.id}/edit" class="btn btn-warning">Edit</a>
							<a href="/universities/${university.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/universities/new" class="btn btn-primary">Add a university</a></p>
	</div>
</body>
</html>