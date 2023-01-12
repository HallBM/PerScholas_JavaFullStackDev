package runner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.CustomerDAOImp;
import controller.ItemDAOImpl;
import model.Customers;
import model.Items;

public class AccessDB {
	public static void main(String[] args) {
		custDB();
		itemDB();

	}

	public static void custDB() {
		CustomerDAOImp custDAO = new CustomerDAOImp();

		try {
			custDAO.createCustomersTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------- INSERTING CUSTOMERS ----------");

		ArrayList<Customers> CustomerList = new ArrayList<Customers>();

		Customers c = new Customers();

		c.setEmail("abc@gmail.com");
		c.setFname("Mark");
		c.setLname("Jones");
		CustomerList.add(c);

		c = new Customers("def@gmail.com", "Paul", "McGuire");
		CustomerList.add(c);

		c = new Customers(4, "ghi@gmail.com", "Kathy", "Sue");
		CustomerList.add(c);

		String[] emails = { "as@gmail.com", "bs@gmail.com", "cs@gmail.com", "ds@gmail.com", "es@gmail.com" };
		String[] fnames = { "a", "b", "c", "d", "e" };
		String[] lnames = { "Smith", "Smith", "Smith", "Smith", "Smith" };

		for (int i = 0; i < emails.length; i++) {
			c = new Customers(emails[i], fnames[i], lnames[i]);
			CustomerList.add(c);
		}

		custDAO.addCustomer(CustomerList);

		custDAO.addCustomer(new Customers(12, "fs@gmail.com", "f", "Cameron"));
		custDAO.addCustomer(new Customers("gs@gmail.com", "g", "Strawser"));

		// retrieve table contents (SELECT)
		System.out.println("\n====== RETRIEVING CUSTOMERS ====");
		int custID;
		try {
			custID = 5;
			c = custDAO.getCustomerById(custID);
			System.out.println("Customer ID: " + c.getId() + " | Email: " + c.getEmail() + " | Name: " + c.getFname()
					+ " " + c.getLname());
			custID = 7;
			c = custDAO.getCustomerById(custID);
			System.out.println("Customer ID: " + c.getId() + " | Email: " + c.getEmail() + " | Name: " + c.getFname()
					+ " " + c.getLname());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// update table (DELETE)
			System.out.println("\n---- DELETE CUSTOMERS -----");
			custID = 5;
			custDAO.removeCustomerById(custID);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void itemDB() {
		ItemDAOImpl itemDAO = new ItemDAOImpl();

		try {
			itemDAO.createItemsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------- INSERTING ITEMS ----------");

		List<Items> ItemList = new ArrayList<Items>();

		Items c = new Items();

		c.setName("Clippers");
		c.setPrice(10.0159f);
		ItemList.add(c);

		c = new Items("Flea Collar", 13.01f);
		ItemList.add(c);

		c = new Items(4, "Scratch Pad", 19.9f);
		ItemList.add(c);

		String[] names = { "Laser pointer", "Catnip", "Mouse", "Wet canned food", "Dry food" };
		Float[] prices = { 5f, 6f, 7f, 8f, 9f };

		for (int i = 0; i < names.length; i++) {
			c = new Items(names[i], prices[i]);
			ItemList.add(c);
		}

		itemDAO.addItem(ItemList);

		// retrieve table contents (SELECT)
		System.out.println("\n====== RETRIEVING ALL ITEMS ====");

		try {
			ItemList = itemDAO.getAllItems();

			for (Items i : ItemList) {

				System.out.printf("Item ID: %d | Name: %s | Price: $%.2f\n", i.getId(), i.getName(), i.getPrice());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int itemID;
		try {
			// update table (DELETE)
			System.out.println("\n---- DELETE ITEMS -----");
			itemID = 5;
			itemDAO.removeItemById(itemID);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
