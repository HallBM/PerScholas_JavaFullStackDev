package com.test.project.CrunchifyJunitTest;


public class Student {

	public Student() { }
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	private long id;
	private String Email;
	private String fName;
	private String lName;
	
	// WHAT You need TODO:  Implement the equals @Override method
	
	
	
	/*
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this) return true;
		
		if (!(obj instanceof Student)) return false; 
		
		Student other = (Student) obj;
		
		if (this.getId() != other.getId()) return false;
		if (this.getEmail() != other.getEmail()) return false;
		if (this.getfName() != other.getfName()) return false;
		if (this.getlName() != other.getlName()) return false;
				
		return true;
	}
	 */
}