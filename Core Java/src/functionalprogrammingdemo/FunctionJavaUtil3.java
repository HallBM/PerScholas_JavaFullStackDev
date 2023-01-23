package functionalprogrammingdemo;

//https://www.geeksforgeeks.org/function-interface-in-java-with-examples/

//Java Program to illustrate compose() method

//Importing Function interface
import java.util.function.Function;

//Main class

public class FunctionJavaUtil3 {
	// Main driver method
	public static void main(String args[]) {
		// Function which takes in a number and
		// returns half of it
		Function<Integer, Double> half = a -> a / 2.0;
		
		// INSERT CODE TO TRIPLE THE VALUE OF THE HALF FUNCTION
		
		//// IMPLEMENTATION 1
		//Function<Double,Double> triple = (b) -> b*3;
		//half = triple.compose(half); 
		
		//// IMPLEMENTATION 2
		//Function<Double,Double> triple = (b) -> b*3;
		//half = half.andThen(triple);  
			
		//// IMPLEMENTATION 3 utilizing lambda
		half = half.andThen((b) -> b*3);
		
		// Applying the function to get the result
		System.out.println(half.apply(5));
	}
}
