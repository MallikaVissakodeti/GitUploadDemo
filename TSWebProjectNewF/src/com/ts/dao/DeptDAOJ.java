package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.MyConnection;
import com.ts.dto.Dept;
import com.ts.dto.Employee;

public class DeptDAOJ {
	private SessionFactory factory = null;
	
	public int register(Dept dept) {
		Connection con = null;
		PreparedStatement pst = null;
		final String INSERT_QUERY="insert into DEPARTMENT(DEPT_NAME,LOC) values(?,?)";
		con = MyConnection.getConnection();
		int x = 0;
		try {
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, dept.getDeptName());
			pst.setString(2, dept.getDeptLocation());
			
			x = pst.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;		
	}

	public Dept getDept(int deptId) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Dept dept = null;
		final String QUERY_DEPT="select * from DEPARTMENT where DEPT_ID = ?";
		final String QUERY_EMPLOYEE="select * from EMPLOYEE where deptId = ?";
		con = MyConnection.getConnection();
		try {
			pst1 = con.prepareStatement(QUERY_DEPT);
			pst1.setInt(1, deptId);			
			rs1 = pst1.executeQuery();
			if(rs1.next()) {
				dept = new Dept();
				dept.setDeptId(rs1.getInt(1));
				dept.setDeptName(rs1.getString(2));
				dept.setDeptLocation(rs1.getString(3));				
			}
			pst2 = con.prepareStatement(QUERY_EMPLOYEE);
			pst2.setInt(1, deptId);			
			rs2 = pst2.executeQuery();
			while(rs2.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs2.getInt(1));
				employee.setName(rs2.getString(2));
				employee.setSalary(rs2.getDouble(3));
				employee.setJob(rs2.getString(4));
				employee.setUserName(rs2.getString(5));
				System.out.println(employee);
				dept.getEmployees().add(employee);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Inside DEPT DAO"+dept);
		return null;		
	}

	public List<Dept> getAllDepts() {
				
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		final String SELECT_QUERY="select * from DEPARTMENT";
		con = MyConnection.getConnection();
		List <Dept> list=new ArrayList<Dept>();
		try {
			pst = con.prepareStatement(SELECT_QUERY);			
			rs = pst.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptId(rs.getInt(1));
				dept.setDeptName(rs.getString(2));
				dept.setDeptLocation(rs.getString(3));
				EmployeeDAOJ employeeDao = new EmployeeDAOJ();
				dept.setEmployees(employeeDao.getEmployeesByDept(dept.getDeptId()));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;	
	}
}