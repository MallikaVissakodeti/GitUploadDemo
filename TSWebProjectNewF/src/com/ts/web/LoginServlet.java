package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("uid");
		String pass = request.getParameter("pwd");
		
		
		EmployeeDAO employeeDao = new EmployeeDAO();
		Employee employee = employeeDao.getEmployee(user);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("pass", pass);
		session.setAttribute("empId", employee.getEmpId());
		System.out.println(session.getId()); 
		out.print("<html>");		
		if(employee!=null){
			
			if(employee.getJob().equalsIgnoreCase("MANAGER")) {
				RequestDispatcher rd = request.getRequestDispatcher("MgrHomePage.jsp");
				rd.include(request, response);	
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
				rd.forward(request, response);
			}
			
		}
		else
		{
			out.print("<body>");
			out.print("<center><h1>Invalid Credentials..</h1></center>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.print("</body>");			
		}
		out.println("</html>");		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
