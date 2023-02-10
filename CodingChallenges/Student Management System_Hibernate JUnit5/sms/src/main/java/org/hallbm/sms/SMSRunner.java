package org.hallbm.sms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.HibernateUtil;
import jpa.service.StudentService;

public class SMSRunner {

	private static final Scanner scan = new Scanner(System.in);
	private static final StudentService sServ = new StudentService();
	private static final CourseService cServ = new CourseService();

	public static void main(String[] args) {
		Student student;

		// Create tables and populate with data
		createTablesWithData();

		// User greeting (login or exit?)
		userGreeting();

		// User login (successful login or exit; returns student if successful)
		student = userLogin();

		// Display registered courses and prompt new registration (or exit)
		promptRegisterCourses(student);

		// Display course options and register selection (or exit)
		registerCourses(student);

	}

	public static void userGreeting() {
		String choice;

		// Prompt user for input: login or exit
		System.out.println("Please make a selection:\n(1) Student Login\n(2) Exit");

		// Validate selection
		while (true) {
			choice = scan.nextLine();
			if (choice.equals("1")) {
				break;
			} else if (choice.equals("2")) {
				System.out.println("System will now exit. Goodbye!");
				System.exit(0);
			} else {
				System.out.println(
						"Invalid choice. Please try again. Enter \"1\" for Student Login. Enter \"2\" to exit.");
			}
		}
	}

	public static Student userLogin() {
		// Get user credentials and validate. No more than 3 attempts.
		int count = 1;

		boolean valid = false;
		String studentEmail = null;
		String studentPassword = null;
		Student student;

		while (!valid) {
			System.out.println("Please enter your email address:");
			studentEmail = scan.nextLine();
			System.out.println("Please enter your password:");
			studentPassword = scan.nextLine();

			valid = sServ.validateStudent(studentEmail, studentPassword);

			if (!valid) {
				System.out.println("Wrong Credentials  ***Attempt " + count + " of 3***  Please try again.");
			}

			if (++count == 4) {
				System.out.println("Excessive login attempts. System will now exit. Goodbye!");
				System.exit(0);
			}
		}
		student = sServ.getStudentByEmail(studentEmail);
		System.out.println("\nWelcome " + student.getsName() + "!\n");
		return student;
	}

	public static void promptRegisterCourses(Student student) {
		String choice;

		// Display user's registered courses
		if (student.getsCourses().isEmpty()) {
			System.out.println("You are not currently enrolled in any courses.");
			System.out.println("Would you like to register for any courses? Enter 1 for YES or 2 to EXIT");
		} else {
			System.out.println("You are enrolled in the following course(s):");
			printCourses(student.getsCourses());
			System.out.println("\nWould you like to register for more courses? Enter 1 for YES or 2 to EXIT");
		}

		// Determine if the student would like to register for more courses.
		while (true) {
			choice = scan.nextLine().toLowerCase();
			if (choice.equals("1")) {
				break;
			} else if (choice.equals("2")) {
				System.out.println("You have been logged out. Goodbye!");
				System.exit(0);
			} else {
				System.out.println(
						"Invalid choice. Please try again. Enter \"1\" for Course Registration. Enter \"2\" to EXIT.");
			}
		}
	}

	public static void registerCourses(Student student) {
		String choice;
		int choiceInt;

		// Populate set of enrolled course ids
		Set<Integer> sCourseIds = new HashSet<>();
		student.getsCourses().forEach(cid -> sCourseIds.add(cid.getcId())); // lambda extraction of course ids from
																			// courses

		// Populate set of total courses offered and course ids
		Set<Course> courseList = cServ.getAllCourses();
		Set<Integer> courseIdList = new HashSet<>();
		courseList.forEach(cid -> courseIdList.add(cid.getcId())); // lambda extraction of course ids from courses

		// Exit if user has registered all courses
		if (student.getsCourses().size() == courseList.size()) {
			System.out.println(
					"You've registered for every course! There are no more coures to enroll in. You have been logged out. Goodbye!");
			System.exit(0);
		}

		// Provide list of available courses and request course number for registration
		System.out.println("\nPlease select from the following list of courses:");
		printCourses(courseList);
		System.out.println("\nWhat course would you like to register for? (Enter \"-1\" to exit)");

		while (true) {
			choice = scan.nextLine();

			// validation of selection; guard pattern (exit or re-prompt if any of the
			// conditions are true)
			// user choose to exit?
			if (choice.equals("-1")) {
				System.out.println("You have been signed out. Goodbye!");
				System.exit(0);
			}

			// user enters an invalid input (not a number or not the word 'courses')
			if (!choice.matches("\\d+")) {
				if (choice.toLowerCase().equals("courses")) { // non-numeric option
					System.out.println("\nPlease select from the following list of courses:");
					printCourses(courseList);
					System.out.println("\nWhat course would you like to register for?");
					continue;
				} else {
					System.out.println(
							"Invalid selection. Please select another course to register, enter 'courses' to see full course list, or enter '-1' to EXIT.");
					continue;
				}
			}

			choiceInt = Integer.parseInt(choice);

			// user enters invalid course id (course id does not exist)
			if (!courseIdList.contains(choiceInt)) {
				System.out.println("Incorrect selection. Course #" + choice
						+ " does not exist. Please select a valid Course Id or enter '-1' to EXIT.");
				continue;
			}

			// user enters a course in which they are already enrolled
			if (sCourseIds.contains(choiceInt)) {
				System.out.println(
						"You are already registered in that course! Please select a different Course Id or enter '-1' to EXIT.");
				continue;
			}

			// *** Student has entered a valid input; end guard pattern ***
			// Register student in course
			for (Course c : courseList) {
				// find course from full list of courses
				if (choiceInt == c.getcId()) {
					// register course to student in database
					sServ.registerStudentToCourse(student, c);
					System.out.println("You've been successfully registered to course: " + c.getcName() + "\n");

					// update set of registered course ids, and update student courses in student
					// object
					sCourseIds.add(choiceInt);
					student.addCourse(c);
					break;
				}
			}

			// Display updated list of registered courses
			System.out.println("You are currently enrolled in the following courses:");
			printCourses(sServ.getStudentCourses(student.getsEmail()));

			// Prompt user for additional registration or to exit (or forced exit if all
			// courses have been registered)
			if (student.getsCourses().size() == courseList.size()) {
				System.out.println(
						"\nYou've registered for every course! There are no more coures to enroll in. You have been logged out. Goodbye!");
				System.exit(0);
			} else {
				System.out.println(
						"\nPlease select another course to register, enter 'courses' to see full course list, or enter '-1' to EXIT.");
			}
		}
	}

	public static void printCourses(Set<Course> cS) {
		// prints a table of courses with a header
		// courses printed in order of ascending course ID

		System.out.println(String.format("%-6s", "ID") + String.format("%-52s", "Course Name")
				+ String.format("%-52s", "Instructor Name"));
		System.out.println("====  " + "==================================================  "
				+ "====================================================");
		List<Course> cList = new ArrayList<>();
		cList.addAll(cS);

		// custom Comparator (functional interface) for ordering Courses based on Course
		// ID
		// used by sort function below
		Comparator<Course> compCourseID = new Comparator<>() {
			@Override
			public int compare(Course c1, Course c2) {
				return c1.getcId() >= c2.getcId() ? 1 : -1;
			}
		};

		cList.sort(compCourseID);

		for (Course c : cList) {
			System.out.println(String.format("%-6s", c.getcId()) + String.format("%-52s", c.getcName())
					+ String.format("%-52s", c.getcInstructorName()));
		}
	}

	public static void createTablesWithData() {
		// Get singleton sessionFactory (initiates Hibernate table creation)
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			// Populate data with native SQL commands (DML statements)

			String studentInsertData = "INSERT INTO students (email, name, password) VALUES "
					+ "('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj'), "
					+ "('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU'), "
					+ "('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd'), "
					+ "('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S'), "
					+ "('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz'), "
					+ "('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs'), "
					+ "('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ'), "
					+ "('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j'), "
					+ "('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP'), "
					+ "('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6'), "
					+ "('bhall@gmail.com','Brandon Hall', 'abc123')";

			String courseInsertData = "INSERT INTO courses (id, name, instructor) VALUES "
					+ "(2, 'Mathematics', 'Eustace Niemetz'), " 
					+ "(3, 'Anatomy', 'Reynolds Pastor'), "
					+ "(1, 'English', 'Anderea Scamaden'), " 
					+ "(4, 'Organic Chemistry', 'Odessa Belcher'), "
					+ "(5, 'Physics', 'Dani Swallow'), " 
					+ "(6, 'Digital Logic', 'Glenden Reilingen'), "
					+ "(7, 'Object Oriented Programming', 'Giselle Ardy'), "
					+ "(8, 'Data Structures', 'Carolan Stoller'), " 
					+ "(9, 'Politics', 'Carmita De Maine'), "
					+ "(10, 'Art', 'Kingsly Doxsey')";

			Query studentDML = session.createNativeQuery(studentInsertData);
			Query courseDML = session.createNativeQuery(courseInsertData);

			studentDML.executeUpdate();
			courseDML.executeUpdate();

			transaction.commit();

		}catch (Exception e) {
			transaction.rollback();
			System.out.println("Error during population of data: Database may already contain data set\n");
		} finally {
			session.close();
		}
	}
}
