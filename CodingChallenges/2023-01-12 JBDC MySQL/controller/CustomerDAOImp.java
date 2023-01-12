package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import daointerface.ConnectionDAO;
import daointerface.ICustomer;
import model.Customers;

public class CustomerDAOImp extends ConnectionDAO implements ICustomer {

	public void createCustomersTable() throws SQLException, ClassNotFoundException {
		Connection con = ConnectionDAO.getConnection();
		con.createStatement().executeUpdate(
						"CREATE TABLE IF NOT EXISTS `customers`("
						+ "`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL," 
						+ "`email` VARCHAR(250) NOT NULL,"
						+ "`fname` VARCHAR(25) NOT NULL," 
						+ "`lname` VARCHAR(25) NOT NULL)");
	}

	public Customers getCustomerById(int id) throws ClassNotFoundException, SQLException {
		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			rs.next();
			Customers c = new Customers();
			c.setId(rs.getInt("id"));
			c.setEmail(rs.getString("email"));
			c.setFname(rs.getString("fname"));
			c.setLname(rs.getString("lname"));
			return c;

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addCustomer(List<Customers> CustomerList) {
		try {
			boolean completed = true;
			Connection con = ConnectionDAO.getConnection();
			for (Customers c : CustomerList) {
				PreparedStatement ps;
				if (c.getId() == -1) {
					String sql = "INSERT INTO customers (id, email, fname, lname) VALUES (default, ?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, c.getEmail());
					ps.setString(2, c.getFname());
					ps.setString(3, c.getLname());
				} else {
					String sql = "INSERT INTO customers (id, email, fname, lname) VALUES (?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setInt(1, c.getId());
					ps.setString(2, c.getEmail());
					ps.setString(3, c.getFname());
					ps.setString(4, c.getLname());
				}

				int affectedRows = ps.executeUpdate();
				System.out.println(affectedRows + " row(s) affected !!");

				if (affectedRows == 1) {
					completed &= true;
				} else {
					completed &= false;
				}
			}
			return completed;
		} catch (ClassNotFoundException e) {
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return false;
	}

	public boolean addCustomer(Customers customer) {
		try {
			boolean completed = true;
			Connection con = ConnectionDAO.getConnection();

			PreparedStatement ps;
			if (customer.getId() == -1) {
				String sql = "INSERT INTO customers (id, email, fname, lname) VALUES (default, ?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, customer.getEmail());
				ps.setString(2, customer.getFname());
				ps.setString(3, customer.getLname());
			} else {
				String sql = "INSERT INTO customers (id, email, fname, lname) VALUES (?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, customer.getId());
				ps.setString(2, customer.getEmail());
				ps.setString(3, customer.getFname());
				ps.setString(4, customer.getLname());
			}

			int affectedRows = ps.executeUpdate();
			System.out.println(affectedRows + " row(s) affected !!");

			if (affectedRows == 1) {
				completed &= true;
			} else {
				completed &= false;
			}

			return completed;
		} catch (ClassNotFoundException e) {
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return false;
	}

	public boolean removeCustomerById(int id) {
		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Customer with ID number " + id + " WAS DELETED.");
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
		}
		return false;
	}
}
