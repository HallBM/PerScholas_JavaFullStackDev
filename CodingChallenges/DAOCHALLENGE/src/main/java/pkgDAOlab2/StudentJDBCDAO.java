package pkgDAOlab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentJDBCDAO {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public StudentJDBCDAO() {

	    }

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(StudentBean studentBean) {
		try {

			// TODO: implement the missing code here!!
			connection = getConnection();
			String queryString = "INSERT INTO students (rollno, name, course, address) VALUES (?,?,?,?)";
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,studentBean.getRollNo());
			ptmt.setString(2,studentBean.getName());
			ptmt.setString(3,studentBean.getCourse());
			ptmt.setString(4,studentBean.getAddress());
			
			int succ = ptmt.executeUpdate();
			if (succ == 1) {
				System.out.println("Data Added Successfully");
			} else {
				System.out.println("DATA NOT ADDED");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(StudentBean studentBean) {

		try {
			String queryString = "UPDATE students SET Name=? WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, studentBean.getName());
			ptmt.setInt(2, studentBean.getRollNo());
			ptmt.executeUpdate();
			System.out.println("**Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int rollNo) {

		try {
			String queryString = "DELETE FROM students WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, rollNo);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void findAll() {
	        try {

	        	// TODO: Implement missing code here!!!
	        	
	            String queryString = "SELECT * FROM students";
	            connection = getConnection();
	            ptmt = connection.prepareStatement(queryString);
	            resultSet = ptmt.executeQuery();
	            while (resultSet.next()) {
	                System.out.printf("Roll No.: %d | Name: %s | Course: %s | Address: %s\n", 
	                		resultSet.getInt("rollno"),
	                		resultSet.getString("name"),
	                		resultSet.getString("course"),
	                		resultSet.getString("address"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (resultSet != null)
	                    resultSet.close();
	                if (ptmt != null)
	                    ptmt.close();
	                if (connection != null)
	                    connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	        }
	    }
}
