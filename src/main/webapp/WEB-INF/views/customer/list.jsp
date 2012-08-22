<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>Customer (${fn:length(customers)} found)</td>
			</tr>
		</tbody>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>