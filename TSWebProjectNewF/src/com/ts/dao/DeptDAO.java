package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Dept;

public class DeptDAO {
	private SessionFactory factory = null;
	
	public int register(Dept dept) {		
		return HibernateTemplate.addObject(dept);
	}

	public Dept getDept(int deptId) {
		return (Dept)HibernateTemplate.getObject(Dept.class,deptId);
	}

	public List<Dept> getAllDepts() {
		List<Dept> depts=(List)HibernateTemplate.getObjectListByQuery("From Dept");
		return depts;	
	}
}