<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit university page</title>
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
		<h3>Edit a University</h3>
		<form:form action="/universities/${thisUniversity.id}/edit" method="post" modelAttribute="thisUniversity">
			<input type="hidden" name="_method" value="put">
			<div class="row my-4">
				<form:label path="city" class="col-2">City:</form:label>
				<form:input path="city" class="col-3"/>
				<form:errors path="city" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="name" class="col-2">Name:</form:label>
				<form:input path="name" class="col-3"/>
				<form:errors path="name" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="enrollment" class="col-2">Enrollment:</form:label>
				<form:input type="number" class="col-3" min="1" max="999999" step="1" path="enrollment"/>
				<form:errors path="enrollment" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="isOnline" class="col-2">Offers online courses:</form:label>
				<div class="col">
					<form:radiobutton value="1" class="col-1 form-check-input mx-2" path="isOnline" label="Yes"/>
					<form:radiobutton value="0" class="col-1 form-check-input mx-2" path="isOnline" label="No"/>
				</div>
				<form:errors path="isOnline" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="isInPerson" class="col-2">Is in person:</form:label>
				<div class="col">
					<form:radiobutton value="1" class="col-1 form-check-input mx-2" path="isInPerson" label="Yes"/>
					<form:radiobutton value="0" class="col-1 form-check-input mx-2" path="isInPerson" label="No"/>
				</div>
				<form:errors path="isInPerson" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="yearFounded" class="col-2">Year founded:</form:label>
				<form:input type="number" class="col-3" min="1" step="1" path="yearFounded"/>
				<form:errors path="yearFounded" class="text-danger offset-2"/>
			</div>
			<input type="submit" class="btn btn-primary offset-2 col-2" value="Edit university">
		</form:form>
		<div class="row my-4">
			<form:form action="/universities/${thisUniversity.id}/delete" method="post" modelAttribute="thisUniversity">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" class="btn btn-danger offset-2 col-2" value="Delete university">
			</form:form>]
		</div>
	</div>
</body>
</html>