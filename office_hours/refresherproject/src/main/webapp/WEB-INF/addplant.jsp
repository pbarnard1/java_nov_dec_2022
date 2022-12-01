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
	<title>Add a plant</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>Add a Plant</h1>
		<form:form action="/plants/new" method="post" modelAttribute="newPlant">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</p>
			<p>
				<form:label path="color">Color:</form:label>
				<form:input path="color"/>
				<form:errors path="color"/>
			</p>
			<p>
				<form:label path="isPerennial">Is a perennial plant:</form:label>
				<form:radiobutton path="isPerennial" value="1" label="Yes"/>
				<form:radiobutton path="isPerennial" value="0" label="No"/>
				<form:errors path="isPerennial"/>
			</p>
			<p>
				<input type="submit" value="Add plant"/>
			</p>
		</form:form>
	</div>
</body>
</html>