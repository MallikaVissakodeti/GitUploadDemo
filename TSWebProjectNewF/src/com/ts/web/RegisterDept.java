package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.DeptDAO;
import com.ts.dto.Dept;

@WebServlet("/RegisterDept")
public class RegisterDept extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		Dept dept = new Dept(name,location);
		DeptDAO deptDao = new DeptDAO();
		int x = deptDao.register(dept);
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
		out.println("<h3><CENTER>Registration Success .."+x+" Rows inserted...</CENTER></H3>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
