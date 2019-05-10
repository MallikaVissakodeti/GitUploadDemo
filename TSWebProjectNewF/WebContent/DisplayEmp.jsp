<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
		   Employee employee = (Employee)request.getAttribute("employeeData");
			out.println("<table border=2 align=center>");
			out.println("<tr>");
			out.println("<th>ID</th><th>NAME</th><th>SALARY</th><th>JOB</th><th>USER NAME</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+employee.getId()+"</td><td>"+employee.getName()+"</td><td>"+employee.getSalary()+"</td><td>"+employee.getJob()+"</td><td>"+employee.getUserName()+"</td>");
			out.println("</tr>");
			out.println("</table>");*/
	%>
	<!-- 
	<jsp:useBean id="employeeData" class="com.ts.dto.Employee"
		scope="request" />
	<table border=2 align=center>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>JOB</th>
			<th>USER NAME</th>
		</tr>
		<tr>
			<td><%=employeeData.getEmpId()%></td>
			<td><%=employeeData.getName()%></td>
			<td><%=employeeData.getSalary()%></td>
			<td><%=employeeData.getJob()%></td>
			<td><%=employeeData.getUserName()%></td>
		</tr>
	</table>
 -->
 
 	<table border=2 align=center>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>JOB</th>
			<th>USER NAME</th>
			<th>DEPT ID</th>
			<th>DEPT NAME</th>
			<th>DEPT LOCATION</th>
		</tr>
		<tr>
			<td>${employeeData.empId}</td>
			<td>${employeeData.name}</td>
			<td>${employeeData.salary}</td>
			<td>${employeeData.job}</td>
			<td>${employeeData.userName}</td>
			<td>${employeeData.dept.deptId}</td>
			<td>${employeeData.dept.deptName}</td>
			<td>${employeeData.dept.deptLocation}</td>
		</tr>
	</table>
  

</body>
</html>






