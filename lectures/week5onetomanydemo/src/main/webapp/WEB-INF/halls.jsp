<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All halls page</title>
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
		<h1>All halls</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>University</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hall" items="${allHalls}">
					<tr class="align-middle">
						<td><c:out value="${hall.id}"/></td>
						<td><c:out value="${hall.name}"/></td>
						<td><c:out value="${hall.university.name}"/></td>
						<td>
							<a href="/halls/${hall.id}" class="btn btn-primary">View</a>
							<a href="/halls/${hall.id}/edit" class="btn btn-warning">Edit</a>
							<a href="/halls/${hall.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/halls/new" class="btn btn-primary">Add hall</a></p>
	</div>
</body>
</html>