<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.Employee,java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MgrHomePage.jsp"></jsp:include>
<form action="DisplayDept" method="POST">
Enter Dept id :<input type="text" name="deptId"><br/>
<input type="submit" value="LOGIN">
</form>
</body>
</html>