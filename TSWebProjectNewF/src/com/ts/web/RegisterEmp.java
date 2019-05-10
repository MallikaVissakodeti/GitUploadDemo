package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Dept;
import com.ts.dto.Employee;
import com.ts.dto.Hobbies;

@WebServlet("/RegisterEmp")
public class RegisterEmp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String job = request.getParameter("job");
		String hobbies[] = request.getParameterValues("hobbies");
		List<String> hobbiesList = Arrays.asList(hobbies);
	
		String joinDate = request.getParameter("joinDate");
		
		String user = request.getParameter("uid");
		String pass = request.getParameter("pwd");		
		
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		
		java.util.Date utilJoinDate;
		try {
			utilJoinDate = new SimpleDateFormat("yyyy-MM-dd").parse(joinDate);
			System.out.println(utilJoinDate);
			Dept dept = new Dept();
			dept.setDeptId(deptId);			
			
			Employee employee = new Employee();		
			EmployeeDAO employeeDao = new EmployeeDAO();
			employee.setName(name);
			employee.setSalary(salary);
			employee.setJob(job);
			employee.setUserName(user);
			employee.setPassword(pass);
			employee.setJoinDate(utilJoinDate);
			employee.setDept(dept);
			
			for(String hb:hobbiesList) {
			employee.getHobbyies().add(new Hobbies(hb));
			}
			/*
			Hobbies hobbie1 = new Hobbies(hobbies[0]);
			Hobbies hobbie2 = new Hobbies(hobbies[1]);
			Hobbies hobbie3 = new Hobbies(hobbies[2]);
			
			employee.getHobbyies().add(hobbie1);
			employee.getHobbyies().add(hobbie2);
			employee.getHobbyies().add(hobbie3); */
					
			int x = employeeDao.register(employee);
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		  out.println("<h3><CENTER>Registration Success .."+x+" Rows inserted...</CENTER></H3>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

