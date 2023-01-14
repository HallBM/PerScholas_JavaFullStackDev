package intromisc;

import java.util.Scanner;

public class CharacterReadFromConsole {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a character: ");
		String s = input.nextLine();
		char ch = s.charAt(0);

		if (s.length() != 1) {
			System.out.println("More than one character entered.\nThe first character entered is " + ch);
		} else {
			System.out.println("The character entered is " + ch);
		}
		input.close();
	}
}
