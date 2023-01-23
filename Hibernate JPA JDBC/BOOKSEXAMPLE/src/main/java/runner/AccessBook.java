package runner;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.BookDAOImpl;
import daointerface.IBookDAO;
import model.Books;

public class AccessBook {
	public static void main(String[] args) {
		// CRUD and business logic will invoke here

		// populate table (INSERT)
		IBookDAO bookDao = new BookDAOImpl();
		System.out.println("--------- inserting book records ----------");

		ArrayList<Books> BookList = new ArrayList<Books>();

		Books b1 = new Books();
		b1.setIsbn(120);
		b1.setBookName("Java Book");
		BookList.add(b1);

		Books b2 = new Books();
		b2.setIsbn(300);
		b2.setBookName("Python Book");
		BookList.add(b2);

		Books b3 = new Books();
		b3.setIsbn(365);
		b3.setBookName("JavaScript Book");
		BookList.add(b3);

		Books b4 = new Books();
		b4.setIsbn(256);
		b4.setBookName("SQL Book");
		BookList.add(b4);

		Books b5 = new Books();
		b5.setId(5);
		b5.setIsbn(123);
		b5.setBookName("Django Book");
		BookList.add(b5);

		bookDao.saveBook(BookList);

		// retrieve table contents (SELECT)
		System.out.println("\n====== Display list of all books ====");
		try {
			for (Books cc : bookDao.getAllBooks()) {
				int ISBN = cc.getIsbn();
				String BookName = cc.getBookName();
				System.out.println("======================");
				System.out.println("ISBN Number :" + ISBN + " and Book name: " + BookName);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// update table (UPDATE)
		System.out.println("\n----Book information is updating -----");
		Books Bookupdating = new Books();
		Bookupdating.setIsbn(3);
		Bookupdating.setBookName("Algorithms Book");
		boolean result = bookDao.updateBook(Bookupdating, 3);
		if (result) {
			System.out.println("Record was updated");
		} else {
			System.out.println("Record was not updated");
		} 
		
		// delete entry from table (DELETE)
		System.out.println("\n----Deleting Book information -----");
		boolean a = bookDao.deleteBook(4); // 4 is a id of book
		if (a) {
			System.out.println("Record is deleted");
		} else {
			System.out.println("Record is not deleted");
		}

	}
}
