package jpa.entitymodels;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class ModelsTest {
	private static Course testCourse1, testCourse2, testCourse3;
	private static Set<Course> testCourseSet1, testCourseSet2, testCourseSet3;
	private static Student testStudent1, testStudent2, testStudent3, testStudent4, testStudent5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Courses (#1 and #3 have equivalent values but are different objects in memory)
		testCourse1 = new Course(1, "Math", "Todd Vine");
		testCourse2 = new Course(2, "Science", "Rebecca Ball");
		testCourse3 = new Course(1, "Math", "Todd Vine"); // same values as testCourse1
	
		//Course Sets (#2 and #3 have equivalent values but constructed from different objects in memory)
		testCourseSet1 = new HashSet<>();
		testCourseSet1.add(testCourse1);
		
		testCourseSet2 = new HashSet<>();
		testCourseSet2.add(testCourse1);
		testCourseSet2.add(testCourse2);
		
		testCourseSet3 = new HashSet<>();
		testCourseSet3.add(testCourse2);
		testCourseSet3.add(testCourse3); 
		
		// Students (#4 and #5 have equivalent values but constructed from different objects in memory)
		testStudent1 = new Student("bh@gmail.com", "Brandon Hall", "abc123");
		testStudent2 = new Student("ab@gmail.com", "Adam Brink", "pass123");
		testStudent3 = new Student("ab@gmail.com", "Adam Brink", "pass123", testCourseSet1);
		testStudent4 = new Student("ab@gmail.com", "Adam Brink", "pass123", testCourseSet2);  
		testStudent5 = new Student("ab@gmail.com", "Adam Brink", "pass123", testCourseSet3);
	}

	@Test
	void courseEqualsOverrideTest() {
		System.out.println("Testing equals override for Course class");
		Assertions.assertNotEquals(testCourse1, testCourse2);
		Assertions.assertEquals(testCourse1, testCourse3);
		Assertions.assertNotSame(testCourse1, testCourse3);
	}

	@Test
	void courseEqualsOverrideTestForCourseSets() { 
		System.out.println("Testing that equals override for Course class extends to comparison of Sets of Course");
		Assertions.assertNotEquals(testCourseSet1, testCourseSet2);
		Assertions.assertEquals(testCourseSet2, testCourseSet3);
		Assertions.assertNotSame(testCourseSet2, testCourseSet3);
	}
	
	@Test
	void studentEqualsOverrideTest() { 
		System.out.println("Testing equals override for Student class");
		Assertions.assertNotEquals(testStudent1, testStudent2);
		Assertions.assertNotEquals(testStudent2, testStudent3);
		Assertions.assertNotEquals(testStudent3, testStudent4);
		Assertions.assertEquals(testStudent4, testStudent5);
		Assertions.assertNotSame(testStudent4, testStudent5);
	}
	
}
