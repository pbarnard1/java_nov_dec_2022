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
    <title>View ${thisCity.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<h1>List of stores found in <c:out value="${thisCity.name}"/>:</h1>
		<ul>
			<c:forEach var="store" items="${thisCity.stores}">
				<li>
					<form action="/cities/${thisCity.id}/removeStore/${store.id}" method="POST">
						<input type="hidden" name="_method" value="delete">
						<c:out value="${ store.name }"/>
						<input type="submit" class="btn btn-danger" value="Remove">
					</form>
				</li>
			</c:forEach>
		</ul>
		<p class="fs-3">Missing stores:</p>
		<ul>
			<c:forEach var="store" items="${missingStores}">
				<li>
					<form action="/cities/${thisCity.id}/addStore/${store.id}" method="POST">
						<c:out value="${ store.name }"/>
						<input type="submit" class="btn btn-primary" value="Add">
					</form>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>