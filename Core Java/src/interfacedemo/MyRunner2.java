package interfacedemo;

public class MyRunner2 {
	public static void main(String[] args) {

		Rectangle c1 = new Rectangle(1, 2, 2, 5);
		System.out.println("Area of Rectangle " + c1.getArea());
		System.out.println("Coordinates are " + c1.getCoordinate());

		c1.moveDown();
		System.out.println("After move Down, Coordinates are " + c1.getCoordinate());

		c1.moveRight();
		System.out.println("After move right, Coordinates are " + c1.getCoordinate());
		c1.moveUp();
		System.out.println("After move Up, Coordinates are " + c1.getCoordinate());

		c1.moveLeft();
		System.out.println("After move left, Coordinates are " + c1.getCoordinate());

		System.out.println("--------Test Polymorphism-------");
		Moveable c2 = new Rectangle(5, 10, 100, 200); // upcast
		c2.moveUp();
		System.out.println("After move up, Coordinates are " + c2.getCoordinate());

		c2.moveLeft();
		System.out.println("After move Left, Coordinates are " + c2.getCoordinate());
		
		//System.out.println(c2.getArea()); //not implemented in moveable
	}
}
