package com.test.project.CrunchifyJunitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    //@Test
    //public void shouldAnswerWithTrue()
    //{
    //    assertTrue( true );
    //}
    
    @Test
	public void testStudent() {
		Student a = new Student();
		a.setId(1);
		a.setEmail("mgabriel@perscholas.org");
		a.setfName("Mike");
		a.setlName("Gabriel");
		
		//Student b = a;  //why does this return true even without overriding?
		//In this case, by assigning Student a to Student b, values are passed by reference
		//so both Student a and Student b point to the exact same object location in memory.
		//The original equals method tests for this type of identity with non-primitives.
		//The override method was written to explicitly compare different student objects that
		// hold the same values for the Student attributes whether they are from the same object or not. 
		
		
		Student b = new Student();
		b.setId(1);
		b.setEmail("mgabriel@perscholas.org");
		b.setfName("Mike");
		b.setlName("Gabriel");		
		
		assertEquals(a, b);
	}
}
