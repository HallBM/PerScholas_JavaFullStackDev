package stringdemo;

//LAB 303.2.1 Java String Methods (continued)

public class StringComparison {

	public static void main(String[] args) {

		System.out.println("EQUALS METHOD");
		equalsMethodEx();
		System.out.println();

		System.out.println("EQUALS OPERATOR ==");
		equalsOperatorEx();
		System.out.println();

		System.out.println("COMPARE TO METHOD");
		compareToMethodEx();
	}

	public static void equalsMethodEx() {
		String s1 = "PerScholas";
		String s2 = "PerScholas";
		String s3 = new String("PerScholas");
		String s4 = "Teksystem";
		System.out.println(s1.equals(s2));// true
		System.out.println(s1.equals(s3));// true
		System.out.println(s1.equals(s4));// false
	}

	public static void equalsOperatorEx() {
		String s1 = "Perscholas";
		String s2 = "Perscholas";
		String s3 = new String("Perscholas");
		System.out.println(s1 == s2);// true (because both refer to same instance)
		System.out.println(s1 == s3);// false(because s3 refers to instance created in non-pool)
	}

	public static void compareToMethodEx() {
		String s1 = "Perscholas";
		String s2 = "Perscholas";
		String s3 = "PerScholas";
		System.out.println(s1.compareTo(s2));// 0
		System.out.println(s1.compareTo(s3));// 1(because s1>s3)
		System.out.println(s3.compareTo(s1));// -1(because s3 < s1 )
	}
}
