package com.perscholas.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.perscholas.model.Person;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
	@Test
	public void testPersonLookUp() {
		
	   	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction t = session.beginTransaction();   
    	
		//======================== 
    	// GOAL:   Test that a Person Object exists in the database
    	// with name="Bill Board"   	
    	//=========================
    	
		String myquery="SELECT * FROM Person WHERE name ='Bill Board' ";
	    List<Object[]> details = session.createNativeQuery(myquery).list();
	         for (Object[] objects : details) {
	            Integer person_id=(Integer)objects[0];
	            Integer age=(Integer)objects[1];
	            String email=(String)objects[2];
	            String name=(String)objects[3];
	            Person testPerson = new Person();
	            testPerson.setName("Bill Board");
	            assertEquals(name, testPerson.getName());
	            System.out.println("person_id="+person_id+" age="+age+" email="+email+" name= "+name);
	         }	
	    
		session.close();
		System.out.println("Session Closed");
	}
	
	@Test
	public void testAddressLookUp() {
		//======================== 
    	// GOAL:   Test that a Address Object exists in the database
    	// with city="nyc"   	
    	//=========================
	   	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction t = session.beginTransaction();   
    	
		String myquery="SELECT * FROM address WHERE city = 'nyc' ";
	    List<Object[]> details = session.createNativeQuery(myquery).list();
	         for (Object[] objects : details) {

	        	Integer expectedAddressID = (Integer) objects[0];
	            String expectedCity = (String) objects[1];
	            String expectedState = (String) objects[2];
	            String expectedStreet = (String) objects[3];
	            Integer expectedZipCode = (Integer) objects[4];
	            
	        	Address actualAddress = new Address();
	            actualAddress.setCity("NYC");
	            assertEquals(expectedCity.toLowerCase(), actualAddress.getCity().toLowerCase());
	            System.out.println("Address ID = " + expectedAddressID
	    	            +"\nCity = " + expectedCity
	    	            +"\nState = " + expectedState
	    	            +"\nStreet = " + expectedStreet
	    	            +"\nZip code = " + expectedZipCode);
	         }	
	    
		session.close();
		System.out.println("Session Closed");
	
	}
}
