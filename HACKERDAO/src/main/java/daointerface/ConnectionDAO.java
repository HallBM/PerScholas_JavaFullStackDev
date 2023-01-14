package daointerface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	static Connection con = null;
	static boolean DBpresent = false;
	static String dbname = "doahackathon";
	//protected PreparedStatement ps = null;
	//protected ResultSet rs = null;

	public static Connection getConnection() throws ClassNotFoundException {
		
		final String DBURL = "jdbc:mysql://localhost:3306/";
		final String DBUSERNAME = "root";
		final String DBPASSWORD = "password";
		try {
			if (!DBpresent) {
				con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
				con.createStatement().executeUpdate("CREATE DATABASE IF NOT EXISTS "+ dbname);
				System.out.println("Database " + dbname + " exists");
				DBpresent = true;
			} 
			
			con = DriverManager.getConnection(DBURL + dbname, DBUSERNAME, DBPASSWORD);
			System.out.println("Connected Database Successfully");
		
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}

	public static String getDbname() {
		return dbname;
	}

	public static void setDbname(String dbname) {
		ConnectionDAO.dbname = dbname;
	}
}

