<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty history}">
	<table>
		<tr>
			<th>order number</th>
		</tr>
		<c:forEach var="history" items="${history}">
		<tr>
			<td><a href="trade?order=${history.history_number}">${history.histroy_number}</a></td>
			
		</tr>
		
		</c:forEach>
		
	
	</table>

</c:if>

<c:if test="${empty history}">there is no history.</c:if>

</body>
</html>