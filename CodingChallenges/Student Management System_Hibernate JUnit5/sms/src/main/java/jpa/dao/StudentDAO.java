package jpa.dao;

import java.util.List;
import java.util.Set;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {

	public List<Student> getAllStudents();

	public Student getStudentByEmail(String email);

	public boolean validateStudent(String email, String password);

	public void registerStudentToCourse(Student student, Course course);

	public Set<Course> getStudentCourses(String email);

}
