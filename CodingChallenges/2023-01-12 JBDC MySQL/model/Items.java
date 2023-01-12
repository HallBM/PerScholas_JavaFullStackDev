package model;

public class Items {
	private int id;
	private String name;
	float price;
	
	public Items() {
		super();
	}
	
	public Items(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Items(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}






}
