package daointerface;

import java.sql.SQLException;
import java.util.List;

import model.Items;

public interface IItem {

	List<Items> getAllItems() throws ClassNotFoundException, SQLException;
	
	boolean addItem(List<Items> ItemList);

	boolean removeItemById(int id);
}
