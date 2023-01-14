package org.example.hib.controller;

import org.example.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.get(User.class, 3);
		//u.setId(3);
		u.setEmail("mhaseeb@perscholas");
		u.setFullname("M haseeb");
		u.setPassword("123456");
		session.update(u);
		session.getTransaction().commit();
		session.close();
	}
}

