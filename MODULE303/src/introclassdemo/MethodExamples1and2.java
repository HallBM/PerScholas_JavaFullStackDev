package introclassdemo;

import java.util.InputMismatchException;
import java.util.Scanner;
// Module 303.4, Lab 4

public class MethodExamples1and2 {

	 // Example 1: create a method that adds 2 parameters and returns their sum
 	 // Example 2: create a method that squares an integer
	
	public static void main(String[] args) {
		
		int num1;
		int num2;
		int num3;
		
		// create an object of type MethodExamples1and2
        MethodExamples1and2 obj = new MethodExamples1and2();	
		Scanner scan = new Scanner(System.in);
				
		// EXAMPLE 1
		System.out.println("EXAMPLE 1: METHOD FOR SUM OF 2 PARAMETERS");
		
		num1 = obj.getInt(scan);
        num2 = obj.getInt(scan);
        
             
        // call your  method for Example 1
        long result = obj.sumTwoInts(num1, num2);
        System.out.printf("Sum of %d and %d is: %d\n", num1, num2, result);
		
        // EXAMPLE 2
        System.out.println();
		System.out.println("EXAMPLE 2: METHOD FOR SQUARE OF A PARAMETER");

		num3 = obj.getInt(scan);
		
        // call the method
        // store returned value to result
	    result = obj.squareInts(num3);

	    System.out.printf("Squared value of %d is %d\n", num3, result);

	}
	
	public int getInt(Scanner scan) {
		int num = 0;

		while(true) {
			try {
				System.out.println("Enter an integer:\n");
				num = scan.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				System.out.printf("Input must be an integer with values between %d and %d", Integer.MIN_VALUE, Integer.MAX_VALUE);
				scan.nextLine();
			}
		}
        
        return num;
	}
	
	public long sumTwoInts (int a, int b) {
		return (long) a + (long) b;
	}
	
	
	public long squareInts (int a) {
		return (long) Math.pow(a, 2);
	}

}
