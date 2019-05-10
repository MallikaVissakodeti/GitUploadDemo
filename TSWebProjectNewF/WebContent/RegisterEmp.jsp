<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dao.DeptDAO,java.util.List,com.ts.dto.Dept"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="MgrHomePage.jsp"></jsp:include>
<%
DeptDAO deptDao = new DeptDAO();
List<Dept> deptList = deptDao.getAllDepts();
request.setAttribute("deptList", deptList);
%>
<form action="RegisterEmp" method="POST">
Enter name :<input type="text" name="name"><br/>
Enter salary :<input type="text" name="salary"><br/>
Enter job :<input type="text" name="job"><br/>
Enter user id :<input type="text" name="uid"><br/>
Enter password :<input type="password" name="pwd"><br/>
<input type="checkbox" name="hobbies" value="WhatsApp"> Whats App<br>
  <input type="checkbox" name="hobbies" value="Games"> Games<br>
  <input type="checkbox" name="hobbies" value="Movies" checked> Movies
Enter Date of Join: <input type="date" name="joinDate">
Select Department : <select name="deptId">
<c:forEach var="dept" items="${deptList}">
<option value="${dept.deptId}">${dept.deptName}</option>
</c:forEach>
</select>
<input type="submit" value="LOGIN">
</form>
</body>
</html>