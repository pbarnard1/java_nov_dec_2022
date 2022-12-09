<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<p class="fs-1">All cities</p>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<!--  Fixed variable names accordingly -->
				<c:forEach var="city" items="${cities}">
					<tr class="align-middle">
						<td><c:out value="${city.id}"/></td>
						<td><c:out value="${city.name}"/></td>
						<td>
							<a href="/cities/${city.id}" class="btn btn-primary">View</a>
							<a href="/cities/${city.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col">
				<form:form action="/cities/new" method="post" modelAttribute="newCity">
					<p class="fs-4">Add new city</p>
					<div class="row my-4">
						<form:label path="name" class="col-2">Name:</form:label>
						<form:input path="name" class="col-6"/>
						<form:errors path="name" class="text-danger offset-2"/>
					</div>
					<input type="submit" class="btn btn-primary offset-2 col-2" value="Add city">
				</form:form>
			</div>
			<div class="col">
				<form:form action="/stores/new" method="post" modelAttribute="newStore">
					<p class="fs-4">Add new store</p>
					<div class="row my-4">
						<form:label path="name" class="col-2">Name:</form:label>
						<form:input path="name" class="col-6"/>
						<form:errors path="name" class="text-danger offset-2"/>
					</div>
					<input type="submit" class="btn btn-primary offset-2 col-2" value="Add store">
				</form:form>
			</div>
		</div>
		<p class="fs-1">All stores</p>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${stores}">
					<tr class="align-middle">
						<td><c:out value="${store.id}"/></td>
						<td><c:out value="${store.name}"/></td>
						<td>
							<a href="/stores/${store.id}" class="btn btn-primary">View</a>
							<a href="/stores/${store.id}/delete" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>