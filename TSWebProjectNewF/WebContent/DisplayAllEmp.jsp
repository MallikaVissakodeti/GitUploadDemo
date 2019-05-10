<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.ts.dto.Employee" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>

<jsp:include page="MgrHomePage.jsp" />
	<table border=2 align=center>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>JOB</th>
			<th>USER NAME</th>
		</tr>
		<c:forEach var="employee" items="${employeesData}">
			<tr>
				<td>${employee.empId}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>
				<td>${employee.job}</td>
				<td>${employee.userName}</td></tr>
		</c:forEach>
	</table>
</body>
</html>





