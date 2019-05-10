<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = (String) session.getAttribute("user");
	%>

<body bgcolor=yellow text=green>
	<h3>
		Hi <%=user %>
		<center>
			<h2>WELCOME TO EMPLOYEE HOME PAGE</h2>
		</center>
		<hr>
		<h3>
			<center>
				<a href='DisplayProfile'>Display Profile</a>
			</center>
		</h3>
</body>

</body>
</html>