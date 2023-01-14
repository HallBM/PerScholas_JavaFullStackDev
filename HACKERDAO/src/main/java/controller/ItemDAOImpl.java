package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daointerface.ConnectionDAO;
import daointerface.IItem;
import model.Items;

public class ItemDAOImpl extends ConnectionDAO implements IItem {

	public void createItemsTable() throws SQLException, ClassNotFoundException {
		Connection con = ConnectionDAO.getConnection();
	    con.createStatement().executeUpdate(
	    		"CREATE TABLE IF NOT EXISTS `items`("
	    		+ "`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
	    		+ "`name` VARCHAR(50) NOT NULL,"
	    		+ "`price` DECIMAL(4,2) NOT NULL)");
	}
	
	public List<Items> getAllItems() throws ClassNotFoundException, SQLException {
		try {
			Connection con = ConnectionDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
			List<Items> itemlist = new ArrayList<Items>();
			Items i;

			while (rs.next()) {
				i = new Items();
				i.setId(rs.getInt("id"));
				i.setName(rs.getString("name"));
				i.setPrice(rs.getFloat("price"));
				itemlist.add(i);
			}
			return itemlist;

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addItem(List<Items> ItemList) {
		try {
			boolean completed = true;
			Connection con = ConnectionDAO.getConnection();
			for (Items i : ItemList) {
				PreparedStatement ps;
				if (i.getId() == -1) {
					String sql = "INSERT INTO items (id, name, price) VALUES (default, ?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, i.getName());
					ps.setFloat(2, i.getPrice());

				} else {
					String sql = "INSERT INTO items (id, name, price) VALUES (?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setInt(1, i.getId());
					ps.setString(2, i.getName());
					ps.setFloat(3, i.getPrice());
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

	public boolean removeItemById(int id) {
		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Item with ID number " + id + " DELETED.");
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
