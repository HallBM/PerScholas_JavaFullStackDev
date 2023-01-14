package polymorphismdemo;

class PolymorphismExample {
	public static void main(String[] args) {

		// create an object of Square
		Polygon.Square s1 = new Polygon.Square();
		s1.render();

		// create an object of Circle
		Polygon.Circle c1 = new Polygon.Circle();
		c1.render();

		Polygon p1 = new Polygon();
		p1.render();

	}
}
