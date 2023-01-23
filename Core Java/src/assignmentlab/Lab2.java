package assignmentlab;

public class Lab2 {
	// What do we need to change to make the below code work?

	// ANSWER: CHANGED "STRING" TO "INTEGER" because needs to be bound to subclass
	// of Number defined by GenericClassLAB2 class

	public static void main(String[] args) {
		// create an object of GenericsClass
		GenericClassLAB2<Integer> obj = new GenericClassLAB2<>();
		obj.display();
	}
}

class GenericClassLAB2<T extends Number> {

	public void display() {
		System.out.println("This is a bounded type generics class.");
	}

}
