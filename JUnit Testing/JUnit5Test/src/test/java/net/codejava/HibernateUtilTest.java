package net.codejava;

//
// https://codejava.net/testing/junit-5-tutorial-for-beginner-test-crud-for-hibernate
//

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class HibernateUtilTest {

	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory created");
	}
	
	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null) sessionFactory.close();
		System.out.println("SessionFactory destroyed");
	}
	
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");
	}
	
	@AfterEach
	public void closeSession() {
		if (session != null) session.close();
		System.out.println("Session closed\n");
	}
	
	@Test
	@Order(1)
	public void testCreate() {
		System.out.println("Running testCreate...");
		
		session.beginTransaction();
		
		Product product = new Product("iPhone 10", 699);
		Integer id = (Integer) session.save(product);
		
		session.getTransaction().commit();
		
		Assertions.assertTrue(id > 0);
	}
	
	//  What YOU NEED TODO::
	// Write code for the testUpdate() method:
	//
	@Test
	@Order(4)
	public void testUpdate() {
		System.out.println("Running testUpdate...");
		
		//  YOUR CODE HERE!!
		/**
		 * Test 1 creates product table in database
		 * Test 2 inserts an entry into the product table (id=1)
		 * Test 3 attempts to retrieve data from table using non-existent id (returns null)
		**/
		Integer id = 1;
		
		// Pull details of entry that needs to be updated
		Product product = session.find(Product.class, id);
		String old_name = product.getName();
		Integer old_id = product.getId();
		Float old_price = product.getPrice();
		String new_name = "Google Pixel 7 Pro";
		
		// Update product entry
		product.setName(new_name);
		
		// Update database table; commit changes
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		
		// Retrieve new data from database table
		Product actualproduct = session.find(Product.class, id);
		
		// Testing the same thing in two ways: make sure name from database equals new name and not old name
		assertEquals(new_name, actualproduct.getName());
	    assertNotEquals(old_name, actualproduct.getName());
	    
	    System.out.println("OLD ENTRY: prod_id = " + old_id 
	      				 + " name = " + old_name 
	       				 + " price = $" + old_price.intValue() + ".00");
	    System.out.println("NEW ENTRY: prod_id = " + actualproduct.getId() 
	    				 + " name = " + actualproduct.getName() 
       				 	 + " price = $" + (int)actualproduct.getPrice() + ".00");
	     }	
		
	@Test
	@Order(2)
	public void testGet() {
		System.out.println("Running testGet...");
		
		Integer id = 1;
		
		Product product = session.find(Product.class, id);
		
		assertEquals("iPhone 10", product.getName());		
	}
	
	@Test
	@Order(3)
	public void testGetNotExist() {
		System.out.println("Running testGetNotExist...");
		
		Integer id = 10;
		
		Product product = session.find(Product.class, id);
		
		Assertions.assertNull(product);
	}		

	@Test
	@Order(5)
	public void testList() {
		System.out.println("Running testList...");
		
		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> resultList = query.getResultList();
		
		Assertions.assertFalse(resultList.isEmpty());
	}
	
	@Test
	@Order(6)
	public void testDelete() {
		System.out.println("Running testDelete...");
		
		Integer id = 1;
		Product product = session.find(Product.class, id);
		
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		
		Product deletedProduct = session.find(Product.class, id);
		
		Assertions.assertNull(deletedProduct);
	}	
}
