package org.example.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePreparedDStExample {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement prepStmt = null;
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		
		try {
			con = DriverManager.getConnection(dburl, user, password);
			con.setAutoCommit(false);
			
			System.out.println("Connection established successfully!");
			
			//employee entry to delete
			int empID = 3;
			
			prepStmt = con.prepareStatement("DELETE FROM employees WHERE employeeNumber=?");
			prepStmt.setInt(1, empID);
			System.out.println(prepStmt.executeUpdate() + " entries deleted.");
			con.commit();
				
					
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
		}
	}
	
	
	
	
	
	
}
