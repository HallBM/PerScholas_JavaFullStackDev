package org.example.employeecontroller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeController {
	public void createEmployeeTable() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		Employee e1 = new Employee();
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

	public void findEmployeeByname(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// ------------ Hibernate Named Query -------------
		TypedQuery query = session.getNamedQuery("findEmployeeByName");
		query.setParameter("name", name);
		List<Employee> employees = query.getResultList();
		Iterator<Employee> itr = employees.iterator();
		while (itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e);
		}
		factory.close();
		session.close();
	}

	public void findEmployeeById(int id_no) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// ------------ Hibernate Named Query -------------
		TypedQuery query = session.getNamedQuery("get_Emp_name_by_id");
		query.setParameter("id", id_no);
		List<Object[]> emName = query.getResultList();
		for (Object[] o : emName) {
			System.out.println("Employee name: " + o[0] + " | Employee Salary: " + o[1] + " | Emp Job Title: " + o[2]);
		}
		factory.close();
		session.close();
	}

	public void ShowOfficeCodes_AsDepartment() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// ------------ Hibernate Named Query -------------
		TypedQuery query = session.getNamedQuery("empDepAlias");
		List<Object[]> list = query.getResultList();
		for (Object[] e : list) {
			System.out.println("OfficeCode: " + e[0] + " | Dep Name: " + e[2] + " | Employee Name: " + e[1]);
		}
		factory.close();
		session.close();
	}
	
	public void findAllEmployees() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// ------------ Hibernate Named Query -------------
		TypedQuery query = session.getNamedQuery("getallEmployee");
		List<Employee> list = query.getResultList();
		for (Employee e : list) {
			System.out.println(e);
			//System.out.println("Employee name: " + e.getName() + " | Employee Salary: " + e.getSalary() + " | Emp Job Title: " + e.getJob());
		}
		factory.close();
		session.close();
	}
	
}
