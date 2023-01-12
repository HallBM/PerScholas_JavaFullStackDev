package daointerface;

import java.sql.SQLException;
import java.util.List;

import model.Customers;

public interface ICustomer {

	Customers getCustomerById(int id) throws ClassNotFoundException, SQLException;
	
	boolean addCustomer(List<Customers> CustomerList);
	boolean addCustomer(Customers Customer);
	
	boolean removeCustomerById(int id);
}