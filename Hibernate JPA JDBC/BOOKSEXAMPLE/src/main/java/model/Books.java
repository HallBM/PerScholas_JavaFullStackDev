package model;

public class Books {
	private int id;
	private int isbn;
	private String bookName;

	// ----Constructor---
	public Books() {
	}

	public Books(int isbn, String bookName) {
		this.isbn = isbn;
		this.bookName = bookName;
	}

	public Books(int id, int isbn, String bookName) {
	     this.isbn = isbn;
	     this.bookName = bookName;
	     this.id = id;
	  }
	
	// getter setter methods
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
