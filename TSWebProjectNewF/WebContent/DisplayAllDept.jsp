<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.Employee,java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
table{
width : 300px;
height : 100px;
}
table, td, th {
    border: 1px solid black;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MgrHomePage.jsp"></jsp:include>
<center>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>LOCATIOIN</th>
			<th>EMPLOYEES</th>
		</tr>
		<c:forEach var="dept" items="${deptsData}">
		<tr>
			<td>${dept.deptId}</td>
			<td>${dept.deptName}</td>			
			<td>${dept.deptLocation}</td>
			<td>
		<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>LOCATIOIN</th>
		</tr>
		<c:forEach var="employee" items="${dept.employees}">
		<tr>	
			<td>${employee.empId}</td>
			<td>${employee.name}</td>			
			<td>${employee.salary}</td>			
			</tr>
			</c:forEach>
	</table>
	</td>
	</tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>

