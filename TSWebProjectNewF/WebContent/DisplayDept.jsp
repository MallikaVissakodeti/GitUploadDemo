<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.Employee"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MgrHomePage.jsp"></jsp:include>
 	<table border=2 align=center>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>LOCATION</th>
			<th>EMP ID</th>
			<th>EMP NAME</th>
			<th>SALARY</th>
			<th>JOB</th>
			<th>USER NAME</th>
		</tr>
		<tr>
			<td>${deptData.deptId}</td>
			<td>${deptData.deptName}</td>
			<td>${deptData.deptLocation}</td>		
			<td colspan=5>
			<table border=2 align=center>			
			<c:forEach var="employee" items="${deptData.employees}">
			<tr>
			<td>${employee.empId}</td>
			<td>${employee.name}</td>
			<td>${employee.salary}</td>
			<td>${employee.job}</td>
			<td>${employee.userName}</td>
			</tr>
			</c:forEach>			
			</table>
			
			</td>
		</tr>
	</table>
  

</body>
</html>






