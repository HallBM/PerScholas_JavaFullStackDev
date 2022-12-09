package miniHack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MiniHackathonPlaceOrderCustomer {

	// need to update file location (fileloc) for code to work properly.
	static final String fileloc = "C:\\Users\\Brandon\\eclipse-workspace\\PerScholas_JavaFullStackDev\\MODULE303\\src\\miniHack\\";
	static final String filename = "us-500.csv";
	static List<Customer> cust_dir; 
	
	public static void main(String[] args) {
		MiniHackathonPlaceOrderCustomer m = new MiniHackathonPlaceOrderCustomer();
		m.loadVendorData(); // Read customer information from file. Create a list of customer objects, with fields populated from rows of the CSV file.
		m.searchLastName();	// Prompt user for last name to search through Customers and return Customer info
	}

	void loadVendorData() {

		String line;
		String[] cust_info;// = new ArrayList<>();
		cust_dir = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileloc + filename))) {
		
			br.readLine(); // skip first line (CSV contains header)
			while ((line = br.readLine()) != null) {
						
				// TODO Should refactor: pass each line from file directly to Customer(String s) constructor, and handle parsing and field 
				// validation within the constructor method.
				
				line = line.replace("\"", "");
				
				// cust_info = line.split(","); // code replaced with regex below 
				// new regex will only split string with ',' but not ', " (comma with a space, as found in some fields)
		
				cust_info = line.split(",(?!\\s)");
				
				if (cust_info.length == 12 &&           // if line parsed into 12 fields, and 
					cust_info[7].length() == 5 &&       // zip code field is 5 characters long, and 
					cust_info[7].matches("[0-9]{5}")) { // zip code field is 5 consecutive numbers
					
					// create new customer and add to customer directory list
					cust_dir.add(new Customer(	cust_info[0],cust_info[1],cust_info[2],
													cust_info[3],cust_info[4],cust_info[5],
													cust_info[6],cust_info[7],cust_info[8],
													cust_info[9],cust_info[10],cust_info[11]));
		
				} else {
					System.out.println("Failed to correctly parse file.");
					
					// Print out report of row that caused error
					System.out.println("Record parsed incorrectly: \n" + Arrays.toString(cust_info));
					System.out.println("Is parsed into 12 fields? " + (cust_info.length == 12 ? "YES" : "NO"));
					
					System.exit(1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	void searchLastName() {
		// Notes on method functionality:
		// Will continue to prompt user for last names until search is complete
		// Will return all records from Customers with the requested last name
		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		String query;
		
		do {
			
			// get user input
			System.out.print("Enter last name of customer to lookup information (Enter 0 to exit): ");
			query = scan.nextLine();
			
			// keep track of number of customers with indicated last name
			count = 0; 

			// iterate through customers and print out those that match based on last name
			for (Customer c : cust_dir) {
				if (c.getLast_name().equalsIgnoreCase(query)) {
					System.out.println(c + "\n");
					count++;
				}
			}
			
			// report if no customers found
			if (count == 0) {
				System.out.println("Customer not found with last name " + query + "\n");
			}
			
		} while (!query.equals("0")); // if user input equals "0", exit loop
		
		System.out.println("END");
		scan.close();
	}
}
