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
	<title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>All Plants</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="thisPlant" items="${ allPlants }">
					<tr class="align-middle">
						<td><c:out value="${ thisPlant.id }"/></td>
						<td><c:out value="${ thisPlant.name }"/></td>
						<td>
						<a href="/plants/${thisPlant.id}" class="btn btn-primary">View</a> 
						<a href="/plants/${thisPlant.id}/edit" class="btn btn-warning">Edit</a> 
						<a href="/plants/${thisPlant.id}/delete" class="btn btn-danger">Delete</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/plants/new" class="btn btn-primary">Add plant</a>
	</div>
</body>
</html>