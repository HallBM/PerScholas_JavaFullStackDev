package exceptionsdemo;

public class NestedDemo {
	public static void main(String args[]) {
		// main try-block
		try {
			// try-block2
			try {
				// try-block3
				try {
					int arr[] = {1, 2, 3, 4};
					/*
					 * I'm trying to display the value of an element which doesn't exist. The code
					 * should throw an exception
					 */
					// System.out.println(arr[10]);
					// code added to execute Arithmetic Exception (unchecked/runtime exception)
					System.out.println(arr[2] / (arr[3]-4));
					
				} catch (ArithmeticException e) {  // new code will call this method.
					System.out.print("Arithmetic Exception");
					System.out.println(" handled in try-block3");
				}
			} catch (ArithmeticException e) {
				System.out.print("Arithmetic Exception");
				System.out.println(" handled in try-block2");
			}
		} catch (ArithmeticException e3) {
			System.out.print("Arithmetic Exception");    
			System.out.println(" handled in main try-block");
		} catch (ArrayIndexOutOfBoundsException e4) {    // this one was originally executed 
			System.out.print("ArrayIndexOutOfBoundsException");
			System.out.println(" handled in main try-block");
		} catch (Exception e5) {
			System.out.print("Exception");
			System.out.println(" handled in main try-block");
		}
	}
}
