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
	<h1>Edit a University</h1>
	<a href="/universities" class="btn btn-primary">All universities</a>
	<form:form action="/universities/${thisUniversity.id}/delete" method="post" modelAttribute="thisUniversity">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" class="btn btn-danger" value="Delete university">
	</form:form>
	<form:form action="/universities/${thisUniversity.id}/edit" method="post" modelAttribute="thisUniversity">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="city">City:</form:label>
			<form:errors path="city"/>
			<form:input path="city"/>
		</p>
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="enrollment">Enrollment:</form:label>
			<form:errors path="enrollment"/>
			<form:input type="number" min="1" max="999999" step="1" path="enrollment"/>
		</p>
		<p>
			<form:label path="isOnline">Offers online courses:</form:label>
			<form:errors path="isOnline"/>
			<form:radiobutton value="1" path="isOnline"/>Yes
			<form:radiobutton value="0" path="isOnline"/>No
		</p>
		<p>
			<form:label path="isInPerson">Is in person:</form:label>
			<form:errors path="isInPerson"/>
			<form:radiobutton value="1" path="isInPerson"/>Yes
			<form:radiobutton value="0" path="isInPerson"/>No
		</p>
		<p>
			<form:label path="yearFounded">Year founded:</form:label>
			<form:errors path="yearFounded"/>
			<form:input type="number" min="1" step="1" path="yearFounded"/>
		</p>
		<input type="submit" value="Edit university">
	</form:form>
</body>
</html>