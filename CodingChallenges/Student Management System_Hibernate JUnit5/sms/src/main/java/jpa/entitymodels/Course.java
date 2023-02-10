package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int cId;

	@Column(name = "name", nullable = false, length = 50)
	private String cName;

	@Column(name = "instructor", nullable = false, length = 50)
	private String cInstructorName;

	public Course() {
		this.cId = -1;
		this.cName = "Course Name TBD";
		this.cInstructorName = "Instructor TBD";
	}

	public Course(int cId, String cName, String cInstructorName) {
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 5;
		result = prime * result + cId;
		result = prime * result + (cInstructorName == null ? 0 : cInstructorName.hashCode());
		result = prime * result + (cName == null ? 0 : cName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ((obj == null) || (getClass() != obj.getClass())) return false;
		Course other = (Course) obj;

		if (this.cId != other.cId) return false;
		if (!this.cName.equals(other.cName)) return false;
		if (!this.cInstructorName.equals(other.cInstructorName)) return false;

		return true;
	}
}
