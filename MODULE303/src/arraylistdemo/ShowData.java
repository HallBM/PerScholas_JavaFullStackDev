package arraylistdemo;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowData {
	public static void main(String[] args) {
		// instantiation to class AddDataToArrayList
		AddDataToArrayList b = new AddDataToArrayList();
		ArrayList<Book> mybooklist = b.bookdetails();
		for (Book showValue : mybooklist) {
			// ---- invoking getter method for getting Data---------
			System.out.println(showValue.getNumber() + " " + showValue.getName1() + " " + showValue.getCategory() + " "
					+ showValue.getAuthor());
		}

	}
}
