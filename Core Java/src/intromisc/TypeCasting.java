package intromisc;

//LAB 303.1.3 Core Java: Type Casting

public class TypeCasting {

	public static void main(String[] args) {
		autoTypeConversion();
		System.out.println();

		autoPromoteTest();
		System.out.println();

		explicitTest();
	}

	public static void autoTypeConversion() {
		System.out.println("AUTO TYPE CONVERSION:");
		int x = 20;
		double y = 40.5;
		long p = 30;
		float q = 10.60f;
		// int z = x + y; (1) // Error; cannot convert from double to int.
		double z = x + y;
		System.out.println("Sum of two numbers: " + z);

		// long r = p - q; // (2) // Error; cannot convert from float to long.
		float r = p - q;
		System.out.println("Subtraction of two numbers: " + r);

	}

	public static void autoPromoteTest() {
		System.out.println("AUTO PROMOTE TEST:");
		byte b = 42;
		//System.out.println((int)'a');
		//System.out.println((char)97);
		char c = 'a';
		short s = 1024;
		int i = 50000;
		float f = 5.67f;
		double d = .1234;
		// Expression:
		double result = (f * b) + (i / c) - (d * s);
		// Result after all the promotions are done.
		System.out.println("result = " + result);

	}

	public static void explicitTest() {
		System.out.println("EXPLICIT TEST:");
		double d = 100.04;
		// explicit type casting
		long l = (long) d;
		int i = (int) l;
		System.out.println("Double value " + d); // fractional part lost.
		System.out.println("Long value " + l); // fractional part lost.
		System.out.println("Int value " + i);

		byte b;
		int z = 257;
		double dou = 323.142;
		System.out.println("Conversion of int to byte.");
		b = (byte) z;
		System.out.println("i = " + z + " b = " + b);
		System.out.println("Conversion of double to int.");
		z = (int) dou;
		System.out.println("d = " + dou + " b = " + z);
		System.out.println("Conversion of double to byte.");

		b = (byte) dou;
		System.out.println("d = " + dou + " b = " + b);

	}

}
