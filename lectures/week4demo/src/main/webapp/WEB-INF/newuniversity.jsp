<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New university page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form:form action="/universities/new" method="post" modelAttribute="newUniversity">
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
		<input type="submit" value="Add university">
	</form:form>
</body>
</html>