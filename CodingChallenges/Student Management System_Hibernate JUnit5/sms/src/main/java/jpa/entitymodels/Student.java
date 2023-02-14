package jpa.entitymodels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@NamedQueries({
	@NamedQuery( name="GetAllStudents", query="FROM Student"),
	@NamedQuery( name="ValidateStudent", query="FROM Student WHERE sEmail = :email AND sPass = :password"),
	@NamedQuery( name="GetAllCourses", query="FROM Course"),
	@NamedQuery( name="GetStudentCourses",
				query="SELECT sCourses FROM Student where sEmail = :email")})

public class Student {

	@Id
	@Column(name = "email", length = 50, unique = true)
	private String sEmail;

	@Column(name = "name", nullable = false, length = 50)
	private String sName;

	@Column(name = "password", nullable = false, length = 50)
	private String sPass;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity=Course.class, cascade = {CascadeType.ALL})
	private Set<Course> sCourses;

	public Student() {
		this.sEmail = "no email provided";
		this.sName = "default name";
		this.sPass = "password";
		this.sCourses = new HashSet<>();
	}

	public Student(String sEmail, String sName, String sPass) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = new HashSet<>();
	}

	public Student(String sEmail, String sName, String sPass, Set<Course> sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public Set<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(Set<Course> sCourses) {
		this.sCourses = sCourses;
	}

	//ADDED
	public void addCourse(Course course) {
			this.sCourses.add(course);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (sEmail == null ? 0 : sEmail.hashCode());
		result = prime * result + (sPass == null ? 0 : sPass.hashCode());
		result = prime * result + (sName == null ? 0 : sName.hashCode());
		result = prime * result + (sCourses == null ? 0 : sCourses.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ((obj == null) || (getClass() != obj.getClass())) return false;
		Student other = (Student) obj;

		if (!this.sEmail.equals(other.sEmail)) return false;
		if (!this.sName.equals(other.sName)) return false;
		if (!this.sPass.equals(other.sPass)) return false;
		if (!this.sCourses.equals(other.sCourses)) return false;

		return true;
	}
}
