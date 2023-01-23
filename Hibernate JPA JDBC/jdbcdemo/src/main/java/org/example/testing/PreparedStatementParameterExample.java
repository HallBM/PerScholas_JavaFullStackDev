package org.example.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementParameterExample {
	Connection connection = null;
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost/classicmodels";
	String userName = "root";
	String userPass = "password";

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(connectionUrl, userName, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) throws SQLException {
	        PreparedStatementParameterExample ptmtExample = new PreparedStatementParameterExample();
	        Connection con = ptmtExample.getConnection();
	        PreparedStatement statement = null;
	        
	        // Create table using JDBC (DDL example)
	        con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS students ("
	        		+ "RollNo int(9)  PRIMARY KEY NOT NULL,"
	        		+ "Name tinytext NOT NULL,"
	        		+ "Course varchar(25) NOT NULL,"
	        		+ "Address text)");
	        
	        try {
	        	con.setAutoCommit(false);
	        	
	        	//INSERT INTO TABLE
	        	// Writing a parameterized query in prepared Statement
	        	String insertQuery = "INSERT INTO students(RollNo,Name,Course,Address) VALUES(?,?,?,?)";
	            // Compiling query String
	            statement = con.prepareStatement(insertQuery);
	            // setting parameter to the query
	            statement.setInt(1, 3);
	            statement.setString(2, "Joseph");
	            statement.setString(3, "Hamilton");
	            statement.setString(4, "134 Youngs Street, Clarence, NY, 12322");
	            //Updating Query
	            System.out.println(statement.executeUpdate() + " entry added to 'Students' table.");
	            statement.close();
	            
	            //DELETE ENTRY FROM TABLE
	        	// Writing a parameterized query in prepared Statement
	        	String deleteQuery = "DELETE FROM students WHERE rollno =?";
	            // Compiling query String
	            statement = con.prepareStatement(deleteQuery);
	            // setting parameter to the query
	            statement.setInt(1, 3);
	            //Updating Query
	            System.out.println(statement.executeUpdate() + " entry deleted from 'Students' table.");
	            statement.close();
	            
	            con.commit();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            con.rollback();
	        } finally {
	            con.close();
	        }
	    }
}
