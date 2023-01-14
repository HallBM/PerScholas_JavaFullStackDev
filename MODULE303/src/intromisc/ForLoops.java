package intromisc;

import java.util.Scanner;

// Lab 303.3.1: for Loops

public class ForLoops {

	public static void main(String[] args) {

		System.out.println("LOOP DEMO ONE:");
		loopDemoOne();
		System.out.println();

		System.out.println("ARRAY DEMO TWO:");
		loopDemoTwo();
		System.out.println();

		System.out.println("PALINDROME EXAMPLE:");
		palindromeExample();
		System.out.println();

		System.out.println("PYRAMID EXAMPLE:");
		pyramidExample();
		System.out.println();
	}

	public static void loopDemoOne() {
		int n = 5;
		// for loop
		for (int i = 1; i <= n; ++i) {
			System.out.println("Java is fun");
		}
	}

	public static void loopDemoTwo() {
		int sum = 0;
		int n = 1000;
		// for loop
		for (int i = 1; i <= n; ++i) {
			// body inside for loop
			sum += i; // sum = sum + i
		}
		System.out.println("Sum = " + sum);
	}

	public static void palindromeExample() {
		String original, reverse = ""; // Objects of String class
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string/number to check if it is a palindrome");
		original = in.nextLine();
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		if (original.equals(reverse)) {
			System.out.println("Entered string/number is a palindrome.");
		} else {
			System.out.println("Entered string/number isn't a palindrome.");
		}
		in.close();
	}

	public static void pyramidExample() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();// new line
		}
	}

}
