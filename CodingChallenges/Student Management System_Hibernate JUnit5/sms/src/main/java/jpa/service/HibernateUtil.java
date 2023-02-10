package jpa.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// Singleton pattern
	private static final SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
