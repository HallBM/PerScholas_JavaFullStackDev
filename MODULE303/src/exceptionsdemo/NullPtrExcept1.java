package exceptionsdemo;

class NullPtrExcept1 {
	public static void main(String[] args) {
		// Initializing String variable with null value
		String ptr = null;

		try {
			if (ptr.equals("gfg"))
				System.out.print("Same");
			else
				System.out.print("Not Same");
		} catch (NullPointerException e) {
			System.out.print("NullPointerException Caught");
		}
	}
}
