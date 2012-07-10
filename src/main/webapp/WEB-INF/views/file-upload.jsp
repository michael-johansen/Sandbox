<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<spring:url value="/file-upload" var="action" />
	<form:form modelAttribute="documents" action="${action}" method="POST" enctype="multipart/form-data">
		<form:input path="[one].fileName" />
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>