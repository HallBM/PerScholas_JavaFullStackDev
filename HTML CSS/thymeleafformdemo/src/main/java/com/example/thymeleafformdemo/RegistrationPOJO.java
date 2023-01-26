 package com.example.thymeleafformdemo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistrationPOJO {

	private String fname;
    private String lname;
    private String dob;
    private String phoneno;
    private String jobtitle;
    private String company;
    
    public RegistrationPOJO() {}
	
    public RegistrationPOJO(String fname, String lname, String dob, String phoneno, String jobtitle, String company) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.phoneno = phoneno;
		this.jobtitle = jobtitle;
		this.company = company;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	                          
	
}
