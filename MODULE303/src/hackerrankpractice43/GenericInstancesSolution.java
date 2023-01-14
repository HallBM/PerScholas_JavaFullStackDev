package hackerrankpractice43;

import java.util.Scanner;


/* Input example:
0 3 0 1
68843516 63681054
82054492 51269762
83218720 78332855
xcatycvgyrvxgtpjgleqlqofjeofsmahouohdexbwszglnvzzztxbzdmbsqkprcwrfbgpprtqovpj vrsvbwmnkxzkxssdyugfalclbpwnoyrapfjhxhjhgmjnojxxoikjowjcoyqcrdzmlxlqrgnaosxkp

Expected Output:
Adding 2 generic instances
The result is: 132524570.00
Subtracting two generic instances
The result is: 5162462.00
Multiplying two generic instances
The result is: 4384027659945864.00
Dividing two generic instances
The result is: 1.08
Adding 2 generic instances
The result is: 133324254.00
Subtracting two generic instances
The result is: 30784730.00
Multiplying two generic instances
The result is: 4206914275870904.00
Dividing two generic instances
The result is: 1.60
Adding 2 generic instances
The result is: 161551575.00
Subtracting two generic instances
The result is: 4885865.00
Multiplying two generic instances
The result is: 6518759927045600.00
Dividing two generic instances
The result is: 1.06
Adding two strings
The result is: xcatycvgyrvxgtpjgleqlqofjeofsmahouohdexbwszglnvzzztxbzdmbsqkprcwrfbgpprtqovpjvrsvbwmnkxzkxssdyugfalclbpwnoyrapfjhxhjhgmjnojxxoikjowjcoyqcrdzmlxlqrgnaosxkp
Can't perform this operation on strings
Can't perform this operation on strings
Can't perform this operation on strings
*/


public class GenericInstancesSolution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input 1 line at a time:"); // added prompt for input
		String[] s = sc.nextLine().split(" ");
		int i = Integer.parseInt(s[0]), l = Integer.parseInt(s[1]), d = Integer.parseInt(s[2]),
				q = Integer.parseInt(s[3]);

		NumericDataType<Integer> obj1 = new NumericDataType<Integer>();
		NumericDataType<Long> obj2 = new NumericDataType<Long>();
		NumericDataType<Double> obj3 = new NumericDataType<Double>();
		StringDataType<String> obj4 = new StringDataType<String>();

		for (int t = 0; t < i; t++) {
			s = sc.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			obj1.performAll(a, b);
		}
		for (int t = 0; t < l; t++) {
			s = sc.nextLine().split(" ");
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);
			obj2.performAll(a, b);
		}
		for (int t = 0; t < d; t++) {
			s = sc.nextLine().split(" ");
			double a = Double.parseDouble(s[0]);
			double b = Double.parseDouble(s[1]);
			obj3.performAll(a, b);
		}
		for (int t = 0; t < q; t++) {
			s = sc.nextLine().split(" ");
			String a = s[0];
			String b = s[1];
			obj4.performAll(a, b);
		}
		
		sc.close();
	}
}
