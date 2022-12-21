<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit store</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<p><a href="/stores" class="btn btn-primary">All stores</a></p>
		</div>
		<div class="row">
			<div class="col">
				<form:form action="/stores/${editedStore.id}/edit" method="post" modelAttribute="editedStore">
					<input type="hidden" name="_method" value="put">
					<p class="fs-4">Edit store</p>
					<div class="row my-4">
						<form:label path="hasDriveThru" class="col-2">Has a drive-thru:</form:label>
						<div class="col">
							<form:radiobutton value="1" path="hasDriveThru" class="col-1 form-check-input mx-2" label="Yes"/>
							<form:radiobutton value="0" path="hasDriveThru" class="col-1 form-check-input mx-2" label="No"/>
						</div>
						<form:errors path="hasDriveThru" class="text-danger offset-2"/>
					</div>
					<div class="row my-4">
						<form:label path="employeeCount" class="col-2">Number of employees:</form:label>
						<form:input type="number" step="1" path="employeeCount" class="col-6"/>
						<form:errors path="employeeCount" class="text-danger offset-2"/>
					</div>
					<div class="row my-4">
						<form:label path="address" class="col-2">Address:</form:label>
						<form:input path="address" class="col-6"/>
						<form:errors path="address" class="text-danger offset-2"/>
					</div>
					<div class="row my-4">
						<form:label path="city" class="col-2">City:</form:label>
						<div class="col">
							<form:select path="city" class="col-3">
								<form:options items="${cities}" itemValue="id" itemLabel="name" class="col-1 form-check-input mx-2" />
							</form:select>
						</div>
						<form:errors path="city" class="text-danger offset-2"/>
					</div>
					<div class="row my-4">
						<form:label path="chain" class="col-2">Chain (retailer):</form:label>
						<div class="col">
							<form:select path="chain" class="col-3">
								<form:options items="${chains}" itemValue="id" itemLabel="name" class="col-1 form-check-input mx-2" />
							</form:select>
						</div>
						<form:errors path="chain" class="text-danger offset-2"/>
					</div>
					<input type="submit" class="btn btn-primary offset-2 col-2" value="Edit store">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>