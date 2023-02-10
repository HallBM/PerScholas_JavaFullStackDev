/**
 *
 */
package jpa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

@TestMethodOrder(OrderAnnotation.class)
class StudentServiceTest {
	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	private static StudentService sServ;
	private static Student testStudent1, testStudent2;
	private static Course testCourse1, testCourse2;
	private static Set<Course> testCourseSet;
	private static List<Student> testStudentList;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// src/test/resources contains a Hibernate config file that specifies a new test database (sms_sba_test)
		factory = new Configuration().configure().buildSessionFactory();

		// create student service object for access to methods
		sServ = new StudentService();

		// create 2 courses
		testCourse1 = new Course(1, "Math", "Todd Vine");
		testCourse2 = new Course(2, "Science", "Rebecca Ball");

		// create 2 course set containing both courses
		testCourseSet = new HashSet<>();
		testCourseSet.add(testCourse1);
		testCourseSet.add(testCourse2);

		// create 2 students, one without classes and one with classes
		testStudent1 = new Student("bh@gmail.com", "Brandon Hall", "abc123");
		testStudent2 = new Student("ab@gmail.com", "Adam Brink", "pass123", testCourseSet);
		
		// create list of students
		testStudentList = new ArrayList<>();
		testStudentList.add(testStudent1);
		testStudentList.add(testStudent2);

		// add courses and students to tables
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		session.save(testCourse1);
		session.save(testCourse2);
		session.save(testStudent1);
		session.save(testStudent2);

		transaction.commit();
		session.close();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session = factory.openSession();
		transaction = session.beginTransaction();

		session.createNativeQuery("DROP TABLE students_courses").executeUpdate();
		session.createNativeQuery("DROP TABLE hibernate_sequence").executeUpdate();
		session.createNativeQuery("DROP TABLE students").executeUpdate();
		session.createNativeQuery("DROP TABLE courses").executeUpdate();

		transaction.commit();
		session.close();
		factory.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		session = factory.openSession();
		transaction = session.beginTransaction();
	}

	@AfterEach
	void tearDown() throws Exception {
		transaction.rollback();
		session.close();
	}

	@Test
	@Order(1)
	void testGetStudentByEmail() {

		System.out.println("Testing getStudentByEmail");

		// Find test student using email
		Student expected1 = testStudent1;
		Student actual1 = sServ.getStudentByEmail(testStudent1.getsEmail());
		Assertions.assertEquals(expected1, actual1, "Student lookup for existing email was not successful");
		Assertions.assertNotNull(actual1);

		// Return null if email doesn't exist in database
		Student actual2 = sServ.getStudentByEmail("NotAnEmail@gmail.com");
		Assertions.assertNull(actual2, "Student lookup for an email not in the database returns null");
	}

	@Test
	@Order(2)
	void testValidateStudents() {

		System.out.println("Testing validateStudents");

		// Validate existing student
		Boolean actual1 = sServ.validateStudent(testStudent1.getsEmail(),testStudent1.getsPass());
		Assertions.assertTrue(actual1, "Student validation was not successful");

		// Wrong email and password
		Boolean actual2 = sServ.validateStudent("NotAnEmail@gmail.com", "Not A Password");
		Assertions.assertFalse(actual2, "Student validated with wrong email and password");

		// Wrong email
		Boolean actual3 = sServ.validateStudent("NotAnEmail@gmail.com",testStudent1.getsPass());
		Assertions.assertFalse(actual3, "Student validated with wrong email");

		// Wrong password
		Boolean actual4 = sServ.validateStudent(testStudent1.getsEmail(), "Not A Password");
		Assertions.assertFalse(actual4, "Student validated with wrong password");
	}

	@Test
	@Order(3)
	void testGetStudentCourses() {

		System.out.println("Testing getStudentCourses");

		// Student (testStudent1) without registered courses returns null
		Set<Course> expected1 = testStudent1.getsCourses();
		Set<Course> actual1 = sServ.getStudentCourses(testStudent1.getsEmail());
		Assertions.assertEquals(expected1, actual1);
		Assertions.assertTrue(actual1.isEmpty());

		// Student (testStudent2) with registered courses returns courses
		Set<Course> expected2 = testStudent2.getsCourses();
		Set<Course> actual2 = sServ.getStudentCourses(testStudent2.getsEmail());
		Assertions.assertEquals(expected2, actual2);
		Assertions.assertFalse(actual2.isEmpty());
	}

	@Test
	@Order(4)
	void testRegisterStudentToCourse() {

		System.out.println("Testing RegisterStudentToCourse");

		// Student (testStudent1) without registered courses, will add registered course
		Set<Course> expected1 = new HashSet<>();
		expected1.add(testCourse1);
		sServ.registerStudentToCourse(testStudent1, testCourse1);
		Set<Course> actual1 = testStudent1.getsCourses();
		Assertions.assertEquals(expected1, actual1);
		
		// Student (testStudent2) with registered courses should not change and not throw an error (session.update() used)
		Set<Course> expected2 = testCourseSet;
		sServ.registerStudentToCourse(testStudent2, testCourse1);
		Set<Course> actual2 = testStudent2.getsCourses();
		Assertions.assertEquals(expected2, actual2);
	}
	
	@Test
	@Order(5)
	void testGetAllStudents() {

		System.out.println("Testing getAllStudents");

		List<Student> expected = testStudentList;
		List<Student> actual = sServ.getAllStudents();

		Comparator<Student> compStudentEmail = new Comparator<>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getsEmail().compareTo(s2.getsEmail()) < 0 ? -1 : 1;
			}
		};
		
		Collections.sort(expected, compStudentEmail);
		Collections.sort(actual, compStudentEmail);		
		
		Assertions.assertIterableEquals(expected, actual);
		Assertions.assertNotSame(expected, actual);
		Assertions.assertFalse(actual.isEmpty());
	}
}
