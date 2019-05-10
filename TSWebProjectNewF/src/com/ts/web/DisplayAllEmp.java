package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;

@WebServlet("/DisplayAllEmp")
public class DisplayAllEmp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> arrayList = employeeDAO.getAllEmployees();

		HttpSession session = request.getSession();
		System.out.println(session.getId()); 
	
		request.setAttribute("employeesData", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllEmp.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}