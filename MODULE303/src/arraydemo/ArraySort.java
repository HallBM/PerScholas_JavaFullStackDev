package arraydemo;

import java.util.Arrays;

// Module 303.4, Lab 1

public class ArraySort {

	public static void main(String[] args) {
			int[] integers = {30, 57, 88, 12, 34, 54, 90, 62, 82, 10};
	         
	        System.out.println("Before sort: " + Arrays.toString(integers));
	         
	        Arrays.sort(integers); //Please implement a way to sort the integers array
	         
	        System.out.println("After sort: " + Arrays.toString(integers));

	}

}
