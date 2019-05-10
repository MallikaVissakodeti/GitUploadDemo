package com.ts.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@Column(length=25)
	private String name;
	@Column(length=25)
	private double salary;
	@Column(length=25)
	private String job;
	@Column(length=25)
	private String userName;
	@Column(length=25)
	private String password;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date joinDate;
	
	@ElementCollection
	@JoinTable(name="Hobbies",joinColumns=@JoinColumn(name="EMP_ID"))
	private List<Hobbies> hobbyies =new ArrayList<Hobbies>();
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept dept;
	
	
	public Employee() {
		super();	
	}
	
	public Employee(int empId, String name, double salary, String job, String userName, String password, Date joinDate,
			List<Hobbies> hobbyies, Dept dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.job = job;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
		this.hobbyies = hobbyies;
		this.dept = dept;
	}


	public Employee(String name, double salary, String job, String userName, String password, Date joinDate,
			List<Hobbies> hobbyies, Dept dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.job = job;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
		this.hobbyies = hobbyies;
		this.dept = dept;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.util.Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(java.util.Date joinDate) {
		this.joinDate = joinDate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Hobbies> getHobbyies() {
		return hobbyies;
	}

	public void setHobbyies(List<Hobbies> hobbyies) {
		this.hobbyies = hobbyies;
	}
}
