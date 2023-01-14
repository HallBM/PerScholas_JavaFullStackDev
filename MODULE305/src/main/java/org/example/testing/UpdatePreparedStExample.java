package org.example.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePreparedStExample {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		try {
			con = DriverManager.getConnection(dburl, user, password);
			System.out.println("Connection established successfully!");
			
			// check before update
			System.out.println("ENTRY FOR ID #3 BEFORE UPDATE");
			prepStmt = con.prepareStatement("select * from employees where employeeNumber=?");
			prepStmt.setInt(1, 3);
			// execute select query
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				// System.out.print(rs.getInt("lastName"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("officeCode"));
			}
			
			
			//update
			String sql = "update employees set firstName=? , lastName=? where employeeNumber = ?";

			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, "Gary");
			prepStmt.setString(2, "Larson");
			prepStmt.setLong(3, 3);

			int rowsAffected = prepStmt.executeUpdate();
			
			//check after update
			System.out.println("ENTRY FOR ID #3 AFTER UPDATE");
			prepStmt = con.prepareStatement("select * from employees where employeeNumber=?");
			prepStmt.setInt(1, 3);
			// execute select query
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				// System.out.print(rs.getInt("lastName"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("officeCode"));
			}
			
			
			//Additional Queries
			System.out.println("Additional Queries for other ids");
			prepStmt = con.prepareStatement("select * from employees where employeeNumber=?");
			prepStmt.setInt(1, 1401);
			// execute select query
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				// System.out.print(rs.getInt("lastName"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("officeCode"));
			}
			
			prepStmt.setLong(1, 1501);
			// execute select query
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				// System.out.print(rs.getInt("lastName"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("officeCode"));
			}
			
			
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
