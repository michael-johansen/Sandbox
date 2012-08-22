<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	Edit Customer
	<spring:url value="/customers" var="actionUrl" />
	<form:form modelAttribute="customer" action="${actionUrl}">
		firstName: <form:input path="firstName" />
		<br>
		lastName: <form:input path="lastName" />
		<br>
		<button type="submit">submit</button>
	</form:form>
</body>
</html>