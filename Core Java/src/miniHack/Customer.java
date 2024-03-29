package miniHack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
	private String first_name;
	private String last_name;
	private String company_name;
	private String address;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String phone1;
	private String phone2;
	private String email;
	private String web;
	
	//The system displays the customer's information: name, street, city, zip, phone, email.
	@Override
	public String toString() {
		return String.format("Name: %s %s\nStreet: %s\nCity: %s\nZip: %s\nPhone #s: %s and %s\nEmail: %s",this.getFirst_name(), this.getLast_name(), 
				this.getAddress(), this.getCity(), this.getZip(), this.getPhone1(), this.getPhone2(), this.getEmail());
	}
	
	public Customer(String first_name, String last_name, String company_name, String address, String city,
			String county, String state, String zip, String phone1, String phone2, String email, String web) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.company_name = company_name;
		this.address = address;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
	}
	
	public Customer(String line) {
		// TODO update overloaded constructor function to parse string, validate field inputs, and assign variables to Customer object
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	
	
}
