package exceptionsdemo;

class ThrowableExample {

	// Main Method
	public static void main(String[] args) throws MyFirstException {

		try {
			testException();
		}

		catch (Throwable e) {
			// Print using toString()
			System.out.println("Exception: " + e.toString());
		}
	}

	// Method which throws Exception
	public static void testException() throws MyFirstException {
		throw new MyFirstException("This is my error message");
	}
}

class MyFirstException extends ArithmeticException {

	public MyFirstException(String s) {
		super(s);
	}

	public String toString() {
		return (this.getClass().getSuperclass() + ": " + 
				this.getClass() + ": " +
				this.getMessage());
	}

}
