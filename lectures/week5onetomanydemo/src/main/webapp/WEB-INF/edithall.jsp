<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit hall page</title>
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
		<h3>Edit a Hall</h3>
		<form:form action="/halls/${editedHall.id}/edit" method="post" modelAttribute="editedHall">
			<input type="hidden" name="_method" value="put">
			<div class="row my-4">
				<form:label path="name" class="col-2">Name:</form:label>
				<form:input path="name" class="col-3"/>
				<form:errors path="name" class="text-danger offset-2"/>
			</div>
			
			<div class="row my-4">
				<form:label path="isResidential" class="col-2">Is residential:</form:label>
				<div class="col">
					<form:radiobutton value="1" class="col-1 form-check-input mx-2" path="isResidential" label="Yes"/>
					<form:radiobutton value="0" class="col-1 form-check-input mx-2" path="isResidential" label="No"/>
				</div>
				<form:errors path="isResidential" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="floors" class="col-2">Floors:</form:label>
				<form:input type="number" class="col-3" min="1" max="999999" step="1" path="floors"/>
				<form:errors path="floors" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="hasLectureRooms" class="col-2">Has lecture rooms:</form:label>
				<div class="col">
					<form:radiobutton value="1" class="col-1 form-check-input mx-2" path="hasLectureRooms" label="Yes"/>
					<form:radiobutton value="0" class="col-1 form-check-input mx-2" path="hasLectureRooms" label="No"/>
				</div>
				<form:errors path="hasLectureRooms" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="university" class="col-2">University:</form:label>
				<div class="col">
					<form:select path="university" class="col-3">
						<form:options items="${universities}" itemValue="id" itemLabel="name" class="col-1 form-check-input mx-2" />
					</form:select>
				</div>
				<form:errors path="university" class="text-danger offset-2"/>
			</div>
			<input type="submit" class="btn btn-primary offset-2 col-2" value="Edit hall">
		</form:form>
	</div>
</body>
</html>