package interfacedemo;

public class Rectangle extends Shape implements Moveable {
	
	private int x,y; //top left corner
	private int height, width;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		this.y++;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		this.y--;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		this.x--;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		this.x++;
	}

	@Override
	public String getCoordinate() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.height * this.width;
	}

}
