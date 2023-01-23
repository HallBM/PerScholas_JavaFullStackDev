package arraydemo;

import java.util.Arrays;

//Module 303.4, Lab 2

public class ArrayBinarySearch {

	public static void main(String[] args) {
		String[] names = {"Carol", "Bob", "Alice", "John", "Tim", "Kate", "Mary"};
        
		// Display the index of Mary in the original list
		System.out.printf("Mary is at index %d in the original array.\n", linearSearch(names, "Mary"));
		
        // Please implement a Binary search that will display what index Mary is at
		Arrays.sort(names);
		System.out.printf("Mary is at index %d in the sorted array of names (found through implementation of Binary Search).",
				Arrays.binarySearch(names, "Mary"));
		
	}
	
	public static int linearSearch (Object [] array, Object element) {
		
		int index = 0;
		
		for (Object o : array) {
			if (array[index] == element) {
				return index;
			}
			index ++;
		}
		
		return -1; // if element not found in array
		
	}

}
