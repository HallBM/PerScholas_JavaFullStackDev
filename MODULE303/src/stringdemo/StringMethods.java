package stringdemo;

import java.util.Arrays;

//LAB 303.2.1 Java String Methods
public class StringMethods {

	
	public static void main(String[] args) {

		System.out.println("LENGTH METHOD");
		lengthEx();
		System.out.println();

		System.out.println("ISEMPTY METHOD");
		isEmptyEx();
		System.out.println();

		System.out.println("TRIM METHOD");
		trimEx();
		System.out.println();

		System.out.println("TOLOWERCASE METHOD");
		toLowerCaseEx();
		System.out.println();

		System.out.println("TOUPPERCASE METHOD");
		toUpperCaseEx();
		System.out.println();

		System.out.println("CONCAT METHOD");
		concatEx();
		System.out.println();

		System.out.println("SPLIT METHOD");
		splitEx();
		System.out.println();

		System.out.println("CHARAT METHOD");
		charAtEx();
		System.out.println();

		System.out.println("COMPARETO METHOD");
		compareToEx();
		System.out.println();

		System.out.println("SUBSTRING METHOD");
		substringEx();
		System.out.println();

		System.out.println("INDEXOF METHOD");
		indexOfEx();
		System.out.println();

		System.out.println("CONTAINS METHOD");
		containsEx();
		System.out.println();

		System.out.println("REPLACE METHOD");
		replaceEx();
		System.out.println();

		System.out.println("APPROACHES TO COMPARING STRINGS:");
		System.out.println("EQUALS METHOD (EQ BY CONTENT)");
		StringComparison.equalsMethodEx();
		System.out.println();

		System.out.println("EQUALS OPERATOR (EQ BY REFERENCE)");
		StringComparison.equalsOperatorEx();
		System.out.println();

		System.out.println("COMPARETO METHOD (LEXICOGRAPHICAL COMPARISON)");
		StringComparison.compareToMethodEx();
		System.out.println();
	}

	public static void lengthEx() {
		String str1 = "Java";
		String str2 = "";

		System.out.println(str1.length()); // 4
		System.out.println(str2.length()); // 0
		System.out.println("Java".length()); // 4
		System.out.println("Java\n".length()); // 5
		System.out.println("Learn Java".length()); // 10
	}

	public static void isEmptyEx() {
		String s1 = "";
		String s2 = "hello";
		System.out.println(s1.isEmpty()); // true
		System.out.println(s2.isEmpty()); // false
	}

	public static void trimEx() {
		String s1 = "  hello   ";
		System.out.println(s1 + "how are you"); // without trim()
		System.out.println(s1.trim() + "how are you"); // with trim()
	}

	public static void toLowerCaseEx() {
		String s1 = "HELLO HOW Are You?";
		String s1lower = s1.toLowerCase();
		System.out.println(s1lower);
	}

	public static void toUpperCaseEx() {
		String s1 = "hello how are you?";
		String s1upper = s1.toUpperCase();
		System.out.println(s1upper);
	}

	public static void concatEx() {
		// ------By using concat method----
		String str1 = "Learn ";
		String str2 = "Java";
		// concatenate str1 and str2
		System.out.println(str1.concat(str2)); // "Learn Java"

		// concatenate str2 and str11
		System.out.println(str2.concat(str1)); // "JavaLearn "
		// --- By using + operator---
		String s3 = "hello";
		String s4 = "Learners";
		// String s5 = s3.concat(s4); or
		String s5 = s3 + s4;
		// both of the above statement will give you the same result
		System.out.println(s5);

		// Three strings are concatenated
		String message = "Welcome " + "to " + "Java";
		System.out.println(message);
		
		// String Chapter is concatenated with number 2
		String s = "Chapter" + 2; // s becomes Chapter2
		System.out.println(s);
		
		// String Supplement is concatenated with character B
		String s1 = "Supplement" + 'B'; // s1 becomes SupplementB
		System.out.println(s1);
	}

	public static void splitEx() {
		String vowels = "a::b::c::d:e";

		// splitting the string at "::"
		// storing the result in an array of strings
		String[] result = vowels.split("::");

		// converting array to string and printing it
		System.out.println("result = " + Arrays.toString(result));
	}

	public static void charAtEx() {
		String message = "Welcome to Java";
		System.out.println("The first character in the message is " + message.charAt(0));
	}

	public static void compareToEx() {
		String s1 = "hello";
		String s2 = "hello ";
		String s3 = "hemlo";
		String s4 = "flag";
		System.out.println(s1.compareTo(s2)); // 0 because both are equal
		System.out.println(s1.compareTo(s3)); // -1 because "l" is only one time lower than "m"
		System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times
	}

	public static void substringEx() {
		String str1 = "java is fun";

		// extract substring from index 0 to 3
		System.out.println(str1.substring(0, 4));

	}

	public static void indexOfEx() {
		String str1 = "Java is fun";
		int result;

		// getting index of character 's'
		result = str1.indexOf('s');

		System.out.println(result); // 6

		// getting index of character 'J'
		result = str1.lastIndexOf('J');
		System.out.println(result); // 0

		// the last occurrence of 'a' is returned
		result = str1.lastIndexOf('a');
		System.out.println(result); // 3
		result = str1.lastIndexOf('j');
		System.out.println(result); // -1

		// getting the last occurrence of "ava"
		result = str1.lastIndexOf("ava");
		System.out.println(result); // 1

		// substring not in the string
		result = str1.lastIndexOf("java");
		System.out.println(result); // -1

	}

	public static void containsEx() {
		String str1 = "Learn Java";
		Boolean result;

		// check if str1 contains "Java"
		result = str1.contains("Java");
		System.out.println(result); // true

		// check if str1 contains "Python"
		result = str1.contains("Python");
		System.out.println(result); // false

		// check if str1 contains ""
		result = str1.contains("");

		System.out.println(result); // true

	}

	public static void replaceEx() {
		String str1 = "abc cba";

		// all occurrences of 'a' is replaced with 'z'
		System.out.println(str1.replace('a', 'z'));

		// all occurences of 'L' is replaced with 'J'
		System.out.println("Lava".replace('L', 'J'));
		// character not in the string
		System.out.println("Hello".replace('4', 'J'));
// all occurrences of "C++" is replaced with "Java"
		System.out.println(str1.replace("C++", "Java"));

		// all occurences of "aa" is replaced with "zz"
		System.out.println("aa bb aa zz".replace("aa", "zz"));

		// substring not in the string
		System.out.println("Java".replace("C++", "C"));
	}

}
