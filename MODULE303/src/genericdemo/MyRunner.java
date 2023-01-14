package genericdemo;

public class MyRunner {
	public static void main(String[] args) {

		System.out.println("DEMO CLASS");
		DemoClass dObj = new DemoClass();
		dObj.genericsMethod(25); // passing int
		dObj.genericsMethod("Per Scholas"); // passing String
		dObj.genericsMethod(2563.5); // passing float
		dObj.genericsMethod('H'); // passing Char

		System.out.println();
		System.out.println("GENERIC MULTIPLE DATA TYPE");

		// initialize generic class
		// with String and Integer data

		GenericMultipleDataType<String, Integer> mobj = new GenericMultipleDataType<>("Per Scholas", 11025);

		System.out.println(mobj.getValueOne());
		System.out.println(mobj.getValueTwo());

		// initialize generic class
		// with String and String data
		GenericMultipleDataType<String, String> mobj2 = new GenericMultipleDataType<>("Per Scholas", "Non profit");
		System.out.println(mobj2.getValueOne());
		System.out.println(mobj2.getValueTwo());
	}

}
