<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Entrance page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>Welcome to my awesome site!</h1>
		<div class="row">
			<div class="col">
				<p class="fs-3">Register</p>
				<form:form action="/register" method="post" modelAttribute="registerUser">
					<div class="row my-4">
						<form:label path="name" class="col-3">Name:</form:label>
						<form:input path="name" class="col-8"/>
						<form:errors path="name" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="email" class="col-3">Email:</form:label>
						<form:input path="email" class="col-8" type="email"/>
						<form:errors path="email" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="password" class="col-3">Password:</form:label>
						<form:password path="password" class="col-8"/>
						<form:errors path="password" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="confirmedPassword" class="col-3">Confirmed password:</form:label>
						<form:password path="confirmedPassword" class="col-8"/>
						<form:errors path="confirmedPassword" class="text-danger offset-3"/>
					</div>
					<div class="row">
						<input type="submit" class="btn btn-primary offset-3 col-3" value="Register"/>
					</div>
				</form:form>
			</div>
			<div class="col">
				<p class="fs-3">Log in (placeholder - will add Tuesday)</p>
			</div>
		</div>
	</div>
</body>
</html>