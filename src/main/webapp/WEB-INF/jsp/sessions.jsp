<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h2>Admin access.</h2>

	<table>
		<tr>
			<td>session id</td>
			<td>action</td>
		</tr>
		<c:forEach items="${sessionList}" var="sessionId">
			<tr>
				<td>${sessionId}</td>
				<td><a href="<c:url value='/disconnect-${sessionId}-user' />">disconnect</a></td>
			</tr>
		</c:forEach>

	</table>


	<a href="j_spring_security_logout"> Logout</a>
</body>
</html>