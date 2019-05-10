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

@WebServlet("/DisplayDept")
public class DisplayDept extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		DeptDAO deptDao = new DeptDAO();
		Dept dept = deptDao.getDept(deptId);
		System.out.println("Inside Display Dept"+dept);
		request.setAttribute("deptData", dept);		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayDept.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
