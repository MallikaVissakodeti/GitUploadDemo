package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.db.MyConnection;
import com.ts.dto.Employee;

public class EmployeeDAOJ {

		public Employee getEmployee(String user, String pass) {
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			Employee employee = null;
			final String SELECT_QUERY="select * from employee where userName= ? and password = ?";
			con = MyConnection.getConnection();
			try {
				pst = con.prepareStatement(SELECT_QUERY);
				pst.setString(1, user);
				pst.setString(2, pass);
				rs = pst.executeQuery();
				if(rs.next()) {
					employee = new Employee();
					employee.setEmpId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setJob(rs.getString(4));
					employee.setUserName(rs.getString(5));		
					employee.setPassword(rs.getString(6));		
				}
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
			return null;		
		}

		public int register(Employee employee) {
			Connection con = null;
			PreparedStatement pst = null;
			final String INSERT_QUERY="insert into employee(name,salary,job,userName,password,deptId) values(?,?,?,?,?,?)";
			con = MyConnection.getConnection();
			int x = 0;
			try {
				pst = con.prepareStatement(INSERT_QUERY);
				pst.setString(1, employee.getName());
				pst.setDouble(2, employee.getSalary());
				pst.setString(3, employee.getJob());
				pst.setString(4, employee.getUserName());
				pst.setString(5, employee.getPassword());
				pst.setInt(6, employee.getDept().getDeptId());
				x = pst.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return 0;		
			
		}

		public Employee getEmployee(int id) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			final String SELECT_QUERY="select * from employee e inner join department d where e.deptId = d.DEPT_ID and e.id = ?";
			con = MyConnection.getConnection();
			Employee employee = null;
			try {
				pst = con.prepareStatement(SELECT_QUERY);
				pst.setInt(1, id);			
				rs = pst.executeQuery();
				if(rs.next()) {
					employee = new Employee();
					employee.setEmpId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setJob(rs.getString(4));
					employee.setUserName(rs.getString(5));
					employee.getDept().setDeptId(rs.getInt(7));
					employee.getDept().setDeptName(rs.getString(9));
					employee.getDept().setDeptLocation(rs.getString(10));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return null;		
		}

		public List<Employee> getEmployeesByDept(int deptId) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			final String SELECT_QUERY="select * from employee where deptId = ?";
			con = MyConnection.getConnection();
			List<Employee> arrayList = new ArrayList<Employee>();
			try {
				pst = con.prepareStatement(SELECT_QUERY);
				pst.setInt(1, deptId);			
				rs = pst.executeQuery();
				while(rs.next()) {
					Employee employee = new Employee();
					employee.setEmpId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setJob(rs.getString(4));
					employee.setUserName(rs.getString(5));	
					arrayList.add(employee);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;		
		}
		public List<Employee> getAllEmployees() {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			final String SELECT_QUERY="select * from employee";
			con = MyConnection.getConnection();
			List <Employee> arrayList=new ArrayList<Employee>();
			try {
				pst = con.prepareStatement(SELECT_QUERY);			
				rs = pst.executeQuery();
				while(rs.next()) {
					Employee employee = new Employee();
					employee.setEmpId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setJob(rs.getString(4));
					employee.setUserName(rs.getString(5));	
					arrayList.add(employee);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return null;	
		}

}
