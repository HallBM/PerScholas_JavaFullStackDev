package arraydemo;

import java.util.Arrays;
import java.util.Scanner;

public class HackerRankNegSubArray {

	public static void main(String[] args) {
		
		// https://www.hackerrank.com/challenges/java-negative-subarray/problem

	
		/*
		
		bring in two lines of input
		first line is int of number of array elements 1<=n<=100
		second line are the space-separated int values
		
		 
		Example input: 
		5
		1 -2 4 -5 1
		
		Example output:
		9      
		
		There are 9 subarrays that have negative sums
		*/
		
		//read in number of ints in array
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int[] arr = new int[n];

		//populate array of ints with int values
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		// handle edge case of an array of 1
		if (n == 1) {
			System.out.println(arr[0] < 0 ? 1 : 0);
			System.exit(0);
		}

		int count = 0; // count of negative sums

		//create all sub-arrays of k-length and test whether sum of subarray is negative
		for (int k = 1; k <= n; k++) {
			for (int j = 0; j < n - k + 1; j++) {
				//generate subarray and pass to function that calculates sum and returns 1 if sum is negative
				count += negSumArr(Arrays.copyOfRange(arr, j, j + k)); 
			}
		}
		System.out.println(count);
	}
	
	public static int negSumArr(int[] array) {
		
		//calculate sum of array and return 1 if sum is negative
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum < 0 ? 1 : 0;
	}
}