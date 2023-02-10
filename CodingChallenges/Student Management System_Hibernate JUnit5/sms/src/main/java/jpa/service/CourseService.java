package jpa.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO{
	@Override
	public Set<Course> getAllCourses() {
		Session session = null;
		Transaction transaction = null;
		List<Course> courses = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			courses = session.getNamedQuery("GetAllCourses").getResultList();
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		Set<Course> cS = new HashSet<>(courses);
		return cS;

	}

}
