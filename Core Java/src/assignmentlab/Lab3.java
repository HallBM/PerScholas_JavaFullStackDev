package assignmentlab;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Lab3 {

	public static void main(String args[]) {
		Printer myPrinter = new Printer();
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		int count = 0;

		// https://www.geeksforgeeks.org/class-getdeclaredmethods-method-in-java-with-examples/

		// The getDeclaredMethods() method of java.lang.Class class

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.equals("printArray"))
				count++;
			System.out.println("Method count=" + count);
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");
	}
}

class Printer {
	public <E> void printArray (E[] elements){
		
		System.out.println(Arrays.toString(elements));
		
		for (E element : elements) {
			System.out.println(element);
		}
	}
}
