package intromisc;

import java.util.Scanner;

// Lab 303.3.2: While Loops

public class WhileLoops2 {

	public static void main(String[] args) {
		
		
		
		System.out.println("GUESS THE NUMBER");
		guessTheNumber();
		System.out.println();
		
		System.out.println("SUBTRACTION QUIZ");
		subtractionQuizLoop();
		System.out.println();
		
		System.out.println("SENTINEL VALUE DEMO");
		sentinelValueDemo();

	}

	public static void guessTheNumber() {
		// Generate a random number to be guessed
		int number = (int) (Math.random() * 101);
		System.out.println(number);
		Scanner input = new Scanner(System.in);
		System.out.println("Guess a magic number between 0 and 100");
		int guess = -1;
		while (guess != number) {
			// Prompt the user to guess the number
			System.out.print("\nEnter your guess: ");
			guess = input.nextInt();
			if (guess == number)
				System.out.println("Yes, the number is " + number);
			else if (guess > number)
				System.out.println("Your guess is too high");
			else
				System.out.println("Your guess is too low");
		} // End of loop
		input.close();
	}

	public static void subtractionQuizLoop() {
		final int NUMBER_OF_QUESTIONS = 5; // Number of questions
		int correctCount = 0; // Count the number of correct answers
		int count = 0; // Count the number of questions
		long startTime = System.currentTimeMillis();
		String output = ""; // output string is initially empty
		Scanner input = new Scanner(System.in);

		while (count < NUMBER_OF_QUESTIONS) {
			// 1. Generate two random single-digit integers

			int number1 = (int) (Math.random() * 10);
			int number2 = (int) (Math.random() * 10);
			// 2. If number1 < number2, swap number1 with number2
			if (number1 < number2) {
				int temp = number1;
				number1 = number2;
				number2 = temp;
			}
			// 3. Prompt the student to answer "What is number1 - number2?"
			System.out.print("What is " + number1 + " - " + number2 + "? ");
			int answer = input.nextInt();
			// 4. Grade the answer and display the result
			if (number1 - number2 == answer) {
				System.out.println("You are correct!");
				correctCount++;
			} else
				System.out.println(
						"Your answer is wrong.\n" + number1 + " - " + number2 + " should be " + (number1 - number2));
			// Increase the count
			count++;
			output += "\n" + number1 + "-" + number2 + "=" + answer
					+ ((number1 - number2 == answer) ? " correct" : " wrong");
		}

		input.close();
	}

	public static void sentinelValueDemo() {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		// Read an initial data
		System.out.print("Enter an int value (the program exits if the input is 0): ");
		int data = input.nextInt();
		// Keep reading data until the input is 0
		int sum = 0;
		while (data != 0) {
			sum += data;
			// Read the next data
			System.out.print("Enter an int value (the program exits if the input is 0): ");
			data = input.nextInt();
		}
		System.out.println("The sum is " + sum);

		input.close();
	}

}
