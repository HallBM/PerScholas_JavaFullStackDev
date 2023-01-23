package genericdemo;

import java.util.Arrays;

public class DemoClass {
	public <T> void genericsMethod(T data) {
		System.out.println("Generics Method:");
		System.out.println("Data Passed: " + data.getClass() + ": " + data);
	}

}

