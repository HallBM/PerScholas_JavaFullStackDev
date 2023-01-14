package encapsulationdemo;


public class People {

	public static void main(String[] args) {

		Student s1 = new Student (1,"Michael","Gabriel","mgabriel@perscholas.org", "123-456-7890");
		Student s2 = new Student (2,"Bairon","Vasquez", "bvasquex@perscholas.org",123457891);
		Student s3 = new Student ("0003", "Mark", "Chamberlain", "mchamber@gmail.com", "123-456-7892");
		Student s4 = new Student ("0004", "Ryan", "Peoples", "rpeoples@aol.com", 1234567893);
		Student s5 = new Student ();
		
		s5.setEmail("abc@gmail.com");
		s5.setFirstName("Amanda");
		s5.setLastName("Sutton");
		s5.setPhoneNo("123-456-7899");
		s5.setStudentID("0005");
		
		s1.getInfo();
		s2.getInfo();
		s3.getInfo();
		s4.getInfo();
		s5.getInfo();
		
	}

}
