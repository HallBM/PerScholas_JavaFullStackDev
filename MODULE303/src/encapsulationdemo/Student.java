package encapsulationdemo;

public class Student {
	private String studentID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Student() {

	}

	public Student(String studentID, String firstName, String lastName, String email, String phoneNo) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Student(int studentID, String firstName, String lastName, String email, String phoneNo) {
		this.studentID = String.format("%04d", studentID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Student(int studentID, String firstName, String lastName, String email, int phoneNo) {
		this.studentID = String.format("%04d", studentID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		String phonenumber = Integer.toString(phoneNo);
		this.phoneNo = String.format("%s-%s-%s", phonenumber.substring(0, 3), phonenumber.substring(3, 6),
				phonenumber.substring(6));
	}

	public Student(String studentID, String firstName, String lastName, String email, int phoneNo) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		String phonenumber = Integer.toString(phoneNo);
		this.phoneNo = String.format("%s-%s-%s", phonenumber.substring(0, 3), phonenumber.substring(3, 6),
				phonenumber.substring(6));
	}

	public void getInfo() {
		System.out.printf("ID: %s, NAME: %s %s, EMAIL: %s, PHONE NO.: %s\n", 
				this.getStudentID(), 
				this.getFirstName(), 
				this.getLastName(), 
				this.getEmail(), 
				this.getPhoneNo());
	}
	
}
