package org.example.hib.controller;

import java.util.List;

import javax.persistence.TypedQuery;
import org.example.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUser_HQL {
	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User"; // Example of HQL to get all records of user class
		TypedQuery<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	public void findUserSelect() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		/* ------------ Example of HQL to get all the records------- */
		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql);
		List<User> list = query.getResultList();

		for (User u : list) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());

		}
	}

	public void getRecordbyId(int record_no) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User E WHERE E.id > " + record_no + " ORDER BY E.salary DESC";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() + "|" + "Email: "
					+ u.getEmail() + "|" + "password" + u.getPassword());
		}
	}

	public void getRecords() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		TypedQuery<Object[]> queryy = session.createQuery("SELECT U.salary, U.fullname FROM User AS U", Object[].class);
		List<Object[]> resultss = queryy.getResultList();
		for (Object[] a : resultss) {
			System.out.println("Salary: " + a[0] + ", City: " + a[1]);
		}
	}

	public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT max(U.salary) FROM User U";
		TypedQuery query = session.createQuery(hql);
		Double result = (Double) query.getSingleResult();
		System.out.println(result);
	}

	public void getRowCount() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT COUNT(*) FROM User U";
		TypedQuery query = session.createQuery(hql);
		List results = session.createQuery(hql).getResultList();
		System.out.println(results);

	}

	public void getmaxSalaryGroupBy() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
		TypedQuery query = session.createQuery(hql);
		List<Object[]> result = query.getResultList();
		for (Object[] o : result) {
			System.out.println("Total salary " + o[0] + " | city: " + o[1]);
		}
	}

}
