package org.example.testing;

//Importing SQL database
import java.sql.*;

//Main class to illustrate demo of JDBC
public class SimpleQuery {

	static String connectionUrl = "jdbc:mysql://localhost/classicmodels";
	static String userName = "root";
	static String userPass = "password";
	static Connection con = null;

	// Write a query to display (employeeNumber,lastName,firstName,VacationHours)
	// where VacationHours > 20

	// Main driver method
	public static void main(String[] args) throws Exception {
		try {
			con = DriverManager.getConnection(connectionUrl, userName, userPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Step 3: Creating statement
		String query = "SELECT employeenumber, lastname, firstname, vacationhours FROM employees WHERE vacationhours <?";
		PreparedStatement prepst = con.prepareStatement(query);
		prepst.setInt(1, 20);

		// Step 4: Executing the query and storing the result
		ResultSet rs = prepst.executeQuery();

		// Step 5: Processing the results
		while (rs.next()) {
			System.out.println("Begin New Record");
			System.out.println(rs.getLong("employeenumber"));
			System.out.println(rs.getString("lastname"));
			System.out.println(rs.getString("firstname"));
			System.out.println(rs.getString("vacationhours"));
		}

		// Step 6: Closing the connections
		// using close() method to release memory resources
		con.close();

		// Display message for successful execution of program
		System.out.println("JDBC query completed");
	}
}
