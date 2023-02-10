package jpa.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO{

	@Override
	public List<Student> getAllStudents() {
		Session session = null;
		Transaction transaction = null;
		List<Student> students = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			students = session.getNamedQuery("GetAllStudents").getResultList();
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = null;
		Transaction transaction = null;
		Student student = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			student = session.get(Student.class, email);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}


	@Override
	public boolean validateStudent(String email, String password) {
		Session session = null;
		Transaction transaction = null;
		List<Student> students = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			students = session.createNamedQuery("ValidateStudent", Student.class)
						.setParameter("email", email)
						.setParameter("password", password)
						.getResultList();
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (students.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void registerStudentToCourse(Student s, Course c) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			s.addCourse(c);
			session.update(s);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Set<Course> getStudentCourses(String email) {
		return getStudentByEmail(email).getsCourses();
	}

}
