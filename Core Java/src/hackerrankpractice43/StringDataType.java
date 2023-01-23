package hackerrankpractice43;

class StringDataType<T> implements DataType<T> {
	public void addition(T a, T b) {
		System.out.println("Adding two strings");
		System.out.println("The result is: " + a + b);
	}

	public void subtraction(T a, T b) {
		System.out.println("Can't perform this operation on strings");
	}

	public void multiplication(T a, T b) {
		System.out.println("Can't perform this operation on strings");
	}

	public void division(T a, T b) {
		System.out.println("Can't perform this operation on strings");
	}

	public void performAll(T a, T b) {
		addition(a, b);
		subtraction(a, b);
		multiplication(a, b);
		division(a, b);
	}
}
