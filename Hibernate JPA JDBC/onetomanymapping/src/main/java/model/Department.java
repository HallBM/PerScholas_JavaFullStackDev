package model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;

	@OneToMany(targetEntity = Teacher.class, cascade = { CascadeType.ALL })
	private Set<Teacher> teacherList;

	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public Department() {

	}

	public Set<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(Set<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public void addTeacher(Teacher t) {
		this.teacherList.add(t);
	}
		
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
